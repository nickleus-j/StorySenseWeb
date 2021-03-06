/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
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
        			" (userID,storyAccomID,LikeTime) " +
        			"VALUES (?,?,now())");
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
            		"WHERE account.accountID=storyaccomplishment.AccountID AND storyAccomID=ID AND " +
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
            		"WHERE account.accountID=storyaccomplishment.AccountID AND storyAccomID=ID AND " +
            		"ID= ? ");
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
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("DELETE from likedstory WHERE userID=? AND storyAccomID=?");
			ps.setInt(1,userID);
			ps.setInt(2, storyID);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
		}

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

	@Override
	public int countLikesGiven(int userID) {
		int count=0;
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT count(*) FROM likedstory,storyaccomplishment " +
            		"WHERE storyAccomID=ID AND AccountID=?");
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
	public LikedStory getLikeOfUser(int userID, int sID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            /*ps = con.prepareStatement("SELECT account.Name,storyaccomplishment.Name AS storyName," +
            		"ID AS storyID,account.accountID,likedstory.key from account,storyaccomplishment,likedstory " +
            		"WHERE account.accountID=storyaccomplishment.AccountID AND storyAccomID=ID AND " +
            		"userID= ? AND storyAccomID=?");
            		*/
            ps = con.prepareStatement("SELECT * from likedstory WHERE userID=? AND storyAccomID=?");
            ps.setInt(1, userID);
            ps.setInt(2, sID);
            rs = ps.executeQuery();
            
            LikedStory approval=null;
            if(rs.first()){
            	approval=new LikedStory();
            	approval.setKey(rs.getInt("key"));
            	approval.setStoryID(rs.getInt("storyAccomID"));
            	approval.setUserID(rs.getInt("userID"));
            	approval.setLikeTime(rs.getTimestamp("LikeTime"));
            }
            
            rs.close();
            ps.close();
            con.close();
            return approval;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LikedStoryMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

}
