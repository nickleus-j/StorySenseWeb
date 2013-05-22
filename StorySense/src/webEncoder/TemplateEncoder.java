/*******************************************************************************
 *Copyright (c) 2013 Story Sense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
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
		}
		
		return code.concat("</table>");
	}

	public String showTemplateList(int author){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateDao=myDAOFactory.createTemplateDAO();
		String code="<table border=\"2\"><caption>Templates</caption>";
		ArrayList<Template> templates=null;
		
		templates=(ArrayList<Template>)templateDao.getAlltemplates();
		
		if(templates==null||templates.isEmpty())
			code=code.concat("<tr><td>Problem occured</td></tr>");
		
		else{
			for(int ctr=0;ctr<templates.size();ctr++){
				code=code.concat("<tr><th>"+templates.get(ctr).getName()+"</th>" +
						"<td><button>View Template</button></td></tr>");
			}
		}
		
		return code.concat("</table>");
	}
}
