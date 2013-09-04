package ajaxAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.RelationDAO;

import servlets.BaseServlet;

/**
 * Servlet implementation class RelationInserter
 */
@WebServlet({ "/addRelation", "/addKnwoledge" })
public class RelationInserter extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RelationInserter() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		String c1=request.getParameter("c1"),rel=request.getParameter("rel"),c2=request.getParameter("c2");
		
		try {
			insertRelation(response.getWriter(),c1,rel,c2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void insertRelation(PrintWriter out,String c1, String rel,String c2){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationDAO relationAccess=myDAOFactory.createRelationDAO();
		
		/*if the relation is existing*/
		if(relationAccess.RelationIsExisting(c1,c2,rel)){
			out.write("relation already existing");
		}
		else {
			relationAccess.AddRelation(c1,c2,rel);
			out.write("Relation Added");
		}
	}
}
