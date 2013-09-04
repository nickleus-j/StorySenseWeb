package webEncoder;

import java.util.List;

import dao.ConceptDAO;
import dao.ConfigValuesDAO;
import dao.DAOFactory;
import dao.RelationshipDAO;
import entity.Concept;
import entity.ConfigValues;
import entity.Relationship;

/**
 * Generates HTML Code involving the pages
 * used  in Administrator pages
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
	
	/**
	 * Generates HTML table code containing
	 * the relationships supported by the ontology
	 * @return relationshipsHtmlTable
	 */
	public String getRelationshipsWithMeaningHtmlTable(){
		String code="<table bgcolor=\"white\"style=\"border: 4px solid #660000; border-radius: 4px;\" id='"+getSupportedRelationshipsTableId()+"'><tr><th colspan=\"2\" style=\"font-family: Segoe UI; background-color: #660000; color: white;\">Relationships Available</tr></th>";
		
		return code.concat(getRelationshipsWithMeaningHtmlTableContents()+"</table>");
	}
	
	/**
	 * Returns in HTML rows the relationships supported by the ontology
	 * The text booxes allow saving of any possible changes
	 * @return
	 */
	public String getRelationshipsWithMeaningHtmlTableContents(){
		String code="";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relaDao=myDAOFactory.createRelationshipDAO();
		List<Relationship> relationships=relaDao.getRelationships();
		
		code=code.concat("<tr><th>Relationship name</th><th>Relationship Meaning</th></tr>");
		
		for(int ctr=0;ctr<relationships.size();ctr++){
			code=code.concat("<tr><td>"+relationships.get(ctr).getRelationship()+"</td>");
			//code=code.concat("<td><input value='"+relationships.get(ctr).getSentence_pattern()+"'/></td></tr>");
			code=code.concat("<td>"+relationships.get(ctr).getSentence_pattern()+"</td></tr>");
			
		}
		
		//code=code.concat("<tr><td><input type=\"button\" value='Save'/></td>");
		
		return code;
	}
	
	/**
	 * Returns HTMl string that will generate a table where the settings can change
	 * @return
	 */
	public String getSettingsHTML(){
		String code="<table align='center' class='settingTbl'><caption>Settings</caption>";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ConfigValuesDAO configDao=myDAOFactory.createConfigValuesDAO();
		List<ConfigValues> configurationSettings=configDao.getConfigurationSettings();
		
		for(int ctr=0;ctr<configurationSettings.size();ctr++){
			code+=("<tr><td>"+configurationSettings.get(ctr).getSettingName()+"<td>");
			code+=("<td><input id=\"setting"+ctr+"\" " +
					"value=\""+configurationSettings.get(ctr).getValue()+"\"/></td>");
			code+=("<td><input type='button' value='save' onclick=\"changeSetting(" +configurationSettings.get(ctr).getValueID()+
					",'setting"+ctr+"')\"/></td>");
		}
		
		
		return code.concat("</table>");
	}
	
	/**
	 * represents in JSON format the concepts stored in the database
	 * @return JSON code representing the Concept
	 */
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
