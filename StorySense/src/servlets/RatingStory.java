package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RatingStory
 */
@WebServlet(description = "rates a story submitted", urlPatterns = { "/RatingStory" })
public class RatingStory extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RatingStory() {
        
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

}
