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
