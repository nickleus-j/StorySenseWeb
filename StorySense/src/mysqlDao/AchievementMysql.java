package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.AchievementDAO;
import dao.DAOFactory;
import dbConnection.DBConnectionFactory;
import entity.Achievement;

/**
 * Handles the Mysql operations for the Achievement record
 * @author nickleus
 *
 */
public class AchievementMysql extends AchievementDAO {
/**
 * Adds the achievements that can be achieved by
 * the learners
 */
	@Override
	public void addAchievement(Achievement medal) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO achievement" +
        			" (ID,Title,Description) " +
        			"VALUES (?,?,?)");
            ps.setInt(1, medal.getID());
            ps.setString(2, medal.getTitle());
            ps.setString(3, medal.getDescription());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	/**
	 * returns all achievements the learner can get
	 */
	@Override
	public List<Achievement> getAllAchievements() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from achievement");
            rs = ps.executeQuery();
            
            Achievement medal;
            ArrayList<Achievement> Achievements=new ArrayList<Achievement>();
            while(rs.next()){
            	medal=new Achievement();
            	medal.setID(rs.getInt("ID"));
            	medal.setTitle(rs.getString("Title"));
            	medal.setDescription("Description");
            	Achievements.add(medal);
            }
            
            rs.close();
            ps.close();
            con.close();
            
            return Achievements;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Updates the attributes of the record
	 */
	@Override
	public void updateAchievement(Achievement medal) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update achievement SET  Title=?, Description =? where ID = ?");
			ps.setString(1,medal.getTitle());
			ps.setString(2, medal.getDescription());
			ps.setInt(3, medal.getID());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
