package achievementExecutors;

import dao.DAOFactory;
import dao.LearnerAcievementDAO;

public class AchievementWatcher {

	
	public boolean didUserUserHaveFirstStory(int userId){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		
		return learnerBadgeDao.hasLearnerAchieved(userId, getFirstStoryAchId());
	}
	
	
	public int getFirstStoryAchId(){return 1;}
	public int getApprovalAchievement(){return 2;}
	public int getPoppularAchievementId(){return 3;}
}
