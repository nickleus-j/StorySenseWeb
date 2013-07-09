package notification;

import dao.*;
import entity.Achievement;
import entity.Acomplishment;
import entity.Learnerachievement;
import entity.LikedStory;
import entity.NotifMessage;
import entity.Notification;
import entity.Rating;
import entity.User;
/**
 * Creates Notification messages for the respective users who should be alerted
 * @author nickleus
 *
 */
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
				liker.getName()+" Liked your story "+story.getName()+" "+Comments, 
				story.getAccountID());
	}
	
	public void createRatingNotification(Rating score,String Comments){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO uDao=myDAOFactory.createUserDAO();
		AcomplishmentDAO acomDao=myDAOFactory.createAcomplishmentDAO();
		Acomplishment story=acomDao.getStory(score.getAccomplishmentID());
		User reader=uDao.getUser(score.getReaderID());
		int type=3;/*The notification type ID*/
		
		createNotification(type, 
				reader.getName()+" Gave a score of "+score.getScore()+" for "+story.getName()+"  "+Comments, 
				story.getAccountID());
	}
}/*End of class*/
