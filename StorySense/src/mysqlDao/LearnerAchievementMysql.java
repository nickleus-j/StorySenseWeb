/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
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

import dao.DAOFactory;
import dao.LearnerAcievementDAO;
import dbConnection.DBConnectionFactory;
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
        			"VALUES (?,?,?)");
            ps.setInt(1, medal.getAchievementID());
            ps.setInt(2, medal.getLearnerID());
            ps.setString(3, medal.getObtainDate()); 
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
            	medal.setObtainDate(rs.getString("obtainDate"));
            	Achievements.add(medal);
            }
            
            rs.close();
            ps.close();
            con.close();
            if(Achievements.isEmpty())
            	return null;
            return Achievements;
		}
        catch (Exception ex)
        {
            Logger.getLogger(LearnerAchievementMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	private ArrayList<Learnerachievement> listResults(ResultSet rs) throws SQLException{
		Learnerachievement medal;
        ArrayList<Learnerachievement> Achievements=new ArrayList<Learnerachievement>();
        while(rs.next()){
        	medal=new Learnerachievement();
        	medal.setAchievementID(rs.getInt("AchievementID"));
        	medal.setLearnerID(rs.getInt("learnerID"));
        	medal.setObtainDate("obtainDate");
        	Achievements.add(medal);
        }
        return Achievements;
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

            ps = con.prepareStatement("SELECT * from learnerachievement");
            rs = ps.executeQuery();
            
            //Learnerachievement medal;
            ArrayList<Learnerachievement> Achievements=listResults(rs);
            
            rs.close();
            ps.close();
            con.close();
            
            if(Achievements.isEmpty())
            	return null;
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
