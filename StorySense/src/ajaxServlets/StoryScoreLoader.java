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
package ajaxServlets;

import infoResource.LearnerElemAttr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.RatingDAO;
import dao.UserDAO;
import entity.Acomplishment;
import entity.Rating;
import entity.User;

import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;

/**
 * Servlet implementation class StoryScoreLoader
 */
@WebServlet(description = "Shows how the score of the story is added up", urlPatterns = { "/StoryScoreLoader" })
public class StoryScoreLoader extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StoryScoreLoader() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		LearnerElemAttr elemParamNames=new LearnerElemAttr();
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO acomDao=myDAOFactory.createAcomplishmentDAO();
		int accomID=Integer.parseInt(request.getParameter(elemParamNames.getStoryIdParameter()));
		Acomplishment myAcom=acomDao.getStory(accomID);
		PrintWriter out;
		
		//response.setContentType("text/html"); 
		try{
		out=response.getWriter();
		
		out.write("<tr><th>Total Score Given</th><td>"+getTotalScore(myAcom)+"</td></tr>");
		
		out.write("<tr><td>");
		loadStoryText(out, myAcom);
		out.write("</td></tr>");
		
		out.write("<tr><td>");
		generateTblHead(out,"Scores Given");
		out.write("</td></tr>");
		
		out.write("<tr><td>");
		generateScoreHtmlTbl(out, myAcom);
		out.write("</td></tr>");
		
		}catch(IOException ioex){
			System.out.println("Panic");
		}

	}/*End of Function*/

	
	private String getTotalScore(Acomplishment myAcom){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RatingDAO myRatingDao=myDAOFactory.createRatingDAO();
		
		return ""+myRatingDao.getTotalScore(myAcom.getID());
	}
	
	public void generateScoresTblHead(PrintWriter out){
		out.write("<table class=\"headTbl\" bgcolor = \"#7DFB9D\">"+
		"<thead><tr><th  id=\"fontStyle2\">Scores Given </th></tr></thead></table>");
	}
	
	public void generateTblHead(PrintWriter out,String text){
		out.write("<table class=\"headTbl\" bgcolor = \"#7DFB9D\">"+
		"<thead><tr><th  id=\"fontStyle2\">"+text+"</th></tr></thead></table>");
	}
	
	/**
	 * generates a table containing the individual scores of the stories
	 * @param out
	 * @param myAcom
	 * @throws IOException
	 */
	public void generateScoreHtmlTbl(PrintWriter out,Acomplishment myAcom) throws IOException{
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO myUserDao=myDAOFactory.createUserDAO();
		RatingDAO myRatingDao=myDAOFactory.createRatingDAO();
		ArrayList<Rating> ratings=(ArrayList<Rating>) myRatingDao.getRatingsOfAccomplishment(myAcom.getID());
		User myUser;
		
		out.write("<table  bgcolor = \"white\">");
		out.write("<tr><th>Reviewer</th><th>Story Title</th><th>Score</th></tr>");
		if(ratings!=null)
			for(int ctr=0;ctr<ratings.size();ctr++){
				myUser=myUserDao.getUser(ratings.get(ctr).getReaderID());
				/*Generate HTML code*/
				out.write("<tr>");
				out.write("<td>"+myUser.getName()+"</td>");
				out.write("<td>"+ratings.get(ctr).getScore()+"</td>");
				
				out.write("</tr>");
				}/*End of loop*/
			else out.write("<tr><th colspan=\"3\">No scores yet</th></tr>");
		out.write("</table>");
	}
	
	private void loadStoryText(PrintWriter out,Acomplishment myAcom)throws IOException{
		CompleteStoryLoader sLoader=new CompleteStoryLoader();
		
		String url=myAcom.getFileURL();
		out.write("<hr>"+sLoader.loadStory(url)+"<hr>");
	}
}
