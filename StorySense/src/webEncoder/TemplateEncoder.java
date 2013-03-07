package webEncoder;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.TemplateDAO;
import entity.Template;

public class TemplateEncoder {

	public String showTemplateList(){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateDao=myDAOFactory.createTemplateDAO();
		String code="<table border=\"2\"><caption>Templates</caption>";
		ArrayList<Template> templates=null;
		
		templates=(ArrayList<Template>)templateDao.getAlltemplates();
		
		if(templates==null)
			code=code.concat("<tr><td>Problem occured</td></tr>");
		
		else{
			for(int ctr=0;ctr<templates.size();ctr++){
				code=code.concat("<tr><th>Template name</th><td>"
						+templates.get(ctr).getName()+"</td><td><button>View Template</button></td></tr>");
			}
			//code=code.concat("<tr")
		}
		
		return code.concat("</table>");
	}
	
}
