package achievementExecutors;

import dao.DAOFactory;
import dao.LearnerAcievementDAO;

public class AchievementWatcher {

	
	public boolean didUserUserHaveFirstStory(int userId){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		
		return learnerBadgeDao.hasLearnerAchieved(userId, getFirstStoryAchId());
	}
	
	public boolean didUSerHaveAchievement(int userID,int achId){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		
		return learnerBadgeDao.hasLearnerAchieved(userID, achId);
	}
	
	public int getFirstStoryAchId(){return 1;}
	public int getApprovalAchievement(){return 2;}
	public int getPopularAchievementId(){return 3;}
	public int getTenStoriesAchievemnetId(){return 5;}
	
}
