package dao;

import java.util.List;

import entity.LikedStory;

public abstract class LikedStoryDAO {

	public abstract void likeStory(int userID,int storyID);
	public abstract List<LikedStory> getAllLikes();
	public abstract List<LikedStory> getAllLikesForUser(int userID);
	public abstract List<LikedStory> getStoryLikes(int storyID);
	public abstract int countStoryLikes(int storyID);
	public abstract int countUserLikes(int userID);
	public abstract void disLike(int userID,int storyID);
	public abstract boolean didUserLike(int userID,int storyID);
}
