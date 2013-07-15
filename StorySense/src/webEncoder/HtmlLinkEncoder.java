/*******************************************************************************
 *Copyright (c) 2013 Story Sense.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
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
