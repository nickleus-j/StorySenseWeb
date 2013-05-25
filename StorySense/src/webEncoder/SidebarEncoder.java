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
import entity.Acomplishment;
import entity.Concept;

public class SidebarEncoder {

	public void showPopularStory(JspWriter out){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO acomDao=myDaoFactory.createAcomplishmentDAO();
		Acomplishment accom=acomDao.getPopularStory();
		
		try {
			out.write(accom.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}/*End of Meyhod*/
	
	public void showPopularTerm(JspWriter out){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		ConceptDAO conceptDao=myDaoFactory.createConceptDAO();
		Concept trendingConcept=conceptDao.getPopularConcept();
		
		try {
			out.write(trendingConcept.getWord_phrase());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}/*End of Meyhod*/
}
