/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package webEncoder;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import dao.AcomplishmentDAO;
import dao.ConceptDAO;
import dao.DAOFactory;
import dao.RelationDAO;
import dao.UserDAO;
import entity.Acomplishment;
import entity.Concept;
import entity.User;
import java.util.ArrayList;

public class SidebarEncoder {

	public void showPopularStory(JspWriter out){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO acomDao=myDaoFactory.createAcomplishmentDAO();
		Acomplishment accom=acomDao.getPopularStory();
		
		try {
			out.write(generateStoryLink(accom)+generateAuthorLink(myDaoFactory, accom));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}/*End of Method*/
	
	private String generateStoryLink(Acomplishment story){
		return "<a href='StoryDisplay.jsp?aID="+story.getID()+"'>"+story.getName()+"</a></br>";
	}
	
	private String generateAuthorLink(DAOFactory myDaoFactory,Acomplishment story){
		UserDAO uDao=myDaoFactory.createUserDAO();
		User author=uDao.getUser(story.getAccountID());
		
		return "<a href='viewAUser?uID="+story.getAccountID()+"'>By "+author.getName()+"</a>";
	}
	
	public void showPopularTerm(JspWriter out){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		ConceptDAO conceptDao=myDaoFactory.createConceptDAO();
		RelationDAO relDao=myDaoFactory.createRelationDAO();
		Concept trendingConcept=conceptDao.getPopularConcept();
		ArrayList<String> sentences;
		try {
			out.write(trendingConcept.getWord_phrase());
			sentences=relDao.getRelationsOfConcept(trendingConcept.getWord_phrase());
			
			out.write("<table>");
			for(int ctr=0;ctr<sentences.size();ctr++){
				out.write("<tr><td>"+sentences.get(ctr)+"<tr><td>");
			}
			out.write("</table>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}/*End of Method*/
	public String getHighScoredStory(){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO acomDao=myDaoFactory.createAcomplishmentDAO();
		return acomDao.getHighestAverageScoredStoryJson();
	}
}
