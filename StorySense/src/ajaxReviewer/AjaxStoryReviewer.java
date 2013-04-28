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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.RelationshipDAO;
import entity.Acomplishment;
import entity.Relation;

import model.Story;

import serializableObjects.StoryFileAccess;
import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;
import webEncoder.RatingFormEncoder;

/**
 * Servlet implementation class AjaxStoryReviewer
 */
@WebServlet(name = "StoryRater", description = "Generates Code for reviewing", urlPatterns = { "/StoryRater" })
public class AjaxStoryReviewer extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AjaxStoryReviewer() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		Acomplishment ratedStory;
		Story theStory;
		RatingFormEncoder ratingHtml=new RatingFormEncoder();
		StoryFileAccess sfa;
		int sID=Integer.parseInt(request.getParameter("q"));
		
		ratedStory=myAcomDAO.getStory(sID);
		sfa=getStoryFile(ratedStory.getFileURL());
		theStory=sfa.getMyStory();
		
		
		
		try {
			PrintWriter out=response.getWriter();
			out.write(ratingHtml.enterAssertionsTableCode(theStory));
			//out.write(ratingHtml.generateQuestionTblHtml(theStory));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Loads a story given the file entered
	 */
	public StoryFileAccess getStoryFile(String fileUrl){
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(fileUrl);
			ObjectInputStream oi = new ObjectInputStream(fileIn);
			StoryFileAccess storyFile=(StoryFileAccess)oi.readObject();
			fileIn.close();
			oi.close();
			return storyFile;
		} catch(IOException ioEx){
			
		}
		catch(Exception ex){
			//out.println("Error in getting the story\n"+ex.getMessage());
		}
		return null;
	}
	
	public void enterRelations(Story theStory,PrintWriter out){
		ArrayList<Relation> relations=theStory.getRelationRules();
		for(int ctr=0;ctr<relations.size();ctr++){
			out.write(relations.get(ctr).getConcept1()+" "+
			relations.get(ctr).getRelationship()+" "+relations.get(ctr).getConcept2()+"<hr/>");
		}/*End of loop*/
	}

	
	
	
}
