/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package entity;

public class Template {

	private int TemplateID,levelRequirement,plusScore;
	private String StoryURL,RelationURL,Name;
	
	
	public int getTemplateID() {
		return TemplateID;
	}
	public void setTemplateID(int templateID) {
		TemplateID = templateID;
	}
	public int getLevelRequirement() {
		return levelRequirement;
	}
	public void setLevelRequirement(int levelRequirement) {
		this.levelRequirement = levelRequirement;
	}
	public int getPlusScore() {
		return plusScore;
	}
	public void setPlusScore(int plusScore) {
		this.plusScore = plusScore;
	}
	public String getStoryURL() {
		return StoryURL;
	}
	public void setStoryURL(String storyURL) {
		StoryURL = storyURL;
	}
	public String getRelationURL() {
		return RelationURL;
	}
	public void setRelationURL(String relationURL) {
		RelationURL = relationURL;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
