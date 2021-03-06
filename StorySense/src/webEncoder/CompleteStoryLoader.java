/*******************************************************************************
 *Copyright (c) 2013 Story Sense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez 
 *******************************************************************************/
package webEncoder;

import infoResource.ExternalResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.LikedStoryDAO;
import dao.RatingDAO;
import dao.UserDAO;

import model.Story;
import serializableObjects.StoryFileAccess;
import entity.Acomplishment;
import entity.User;

/**
 * This loads the stories from the server to be returned to the browser
 * The AJAXscripts must be loaded from the html file for full functionality
 * @author nickleus`
 *
 */
public class CompleteStoryLoader {

	private User SessionUser;
	public CompleteStoryLoader(){}

	public CompleteStoryLoader(User u){
		SessionUser=u;
	}
	/*Methods*/
	public String previewStory(StoryFileAccess StoryF)
    {   
		Story Story=StoryF.getMyStory();
        String story_preview = Story.getsStory();
        for (int i=0; i<StoryF.getAnswers().size(); i++)
        {
        	/*revised story writer format
        	 * File version difference causes multiple replacements
        	 */
        story_preview = story_preview.replaceFirst("<input type='text' width='15' name='answer"+(i+1)+
        		"' id='answer"+(i+1)+"'/>.",
        		StoryF.getAnswers().get(i)+" ");
        story_preview = story_preview.replaceFirst("<input type='text' width='15' name='answer"+(i+1)+"' />.",
        		StoryF.getAnswers().get(i)+" ");
        }
        
        return story_preview;
    }
	
	/**
	 * Loads a story given the file entered
	 * /var/lib/openshift/51dd87aa5973ca662000002e/app-root/repo/diy/tomcat/webapps/StorySense/
	 */
	public String loadStory(String fileUrl){
		FileInputStream fileIn;
		String prefix=ExternalResources.getPrefix();
		try {
			fileIn = new FileInputStream(prefix+fileUrl);
			ObjectInputStream oi = new ObjectInputStream(fileIn);
			StoryFileAccess storyFile=(StoryFileAccess)oi.readObject();
			fileIn.close();
			oi.close();
			return previewStory(storyFile);
		} catch(IOException ioEx){
			System.out.println("Exception stroy: " + ioEx.toString());
			return "File path problems";
		}
		catch(Exception ex){
			//out.println("Error in getting the story\n"+ex.getMessage());
		}
		return "Error";
	}
	/**
	 * Shows the stories requires the AjaxScripts
	 * @param out
	 */
	public void showStories(JspWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStories(10);
		
		encodeStoriesInHTML(out,Stories,myDAOFactory.createUserDAO());
	}
	
	/**
     * This function is to be used in a JSP File
    generates HTML code that will display the stories writen and some about them
    */
	private void encodeStoriesInHTML(JspWriter out,ArrayList<Acomplishment> Stories,UserDAO myUserDao){
		User myUser;
		try{
			out.write("<table id=\"tableBorderfeed2\" bgcolor=\"white\">");
			out.write("<tr><td id='1st'></td></tr>");
			/*loop that displays the stories*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				out.write("<tr class=\"storyHead\" onClick=\"window.location.href='StoryDisplay.jsp?aID="+Stories.get(ctr).getID()+"'\">");
				myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
				out.write("<th></th><td style=\"font-size: 5px\"> \""+Stories.get(ctr).getName()+"\"</td> <th> </th>" +
						"<td>"+myUser.getName()+"</td></tr>");
				
				if(SessionUser!=null)
					out.write(generateLikeRow(Stories.get(ctr))+"</tr>");
				out.write("<tr><td colspan=\"4\">");
				out.println("<br/>"+loadStory(Stories.get(ctr).getFileURL()));
				out.write("<hr/></td></tr>");
				
			}/*End of Loop*/
			out.write("</table>");
			}catch(IOException ie){}
	}
	
	public void encodeStoriesInHTML(JspWriter out,ArrayList<Acomplishment> Stories,User myUser){
		/*
		 * <td style=\"font-size: 5px\" " +
						"onClick=\"window.location.href='StoryDisplay.jsp?aID="+Stories.get(ctr).getID()+"'\"> 
		 */
		try{
			out.write("<table id=\"tableBorderfeed2\" bgcolor=\"white\">");
			out.write("<tr><td id='1st'></td></tr>");
			/*loop that displays the stories*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				out.write("<tr class=\"storyHead\" " +
						"onClick=\"window.location.href='StoryDisplay.jsp?aID="+Stories.get(ctr).getID()+"'\">");
				out.write("<th></th><td style=\"font-size: 5px\"> \""+Stories.get(ctr).getName()+"\"</td> <th> </th>" +
						"<td>"+myUser.getName()+"</td></tr>");
				
				if(SessionUser!=null)
					out.write(generateLikeRow(Stories.get(ctr))+"</tr>");
				out.write("<tr><td colspan=\"4\">");
				out.println("<br/>"+loadStory(Stories.get(ctr).getFileURL()));
				out.write("<hr/></td></tr>");
			}/*End of Loop*/
			out.write("</table>");
			//out.write("</p>");
			}catch(IOException ie){}
	}
	
