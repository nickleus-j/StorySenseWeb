package webEncoder;

import infoResource.ReviewerResource;

import java.io.PrintWriter;
import java.util.ArrayList;

import model.Question;
import model.Story;
import dao.DAOFactory;
import dao.RelationshipDAO;
import entity.Relation;

/**
 * Encodes The html elements that will be used in creating
 * a rating for the stories written
 * @author nickleus
 *
 */
public class RatingFormEncoder {

	private String SA,A, D,SD;
	public static final String  Assert="assert_";
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
		String formRow="<td>",assertID=Assert+id;
		formRow=formRow.concat("<input type=\"radio\" name =\""+assertID+"\" value=\""+0+"\"></td>");
		formRow=formRow.concat("<td><input type=\"radio\" name =\""+assertID+"\" value=\""+1+"\"></td>");
		formRow=formRow.concat("<td><input type=\"radio\" name =\""+assertID+"\" value=\""+3+"\" checked=\"checked\"></td>");
		formRow=formRow.concat("<td><input type=\"radio\" name =\""+assertID+"\" value=\""+4+"\"></td>");
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
		String tblHeaders="<th>Knowledge</th><th>"+SD+"</th><th>"+D+"</th><th>"+A+"</th>" +
				"<th>"+SA+"</th>";
		
		
		RateFormHtml=RateFormHtml.concat("<table align=\"center\">"+tblHeaders);
		
		for(int ctr=0;ctr<assertions.size();ctr++){
			relations=assertions.get(ctr);
			for(int i=0;i<relations.size();i++){
				RateFormHtml=RateFormHtml.concat("<tr><td>"+relations.get(i).getConcept1()+" "+
				relationDao.getRelationshipSentence(relations.get(i).getRelationship())+
				" "+relations.get(i).getConcept2()+" </td>");
				
				RateFormHtml=RateFormHtml.concat(getasseriontValidationHtml(ctr*10+i));
				
				RateFormHtml=RateFormHtml.concat("</tr>");
			}/*End of relation Loop*/
		}/*End of Assertion loop*/
		return RateFormHtml.concat("</table>");
	}/*End of function*/
	
	public String generateQuestionTblHtml(Story theStory){
		String code="<table>";
		
		return code.concat(showStoryQuestions(theStory)+"</table>");
	}
	
	/**
	 * Requires to be place in a table element in HTML
	 * @param theStory
	 * @return
	 */
	public String showStoryQuestions(Story theStory){
		String code="",caption="<Caption>Questions</Caption>";
		ArrayList<Question> questions=theStory.getQuestion();
		
		if(!questions.isEmpty())
			code=code.concat(caption);
		
		for(int ctr=0;ctr<questions.size();ctr++){
			code=code.concat("<tr><td>"+questions.get(ctr).getQuestion()+"</td>");
			code=code.concat("<td>"+questions.get(ctr).getOption1()+"</td>");
			code=code.concat("<td>"+questions.get(ctr).getOption2()+"</td></tr>");
		}
		
		return code;
	}
	
	/**
	 * generates HTML code that will show a
	 * combobox that will determine how much the 
	 * reviewer like the story
	 * @return
	 */
	public String createSatisfactionSelectHtml(){
		String select="<select name=\"quality\" id=\"quality\">";
		ReviewerResource rr=new ReviewerResource();
		String[] options=rr.getSatisfactionOptions();
		
		for(int ctr=0;ctr<options.length;ctr++)
			select=select.concat("<option>"+options[ctr]+"</option>");
		
		return select.concat("</select>");
	}
	
}
