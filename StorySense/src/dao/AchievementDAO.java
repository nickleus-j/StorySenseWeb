package dao;

import java.util.List;

import entity.Achievement;

/**
 * Represents how Java will communicate to the 
 * Achievement records in the database
 * @author nickleus
 *
 */
public abstract class AchievementDAO {

	public abstract void addAchievement(Achievement medal);
	public abstract List<Achievement> getAllAchievements();
	public abstract void updateAchievement(Achievement medal);
}
