package dao;

import java.util.ArrayList;

import entity.Relation;


public abstract class RelationDAO {

	public abstract ArrayList<String> getConcept1ByRelationship(String concept2, String relationship, int confidence);
	public abstract  ArrayList<String> getConcept2ByRelationship(String concept1, String relationship, int confidence);
	public abstract ArrayList<String> getSynonyms(String concept, int confidence);
	public abstract String getSingleConcept1ByRelationship(String concept2, String relationship, int confidence);
	public abstract String getSingleConcept2ByRelationship(String concept1, String relationship, int confidence);
	public abstract boolean RelationIsExisting(String concept1, String concept2, String relationship);
	public abstract ArrayList<Relation> getRelations();
	public abstract Relation getRelationScoreAndValidate(String concept1, String concept2, String relationship);
	public abstract boolean RelationIsConfident(String concept1, String concept2, String relationship, int confidence);
	public abstract void incrementIsMeaningless(String concept1, String concept2, String relationship);
	public abstract void incrementFrequencyCount(String concept1, String concept2, String relationship);
	public abstract void updateRelationScore(String concept1, String concept2, String relationship, int added_score);
	public abstract void deleteIfMeaningless(String concept1, String concept2, String relationship, int meaningless_count);
}
