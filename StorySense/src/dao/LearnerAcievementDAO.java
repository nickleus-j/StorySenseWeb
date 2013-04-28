/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
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
