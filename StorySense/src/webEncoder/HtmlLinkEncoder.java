package webEncoder;

import entity.User;

public class HtmlLinkEncoder {

	public String createLinkToUser(User given){
		String linkToViewUser="<a href=\"viewAUser?uID="+given.getAccountID()+"\">";
		
		return linkToViewUser.concat(given.getName()+"</a>");
	}
}
