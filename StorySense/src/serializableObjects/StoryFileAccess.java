/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
package serializableObjects;

import java.io.Serializable;
import java.util.ArrayList;

import entity.Acomplishment;

import model.Story;

public class StoryFileAccess implements Serializable {

	private Story myStory;
	private ArrayList<String> Answers;
	
	public StoryFileAccess(Story story,ArrayList<String> ans){
		myStory=story;
		Answers=ans;
	}
	
	/*Getter setter*/
	public Story getMyStory() {return myStory;}
	public void setMyStory(Story myStory) {this.myStory = myStory;}
	/*public Acomplishment getMyAccomplishment() {return myAccomplishment;}
	public void setMyAccomplishment(Acomplishment myAccomplishment) {this.myAccomplishment = myAccomplishment;}*/
	public ArrayList<String> getAnswers() {return Answers;}
	public void setAnswers(ArrayList<String> answers) {Answers = answers;}
	
	
	
}
