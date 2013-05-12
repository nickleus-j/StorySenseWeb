/*******************************************************************************
 *Copyright (c) 2013 Story Sense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.UserDAO;

/**
 * Used to direct to see the records of another learner
 */
@WebServlet(name = "viewAUser", description = "Views the story of the user", urlPatterns = { "/viewAUser" })
public class UserViewPage extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserViewPage() {
       
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int userID=0;
		
		try{
			userID=Integer.parseInt(request.getParameter("uID"));
			DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
			UserDAO userDAO=myDAOFactory.createUserDAO();
			request.setAttribute("viewedUser", userDAO.getUser(userID));
			RequestDispatcher dispatcher =request.getRequestDispatcher("UserStories.jsp");
			dispatcher.forward(request, response); 
		} catch(NumberFormatException ex){
			ex.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
