package webEncoder;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;


import dao.DAOFactory;
import dao.ProfileDAO;
import dao.UserDAO;
import entity.Profile;
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
		
		
		ArrayList<User> Users=(ArrayList<User>)myUserDAO.getTopLearners();
			for(int ctr=0;ctr<Users.size();ctr++)
				tableCode=tableCode.concat("<tr align='center'>"+
				"<td class='lBoardbBox'>" +Users.get(ctr).getName()+"</td>"+
				"<td class='lBoardbBox'>"+Users.get(ctr).getLevel()+"</td>"+
				"<td class='lBoardbBox'>"+Users.get(ctr).getPoints()+"</td>"+
				"</tr>");
				
			return tableCode;
	}
	
	public String enterUserImageTag(User u){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		String imgCode="";
		
		Profile profile=profileDAO.getProfile(u);
		imgCode=imgCode.concat("<img width=\"100\" height=\"100\" src='"+profile.getImageURL()+"'/>");
		
		return imgCode;
		
	}
	
	public String enterUserRealName(User u){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		String imgCode="";
		
		Profile profile=profileDAO.getProfile(u);
		imgCode=profile.getFirstName()+" "+ profile.getSurname();
		
		return imgCode;
		
	}
	
}
