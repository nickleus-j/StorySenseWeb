package webEncoder;

import java.io.PrintWriter;
import java.util.ArrayList;

import model.Story;
import dao.DAOFactory;
import dao.RelationshipDAO;
import entity.Relation;

public class RatingFormEncoder {

	private String SA,A, D,SD;
	
	public RatingFormEncoder(){
		SA="Strongly Agree";
		A="Agree";
		D="Disagree";
		SD=" Strongly Disagree";
	}
	
	/**
	 * Create a form that will rate the score of the story made
	 * @param theStory
	 * @return
	 */
	public String enterAssertions(Story theStory){
		String RateFormHtml="<form method=\"post\">";
		String submitBt="<input type=\"submit\">";

		
		
		RateFormHtml=RateFormHtml.concat("<table>");
		RateFormHtml=RateFormHtml.concat("<caption class=\"subheader\">Validation</caption>");
		
		RateFormHtml=RateFormHtml.concat("<tr><td>"+enterAssertionsTableCode(theStory)+"</td></tr>");
		
		return RateFormHtml.concat("</table>"+submitBt+"</form>");
	}/*End of function*/
	
	public String getasseriontValidationHtml(int id){
		String formRow="<td>",assertID="assert_"+id;
		formRow=formRow.concat("<input type=\"radio\" name =\""+assertID+"\" value=\""+SD+"\"></td>");
		formRow=formRow.concat("<td><input type=\"radio\" name =\""+assertID+"\" value=\""+D+"\"></td>");
		formRow=formRow.concat("<td><input type=\"radio\" name =\""+assertID+"\" value=\""+A+"\"></td>");
		formRow=formRow.concat("<td><input type=\"radio\" name =\""+assertID+"\" value=\""+SA+"\"></td>");
		return formRow;
	}
	
	/**
	 * Returns HTML code for a table containing the assertions in a story
	 * @param theStory
	 * @return
	 */
	public String enterAssertionsTableCode(Story theStory){
		String RateFormHtml="";
		ArrayList<ArrayList<Relation>> assertions=theStory.getAssertions();
		ArrayList<Relation> relations;
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relationDao=myDAOFactory.createRelationshipDAO();
		String tblHeaders="<th>Knowledge</th><th>Strongly Disagree</th><th>Disagree</th>" +
				"<th>Agree</th><th>Strongly Agree</th>";
		
		
		RateFormHtml=RateFormHtml.concat("<table>"+tblHeaders);
		
		for(int ctr=0;ctr<assertions.size();ctr++){
			relations=assertions.get(ctr);
			for(int i=0;i<relations.size();i++){
				RateFormHtml=RateFormHtml.concat("<tr><td>"+relations.get(i).getConcept1()+" "+
				relationDao.getRelationshipSentence(relations.get(i).getRelationship())+
				" "+relations.get(i).getConcept2()+" </td>");
				
				RateFormHtml=RateFormHtml.concat(getasseriontValidationHtml(ctr));
				
				RateFormHtml=RateFormHtml.concat("</tr>");
			}/*End of relation Loop*/
		}/*End of Assertion loop*/
		return RateFormHtml.concat("</table>");
	}/*End of function*/
}
