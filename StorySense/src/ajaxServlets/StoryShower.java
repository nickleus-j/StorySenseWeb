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

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;

import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;

/**
 * Servlet implementation class StoryShower
 */
@WebServlet(description = "Shows A story", urlPatterns = { "/StoryShower" })
public class StoryShower extends BaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html"); 
		int sID=Integer.parseInt(request.getParameter("q"));
		CompleteStoryLoader sLoader=new CompleteStoryLoader();
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		
		try{
			String url=myAcomDAO.getStory(sID).getFileURL();
			response.getWriter().write("<hr>"+sLoader.loadStory(url)+"<hr>");
		}catch(IOException ioEX){}
		
	}

}
