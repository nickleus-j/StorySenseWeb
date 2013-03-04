package ajaxServlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;

import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;

/**
 * Servlet implementation class StoryShower
 */
@WebServlet(description = "Shows A story", urlPatterns = { "/StoryShower" })
public class StoryShower extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StoryShower() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html"); 
		int sID=Integer.parseInt(request.getParameter("q"));
		//String stage=request.getParameter("screen");
		CompleteStoryLoader sLoader=new CompleteStoryLoader();
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		
		try{
			String url=myAcomDAO.getStory(sID).getFileURL();
			response.getWriter().write(sLoader.loadStory(url));
		}catch(IOException ioEX){}
		
	}

}
