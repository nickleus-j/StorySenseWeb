/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
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
	public abstract Achievement getAchievementById(int id);
	public abstract List<Achievement> getUserAchievements(int userId);
	public abstract List<Achievement> getUnAttainedAchievements();
	public abstract List<Achievement> getUnAttainedAchievements(int userId);
}
