package ajaxAdmin;

import infoResource.ExternalResources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.TemplateDAO;

import entity.User;
import entity.Template;

import servlets.BaseServlet;

/**
 * Servlet implementation class TemplateWriter
 */
@WebServlet("/TemplateWriter")
public class TemplateWriter extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TemplateWriter() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		String templateName=request.getParameter("nameField");
		String RelationContents=request.getParameter("relT"),StoryContents=request.getParameter("storyT");
		int templateLevelReq=Integer.parseInt(request.getParameter("lvlField"));
		int pointsToGive=Integer.parseInt(request.getParameter("ptField"));
		PrintWriter out;
		User sessionUser;
		try{
			HttpSession session = request.getSession();
			out=response.getWriter();
			
			out.write("name: "+templateName+"\n");
			out.write("Level required: "+templateLevelReq+"\n");
			out.write("points: "+pointsToGive+"\n");
			out.write("Story: "+StoryContents+"\n");
			out.write("Relations: "+RelationContents+"\n");
			
			sessionUser=(User) session.getAttribute("user");
			
			Template createdTemplate=new Template();
			createdTemplate.setLevelRequirement(templateLevelReq);
			createdTemplate.setName(templateName);
			createdTemplate.setPlusScore(pointsToGive);
			
			saveTemplates(StoryContents,RelationContents,createdTemplate,sessionUser);
			response.sendRedirect("ViewTemplatesMade.jsp");
		}catch(IOException ioEX){}
		
	}

	private String generateTemplateName(String givenName,User sessionUser){
		Random generator = new Random();
		int r = Math.abs(generator.nextInt());
		
		return givenName+r+"-"+sessionUser.getName();
	}
	
	
	private void saveToDb(Template giventemplate){
		DAOFactory myDaofactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO tdao=myDaofactory.createTemplateDAO();
		
		tdao.addTemplate(giventemplate);
	}
	
	
	private void saveTemplates(String StoryText,String RelationText,Template giventemplate,User sessionUser) throws IOException{
		String prefix=ExternalResources.getPrefix();
		String finalName=generateTemplateName(giventemplate.getName(),sessionUser);
		
		FileWriter sTemplateWriter=new FileWriter(prefix+"StoryTemplates/"+
				finalName+"_StoryTemplate.txt");
		sTemplateWriter.write(StoryText);
		sTemplateWriter.flush();
		sTemplateWriter.close();
		
		FileWriter rTemplateWriter=new FileWriter(prefix+"RelationTemplates/"+
				finalName+"_RelationTemplate.txt");
		rTemplateWriter.write(RelationText);
		rTemplateWriter.flush();
		rTemplateWriter.close();
		
		giventemplate.setStoryURL(prefix+"StoryTemplates/"+finalName+"_StoryTemplate.txt");
		giventemplate.setRelationURL(prefix+"RelationTemplates/"+finalName+"_RelationTemplate.txt");
		giventemplate.setAuthorID(sessionUser.getAccountID());
		saveToDb(giventemplate);
	}
}
