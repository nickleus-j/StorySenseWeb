package webEncoder;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;

import model.Story;

import dao.DAOFactory;
import dao.ProfileDAO;
import dao.UserDAO;
import entity.User;

/**
 * Used to return Stings or other data types in generating the
 * HTML code output to be interpreted by the web browser
 * This is used for insertables and attributes of tags
 * @author nickleus
 *
 */
public class WebCodeMaker {

	private JspWriter out;
	
	
	public WebCodeMaker(JspWriter writer){
		out=writer;
	}
	
	/*	Methods	*/
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
	
	/**
	 * This generates the HTML code for the leader board based on the contents
	 * of the database
	 * @return LBoardCode
	 */
	public String getleaderBoardHTMLTable(){
		String tableCode="";
		
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO myUserDAO = myDAOFactory.createUserDAO();
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		
		ArrayList<User> Users=(ArrayList<User>)myUserDAO.getTopLearners();
		ArrayList<String> picURls=(ArrayList<String>)profileDAO.getLeaderPicUrl();
			for(int ctr=0;ctr<Users.size();ctr++)
				tableCode=tableCode.concat("<tr align='center'>"+
				"<td class='lBoardbBox'>" +
				"<img src='"+picURls.get(ctr)+"' class='profPic'/>"+Users.get(ctr).getName()+"</td>"+
				"<td class='lBoardbBox'>"+Users.get(ctr).getLevel()+"</td>"+
				"<td class='lBoardbBox'>"+Users.get(ctr).getPoints()+"</td>"+
				"</tr>");
				
			return tableCode;
	}	
	
}
