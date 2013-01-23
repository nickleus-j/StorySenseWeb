package dao;

import java.util.List;

import entity.Relationship;


public abstract class RelationshipDAO {

	public abstract void addRelationship(String Relationship,String Sentence);
	public abstract String getRelationshipSentence(String Relationship);
	public abstract List<Relationship> getRelationships();
	//public abstract Relationship getMatchingRelationship(String Relationship);
}
