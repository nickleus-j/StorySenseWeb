/*******************************************************************************
 *Copyright (c) 2013 StorySenes
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package entity;

public class LikedStory {

	private int key,storyID,userID;
	private String userName,storyName;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getStoryID() {
		return storyID;
	}
	public void setStoryID(int storyID) {
		this.storyID = storyID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
	
	
}
