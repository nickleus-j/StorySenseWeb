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
import dao.NotificationTypeDao;
import dbConnection.DBConnectionFactory;
import entity.Achievement;
import entity.NotificationType;

public class NotificationTypeMySQL extends NotificationTypeDao {

	@Override
	public void insertNotificationType(NotificationType given) {
		/*INSERT INTO `ontology`.`notificationType` (`typeName`) VALUES ('Achievement Unlock');*/
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO notificationType (typeName) VALUES (?)");
            ps.setString(1, given.getTypeName());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(NotificationTypeMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void updateNotificationType(NotificationType given) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("UPDATE notificationType SET typeName=? WHERE typeID=?");
			ps.setString(1, given.getTypeName());
			ps.setInt(2,given.getTypeID());
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(NotificationTypeMySQL.class.getName()).log(Level.SEVERE, null, ex);
			
		}
	}

	private List<NotificationType> getResults(ResultSet rs) throws SQLException{
		List<NotificationType> list=new ArrayList<NotificationType>();
		NotificationType type;
		while(rs.next()){
			type=new NotificationType();
			type.setTypeID(rs.getInt("typeID"));
			type.setTypeName(rs.getString("typeName"));
			list.add(type);
		}
		return list;
	}
	@Override
	public List<NotificationType> getNotificationTypes() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from notificationType");
            rs = ps.executeQuery();
            
            List<NotificationType> types=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return types;
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationTypeMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public NotificationType getNotificationType(int id) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from notificationType WHERE typeID=3");
            rs = ps.executeQuery();
            
            List<NotificationType> types=getResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return types.get(0);
		}
        catch (Exception ex)
        {
            Logger.getLogger(NotificationTypeMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

}
