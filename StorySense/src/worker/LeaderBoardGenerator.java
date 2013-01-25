package worker;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.ProfileDAO;
import dao.UserDAO;
import entity.User;

public class LeaderBoardGenerator {

	ArrayList<User> Users;
	ArrayList<String> picURls;
	public LeaderBoardGenerator(){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO myUserDAO = myDAOFactory.createUserDAO();
		ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
		
		Users=(ArrayList<User>)myUserDAO.getTopLearners();
		picURls=(ArrayList<String>)profileDAO.getLeaderPicUrl();
	}
	
	public String getleaderBoardHTMLTable(){
		String tableCode="";
		 
			for(int ctr=0;ctr<Users.size();ctr++)
				tableCode.concat("<tr>"+
				"<td><img src='"+picURls.get(ctr)+"' class='profPic'/>"+Users.get(ctr).getName()+"</td>"+
				"<td>15</td>"+
				"<td>1510</td>"+
				"</tr>");
		 return "lll";
	}
	/*
	 * <%
	DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
	UserDAO myUserDAO = myDAOFactory.createUserDAO();
	ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
	
	ArrayList<User> Users=(ArrayList<User>)myUserDAO.getTopLearners();
	ArrayList<String> picURls=(ArrayList<String>)profileDAO.getLeaderPicUrl();
	
	
%>
	 */
}
