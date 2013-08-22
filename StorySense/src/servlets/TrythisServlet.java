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
package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrythisServlet extends BaseServlet {

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

		try{
			response.sendRedirect("../StorySense/LearnerHomeSample.jsp");
			//request.setAttribute("result","hello");
			RequestDispatcher dispatcher =request.getRequestDispatcher("../StorySense/LearnerHomeSample.jsp");
			dispatcher.forward(request, response); 
			
		}catch(Exception ex){}
	}

}
