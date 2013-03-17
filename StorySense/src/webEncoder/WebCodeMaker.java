package webEncoder;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;


import dao.DAOFactory;
import dao.ProfileDAO;
import dao.TemplateDAO;
import dao.UserDAO;
import entity.Profile;
import entity.Template;
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
		HtmlLinkEncoder linkEncoder=new HtmlLinkEncoder();
		
		ArrayList<User> Users=(ArrayList<User>)myUserDAO.getTopLearners();
			for(int ctr=0;ctr<Users.size();ctr++)
				tableCode=tableCode.concat("<tr align='center'>"+
				"<td class='lBoardbBox'>" +linkEncoder.createLinkToUser(Users.get(ctr))+"</td>"+
				"<td class='lBoardbBox'>"+Users.get(ctr).getLevel()+"</td>"+
				"<td class='lBoardbBox'>"+Users.get(ctr).getPoints()+"</td>"+
				"</tr>");
				
			return tableCode;
	}
	
	/**
	 * Generates a string that will be used in HTML documents
	 * to show an image
	 * @param u
	 * @return
	 */
	public String enterUserImageTag(User u){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		String imgCode="";
		
		Profile profile=profileDAO.getProfile(u);
		imgCode=imgCode.concat("<img width=\"100\" height=\"100\" src='"+profile.getImageURL()+"'/>");
		
		return imgCode;
		
	}
	/**
	 * Generates a string that will be used in HTML documents
	 * to show an image
	 * @param u
	 * @param width
	 * @param height
	 * @return
	 */
	public String enterUserImageTag(User u,int width,int height){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		String imgCode="";
		
		Profile profile=profileDAO.getProfile(u);
		imgCode=imgCode.concat("<img width=\""+width+"\" height=\""+height+"\" src='"+profile.getImageURL()+"'/>");
		
		return imgCode;
		
	}
	
	/**Returns HTML code that show the users' image with his/her
	 * real name
	 * @param u
	 * @return
	 */
	public String enterUserRealName(User u){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		String imgCode="";
		
		Profile profile=profileDAO.getProfile(u);
		imgCode=profile.getFirstName()+" "+ profile.getSurname();
		
		return imgCode;
		
	}
	
	public String showUserHTMl(User u){
		String code="Hello ";
		if(u!=null){
			code=code.concat(u.getName());
			code=enterUserImageTag(u,50,50).concat(code);
		}
		return code;
	}
	
	public String getTemplateComboBoxHTML(){
		String Code="<select id=\"level\" onchange=\"ReviewStoriesInLevel(10,1,this.value)\">";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateDao=myDAOFactory.createTemplateDAO();
		ArrayList<Template> templates=(ArrayList<Template>)templateDao.getGroupedtemplates();
		
		for(int ctr=0;ctr<templates.size();ctr++){
			
			Code=Code.concat("<option>"+templates.get(ctr).getLevelRequirement()+"</option>");
		}
		
		return Code.concat("</select>");
	}
	
	public String getChooseTemplateLevelHTML(){
		String Code="<select id=\"level\" >";
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateDao=myDAOFactory.createTemplateDAO();
		ArrayList<Template> templates=(ArrayList<Template>)templateDao.getGroupedtemplates();
		
		for(int ctr=0;ctr<templates.size();ctr++){
			
			Code=Code.concat("<option>"+templates.get(ctr).getLevelRequirement()+"</option>");
		}
		
		return Code.concat("</select>");
	}
	
}
