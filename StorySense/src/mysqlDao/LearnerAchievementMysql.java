package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DAOFactory;
import dao.LearnerAcievementDAO;
import dbConnection.DBConnectionFactory;
import entity.Achievement;
import entity.Learnerachievement;
import entity.User;

public class LearnerAchievementMysql extends LearnerAcievementDAO {

	/**
	 * Inform that the learner has achieved the achievement
	 */
	@Override
	public void giveAchievement(Learnerachievement medal) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO learnerachievement" +
        			" (AchievementID,learnerID) " +
        			"VALUES (?,?)");
            ps.setInt(1, medal.getAchievementID());
            ps.setInt(2, medal.getLearnerID());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(LearnerAchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	/**
	 * Get all the achievements of the learner
	 */
	@Override
	public List<Learnerachievement> getLearnerAchievements(User myUser) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from learnerachievement WHERE learnerID=?");
            ps.setInt(1, myUser.getAccountID());
            rs = ps.executeQuery();
            
            Learnerachievement medal;
            ArrayList<Learnerachievement> Achievements=new ArrayList<Learnerachievement>();
            while(rs.next()){
            	medal=new Learnerachievement();
            	medal.setAchievementID(rs.getInt("AchievementID"));
            	medal.setLearnerID(myUser.getAccountID());
            	Achievements.add(medal);
            }
            
            rs.close();
            ps.close();
            con.close();
            
            return Achievements;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LearnerAchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Get all the achievements obtained by all learners
	 */
	@Override
	public List<Learnerachievement> getAllUserRewards() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from learnerachievement ");
            rs = ps.executeQuery();
            
            Learnerachievement medal;
            ArrayList<Learnerachievement> Achievements=new ArrayList<Learnerachievement>();
            while(rs.next()){
            	medal=new Learnerachievement();
            	medal.setAchievementID(rs.getInt("AchievementID"));
            	medal.setLearnerID(rs.getInt("learnerID"));
            	Achievements.add(medal);
            }
            
            rs.close();
            ps.close();
            con.close();
            
            return Achievements;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LearnerAchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Update the achievement details
	 */
	@Override
	public void updateAchievement(Learnerachievement medal) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update learnerachievement SET  AchievementID=? where learnerID = ?");
			ps.setInt(1, medal.getAchievementID());
			ps.setInt(2, medal.getLearnerID());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(LearnerAchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
