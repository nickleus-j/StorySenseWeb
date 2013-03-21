package ajaxServlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.RelationshipDAO;
import entity.Acomplishment;
import entity.Relation;

import model.Story;

import serializableObjects.StoryFileAccess;
import servlets.BaseServlet;
import webEncoder.CompleteStoryLoader;

/**
 * Servlet implementation class AjaxStoryReviewer
 */
@WebServlet(name = "StoryRater", description = "Generates Code for reviewing", urlPatterns = { "/StoryRater" })
public class AjaxStoryReviewer extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AjaxStoryReviewer() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		Acomplishment ratedStory;
		Story theStory;
		StoryFileAccess sfa;
		int sID=Integer.parseInt(request.getParameter("q"));
		
		ratedStory=myAcomDAO.getStory(sID);
		sfa=getStoryFile(ratedStory.getFileURL());
		theStory=sfa.getMyStory();
		
		try {
			enterAssertions(theStory, response.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Loads a story given the file entered
	 */
	public StoryFileAccess getStoryFile(String fileUrl){
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(fileUrl);
			ObjectInputStream oi = new ObjectInputStream(fileIn);
			StoryFileAccess storyFile=(StoryFileAccess)oi.readObject();
			fileIn.close();
			oi.close();
			return storyFile;
		} catch(IOException ioEx){
			
		}
		catch(Exception ex){
			//out.println("Error in getting the story\n"+ex.getMessage());
		}
		return null;
	}
	
	public void enterRelations(Story theStory,PrintWriter out){
		ArrayList<Relation> relations=theStory.getRelationRules();
		for(int ctr=0;ctr<relations.size();ctr++){
			out.write(relations.get(ctr).getConcept1()+" "+
			relations.get(ctr).getRelationship()+" "+relations.get(ctr).getConcept2()+"<hr/>");
		}/*End of loop*/
	}
	
	public void enterAssertions(Story theStory,PrintWriter out){
		ArrayList<ArrayList<Relation>> assertions=theStory.getAssertions();
		ArrayList<Relation> relations;
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relationDao=myDAOFactory.createRelationshipDAO();
		String tblHeaders="<th>Knowledge</th><th>Strongly Disagree</th><th>Disagree</th>" +
				"<th>Agree</th><th>Strongly Agree</th>";
		//CompleteStoryLoader sLoader=new CompleteStoryLoader();
		out.write("<table>");
		out.write("<caption class=\"subheader\">Validation</caption>");
		out.write("<th>Assertion</th>"+tblHeaders);
		
		for(int ctr=0;ctr<assertions.size();ctr++){
			relations=assertions.get(ctr);
			for(int i=0;i<relations.size();i++){
				out.write("<tr><td>"+relations.get(i).getConcept1()+" "+
				relationDao.getRelationshipSentence(relations.get(i).getRelationship())+
				" "+relations.get(i).getConcept2()+" </td>");
				
				out.write("</tr>");
			}/*End of relation Loop*/
		}/*End of Assertion loop*/
		out.write("</table>");
	}/*End of function*/
	
	
	
}
