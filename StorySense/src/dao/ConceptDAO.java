package dao;

import java.util.List;

import entity.Concept;


public abstract class ConceptDAO {

	public abstract void AddConcept(String Word_Phrase);
	public abstract List<Concept> getConcepts();
	public abstract List<Concept> getConceptWithMatchingTitle(String concept);
	public abstract Concept getConcept(String concept);
}
