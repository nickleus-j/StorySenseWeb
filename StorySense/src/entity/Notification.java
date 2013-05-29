package entity;

import java.sql.Timestamp;

/*
 * +----------------+------------+------+-----+---------+----------------+
| Field          | Type       | Null | Key | Default | Extra          |
+----------------+------------+------+-----+---------+----------------+
| NotificationId | int(11)    | NO   | PRI | NULL    | auto_increment |
| notifUser      | int(11)    | YES  | MUL | NULL    |                |
| StartedOn      | timestamp  | YES  |     | NULL    |                |
| viewed         | tinyint(1) | YES  |     | 0       |                |
+----------------+------------+------+-----+---------+----------------+

 */
public class Notification {

	private int NotificationId,notifUser;
	private Timestamp StartedOn;
	private boolean viewed;
	
	
	public int getNotificationId() {
		return NotificationId;
	}
	public void setNotificationId(int notificationId) {
		NotificationId = notificationId;
	}
	public int getNotifUser() {
		return notifUser;
	}
	public void setNotifUser(int notifUser) {
		this.notifUser = notifUser;
	}
	public Timestamp getStartedOn() {
		return StartedOn;
	}
	public void setStartedOn(Timestamp startedOn) {
		StartedOn = startedOn;
	}
	public boolean isViewed() {
		return viewed;
	}
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	
}
