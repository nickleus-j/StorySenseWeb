package webEncoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Story;
import serializableObjects.StoryFileAccess;
import entity.User;

public class CompleteStoryLoader {

	private User myUser;
	
	public CompleteStoryLoader(){}
	
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
        story_preview = story_preview.replaceFirst("<input type='text' width='15' name='answer"+(i+1)+"' />.",
        		StoryF.getAnswers().get(i)+" ");
        }
        
        return story_preview;
    }
	
	/*For demo purpose*/
	public String loadSampleStory(){
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream("The introduction of Simba522066365Simba.story");
			ObjectInputStream oi = new ObjectInputStream(fileIn);
			StoryFileAccess storyFile=(StoryFileAccess)oi.readObject();
			return previewStory(storyFile);
		} catch(IOException ioEx){
			//out.println("Error in reading the story"+ioEx.getMessage());
		}
		catch(Exception ex){
			//out.println("Error in getting the story\n"+ex.getMessage());
		}
		return "Error";
	}
}
