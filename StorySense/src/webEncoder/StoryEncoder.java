package webEncoder;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import dao.DAOFactory;
import dao.TemplateDAO;
import entity.Template;


import model.Story;

/**
 * Encodes the Story generated into HTML
 * so that the browsers can show them to the users
 * @author nickleus
 *
 */
public class StoryEncoder {

	private HttpServletRequest Request;
	private JspWriter Out;
	
	public StoryEncoder(HttpServletRequest request,JspWriter out){
		Request=request;
		Out=out;
	}
	
	public String writeStory(){
		
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateFactory=myDAOFactory.createTemplateDAO();
		ArrayList<Template> templateList=(ArrayList<Template>)templateFactory.getAlltemplates();
		StoryGenerator storyMaker=new StoryGenerator(templateList, getConfidence());//Number of templates and Confidence for now
		Story myStory=storyMaker.getStory();
		
		return myStory.getsStory();
	}
	
	public void encodeStory(){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateFactory=myDAOFactory.createTemplateDAO();
		ArrayList<Template> templateList=(ArrayList<Template>)templateFactory.getAlltemplates();
		StoryGenerator storyMaker=new StoryGenerator(templateList, getConfidence());//Number of templates and Confidence for now
		
		Story myStory=storyMaker.getStory();
		
		Request.getSession().setAttribute("Story", myStory);
		Request.getSession().setAttribute(TEMPLATEID, storyMaker.getTemplateID());
		try {
			Out.write(myStory.getsStory());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getStoryAttributeName(){return "Story";}
	public int getConfidence(){ return 60;}
	public static final String  TEMPLATEID="templateID";
}
