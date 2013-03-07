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

/**
 * Servlet implementation class FeedFetcher
 */
@WebServlet(name = "StoryFeedFetcher", urlPatterns = { "/StoryFeedFetcher" })
public class FeedFetcher extends BaseServlet {
	private static final long serialVersionUID = 1L;


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
			encodeStoriesInHTML(response.getWriter(), Stories, 
				myDAOFactory.createUserDAO(), (User)request.getSession().getAttribute("user"));
		}catch(IOException ioEX){}
	}

	/**
	 * Put in HTML the stories from the server
	 * @param out : Writers to HTMl client
	 * @param Stories : The stories aquired from the server
	 * @param myUserDao : the gets the ID of the writer
	 * @param SessionUser : The user Logged In.
	 */
	private void encodeStoriesInHTML(PrintWriter out,ArrayList<Acomplishment> Stories,UserDAO myUserDao,User SessionUser){
		CompleteStoryLoader sLoader=new CompleteStoryLoader(SessionUser);
		User myUser;
		
			out.write("<tr><td id='1st'></td></tr>");
			/*loop that displays the stories*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				out.write("<tr class=\"storyHead\">");
				myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
				out.write("<th>Title:</th><td> "+Stories.get(ctr).getName()+"</td> <th>Made by </th>" +
						"<td>"+myUser.getName()+"</td></tr>");
				
				if(SessionUser!=null)
					out.write(sLoader.generateLikeRow(Stories.get(ctr))+"</tr>");
				out.write("<tr><td colspan=\"4\">");
				out.write("<br/>"+sLoader.loadStory(Stories.get(ctr).getFileURL()));
				out.write("<hr/></td></tr>");
				
			}/*End of Loop onshow=""*/
			out.write("<tr><td align='center' colspan='5' onshow=\"loadMoreStoriesInFeed()\">" +
					"<button onclick=\"loadMoreStoriesInFeed()\">Load More</button></td></tr>");

			
	}
	
	
}