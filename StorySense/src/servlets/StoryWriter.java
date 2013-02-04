package servlets;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Story;

/**
 * Servlet implementation class StoryWriter
 */
@WebServlet(description = "Writes the story of the learner and saves it", urlPatterns = { "/StoryWriter" })
public class StoryWriter extends BaseServlet {

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
			Story myStory=(Story)request.getAttribute("Story");
			out.println("The story");
			out.println(myStory.getsStory());
		}catch(Exception ex){
			out.println("Error in getting the story");
		}
	}

}
