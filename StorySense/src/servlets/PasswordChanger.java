package servlets;

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
		try{
			theUser=(User) request.getSession().getAttribute("user");
		if(request.getParameter("ConfirmPass")!=null)
			updatUserPassword(theUser, request.getParameter("ConfirmPass"));
		
		response.sendRedirect("../StorySense/View_Profile.jsp");
		}catch(Exception ex){}
	}

}
