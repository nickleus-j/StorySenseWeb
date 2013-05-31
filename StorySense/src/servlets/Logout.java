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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends BaseServlet {

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
        try {
			response.sendRedirect("../StorySense/Home.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
