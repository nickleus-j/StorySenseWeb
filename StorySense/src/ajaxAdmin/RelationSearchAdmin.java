package ajaxAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.RelationDAO;
import entity.Relation;

import servlets.BaseServlet;

/**
 * Servlet implementation class RelationSearchAdmin
 */
@WebServlet("/RelationSearchAdmin")
public class RelationSearchAdmin extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RelationSearchAdmin() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationDAO knowledgeDao=myDAOFactory.createRelationDAO();
		PrintWriter out;
		
		try{
			out=response.getWriter();
			String key=request.getParameter("key");
			ArrayList<Relation> arrRelations=knowledgeDao.getRelationsOfConceptSearch(key);
			
			out.write("[");
			
			for(int ctr=0;ctr<arrRelations.size();ctr++){
				out.write("{\"c1\":\""+arrRelations.get(ctr).getConcept1()+"\",");
				out.write("\"relationship\":\""+arrRelations.get(ctr).getRelationship()+"\",");
				out.write("\"c2\":\""+arrRelations.get(ctr).getConcept2()+"\",");
				out.write("\"confidence\":\""+arrRelations.get(ctr).getConfidence_percentage()+"\"}");
				if(ctr<arrRelations.size()-1)
					out.write(",");
			}
			
			out.write("]");
			
		}catch(IOException ioex){}
		
	}

}
