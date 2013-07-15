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
package ajaxLearner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.ProfileDAO;
import dao.UserDAO;

import entity.Acomplishment;
import entity.Profile;
import entity.User;

import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;
import webEncoder.HtmlLinkEncoder;

/**
 * Servlet implementation class FeedFetcher
 */
@WebServlet(name = "StoryFeedFetcher", urlPatterns = { "/StoryFeedFetcher" })
public class FeedFetcher extends BaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int limit=10;
		
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStories(limit);
		try{
			limit=Integer.parseInt(request.getParameter("limit"));
			Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStories(limit);
			encodeStoriesInHTML(response.getWriter(), Stories, myDAOFactory.createUserDAO(),
				(User)request.getSession().getAttribute("user"),myDAOFactory.createProfileDAO());
		}catch(IOException ioEX){}
	}

	/**
	 * Put in HTML the stories from the server
	 * assume the response will be put in an HTML table element
	 * @param out : Writers to HTMl client
	 * @param Stories : The stories acquired from the server
	 * @param myUserDao : the gets the ID of the writer
	 * @param SessionUser : The user Logged In.
	 */
	public void encodeStoriesInHTML(PrintWriter out,ArrayList<Acomplishment> Stories,UserDAO myUserDao,
			User SessionUser,ProfileDAO profDao){
		CompleteStoryLoader sLoader=new CompleteStoryLoader(SessionUser);
		User myUser;
		HtmlLinkEncoder linkEncoer=new HtmlLinkEncoder();
		Profile theProfile;
			
			/*loop that displays the stories*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				out.write("<tr id=\"titleFont\" class=\"storyHead\">");
				myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
				theProfile=profDao.getProfile(myUser);
				out.write("<td colspan=\"2\">\"" +Stories.get(ctr).getName()+"\"</td></tr><tr>"+
						"<td colspan=\"2\">"+ "&nbsp;&nbsp;&nbsp; <img src='"+theProfile.getImageURL()+"'" +
								"width='50' height='50'/> By: "+linkEncoer.createLinkToUser(myUser)+"</td>");
				
				if(SessionUser!=null)
					out.write(sLoader.generateLikeRow(Stories.get(ctr)));
				out.write("<tr><td colspan=\"4\">");
				out.write("<br/>"+sLoader.loadStory(Stories.get(ctr).getFileURL()));
				out.write("<hr/></td></tr>");
				
			}/*End of Loop onshow=""*/
			out.write("<tr><td align='center' colspan='5' onshow=\"loadMoreStoriesInFeed()\">" +
					"<button onclick=\"loadMoreStoriesInFeed()\">Load More</button></td></tr>");

			
	}
	
	
}
