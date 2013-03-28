package ajaxServlets;

import infoResource.AttributeNames;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import servlets.BaseServlet;
import webEncoder.StoryEncoder;

/**
 * Servlet implementation class AJAXStoryGen
 */
@WebServlet(description = "Async Call to generate an  incomplete story", urlPatterns = { "/AJAXStoryGen" })
public class AJAXStoryGen extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AJAXStoryGen() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int level=0;
		
		try{
			level=Integer.parseInt(request.getParameter(AttributeNames.Level.toString()));
		}catch(Exception ex){
			level=0;
		}
		
		StoryEncoder TheEncoder=new StoryEncoder();
		TheEncoder.encodeStory(level);
	}

}
