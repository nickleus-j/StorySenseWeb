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
import dao.NotificationDao;
import dbConnection.DBConnectionFactory;
import entity.Notification;

public class NotificationMySQL extends NotificationDao {

	@Override
	public void insertNotification(Notification given) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT into Notification (notifUser,StartedOn) VALUES(?,now())");
        	ps.setInt(1, given.getNotifUser());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void updateNotification(Notification given) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("UPDATE Notification SET notifUser=?, viewed=? WHERE NotificationId=?");
			ps.setInt(1, given.getNotifUser());
			ps.setBoolean(2, given.isViewed());
			ps.setInt(3, given.getNotificationId());
			ps.executeUpdate();
			
			ps.close();
			con.close();
        }catch(Exception ex){
        	Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	private List<Notification> getResults(ResultSet rs) throws SQLException{
		List<Notification> list=new ArrayList<Notification>();
		Notification notice;
		
		while(rs.next()){
			notice=new Notification();
			notice.setNotificationId(rs.getInt("NotificationId"));
			notice.setNotifUser(rs.getInt("notifUser"));
			notice.setStartedOn(rs.getTimestamp("StartedOn"));
			notice.setViewed(rs.getBoolean("viewed"));
			list.add(notice);
		}
		return list;
	}
	@Override
	public List<Notification> getAllNotifications() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from Notification");
            rs = ps.executeQuery();
            
            List<Notification> notifs=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return notifs;
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<Notification> getUserNotifications(int userID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM Notification WHERE notifUser=? ORDER BY StartedOn DESC");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            List<Notification> notifs=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return notifs;
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public boolean doesUserHaveUnviwedNotifications(int userID) {
		boolean result=false;
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM Notification WHERE notifUser=? AND viewed=0");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            List<Notification> notifs=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            result=!notifs.isEmpty();
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return result;
	}

	@Override
	public Notification getLatestNotification(int userID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM Notification WHERE notifUser=? AND viewed=0");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            List<Notification> notifs=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return notifs.get(0);
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public Notification getNotification(int id) {
		Notification result=null;
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();
            
            ps = con.prepareStatement("SELECT * from Notification WHERE NotificationId=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.first()){
            	result=new Notification();
            	result.setNotificationId(id);
            	result.setNotifUser(rs.getInt("notifUser"));
            	result.setStartedOn(rs.getTimestamp("StartedOn"));
            	result.setViewed(rs.getBoolean("viewed"));
            }
            
            rs.close();
            ps.close();
            con.close();
            
            
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return result;
	}

	@Override
	public void updateNotificationView(int notificationID, String viewed) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("UPDATE Notification SET viewed=? WHERE NotificationId=?");
			ps.setString(1,viewed);
			ps.setInt(2, notificationID);
			ps.executeUpdate();
			
			ps.close();
			con.close();
        }catch(Exception ex){
        	Logger.getLogger(NotificationMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
