package ajaxAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.RelationshipDAO;
import entity.Relationship;

import servlets.BaseServlet;

/**
 * Servlet implementation class RelationshipSupporter
 */
@WebServlet(description = "Adds relationship to be Supported", urlPatterns = { "/RelationshipSupporter" })
public class RelationshipSupporter extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RelationshipSupporter() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationshipDAO relaDao=myDAOFactory.createRelationshipDAO();
		PrintWriter out;
		//Relationship rel=new Relationship();
		
		try{
			out=response.getWriter();
			/*rel.setRelationship(request.getParameter("rl"));
			rel.setSentence_pattern(request.getParameter("sntc"));
			*/
			relaDao.addRelationship(request.getParameter("rl"), request.getParameter("sntc"));
			out.write("Relationship Added");
		}catch(Exception ioEX){}
	}

}
