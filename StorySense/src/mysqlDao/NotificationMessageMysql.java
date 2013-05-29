package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DAOFactory;
import dao.NotificationMessageDao;
import dbConnection.DBConnectionFactory;
import entity.NotifMessage;
import entity.Notification;

public class NotificationMessageMysql extends NotificationMessageDao {

	@Override
	public void insertNotificationMessage(NotifMessage given) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO notifMessage (nType,NotifID,Message) VALUES " +
        			"(?,?,?)");
        	ps.setInt(1, given.getnType());
        	ps.setInt(2, given.getNotifID());
        	ps.setString(3, given.getMessage());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(NotificationMessageMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void updateNotificationMessage(NotifMessage given) {
		
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("UPDATE notifMessage SET nType=?, NotifID=?, Message=? WHERE MsgID=?");
			ps.setInt(1, given.getnType());
        	ps.setInt(2, given.getNotifID());
        	ps.setString(3, given.getMessage());
        	ps.setInt(4, given.getMsgID());
			ps.executeUpdate();
			
			ps.close();
			con.close();
        }catch(Exception ex){
        	Logger.getLogger(NotificationMessageMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	private List<NotifMessage> getResults(ResultSet rs) throws SQLException{
		List<NotifMessage> list=new ArrayList<NotifMessage>();
		NotifMessage msg;
		
		while(rs.next()){
			msg=new NotifMessage();
			msg.setMsgID(rs.getInt("MsgID"));
			msg.setnType(rs.getInt("nType"));
			msg.setNotifID(rs.getInt("NotifID"));
			msg.setMessage(rs.getString("Message"));
			list.add(msg);
		}
		
		return list;
	}
	@Override
	public List<NotifMessage> getAllNotifMsgs() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from notifMessage");
            rs = ps.executeQuery();
            
            List<NotifMessage> notifs=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return notifs;
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMessageMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<NotifMessage> getUserMessages(int userID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from notifMessage WHERE NotifID IN " +
            		"(SELECT NotificationId FROM Notification WHERE notifUser=?)");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            List<NotifMessage> notifs=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return notifs;
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMessageMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<NotifMessage> getMessagesForType(int typeID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from notifMessage WHERE nType=?");
            ps.setInt(1, typeID);
            rs = ps.executeQuery();
            
            List<NotifMessage> notifs=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return notifs;
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMessageMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

}
