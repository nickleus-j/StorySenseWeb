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

import entity.LikedStory;

public abstract class LikedStoryDAO {

	public abstract void likeStory(int userID,int storyID);
	public abstract List<LikedStory> getAllLikes();
	public abstract List<LikedStory> getAllLikesForUser(int userID);
	public abstract List<LikedStory> getStoryLikes(int storyID);
	public abstract LikedStory getLikeOfUser(int userID,int sID);
	public abstract int countStoryLikes(int storyID);
	public abstract int countUserLikes(int userID);
	public abstract void disLike(int userID,int storyID);
	public abstract boolean didUserLike(int userID,int storyID);
	public abstract int countLikesGiven(int userID);
}