	public void encodeStory(int storyID,JspWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		Acomplishment story=myAcomDAO.getStory(storyID);
		String code="<h1>"+story.getName()+"</h1><hr/>";
		
		try{
			out.write(code+generateLikeStoryBtHTML(story)+"<br/>"+loadStory(story.getFileURL()));
		}catch(IOException ie){}
	}
	
	/**
	 * Shows the stories requires the AjaxScripts
	 * @param out
	 */
	public void showStories(JspWriter out,int limit){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStories(limit);
		
		encodeStoriesInHTML(out,Stories,myDAOFactory.createUserDAO());
		
	}
	
	/**This generates an HTML code to be 
	 * Placed in an HTML table
	 * The row generated shows the number of people who liked
	 * the story
	 */
	public String generateLikeRow(Acomplishment myStory){
		//User myUser=(User)request.getSession().getAttribute("user");
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		
		String storyID="story"+myStory.getID();
		String val="<td style=\"align: right;\" id=\""+storyID+"\"" +
				">"+myLikeDAO.countStoryLikes(myStory.getID())+"</td>";
		
		val=val.concat("<td>"+generateLikeButtonHTML(storyID, myStory)+"</td>");
		
		return val.concat("</tr>");
	}
	
	private String generateLikeButtonHTML(String storyID,Acomplishment myStory){
		String btElemName="btStory" +storyID,btIDElemName="id=\""+btElemName+"\"";
		String btCode="";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		
		if(myLikeDAO.didUserLike(SessionUser.getAccountID(), myStory.getID())){
			btCode=btCode.concat("<button "+btIDElemName+" " +
					"onclick=\"showNumberOfLikes('"+storyID+"'," +myStory.getID()+",'--','"+btElemName+"')\">" +"Unlike");
		}
		else btCode=btCode.concat("<button "+btIDElemName+
				" onclick=\"showNumberOfLikes('"+storyID+"'," +myStory.getID()+","+"'like','"+btElemName+"')\">" +
				"Like");
		
		return btCode.concat("</button>");
	}
	
	
	/**
	 * Generates HTML syntax for a button that will like/unlike a
	 * story when clicked
	 * @param storyID
	 * @param myStory
	 * @return
	 */
	private String generateLikeStoryBtHTML(Acomplishment myStory){
		int storyID=myStory.getID();
		String btElemName="btStory" +storyID,btIDElemName="id=\""+btElemName+"\"";
		String btCode="";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		
		btCode+=myLikeDAO.countStoryLikes(storyID);
		if(myLikeDAO.didUserLike(SessionUser.getAccountID(), myStory.getID())){
			btCode=btCode.concat("<button "+btIDElemName+" " +
					"onclick=\"showNumberOfLikes('"+storyID+"'," +myStory.getID()+",'--','"+btElemName+"')\">" +"Unlike");
		}
		else btCode=btCode.concat("<button "+btIDElemName+
				" onclick=\"showNumberOfLikes('"+storyID+"'," +myStory.getID()+","+"'like','"+btElemName+"')\">" +
				"Like");
		
		return btCode.concat("</button>");
	}
	
	/**
	 * Show description of stories made by the user
	 */
	public void showUserStoryPreviews(User myUser,JspWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStoriesOfUser(myUser.getAccountID());
		
		try{
			out.write("<table><caption>your stories</caption>");
			
			/*Table header*/
			out.write("<tr>");
			out.write("<th> Title </th>");
			out.write("<th> Time Finished </th>");
			out.write("<td>Link</td>");
			out.write("</tr>");
			
			/*Loop that shows the story Links*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				out.write("<tr align=\"center\">");
				out.write("<td>"+Stories.get(ctr).getName()+"</td>");
				out.write("<td>"+Stories.get(ctr).getFinishTime()+"</td>");
				out.write("<td>"+createStoryLink(Stories.get(ctr).getID(), "storyStage")+"</td>");
				//out.write("<td>See Story</td>");
				out.write("</tr>");
			}/*End of Loop*/
			out.write("</table>");
		}catch(IOException ie){}
	}
	
	/**
	 * Show description of stories made by the user
	 */
	public void PreviewUserStories(User myUser,JspWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStoriesOfUser(myUser.getAccountID());
		String stageID;
		try{
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
		}catch(IOException ie){}
	}
	
