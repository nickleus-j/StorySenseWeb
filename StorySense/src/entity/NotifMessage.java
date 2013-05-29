package entity;

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

	int MsgID,nType,NotifID;
	String Message;
	
	
	public int getMsgID() {return MsgID;}
	public void setMsgID(int msgID) {MsgID = msgID;}
	public int getnType() {return nType;}
	public void setnType(int nType) {this.nType = nType;}
	public int getNotifID() {return NotifID;}
	public void setNotifID(int notifID) {NotifID = notifID;}
	public String getMessage() {return Message;}
	public void setMessage(String message) {Message = message;}
	
}
