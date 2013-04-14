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
	public abstract List<Acomplishment> getUserStoriesToRatedbyReader(int readerID,int writerID);
	public abstract List<Acomplishment> getAllStoriesOfTemplate(int TemplateID);
	public abstract Acomplishment getStory(int ID);
	public abstract void addStoryAcomplishment(Acomplishment story);
	public abstract void updateStory(Acomplishment story);
	public abstract List<Acomplishment> getUserLikedStories(int userID);
	public abstract List<Acomplishment> getStoryWithLevel(int readerID,int level);
	public abstract List<Acomplishment> getStoryWithAtLeastLevel(int readerID,int level);
	public abstract List<Acomplishment> getUserStoryWithAtLeastLevel(int level,int writerID,int readerID);
}
