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
