/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
package ajaxLearner;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notification.NotificationCreator;

import achievementExecutors.LikeAchievements;

import dao.*;
import entity.Acomplishment;
import entity.User;

import servlets.BaseServlet;

/**
 * Servlet implementation class LikeChanger
 * This servlet manipulates the like table in the database
 */
@WebServlet(description = "Changes Upon likes", urlPatterns = { "/LikeChanger" })
public class LikeChanger extends BaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html"); 
		User myUser=(User)request.getSession().getAttribute("user");
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		LikedStoryDAO LikeDAO=myDAOFactory.createLikeDAO();
		String like;
		NotificationCreator alerter=new NotificationCreator();
		try {
			int sID=Integer.parseInt(request.getParameter("q"));
			
			like=request.getParameter("res");
			
			if(like.matches("like")){
				LikeDAO.likeStory(myUser.getAccountID(), sID);
				alerter.createLikeNotification(LikeDAO.getLikeOfUser(myUser.getAccountID(), sID), "");
				likeAchievementCheck(myDAOFactory,sID,myUser);
			}
			else 
				LikeDAO.disLike(myUser.getAccountID(), sID);
			response.getWriter().write(""+LikeDAO.countStoryLikes(sID));
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch(NullPointerException ne){
			ne.printStackTrace();
		}
	}

	public void likeAchievementCheck(DAOFactory myDAOFactory,int sID,User myUser){
		AcomplishmentDAO acomDao=myDAOFactory.createAcomplishmentDAO();
		UserDAO uDao=myDAOFactory.createUserDAO();
		Acomplishment storyMade=acomDao.getStory(sID);
		User Writer=uDao.getUser(storyMade.getAccountID());
		LikeAchievements likeAchievement=new LikeAchievements();
		likeAchievement.awardApprovalAchievement(storyMade.getAccountID());
		likeAchievement.awardEgoBooster(myUser, Writer);
		likeAchievement.awardMultiLikedStory(storyMade);
	}
}
