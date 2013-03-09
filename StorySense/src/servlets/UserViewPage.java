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
 * Servlet implementation class UserViewPage
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
