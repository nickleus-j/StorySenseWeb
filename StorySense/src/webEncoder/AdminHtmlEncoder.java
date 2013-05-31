package webEncoder;

import java.util.List;

import dao.ConceptDAO;
import dao.DAOFactory;
import dao.RelationshipDAO;
import entity.Concept;
import entity.Relationship;

/**
 * Generates HTML Code involving the pages
 * used by the Administrators
 */ 
public class AdminHtmlEncoder {

	public String getRelationshipsJs(){
		String js="[";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relaDao=myDAOFactory.createRelationshipDAO();
		List<Relationship> relationships=relaDao.getRelationships();
		
		for(int ctr=0;ctr<relationships.size();ctr++){
			js=js.concat("\""+relationships.get(ctr).getRelationship()+"\"");
			if(ctr<relationships.size()-1)
				js=js.concat(",");
		}
		
		return js.concat("]");
	}
	
	public String getConceptTextsJs(){
		String js="[";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ConceptDAO conceptDao=myDAOFactory.createConceptDAO();
		List<Concept> concepts=conceptDao.getConcepts();
		
		for(int ctr=0;ctr<concepts.size();ctr++){
			js=js.concat("\""+concepts.get(ctr).getWord_phrase()+"\"");
			if(ctr<concepts.size()-1)
				js=js.concat(",");
		}
		return js.concat("]");
	}
	
}
