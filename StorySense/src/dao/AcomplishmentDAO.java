package dao;

import entity.Acomplishment;
import java.util.List;

public abstract class AcomplishmentDAO {

	public abstract List<Acomplishment> getAllStories();
	public abstract List<Acomplishment> getAllStories(int limit);
	public abstract List<Acomplishment> getAllStoriesOfUser(int AccountID);
	public abstract List<Acomplishment> getAllStoriesOfTemplate(int TemplateID);
	public abstract Acomplishment getStory(int ID);
	public abstract void addStoryAcomplishment(Acomplishment story);
	public abstract void updateStory(Acomplishment story);
}
