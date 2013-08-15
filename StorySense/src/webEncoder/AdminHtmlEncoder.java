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
	
	public String getRelationshipsWithMeaningJSON(){
		String js="[";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relaDao=myDAOFactory.createRelationshipDAO();
		List<Relationship> relationships=relaDao.getRelationships();
		
		for(int ctr=0;ctr<relationships.size();ctr++){
			js=js.concat("{\"Relationship\":\""+relationships.get(ctr).getRelationship()+"\",");
			js=js.concat("\"Meaning\":\""+relationships.get(ctr).getSentence_pattern()+"\"}");
			if(ctr<relationships.size()-1)
				js=js.concat(",");
		}
		
		return js.concat("]");
	}
	
	
	public String getRelationshipsWithMeaningHtmlTable(){
		String code="<table id='"+getSupportedRelationshipsTableId()+"'><caption>Relationships Available</caption>";
		/*DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relaDao=myDAOFactory.createRelationshipDAO();
		List<Relationship> relationships=relaDao.getRelationships();
		
		code=code.concat("<tr><th>Relationship name</th><th>Relationship Meaning</th></tr>");
		
		for(int ctr=0;ctr<relationships.size();ctr++){
			code=code.concat("<tr><td>"+relationships.get(ctr).getRelationship()+"</td>");
			code=code.concat("<td><input value='"+relationships.get(ctr).getSentence_pattern()+"'/></td></tr>");
			
		}
		
		code=code.concat("<tr><td><input type=\"button\" value='Save'/></td>");
		
		return code.concat("</table>");
		*/
		return code.concat(getRelationshipsWithMeaningHtmlTableContents()+"</table>");
	}
	
	public String getRelationshipsWithMeaningHtmlTableContents(){
		String code="";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relaDao=myDAOFactory.createRelationshipDAO();
		List<Relationship> relationships=relaDao.getRelationships();
		
		code=code.concat("<tr><th>Relationship name</th><th>Relationship Meaning</th></tr>");
		
		for(int ctr=0;ctr<relationships.size();ctr++){
			code=code.concat("<tr><td>"+relationships.get(ctr).getRelationship()+"</td>");
			code=code.concat("<td><input value='"+relationships.get(ctr).getSentence_pattern()+"'/></td></tr>");
			/*if(ctr<relationships.size()-1)
				code=code.concat(",");*/
		}
		
		code=code.concat("<tr><td><input type=\"button\" value='Save'/></td>");
		
		return code;
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
	
	public String getSupportedRelationshipsTableId(){return "supportedTable";}
}
