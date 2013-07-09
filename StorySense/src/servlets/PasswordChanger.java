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
package servlets;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class PasswordChanger
 */
@WebServlet(description = "Changes the password", urlPatterns = { "/PasswordChanger" })
public class PasswordChanger extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private void updatUserPassword(User user,String password){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO userDao=myDAOFactory.createUserDAO();
		user.setPassword(password);
		userDao.updateUser(user);
	}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		User theUser;
		PrintWriter out;
		try{
			out=response.getWriter();
			theUser=(User) request.getSession().getAttribute("user");
		if(request.getParameter("ConfirmPass")!=null)
			updatUserPassword(theUser, request.getParameter("ConfirmPass"));
			//out.write(request.getParameter("ConfirmPass"));
		response.sendRedirect("../StorySense/View_LearnerProfile.jsp");
		}catch(Exception ex){}
	}

}
