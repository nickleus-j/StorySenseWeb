package webEncoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.UserDAO;

import model.Story;
import serializableObjects.StoryFileAccess;
import entity.Acomplishment;
import entity.User;

public class CompleteStoryLoader {

	//private User myUser;
	
	public CompleteStoryLoader(){}
	/*
	public CompleteStoryLoader(User u){
		myUser=u;
	}
	
	/*Methods*/
	public String previewStory(StoryFileAccess StoryF)
    {   
		Story Story=StoryF.getMyStory();
        String story_preview = Story.getsStory();
        for (int i=0; i<StoryF.getAnswers().size(); i++)
        {
        story_preview = story_preview.replaceFirst("<input type='text' width='15' name='answer"+(i+1)+
        		"' id='answer"+(i+1)+"'/>.",
        		StoryF.getAnswers().get(i)+" ");
        story_preview = story_preview.replaceFirst("<input type='text' width='15' name='answer"+(i+1)+"' />.",
        		StoryF.getAnswers().get(i)+" ");
        }
        
        return story_preview;
    }
	
	
	public String loadStory(String fileUrl){
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(fileUrl);
			ObjectInputStream oi = new ObjectInputStream(fileIn);
			StoryFileAccess storyFile=(StoryFileAccess)oi.readObject();
			fileIn.close();
			return previewStory(storyFile);
		} catch(IOException ioEx){
			return "File path problems D:";
		}
		catch(Exception ex){
			//out.println("Error in getting the story\n"+ex.getMessage());
		}
		return "Error";
	}
	
	public void showStories(JspWriter out){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		ArrayList<Acomplishment> Stories=(ArrayList<Acomplishment>)myAcomDAO.getAllStories();
		UserDAO myUserDao=myDAOFactory.createUserDAO();
		User myUser;
		
		try{
		out.write("<pre>");
		out.println("Stories");
		for(int ctr=0;ctr<Stories.size();ctr++){
			out.write("<hr/>");
			myUser=myUserDao.getUser(Stories.get(ctr).getAccountID());
			out.write("<b>Title</b>: "+Stories.get(ctr).getName()+" <b>Made by </b>"+myUser.getName()+"<br/>");
			out.println(loadStory(Stories.get(ctr).getFileURL()));
		}
		
		out.write("</pre>");
		}catch(IOException ie){}
	}
	
	
	/*For demo purpose*/
	public String loadSampleStory(){
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream("The introduction of Simba522066365Simba.story");
			
			ObjectInputStream oi = new ObjectInputStream(fileIn);
			StoryFileAccess storyFile=(StoryFileAccess)oi.readObject();
			fileIn.close();
			return previewStory(storyFile);
		} catch(IOException ioEx){
			return "File path problems D:";
		}
		catch(Exception ex){
			//out.println("Error in getting the story\n"+ex.getMessage());
		}
		return "Error";
	}
}
