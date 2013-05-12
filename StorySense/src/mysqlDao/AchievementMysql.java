/*******************************************************************************
 *Copyright (c) 2013 Story Sense
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
import java.sql.SQLException;
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
	public void addAchievement(Achievement badge) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO achievement" +
        			" (ID,Title,Description,picUrl) " +
        			"VALUES (?,?,?)");
            ps.setInt(1, badge.getID());
            ps.setString(2, badge.getTitle());
            ps.setString(3, badge.getDescription());
            ps.setString(4, badge.getPicUrl());
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
            
            //Achievement badge;
            ArrayList<Achievement> Achievements=listResult(rs);
            rs.close();
            ps.close();
            con.close();
            
            if(Achievements.isEmpty())
            	return null;
            return Achievements;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

    /**
     * Puts the entries of a result set in to a list that 
     * can be manipulated in Java
    */
	private ArrayList<Achievement> listResult(ResultSet rs) throws SQLException{
		Achievement badge;
		ArrayList<Achievement> Achievements=new ArrayList<Achievement>();
		while(rs.next()){
        	badge=new Achievement();
        	badge.setID(rs.getInt("ID"));
        	badge.setTitle(rs.getString("Title"));
        	badge.setDescription(rs.getString("Decription"));
        	badge.setPicUrl(rs.getString("picUrl"));
        	Achievements.add(badge);
        }
		return Achievements;
	}
	/**
	 * Updates the attributes of the record
	 */
	@Override
	public void updateAchievement(Achievement badge) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update achievement SET  Title=?, Description =? picUrl= ?where ID = ?");
			ps.setString(1,badge.getTitle());
			ps.setString(2, badge.getDescription());
			ps.setString(3, badge.getPicUrl());
			ps.setInt(4, badge.getID());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Achievement getAchievementById(int id) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from achievement WHERE ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            Achievement badge=null;
            if(rs.first()){
            	badge=new Achievement();
            	badge.setID(rs.getInt("ID"));
            	badge.setTitle(rs.getString("Title"));
            	badge.setDescription(rs.getString("Decription"));
            	badge.setPicUrl(rs.getString("picUrl"));
            }
            
            rs.close();
            ps.close();
            con.close();
		}
        catch (Exception ex)
        {
            Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

    /**
     * Gets the achivements of a certain user from the database
     * The userid must be represent the id of a learner in the database
    */
	@Override
	public List<Achievement> getUserAchievements(int userId) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from achievement WHERE ID IN" +
            		"(SELECT AchievementID from learnerachievement WHERE learnerID=?)");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            
            //Achievement badge;
            ArrayList<Achievement> Achievements=listResult(rs);
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
     * gets the achievements noby has gotten yet
    */
	@Override
	public List<Achievement> getUnAttainedAchievements() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from achievement WHERE ID IN" +
            		"(SELECT AchievementID from learnerachievement)");
            rs = ps.executeQuery();
            
            //Achievement badge;
            ArrayList<Achievement> Achievements=listResult(rs);
            rs.close();
            ps.close();
            con.close();
            
            if(Achievements.isEmpty())
            	return null;
            return Achievements;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

}
