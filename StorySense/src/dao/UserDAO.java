/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *   nickleus Jimenez
 *******************************************************************************/
package dao;

import java.util.List;

import entity.User;
import entity.Profile;
public abstract class UserDAO {

	public final int MAX_Level=21;
	public abstract void addUser(User U);
	public abstract void addUser(User U,Profile P);
	public abstract void changeActivation(User U,int active);
	public abstract void updateUser(User U);
	public abstract User getUser(String Name,String Password);
	public abstract User findUserWithName(String name);
	public abstract List<User> getUsers();
	public abstract List<User> getUsersWithRole(int role);
	public abstract List<User> getTopLearners();
	public abstract User getUser(int id);
	public abstract boolean authenticateUser(String Name,String Password);
	public abstract List<User> getUserWhoLiked(int storyID);
	public abstract List<User> getUsersRatedByReviewer(int readerID);
	public abstract List<User> getUsersLearnersReviewed(int readerID);
	public abstract void increaseUserPoints(User u,int score);
	public abstract String getBiggestFanName(User writer);
	public abstract boolean isBiggestFan(User fan,User writer);
}
