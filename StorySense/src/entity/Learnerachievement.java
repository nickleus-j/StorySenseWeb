package entity;

/*
 * DROP TABLE IF EXISTS `learnerachievement`;

CREATE TABLE `learnerachievement` (
  `AchievementID` int(11) NOT NULL,
  `learnerID` int(11) DEFAULT NULL,
  KEY `AchievementRef` (`AchievementID`),
  KEY `learnerAchievement` (`learnerID`),
  CONSTRAINT `AchievementRef` FOREIGN KEY (`AchievementID`) REFERENCES `achievement` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `learnerAchievement` FOREIGN KEY (`learnerID`) REFERENCES `account` (`accountID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/
public class Learnerachievement {

	private int AchievementID,learnerID;

	public int getAchievementID() {return AchievementID;}
	public void setAchievementID(int achievementID) {AchievementID = achievementID;}
	public int getLearnerID() {return learnerID;}
	public void setLearnerID(int learnerID) {this.learnerID = learnerID;}
	
}
