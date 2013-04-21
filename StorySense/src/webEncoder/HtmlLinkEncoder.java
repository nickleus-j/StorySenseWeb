package webEncoder;

import entity.User;

/**
 * Creates HTML Link code to be printed from a JSP writer
 * @author Nickleus Jimenez
 */
public class HtmlLinkEncoder {

/**
 * Provides a link to a page that shows the stories
 * of a given user
 */
	public String createLinkToUser(User given){
		String linkToViewUser="<a href=\"viewAUser?uID="+given.getAccountID()+"\">";
		
		return linkToViewUser.concat(given.getName()+"</a>");
	}
	
	public String creaateScoreLink(int Score,int AccomId){
		String linkToViewUser="<a onclick=\"showScores("+AccomId+")\">";
		
		return linkToViewUser.concat(Score+"</a>");
	}
}
