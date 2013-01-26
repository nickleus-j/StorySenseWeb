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
		//tableCode=tableCode.concat("<tr><td>User size"+Users.size()+"</td></tr>");
			for(int ctr=0;ctr<Users.size();ctr++)
				tableCode=tableCode.concat("<tr>"+
				"<td><img src='"+picURls.get(ctr)+"' class='profPic'/>"+Users.get(ctr).getName()+"</td>"+
				"<td>"+Users.get(ctr).getLevel()+"</td>"+
				"<td>"+Users.get(ctr).getPoints()+"</td>"+
				"</tr>");
				
		 //return "<tr><td>lddd</td></tr>";
			return tableCode;
	}
	
	public String doThis(){return ":D D:";}
}
