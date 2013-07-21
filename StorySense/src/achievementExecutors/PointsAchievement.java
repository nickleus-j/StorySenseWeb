package achievementExecutors;

import java.util.List;

import notification.NotificationCreator;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.LearnerAcievementDAO;
import dao.UserDAO;
import entity.Learnerachievement;
import entity.User;

public class PointsAchievement {

	public void awardLeaderBoardAchievement(User given){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		UserDAO uDao=myDaoFactory.createUserDAO();
		List<User> topUsers=uDao.getTopLearners();
		AchievementWatcher watcher=new AchievementWatcher();
		Learnerachievement medal=new Learnerachievement();
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		
		if(!watcher.didUSerHaveAchievement(given.getAccountID(), watcher.getLeaderboardAchievementId())&&
				topUsers.contains(given)){
			medal.setAchievementID(watcher.getLeaderboardAchievementId());
			medal.setLearnerID(given.getAccountID());
			learnerBadgeDao.giveAchievement(medal);
		}/*End of Condition*/
	}/*End of method*/
	
	public void awardLevelAchievement(User awardee){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		Learnerachievement medal=new Learnerachievement();
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		AchievementWatcher watcher=new AchievementWatcher();
		NotificationCreator alerter=new NotificationCreator();
		
		if(!watcher.didUSerHaveAchievement(awardee.getAccountID(), watcher.getStepForwardAchievementId())&&
				awardee.getLevel()>=2){
			medal.setAchievementID(watcher.getStepForwardAchievementId());
			medal.setLearnerID(awardee.getAccountID());
			learnerBadgeDao.giveAchievement(medal);
			alerter.createAchievementNotification(medal, " You have progressed");
		}/*End of level 10 condition*/
		
		/*Level 10*/
		if(!watcher.didUSerHaveAchievement(awardee.getAccountID(), watcher.getRisingUpAchievementId())&&
				awardee.getLevel()>=10){
			medal.setAchievementID(watcher.getRisingUpAchievementId());
			medal.setLearnerID(awardee.getAccountID());
			learnerBadgeDao.giveAchievement(medal);
			alerter.createAchievementNotification(medal, " Keep it up");
		}/*End of level 10 condition*/
		
		
		/*Level 20*/
		if(!watcher.didUSerHaveAchievement(awardee.getAccountID(), watcher.getSoaringAchievementId())&&
				awardee.getLevel()>=20){
			medal.setAchievementID(watcher.getSoaringAchievementId());
			medal.setLearnerID(awardee.getAccountID());
			learnerBadgeDao.giveAchievement(medal);
			alerter.createAchievementNotification(medal, "You have done so much");
		}/*End of level 20 condition*/
		
		/*Other achievement*/
		awardLeaderBoardAchievement(awardee);
		awardTopScorer(awardee,watcher,alerter,medal,learnerBadgeDao,myDaoFactory);
	}
	
	public void awardTopScorer(User awardee,AchievementWatcher watcher,NotificationCreator alerter,
			Learnerachievement medal,LearnerAcievementDAO learnerBadgeDao,DAOFactory myDaoFactory){
		AcomplishmentDAO acomDao=myDaoFactory.createAcomplishmentDAO();
		
		if(!watcher.didUSerHaveAchievement(awardee.getAccountID(), watcher.getTopScorerAchievementId())&&
				acomDao.getHighestAverageScoredStory().getAccountID()==awardee.getAccountID()){
			medal.setAchievementID(watcher.getTopScorerAchievementId());
			medal.setLearnerID(awardee.getAccountID());
			learnerBadgeDao.giveAchievement(medal);
			alerter.createAchievementNotification(medal, "");
		}
	}/**/
	
}
