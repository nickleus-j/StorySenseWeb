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
 */
@WebServlet(description = "handles the logIn operation", urlPatterns = { "/LogIn" })
public class LogIn extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogIn() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		try{
			//HttpSession session = request.getSession();
			//session.get
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
			
			
			
			/*
			 * response.sendRedirect("../StorySense/Home.jsp");
			 * request.getParameter(arg0);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/User_profile.jsp");
			dispatcher.forward(request, response); 
			*/
            
		}catch (Exception ex){}
		finally {
			if(out!=null)
				out.close();
        }
		
	}

}
