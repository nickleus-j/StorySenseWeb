/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
package ajaxReviewer;

import infoResource.AttributeNames;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.UserDAO;
import entity.Acomplishment;
import entity.User;

import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;
import webEncoder.HtmlLinkEncoder;

/**
 * Servlet implementation class StoriesToBeReviewed
 * @author Nickleus
 */
@WebServlet(name = "ReviewerFeed", description = "Gets a feed of information fro the reviewer", urlPatterns = { "/ReviewerFeed" })
public class StoriesToBeReviewed extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StoriesToBeReviewed() { }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int limit=10,level=0;
		User u=null;
		User sessionUser=(User)request.getSession().getAttribute(AttributeNames.user.toString());
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		UserDAO myUserDao=myDAOFactory.createUserDAO();
		ArrayList<Acomplishment> Stories;
		
		try{
			level=Integer.parseInt(request.getParameter(AttributeNames.Level.toString()));
		}catch(Exception ex){
			level=0;
		}
		
		try{
			u=myUserDao.findUserWithName(request.getParameter("u"));
		}catch(Exception ex){
			u=null;
		}
		
		try{
			limit=Integer.parseInt(request.getParameter(AttributeNames.querylimit.toString()));
			
			if(level==0)
				Stories=(ArrayList<Acomplishment>)myAcomDAO.getStoriesToRate(sessionUser.getAccountID());
			else if(u==null)
				Stories=(ArrayList<Acomplishment>)myAcomDAO.getStoryWithAtLeastLevel(sessionUser.getAccountID(), level);
			else{
				Stories=(ArrayList<Acomplishment>)myAcomDAO.getUserStoryWithAtLeastLevel(level,
						u.getAccountID(), sessionUser.getAccountID());
			}
			
			if(Stories!=null)
				encodeStoriesInHTML(response.getWriter(), Stories,myDAOFactory.createUserDAO());
			else 
				
			response.getWriter().print("Error");
		}catch(IOException ioEX){}
		
	}

	/**
	 * Put in HTML the stories from the server
	 * assume the response will be put in an HTML table element
	 * @param out : Writers to HTMl client
	 * @param Stories : The stories aquired from the server
	 * @param myUserDao : the gets the ID of the writer
	 */
	public void encodeStoriesInHTML(PrintWriter out,ArrayList<Acomplishment> Stories,UserDAO myUserDao){
		CompleteStoryLoader sLoader=new CompleteStoryLoader();
		User myUser;
		String stageID="assertionTbl";
		String tblIni="<tr><th colspan=6 id=\"validatedStoriesHeader\" class=\"clickable\" " +
				"onclick=\"ReviewStoriesInUser(10,1,'')\">" +
				"Stories from other learners</th></tr>" +
				"<tr><th>Author</th><th>Story Title</th><th>Show Story</th></tr>";
			
		out.write(tblIni);
			/*Loop that shows the story Links*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
				/*Generate HTML code*/
				out.write("<tr>");
				out.write("<td class=\"clickable\" onclick=\"ReviewStoriesInUser(10,1,'"+myUser.getName()+"')\">"
						+myUser.getName()+"</td>");
				out.write("<td>"+sLoader.createStoryLink(Stories.get(ctr), ("storyPane"+ctr))+"</td>");
				out.write("<td><a>"+createReviewLink(Stories.get(ctr).getID(), stageID)+"</a></td>");

				out.write("</tr><tr><td class=\"hiddenElem\" id=\""+
				("storyPane"+ctr)+"\" colspan='3'></td></tr>");
			}/*End of Loop*/

	}
	/*
	 * "generateRelationPane('"+stageID+"',"+storyID+")\">"
	 * Requires ReviewerScripts.jsp
	 */
	public String createReviewLink(int storyID,String stageID){
		String btID="BT_"+storyID;
		String link="<a href='#reviewArea' id='"+btID+"' onclick=\"" +
				"createRelationPaneHtml("+storyID+")\">";
		return link.concat("Rate Story</a>");
	}
	
	
	
}
