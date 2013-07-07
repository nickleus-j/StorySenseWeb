package entity;

import java.sql.Timestamp;

/*
 * +---------+---------+------+-----+---------+----------------+
| Field   | Type    | Null | Key | Default | Extra          |
+---------+---------+------+-----+---------+----------------+
| MsgID   | int(11) | NO   | PRI | NULL    | auto_increment |
| nType   | int(11) | YES  | MUL | NULL    |                |
| NotifID | int(11) | YES  | MUL | NULL    |                |
| Message | text    | YES  |     | NULL    |                |
+---------+---------+------+-----+---------+----------------+

 */
public class NotifMessage {

	private int MsgID,nType,NotifID;
	private String Message;
	private Timestamp creationTime;
	
	public int getMsgID() {return MsgID;}
	public void setMsgID(int msgID) {MsgID = msgID;}
	public int getnType() {return nType;}
	public void setnType(int nType) {this.nType = nType;}
	public int getNotifID() {return NotifID;}
	public void setNotifID(int notifID) {NotifID = notifID;}
	public String getMessage() {return Message;}
	public void setMessage(String message) {Message = message;}
	public Timestamp getCreationTime() {return creationTime;}
	public void setCreationTime(Timestamp creationTime) {this.creationTime = creationTime;}
	
	
}
