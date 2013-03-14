package ajaxServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.UserDAO;
import entity.Acomplishment;
import entity.User;

import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;
import webEncoder.HtmlLinkEncoder;

/**
 * Servlet implementation class StoriesToBeReviewed
 */
@WebServlet(name = "ReviewerFeed", description = "Gets a feed of information fro the reviewer", urlPatterns = { "/ReviewerFeed" })
public class StoriesToBeReviewed extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StoriesToBeReviewed() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int limit=10;
		
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStories(limit);
		try{
			limit=Integer.parseInt(request.getParameter("limit"));
			Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStories(limit);
			encodeStoriesInHTML(response.getWriter(), Stories,myDAOFactory.createUserDAO());
				
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
	public void encodeStoriesInHTML(PrintWriter out,ArrayList<Acomplishment> Stories,UserDAO myUserDao){
		CompleteStoryLoader sLoader=new CompleteStoryLoader();
		User myUser;
		String stageID="";
			
			/*loop that displays the stories
			for(int ctr=0;ctr<Stories.size();ctr++){
				out.write("<tr class=\"storyHead\">");
				myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
				out.write("<th>Title:</th><td> "+Stories.get(ctr).getName()+"</td> <th>Made by </th>" +
						"<td>"+myUser.getName()+"</td></tr>");
				
				
				out.write("<tr><td colspan=\"4\">");
				out.write("<br/>"+sLoader.loadStory(Stories.get(ctr).getFileURL()));
				out.write("<hr/></td></tr>");
				
			}/*End of Loop onshow=""*/
			
			/*Loop that shows the story Links*/
			for(int ctr=0;ctr<Stories.size();ctr++){

				myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
				/*Generate HTML code*/
				out.write("<tr>");
				out.write("<td>"+myUser.getName()+"</td>");
				out.write("<td>"+Stories.get(ctr).getName()+"</td>");
				out.write("<td>"+sLoader.createStoryLink(Stories.get(ctr).getID(), stageID)+"</td>");
				
				out.write("</tr>" +
						"<tr><td class=\"hiddenElem\" id=\""+stageID+"\" colspan='3'></td>");
				
				out.write("</tr>");
				
			}/*
			out.write("<tr><td align='center' colspan='5' onshow=\"loadMoreStoriesInFeed()\">" +
			"<button onclick=\"loadMoreStoriesInFeed()\">Load More</button></td></tr>");
			*/
	}
	
}
