package achievementExecutors;

import java.util.List;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.LearnerAcievementDAO;
import dao.LikedStoryDAO;
import dao.UserDAO;
import entity.Learnerachievement;
import entity.LikedStory;
import entity.User;

public class LikeAchievements {

	public void awardApprovalAchievement(int userId){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		Learnerachievement medal=new Learnerachievement();
		AchievementWatcher aWatcher=new AchievementWatcher();
		LikedStoryDAO likeDao=myDaoFactory.createLikeDAO();
		List<LikedStory> likesGiven=likeDao.getAllLikesForUser(userId);
		boolean wasApprovalGiven=learnerBadgeDao.hasLearnerAchieved(userId, aWatcher.getApprovalAchievement());
		
		medal.setLearnerID(userId);
		if(likesGiven!=null&&!likesGiven.isEmpty()
				&&!wasApprovalGiven){
			medal.setAchievementID(aWatcher.getApprovalAchievement());
			learnerBadgeDao.giveAchievement(medal);
		}/*End of awarding condition*/
		else if(wasApprovalGiven&&learnerBadgeDao.hasLearnerAchieved(userId, aWatcher.getPopularAchievementId())){
			AcomplishmentDAO acomDao=myDaoFactory.createAcomplishmentDAO();
			if(acomDao.getAllStoriesOfUser(userId).contains(acomDao.getPopularStory())){
				medal.setAchievementID(aWatcher.getPopularAchievementId());
				learnerBadgeDao.giveAchievement(medal);
			}/*End of popular story is made by curretn user condition*/
		}/*End  was approval given condition */
	}
	
	/**
	 * Gives the achievement for giving the most likes to an author
	 * @param fan
	 * @param Writer
	 */
	public void awardEgoBooster(User fan,User Writer){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		LearnerAcievementDAO learnerBadgeDao=myDaoFactory.createLearnerAcievementDAO();
		Learnerachievement medal=new Learnerachievement();
		AchievementWatcher aWatcher=new AchievementWatcher();
		UserDAO uDao=myDaoFactory.createUserDAO();
		
		if(!aWatcher.didUSerHaveAchievement(fan.getAccountID(), aWatcher.getBigFanAchievementId())
				&&uDao.isBiggestFan(fan, Writer)){
			medal.setAchievementID(aWatcher.getBigFanAchievementId());
			medal.setLearnerID(fan.getAccountID());
			learnerBadgeDao.giveAchievement(medal);
		}/*End of condition for awarding*/
	}
	
}
