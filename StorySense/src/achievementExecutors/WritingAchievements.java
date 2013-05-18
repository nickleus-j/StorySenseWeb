package achievementExecutors;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.LearnerAcievementDAO;
import entity.Learnerachievement;

public class WritingAchievements {

	public void awardFirstStory(int userId){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		Learnerachievement medal=new Learnerachievement();
		AchievementWatcher aWatcher=new AchievementWatcher();
		AcomplishmentDAO myAcomDao=myDaoFactory.createAcomplishmentDAO();
		
		if(!aWatcher.didUserUserHaveFirstStory(userId)&&!myAcomDao.getAllStoriesOfUser(userId).isEmpty()){
			medal.setAchievementID(aWatcher.getFirstStoryAchId());
			medal.setLearnerID(userId);
			learnerBadgeDao.giveAchievement(medal);
		}/*End of Condition*/
	}
}
