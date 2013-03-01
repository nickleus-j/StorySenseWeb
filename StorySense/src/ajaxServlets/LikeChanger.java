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
 */
@WebServlet(description = "Changes Upon likes", urlPatterns = { "/LikeChanger" })
public class LikeChanger extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LikeChanger() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html"); 
		//User myUser=(User)request.getSession().getAttribute("user");
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		LikedStoryDAO LikeDAO=myDAOFactory.createLikeDAO();
		
		try {
			response.getWriter().write(""+LikeDAO.countStoryLikes(Integer.parseInt(request.getParameter("q"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
