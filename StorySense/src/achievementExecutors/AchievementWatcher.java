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
	public int getStepForwardAchievementId(){return 4;}
	public int getTenStoriesAchievemnetId(){return 5;}
	public int getFeaturedAchievementId(){return 6;}
	public int getEagerWriterAchievemnetId(){return 7;}
	public int getBigFanAchievementId(){return 8;}
	public int getRisingUpAchievementId(){return 9;}
	public int getSoaringAchievementId(){return 10;}
	public int get20StoriesAchievementId(){return 11;}
	public int get50StoriesAchievementId(){return 12;}
	public int getLeaderboardAchievementId(){return 13;}
	public int get5LikesAchievementId(){return 14;}
	public int getTopScorerAchievementId(){return 15;}
}
