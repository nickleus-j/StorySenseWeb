package entity;

import java.sql.Timestamp;

/**
 * The story accomplishment entity to be represented in the program<br/>
 * `ID` int(11) NOT NULL AUTO_INCREMENT,
  `templateID` int(11) DEFAULT NULL,
  `AccountID` int(11) DEFAULT NULL,
  `Name` varchar(80) DEFAULT NULL,
  `fileURL` text,
  `finishTime` timestamp NULL DEFAULT NULL,

 * @author nickleus
 *
 */
public class Acomplishment {

	private int ID,templateID,AccountID;
	private String Name,fileURL;
	private Timestamp finishTime;
	
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTemplateID() {
		return templateID;
	}
	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	
	
	
}
