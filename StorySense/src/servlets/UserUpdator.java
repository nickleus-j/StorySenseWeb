package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.ProfileDAO;
import dao.UserDAO;

import entity.Profile;
import entity.User;

/**
 * Servlet implementation class UserUpdator
 */
@WebServlet(description = "Updates the user", urlPatterns = { "/UserUpdator" })
public class UserUpdator extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    private Profile getProfile(User sessionUser){
    	DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
        ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
        return profileDAO.getProfile(sessionUser);
        //re
    }
    
	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		User theUser;
		Profile uProfile;
		try{
			theUser=(User) request.getSession().getAttribute("user");
			uProfile=getProfile(theUser);
			
			if(request.getParameter("ConfirmPass")!=null)
				updatUserPassword(theUser, request.getParameter("ConfirmPass"));
			else if(request.getParameter("username")!=null)
				updateUserName(theUser, request.getParameter("username"));
			
			response.sendRedirect("../StorySense/View_Profile.jsp");
		}catch(Exception ex){}
		
	}
	
	private void updatUserPassword(User user,String password){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO userDao=myDAOFactory.createUserDAO();
		user.setPassword(password);
		userDao.updateUser(user);
	}

	private void updateUserName(User user,String name){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO userDao=myDAOFactory.createUserDAO();
		user.setName(name);
		userDao.updateUser(user);
		
	}
}
