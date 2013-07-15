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
 * Servlet implementation class LearnerAchievmentView
 */
@WebServlet(name = "viewAchivements", description = "Shows the acheivements of a learner", urlPatterns = { "/viewAchivements" })
public class LearnerAchievmentView extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LearnerAchievmentView() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int userID=0;
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO userDAO=myDAOFactory.createUserDAO();
		
		try{
			userID=Integer.parseInt(request.getParameter("uID"));
			
		}catch(NullPointerException NullEx){
			userID=0;
		}
		catch(NumberFormatException nex){
			userID=0;
		}
		
		request.setAttribute("viewedUser", userDAO.getUser(userID));
		RequestDispatcher dispatcher =request.getRequestDispatcher("LearnerAchievements.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
