package notification;

import dao.*;
import entity.Achievement;
import entity.Acomplishment;
import entity.Learnerachievement;
import entity.LikedStory;
import entity.NotifMessage;
import entity.Notification;
import entity.User;

public class NotificationCreator {

	public void createNotification(int type,String Message,int userID){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		NotificationDao noticeDao=myDAOFactory.createNotificationDao();
		NotificationMessageDao MsgDao=myDAOFactory.createNotificationMessageDao();
		Notification notice;
		NotifMessage nMessage=new NotifMessage();
		
		if(!noticeDao.doesUserHaveUnviwedNotifications(userID)){
			notice=new Notification();
			notice.setNotifUser(userID);
			noticeDao.insertNotification(notice);
		}
		notice=noticeDao.getLatestNotification(userID);
		
		nMessage.setNotifID(notice.getNotificationId());
		nMessage.setMessage(Message);
		nMessage.setnType(type);
		
		MsgDao.insertNotificationMessage(nMessage);
	}
	
	public void createAchievementNotification(Learnerachievement medal,String comments){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AchievementDAO achDao=myDAOFactory.createAchievementDAO();
		Achievement achievement=achDao.getAchievementById(medal.getAchievementID());
		int type=1;/*The notification type ID*/
		
		createNotification(type, 
				"You earned the "+achievement.getDescription()+" "+comments, 
				medal.getLearnerID());
	}/*End of method*/
	
	public void createLikeNotification(LikedStory approval,String Comments){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO acomDao=myDAOFactory.createAcomplishmentDAO();
		UserDAO uDao=myDAOFactory.createUserDAO();
		Acomplishment story=acomDao.getStory(approval.getStoryID());
		User liker=uDao.getUser(approval.getUserID());
		int type=2;/*The notification type ID*/
		
		createNotification(type, 
				liker.getName()+"Liked your story "+story.getName()+" "+Comments, 
				story.getAccountID());
	}
	
	
}/*End of class*/
