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
	private String ObtainDate;

	public int getAchievementID() {return AchievementID;}
	public void setAchievementID(int achievementID) {AchievementID = achievementID;}
	public int getLearnerID() {return learnerID;}
	public void setLearnerID(int learnerID) {this.learnerID = learnerID;}
	public String getObtainDate() {return ObtainDate;}
	public void setObtainDate(String obtainDate) {ObtainDate = obtainDate;}
	
}
