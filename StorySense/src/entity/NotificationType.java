package entity;
/**
 * 
+----------+-------------+------+-----+---------+----------------+<br>
| Field    | Type        | Null | Key | Default | Extra          |<br>
+----------+-------------+------+-----+---------+----------------+<br>
| typeID   | int(11)     | NO   | PRI | NULL    | auto_increment |<br>
| typeName | varchar(50) | YES  |     | NULL    |                |<br>
+----------+-------------+------+-----+---------+----------------+<br>

 * @author nickleus
 *
 */
public class NotificationType {

	private int typeID;
	private String typeName;
	
	public int getTypeID() {return typeID;}
	public void setTypeID(int typeID) {this.typeID = typeID;}
	public String getTypeName() {return typeName;}
	public void setTypeName(String typeName) {this.typeName = typeName;}
	
}
