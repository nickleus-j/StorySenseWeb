/*******************************************************************************
 *Copyright (c) 2013 StorySense.
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
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class LogIn
 * Allows users to log in the system.
 * Many transactions will requiure a current user
 * for the sake of records.
 */
@WebServlet(description = "handles the logIn operation", urlPatterns = { "/LogIn" })
public class LogIn extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogIn() {}

/**
 * Executes the code that will log in the user to the databse if
 * the username and password matches an entry in the datasbe.
 * Maker sure that the username is unique.
 */ 
	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		try{
			out = response.getWriter();
			
			DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
            UserDAO myUserDAO = myDAOFactory.createUserDAO();
            User myUser = myUserDAO.getUser(request.getParameter("username"),
                    request.getParameter("password"));
            if (myUser != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", myUser);
                
                if(User.Roles.learner.isLearner(myUser.getRole()))
                	response.sendRedirect("../StorySense/LearnerHomeSample2.jsp");
                else if(User.Roles.learner.isReviwer(myUser.getRole()))
                	response.sendRedirect("../StorySense/ReviewerHome.jsp");
                else if(User.Roles.learner.isAdmin(myUser.getRole()))
                	response.sendRedirect("../StorySense/AdminHome.jsp");
            } else {
            	response.sendRedirect("LogInFail.jsp");
                
            }
			
			
            
		}catch (Exception ex){}
		finally {
			if(out!=null)
				out.close();
        }
		
	}

}
