package servlets;

import infoResource.LearnerElemAttr;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.LikedStoryDAO;
import dao.RatingDAO;
import dao.UserDAO;
import entity.Acomplishment;
import entity.User;

/**
 * Servlet implementation class PreviewUserStoriesServlet
 */
@WebServlet(name = "UserStoriesPreviewer", urlPatterns = { "/UserStoriesPreviewer" })
public class PreviewUserStoriesServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PreviewUserStoriesServlet() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("application/json");
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO userDao=myDAOFactory.createUserDAO();
		User u;
		String uName;
		LearnerElemAttr elemAttr=new LearnerElemAttr();
		
		try{
			PrintWriter out=response.getWriter();
			uName=request.getParameter(elemAttr.getUserParamName());
			u=userDao.findUserWithName(uName);
			
				createUserJsonStories(u,out);
		}catch(Exception ex){
			
		}
		
	}

	
	/**
	 * Show description of stories made by the user
	 */
	public void PreviewUserStories(User myUser,PrintWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStoriesOfUser(myUser.getAccountID());
		String stageID;
		RatingDAO rateDao=myDAOFactory.createRatingDAO();
		
		
		/*Loop that shows the story Links*/
		for(int ctr=0;ctr<Stories.size();ctr++){
			myLikeDAO.countStoryLikes(Stories.get(ctr).getID());
			stageID="stage"+Stories.get(ctr).getID();
			
			/*Generate HTML code*/
			out.write("<tr align=\"center\">");
			out.write("<td>"+Stories.get(ctr).getName()+"</td>");
			out.write("<td>"+createScoreLink(rateDao.getTotalScore(Stories.get(ctr).getID()),Stories.get(ctr).getID())
					+"</td>");
			out.write("<td>"+Stories.get(ctr).getFinishTime()+"</td>");
			out.write("<td>"+myLikeDAO.countStoryLikes(Stories.get(ctr).getID())+"</td>");
			out.write("<td>"+createStoryLink(Stories.get(ctr).getID(), stageID)+"</td>");
			
			out.write("</tr>" +
					"<tr><td class=\"hiddenElem\" id=\""+stageID+"\" colspan='5'></td>");
			
			out.write("</tr>");
		}/*End of Loop*/
		//out.write("</table>");
	}
	
	/**
	 * Show description of stories made by the user
	 */
	public void createUserJsonStories(User myUser,PrintWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStoriesOfUser(myUser.getAccountID());
		String stageID;
		RatingDAO rateDao=myDAOFactory.createRatingDAO();
		
		
		out.write("{\"story\":[");
		/*Loop that shows the story Links*/
		for(int ctr=0;ctr<Stories.size();ctr++){
			myLikeDAO.countStoryLikes(Stories.get(ctr).getID());
			stageID="stage"+Stories.get(ctr).getID();
			
			/*Generate HTML code*/
			
			out.write("{\"Name\":\""+Stories.get(ctr).getName()+"\",");
			out.write("\"storyID\":\""+Stories.get(ctr).getID()+"\",");
			out.write("\"Score\":\""+rateDao.getTotalScore(Stories.get(ctr).getID())+"\",");
			out.write("\"TimeFinished\":\""+Stories.get(ctr).getFinishTime()+"\",");
			out.write("\"Likes\":\""+myLikeDAO.countStoryLikes(Stories.get(ctr).getID())+"\",");
			out.write("\"stageID\":\""+stageID+"\"");
			
			if(ctr<Stories.size()-1)
				out.write("},");
			else out.write("}");
		}/*End of Loop*/
		out.write("],");
		out.write("\"writer\":\""+myUser.getName()+"\"}");
		out.flush();
	}
	
	
	/**
	 * Creates a HTML element to Asynchronously get the Story from the server
	 * @param storyID : The ID of the Accomplishment
	 * @param stageID : Where the story will be written
	 * @return
	 */
	public String createStoryLink(int storyID,String stageID){
		String btID="BT_"+storyID;
		String link="<button id='"+btID+"' onclick=\"" +
				"showStory('"+stageID+"',"+storyID+",'"+btID+"')\">";
		return link.concat("See Story</button>");
	}
	
	public String createScoreLink(int Score,int AccomId){
		String linkToViewUser="<a onclick=\"showScores("+AccomId+")\">";
		
		return linkToViewUser.concat(Score+"</a>");
	}
}
