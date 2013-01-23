package entity;

/**
 * `accomplishmentID` int(11) DEFAULT NULL,
  `readerID` int(11) DEFAULT NULL,
  `Score` int(11) DEFAULT '1',

 * @author nickleus
 *
 */
public class Rating {

	private int accomplishmentID,readerID,Score;

	public int getAccomplishmentID() {
		return accomplishmentID;
	}

	public void setAccomplishmentID(int accomplishmentID) {
		this.accomplishmentID = accomplishmentID;
	}

	public int getReaderID() {
		return readerID;
	}

	public void setReaderID(int readerID) {
		this.readerID = readerID;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
	
	
}
