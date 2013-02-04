package servlets;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConceptDAO;
import dao.DAOFactory;
import dao.RelationDAO;

import model.Story;

/**
 * Servlet implementation class StoryWriter
 */
@WebServlet(description = "Writes the story of the learner and saves it", urlPatterns = { "/StoryWriter" })
public class StoryWriter extends BaseServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public StoryWriter() {
        
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		try{
			out = response.getWriter();
			Story myStory=(Story)request.getSession().getAttribute("Story");
			out.println("The story");
			
			if(myStory!=null){
				out.println(myStory.getsStory());
				submitStory(myStory, out,request);
			}
			else out.println("Not forwarded");
		}catch(Exception ex){
			out.println("Error in getting the story");
		}
	}
	
	public void saveStory(ArrayList<String> Answers,Story myStory){
		
	}
	
	
	/**
	 * Submits the story
	 * @param Story
	 * @param out
	 * @param request
	 */
	public void submitStory(Story Story,PrintWriter out,HttpServletRequest request){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ConceptDAO conceptDao=myDAOFactory.createConceptDAO();
		String attName="";
		ArrayList<String> answers=new ArrayList<String>();
		RelationDAO relationAccess=myDAOFactory.createRelationDAO();
		
		/*
		 * Collect the information from the text boxes
		 */
		for(int ctr=1;ctr<=Story.getBlanks();ctr++){
			attName="answer"+ctr;
			answers.add(request.getParameter(attName));
			conceptDao.AddConcept(answers.get(ctr-1));
		}
		
		for(int i=0;i<Story.getAssertions().size(); i++){
			for(int j=0; j<Story.getAssertions().get(i).size();j++){
				//turn the ? into the ones inputted in the blanks
                if(Story.getAssertions().get(i).get(j).getConcept1().equals("?"))
                {
                    Story.getAssertions().get(i).get(j).setConcept1(answers.get(i));
                }
                if(Story.getAssertions().get(i).get(j).getConcept2().equals("?"))
                {
                    Story.getAssertions().get(i).get(j).setConcept2(answers.get(i));
                }
                
                /*Increment frequency if the relation is existing*/
                if(relationAccess.RelationIsExisting(Story.getAssertions().get(i).get(j).getConcept1(), 
                		Story.getAssertions().get(i).get(j).getConcept2(),
                		Story.getAssertions().get(i).get(j).getRelationship()))
                {
                	relationAccess.incrementFrequencyCount(Story.getAssertions().get(i).get(j).getConcept1(), 
                			Story.getAssertions().get(i).get(j).getConcept2(), 
                			Story.getAssertions().get(i).get(j).getRelationship());
                }
			}//End of inner loop
		}//End of outer loop
		
		
	}
	

}
