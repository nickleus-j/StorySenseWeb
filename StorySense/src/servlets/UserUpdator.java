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
			String username=request.getParameter("username"),firstname=request.getParameter("firstname");
			//String surname=request.getParameter("surname");
			
			 if(username!=null&&!username.isEmpty()&&!username.matches(theUser.getName()))
				updateUserName(theUser, username);
			 if(firstname!=null&&!firstname.isEmpty())
				updateProfile(uProfile, request);
			
			
			
			response.sendRedirect("../StorySense/View_Profile.jsp");
		}catch(Exception ex){
			System.out.println(ex);
		}
		
	}
	
	

	private void updateUserName(User user,String name){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO userDao=myDAOFactory.createUserDAO();
		user.setName(name);
		userDao.updateUser(user);
	}
	public void updateProfile(Profile userProfile,HttpServletRequest request){
		String firstname,surname;
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
        ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
        
		firstname=request.getParameter("firstname");
		surname=request.getParameter("surname");
		userProfile.setFirstName(firstname);
		userProfile.setSurname(surname);
		profileDAO.setProfile(userProfile);
	}
}
