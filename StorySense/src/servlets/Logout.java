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
