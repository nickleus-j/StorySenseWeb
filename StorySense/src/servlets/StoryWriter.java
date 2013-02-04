package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
	}

}
