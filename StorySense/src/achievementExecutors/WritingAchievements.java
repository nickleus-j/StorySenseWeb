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
	
	public void AwardTenStoriesAchievement(int userId){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		Learnerachievement medal=new Learnerachievement();
		AchievementWatcher aWatcher=new AchievementWatcher();
		AcomplishmentDAO myAcomDao=myDaoFactory.createAcomplishmentDAO();
		
		if(!aWatcher.didUSerHaveAchievement(userId,aWatcher.getTenStoriesAchievemnetId())&&myAcomDao.getAllStoriesOfUser(userId).size()>=10){
			medal.setAchievementID(aWatcher.getTenStoriesAchievemnetId());
			medal.setLearnerID(userId);
			learnerBadgeDao.giveAchievement(medal);
		}/*End of Condition*/
		
		/*Other Achievements*/
		AwardEagerWriterAchievement(userId);
		

		if(!aWatcher.didUSerHaveAchievement(userId,aWatcher.get20StoriesAchievementId())&&myAcomDao.getAllStoriesOfUser(userId).size()>=20){
			medal.setAchievementID(aWatcher.get20StoriesAchievementId());
			medal.setLearnerID(userId);
			learnerBadgeDao.giveAchievement(medal);
		}/*End of Condition*/
		
		if(!aWatcher.didUSerHaveAchievement(userId,aWatcher.get50StoriesAchievementId())&&myAcomDao.getAllStoriesOfUser(userId).size()>=50){
			medal.setAchievementID(aWatcher.get50StoriesAchievementId());
			medal.setLearnerID(userId);
			learnerBadgeDao.giveAchievement(medal);
		}/*End of Condition*/
	}
	
	public void AwardEagerWriterAchievement(int userId){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		Learnerachievement medal=new Learnerachievement();
		AchievementWatcher aWatcher=new AchievementWatcher();
		AcomplishmentDAO myAcomDao=myDaoFactory.createAcomplishmentDAO();
		
		
		if(!aWatcher.didUSerHaveAchievement(userId,aWatcher.getEagerWriterAchievemnetId())
				&&myAcomDao.getStoriesWrittenOn(userId,"now()").size()>=5){
			medal.setAchievementID(aWatcher.getEagerWriterAchievemnetId());
			medal.setLearnerID(userId);
			learnerBadgeDao.giveAchievement(medal);
		}/*End of Condition*/
	}
	
	
	
}
