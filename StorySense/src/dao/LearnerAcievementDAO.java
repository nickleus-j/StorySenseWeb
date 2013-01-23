package dao;

import java.util.List;

import entity.Learnerachievement;
import entity.User;

/**
 * Represents how Java will communicate to the 
 * LearnerAcievement records in the database
 * @author nickleus
 *
 */
public abstract class LearnerAcievementDAO {

	public abstract void giveAchievement(Learnerachievement medal);
	public abstract List<Learnerachievement> getLearnerAchievements(User myUser);
	public abstract List<Learnerachievement> getAllUserRewards();
	public abstract void updateAchievement(Learnerachievement medal);
}
