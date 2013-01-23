package entity;

public class Relationship {
//RelationshipID | Relationship   | Sentence_pattern 
	private int RelationshipID;
	private String Relationship,Sentence_pattern;
	
	
	/*
	 * accessors and modifiers
	 */
	public int getRelationshipID() {return RelationshipID;}
	public void setRelationshipID(int relationshipID) {RelationshipID = relationshipID;}
	public String getRelationship() {return Relationship;}
	public void setRelationship(String relationship) {Relationship = relationship;}
	public String getSentence_pattern() {return Sentence_pattern;}
	public void setSentence_pattern(String sentence_pattern) {Sentence_pattern = sentence_pattern;}
	
	
	
}
