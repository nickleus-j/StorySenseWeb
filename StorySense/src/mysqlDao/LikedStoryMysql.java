package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DAOFactory;
import dao.LikedStoryDAO;
import dbConnection.DBConnectionFactory;
import entity.Learnerachievement;
import entity.LikedStory;

public class LikedStoryMysql extends LikedStoryDAO {

	@Override
	public void likeStory(int userID, int storyID) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO likedstory" +
        			" (userID,storyAccomID) " +
        			"VALUES (?,?)");
            ps.setInt(1,userID);
            ps.setInt(2,storyID);
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	@Override
	public List<LikedStory> getAllLikes() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT account.Name,storyaccomplishment.Name AS storyName," +
            		"ID AS storyID,account.accountID,likedstory.key from account,storyaccomplishment,likedstory " +
            		"WHERE account.accountID=storyaccomplishment.AccountID AND storyAccomID=ID");
            rs = ps.executeQuery();
            
            LikedStory approval;
            ArrayList<LikedStory>approvals=new ArrayList<LikedStory>();
            while(rs.next()){
            	approval=new LikedStory();
            	approval.setKey(rs.getInt("key"));
            	approval.setStoryID(rs.getInt("storyID"));
            	approval.setUserID(rs.getInt("accountID"));
            	approval.setStoryName(rs.getString("storyName"));
            	approval.setUserName(rs.getString("Name"));
            	approvals.add(approval);
            	/*medal=new Learnerachievement();
            	medal.setAchievementID(rs.getInt("AchievementID"));
            	medal.setLearnerID(myUser.getAccountID());
            	Achievements.add(medal);
            	*/
            }
            
            rs.close();
            ps.close();
            con.close();
            return approvals;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<LikedStory> getAllLikesForUser(int userID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT account.Name,storyaccomplishment.Name AS storyName," +
            		"ID AS storyID,account.accountID,likedstory.key from account,storyaccomplishment,likedstory " +
            		"WHERE account.accountID=storyaccomplishment.AccountID AND storyAccomID=ID AND" +
            		"account.accountID= ? ");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            LikedStory approval;
            ArrayList<LikedStory>approvals=new ArrayList<LikedStory>();
            while(rs.next()){
            	approval=new LikedStory();
            	approval.setKey(rs.getInt("key"));
            	approval.setStoryID(rs.getInt("storyID"));
            	approval.setUserID(rs.getInt("accountID"));
            	approval.setStoryName(rs.getString("storyName"));
            	approval.setUserName(rs.getString("Name"));
            	approvals.add(approval);
            	
            	
            	/*medal=new Learnerachievement();
            	medal.setAchievementID(rs.getInt("AchievementID"));
            	medal.setLearnerID(myUser.getAccountID());
            	Achievements.add(medal);
            	*/
            }
            
            rs.close();
            ps.close();
            con.close();
            return approvals;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<LikedStory> getStoryLikes(int storyID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT account.Name,storyaccomplishment.Name AS storyName," +
            		"ID AS storyID,account.accountID,likedstory.key from account,storyaccomplishment,likedstory " +
            		"WHERE account.accountID=storyaccomplishment.AccountID AND storyAccomID=ID AND" +
            		"storyID= ? ");
            ps.setInt(1, storyID);
            rs = ps.executeQuery();
            
            LikedStory approval;
            ArrayList<LikedStory>approvals=new ArrayList<LikedStory>();
            while(rs.next()){
            	approval=new LikedStory();
            	approval.setKey(rs.getInt("key"));
            	approval.setStoryID(rs.getInt("storyID"));
            	approval.setUserID(rs.getInt("accountID"));
            	approval.setStoryName(rs.getString("storyName"));
            	approval.setUserName(rs.getString("Name"));
            	approvals.add(approval);

            }
            
            rs.close();
            ps.close();
            con.close();
            return approvals;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public int countStoryLikes(int storyID) {
		int count=0;
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT count(*) from likedstory WHERE storyaccomID=?");
            ps.setInt(1, storyID);
            rs = ps.executeQuery();
            
            if(rs.first())
            	count=rs.getInt("count(*)");
            
            rs.close();
            ps.close();
            con.close();
            return count;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return 0;
	}

	@Override
	public int countUserLikes(int userID) {
		int count=0;
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT count(*) from likedstory WHERE userID=?");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            if(rs.first())
            	count=rs.getInt("count(*)");
            
            rs.close();
            ps.close();
            con.close();
            return count;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return 0;
	}

	@Override
	public void disLike(int userID, int storyID) {
		

	}

	@Override
	public boolean didUserLike(int userID, int storyID) {
		boolean like;
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from likedstory WHERE storyAccomID=? AND userID=?");
            ps.setInt(1, storyID);
            ps.setInt(2, userID);
            rs = ps.executeQuery();
            
            like=rs.first();
            
            rs.close();
            ps.close();
            con.close();
            return like;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return false;
	}

}
