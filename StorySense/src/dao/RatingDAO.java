package dao;

import entity.Rating;
import java.util.List;
public abstract class RatingDAO {

	public abstract List<Rating> getRatings();
	public abstract List<Rating> getRatingsOfReader(int readerID);
	public abstract List<Rating> getRatingsOfWriter(int WriterID);
	public abstract Rating getRatingsOfReader(int readerID,int accomID);
	public abstract List<Rating> getRatingsOfAccomplishment(int accomID);
	public abstract int getTotalScore(int accomID);
	public abstract void addRating(Rating r);
	public abstract void updateRating(Rating r);
}
