package ajaxReviewer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.UserDAO;
import entity.Acomplishment;
import entity.User;

import servlets.BaseServlet;

/**
 * Servlet implementation class StoryDetailGiver
 */
@WebServlet(name = "StoryDescRev", urlPatterns = { "/StoryDescRev" })
public class StoryDetailGiver extends BaseServlet {
	private static final long serialVersionUID = 10L;

    /**
     * Default constructor. 
     */
    public StoryDetailGiver() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html"); 
		int sID=Integer.parseInt(request.getParameter("q"));
		
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		UserDAO myUserDao=myDAOFactory.createUserDAO();
		Acomplishment acom;
		User user;
		try{
			PrintWriter out=response.getWriter();
			if(sID>0){
				acom=myAcomDAO.getStory(sID);
				user=myUserDao.getUser(acom.getAccountID());
				out.write("<h2>"+acom.getName()+"</h2>");
				out.write("<h4>by: "+user.getName()+"</h4>");
			}
		}catch(IOException ioE){}
		
	}

}