	public void previewLikedStories(User myUser,JspWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		UserDAO myUserDAO=myDAOFactory.createUserDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getUserLikedStories(myUser.getAccountID());
		String stageID,likeCtrID;
		User author;
		HtmlLinkEncoder linkEncoder=new HtmlLinkEncoder();
		try{
			
			out.write("<tr><th>Title</th><th>Author</th>" +
					"<th>Likes</th><th>View</th></tr>");
			
			/*Loop that shows the story Links*/
			for(int ctr=0;ctr<Stories.size();ctr++){
				myLikeDAO.countStoryLikes(Stories.get(ctr).getID());
				stageID="LikeStage"+Stories.get(ctr).getID();
				author=myUserDAO.getUser(Stories.get(ctr).getAccountID());
				likeCtrID="likeStory"+Stories.get(ctr).getID();
				/*Generate HTML code*/
				out.write("<tr align=\"center\">");
				out.write("<td>"+Stories.get(ctr).getName()+"</td>");
				out.write("<td>"+linkEncoder.createLinkToUser(author)+"</td>");
				
				/*Like column*/
				out.write("<td><b id='"+likeCtrID+"'>"+
						myLikeDAO.countStoryLikes(Stories.get(ctr).getID())+"</b>"+
						generateLikeButtonHTML(likeCtrID, Stories.get(ctr))+"</td>");
				
				out.write("<td>"+createStoryLink(Stories.get(ctr).getID(), stageID)+"</td>");
				
				out.write("</tr>" +
						"<tr><td class=\"hiddenElem\" id=\""+stageID+"\" colspan='4'></td>");
				
				out.write("</tr>");
			}/*End of Loop*/
			//out.write("</table>");
		}catch(IOException ie){}
	}
	
    /**
     *Returns a JSON syntax to be parsed. The syntax returned represents
     * The values of the stories that a user likes. The values are to be 
     * placed in a table to show the stories the user likes
     * 
     * Having it in JSON allows manipulation on the browser/clinet side
     */
	public String PreviewLikedStoriesJson(User myUser){
		String json="{\"story\":[";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		LikedStoryDAO myLikeDAO=myDAOFactory.createLikeDAO();
		UserDAO myUserDAO=myDAOFactory.createUserDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getUserLikedStories(myUser.getAccountID());
		String stageID;
		User author;
		
		for(int ctr=0;ctr<Stories.size();ctr++){
			myLikeDAO.countStoryLikes(Stories.get(ctr).getID());
			stageID="LikeStage"+Stories.get(ctr).getID();
			author=myUserDAO.getUser(Stories.get(ctr).getAccountID());
			
			json=json.concat("{\"Name\":\""+Stories.get(ctr).getName()+"\",");
			json=json.concat("\"authorName\":\""+author.getName()+"\",");
			json=json.concat("\"authorId\":\""+author.getAccountID()+"\",");
			json=json.concat("\"storyID\":\""+Stories.get(ctr).getID()+"\",");
			json=json.concat("\"likeNum\":\""+myLikeDAO.countStoryLikes(Stories.get(ctr).getID())+"\",");
			json=json.concat("\"stageID\":\""+stageID+"\"");
			if(ctr<Stories.size()-1)
				json=json.concat("},");
			else json=json.concat("}");
		}
		
		return json.concat("],\"user\":\""+myUser.getName()+"\"}");
	}
	
	
	public void showUsersWhoLikedStory(int storyID,JspWriter out) throws IOException{
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO myUserDAO=myDAOFactory.createUserDAO();
		List<User> users=myUserDAO.getUserWhoLiked(storyID);
		HtmlLinkEncoder linker=new HtmlLinkEncoder();
		out.write("<hr/><table  align=\"center\" ><h2>Users who liked the story</h2>");
		
		if(users.size()==0){
			out.write("<tr><th>Nobody liked your story yet</th></tr>");
		}
		else {
			for(int ctr=0;ctr<users.size();ctr++)
				out.write("<tr><td>"+linker.createLinkToUser(users.get(ctr))+"</td></tr>");
		}
		
		out.write("</table><hr/>");
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
	
	/**
	 * Creates a HTML element to Asynchronously get the Story from the server
	 * using the story name with a hyperlink
	 * @param theStory
	 * @param stageID
	 * @return
	 */
	public String createStoryLink(Acomplishment theStory,String stageID){
		int storyID=theStory.getID();
		String btID="Link_"+storyID;
		String link="<a id='"+btID+"' onclick=\"" +
				"showStoryClicked('"+stageID+"',"+storyID+")\">";
		return link.concat(theStory.getName()+"</a>");
	}
	public String createScoreLink(int Score,int AccomId){
		String linkToViewUser="<a onclick=\"showScores("+AccomId+")\">";
		
		return linkToViewUser.concat(Score+"</a>");
	}
}
