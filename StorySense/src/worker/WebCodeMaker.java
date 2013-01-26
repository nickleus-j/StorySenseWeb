package worker;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;

import dao.DAOFactory;
import dao.ProfileDAO;
import dao.UserDAO;
import entity.User;

/**
 * Used to return Stings or other data types in generating the
 * HTML code output to be interpreted by the web browser
 * @author nickleus
 *
 */
public class WebCodeMaker {

	private JspWriter out;
	
	
	public WebCodeMaker(JspWriter writer){
		out=writer;
	}
	
	/*	Methods	<% //LBoardHTMLGenerator generator=new LBoardHTMLGenerator(); %>*/
	public void writeJsElementReference(String elementName){
		try {
			out.write("\""+elementName+"\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String giveJsStringParam(String elementName){
		return "\""+elementName+"\"";
	}
	
	public String getleaderBoardHTMLTable(){
		String tableCode="";
		
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO myUserDAO = myDAOFactory.createUserDAO();
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		
		ArrayList<User> Users=(ArrayList<User>)myUserDAO.getTopLearners();
		ArrayList<String> picURls=(ArrayList<String>)profileDAO.getLeaderPicUrl();
		
			for(int ctr=0;ctr<Users.size();ctr++)
				tableCode.concat("<tr>"+
				"<td><img src='"+picURls.get(ctr)+"' class='profPic'/>"+Users.get(ctr).getName()+"</td>"+
				"<td>15</td>"+
				"<td>1510</td>"+
				"</tr>");
				
		 //return "<tr><td>lddd</td></tr>";
			return tableCode;
	}
	
	public String doThis(){return ":D D:";}
}
