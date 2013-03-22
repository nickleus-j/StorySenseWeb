package ajaxServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.BaseServlet;

import webEncoder.CompleteStoryLoader;
import worker.AttributeNames;
import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.RatingDAO;
import dao.UserDAO;
import entity.Acomplishment;
import entity.User;

/**
 * Servlet implementation class StoriesRated
 */
@WebServlet(description = "See the stories rated by the reviewer", urlPatterns = { "/StoriesRated" })
public class StoriesRated extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public StoriesRated() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int limit=10,level=0;
		User sessionUser=(User)request.getSession().getAttribute(AttributeNames.user.toString());
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		ArrayList<Acomplishment> Stories;
		
		try{
			level=Integer.parseInt(request.getParameter(AttributeNames.Level.toString()));
		}catch(Exception ex){
			level=0;
		}
		
		try{
			limit=Integer.parseInt(request.getParameter(AttributeNames.querylimit.toString()));
			
			
				Stories=(ArrayList<Acomplishment>)myAcomDAO.getStoriesRated(sessionUser.getAccountID());
			
			encodeStoriesInHTML(response.getWriter(), Stories,myDAOFactory.createUserDAO(),sessionUser);
				
			response.getWriter().print("");
		}catch(IOException ioEX){}
	}

	/**
	 * Put in HTML the stories from the server
	 * assume the response will be put in an HTML table element
	 * @param out : Writers to HTMl client
	 * @param Stories : The stories aquired from the server
	 * @param myUserDao : the gets the ID of the writer
	 */
	public void encodeStoriesInHTML(PrintWriter out,ArrayList<Acomplishment> Stories,UserDAO myUserDao,User sessionUser){
		CompleteStoryLoader sLoader=new CompleteStoryLoader();
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RatingDAO myRatingDao=myDAOFactory.createRatingDAO();
		User myUser;
		String stageID="";
		String tblIni="<tr><th colspan=6 id=\"validatedStoriesHeader\">" +
				"Stories from other learners</th></tr>" +
				"<tr><th>Author</th><th>Story Title</th><th>Score</th></tr>";
			
		out.write(tblIni);
			/*Loop that shows the story Links*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				stageID="story"+Stories.get(ctr).getID();
				myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
				/*Generate HTML code*/
				out.write("<tr>");
				out.write("<td>"+myUser.getName()+"</td>");
				
				out.write("<td>"+sLoader.createStoryLink(Stories.get(ctr), stageID)+"</td>");
				out.write("<td>"+myRatingDao.getRatingsOfReader(sessionUser.getAccountID(),
						Stories.get(ctr).getID()).getScore()+"</td>");
				out.write("</tr>" +
						"<tr><td class=\"hiddenElem\" id=\""+stageID+"\" colspan='3'></td>");
				
				out.write("</tr>");
				
			}
	}
}
