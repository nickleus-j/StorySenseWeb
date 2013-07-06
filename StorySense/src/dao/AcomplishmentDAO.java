/*******************************************************************************
 *Copyright (c) 2013 Story Sense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package dao;

import entity.Acomplishment;
import java.util.List;

public abstract class AcomplishmentDAO {

	public abstract List<Acomplishment> getAllStories();
	public abstract List<Acomplishment> getAllStoriesRated();
	public abstract List<Acomplishment> getAllStories(int limit);
	public abstract List<Acomplishment> getAllStoriesOfUser(int AccountID);
	public abstract List<Acomplishment> getStoriesToRate(int AccountID);
	public abstract List<Acomplishment> getStoriesRated(int readerID);
	public abstract List<Acomplishment> getStoriesOfWriterRated(int writerID);
	public abstract List<Acomplishment> getUserStoriesToRatedbyReader(int readerID,int writerID);
	public abstract List<Acomplishment> getUserStoriesratedByReader(int readerID,int writerID);
	public abstract List<Acomplishment> getAllStoriesOfTemplate(int TemplateID);
	public abstract Acomplishment getStory(int ID);
	public abstract void addStoryAcomplishment(Acomplishment story);
	public abstract void updateStory(Acomplishment story);
	public abstract List<Acomplishment> getUserLikedStories(int userID);
	public abstract List<Acomplishment> getStoryWithLevel(int readerID,int level);
	public abstract List<Acomplishment> getStoryWithAtLeastLevel(int readerID,int level);
	public abstract List<Acomplishment> getUserStoryWithAtLeastLevel(int level,int writerID,int readerID);
	public abstract Acomplishment getPopularStory();
	public abstract String getMostLikeStoryTitle(int writerID);
	public abstract int getMaximumNumberLikesForStory(int writerID);
	public abstract List<Acomplishment> getStoriesWrittenOn(int userID,String date);
}
