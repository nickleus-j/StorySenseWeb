package webEncoder;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;

import dao.AchievementDAO;
import dao.DAOFactory;
import entity.Achievement;
import entity.User;

public class learnerInfoEncoder {

	/**
	 * Returns HTML code to be used to generate the HTML code
	 * @param givenUser
	 * @return achivementHtmlCode
	 */
	public String writeHtmlAchievements(User givenUser){
		String code="<table><tr>";
		DAOFactory daoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		AchievementDAO medalDao=daoFactory.createAchievementDAO();
		ArrayList<Achievement> medals=(ArrayList<Achievement>)medalDao.getUserAchievements(givenUser.getAccountID());
		
		if(medals==null||medals.isEmpty()||givenUser.getRole()!=User.Roles.learner.getValue()){
			code=code.concat("<th> No Badges</th>");
			return code.concat("</table>");
		}
		
		for(int ctr=0;ctr<medals.size();ctr++){
			code=code.concat("<td><img width='100' height='100' src=\""+medals.get(ctr).getPicUrl()+"\"></td>");
		}
		code=code.concat("</tr><tr>");
		for(int ctr=0;ctr<medals.size();ctr++){
			code=code.concat("<td>"+medals.get(ctr).getTitle()+"</td>");
		}
		code=code.concat("</tr>");
		return code.concat("</table>");
	}
	
	public void writeHtmlAchievements(JspWriter out,User givenUser){
		try {
			out.write("<h2>Achievemnts</h2>");
			out.write(writeHtmlAchievements(givenUser));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
