package serializableObjects;

import java.io.Serializable;
import java.util.ArrayList;

import entity.Acomplishment;

import model.Story;

public class StoryFileAccess implements Serializable {

	private Story myStory;
	private Acomplishment myAccomplishment;
	private ArrayList<String> Answers;
	
	public StoryFileAccess(Story story,ArrayList<String> ans){
		myStory=story;
		Answers=ans;
	}
	
	/*Getter setter*/
	public Story getMyStory() {return myStory;}
	public void setMyStory(Story myStory) {this.myStory = myStory;}
	public Acomplishment getMyAccomplishment() {return myAccomplishment;}
	public void setMyAccomplishment(Acomplishment myAccomplishment) {this.myAccomplishment = myAccomplishment;}
	public ArrayList<String> getAnswers() {return Answers;}
	public void setAnswers(ArrayList<String> answers) {Answers = answers;}
	
	
	
}
