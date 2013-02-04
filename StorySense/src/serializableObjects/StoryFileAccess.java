package serializableObjects;

import java.io.Serializable;

import entity.Acomplishment;

import model.Story;

public class StoryFileAccess implements Serializable {

	private Story myStory;
	
	private Acomplishment myAccomplishment;
	
	
	/*Getter setter*/
	public Story getMyStory() {return myStory;}
	public void setMyStory(Story myStory) {this.myStory = myStory;}
	public Acomplishment getMyAccomplishment() {return myAccomplishment;}
	public void setMyAccomplishment(Acomplishment myAccomplishment) {this.myAccomplishment = myAccomplishment;}
	
	
	
}
