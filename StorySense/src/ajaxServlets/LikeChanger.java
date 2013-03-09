package ajaxServlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.LikedStoryDAO;
import entity.User;

import servlets.BaseServlet;

/**
 * Servlet implementation class LikeChanger
 * This servlet manipulates the like table in the database
 */
@WebServlet(description = "Changes Upon likes", urlPatterns = { "/LikeChanger" })
public class LikeChanger extends BaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html"); 
		User myUser=(User)request.getSession().getAttribute("user");
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		LikedStoryDAO LikeDAO=myDAOFactory.createLikeDAO();
		String like;
		try {
			int sID=Integer.parseInt(request.getParameter("q"));
			
			like=request.getParameter("res");
			
			if(like.matches("like"))
				LikeDAO.likeStory(myUser.getAccountID(), sID);
			else 
				LikeDAO.disLike(myUser.getAccountID(), sID);
			response.getWriter().write(""+LikeDAO.countStoryLikes(sID));
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

}
