/*******************************************************************************
 *Copyright (c) 2013 StorySebs
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
import dao.RatingDAO;
import dbConnection.DBConnectionFactory;
import entity.Acomplishment;
import entity.Rating;
/**
 * The representation of the Rating table in MySQL server
 * @author nickleus
 *
 */
public class RatingMySQL extends RatingDAO {

	/**
	 * get all the ratings in the database
	 * @return allRatings
	 */
	@Override
	public List<Rating> getRatings() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM rating");
            rs = ps.executeQuery();
            
            Rating Score;
            ArrayList<Rating> ratings=new ArrayList<Rating>();
            while(rs.next()){
            	Score=new Rating();
            	Score.setAccomplishmentID(rs.getInt("accomplishmentID"));
            	Score.setReaderID(rs.getInt("readerID"));
            	Score.setScore(rs.getInt("Score"));
            	Score.setConfidence(rs.getFloat("Confidence"));
            	ratings.add(Score);
            }
            
            rs.close();
            ps.close();
            con.close();
            
            if(ratings.isEmpty())
            	return null;
            return ratings;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	private void addResultsToList(ArrayList<Rating> ratings,ResultSet rs) throws SQLException{
		Rating Score;
        while(rs.next()){
        	Score=new Rating();
        	Score.setAccomplishmentID(rs.getInt("accomplishmentID"));
        	Score.setReaderID(rs.getInt("readerID"));
        	Score.setScore(rs.getInt("Score"));
        	Score.setConfidence(rs.getFloat("Confidence"));
        	ratings.add(Score);
        }
	}
	/**
	 * returns the ratings made by a user
	 * @return readerRatings
	 * @param readerID : the account id of the reader
	 */
	@Override
	public List<Rating> getRatingsOfReader(int readerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM rating WHERE readerID = ?");
            ps.setInt(1, readerID);
            rs = ps.executeQuery();
           
            ArrayList<Rating> ratings=new ArrayList<Rating>();
            addResultsToList(ratings, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            if(ratings.isEmpty())
            	return null;
            return ratings;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * returns the Ratings of the writer's work
	 * @return ratingsForTheWriter
	 * @param WriterID :the userID of the writer
	 */
	@Override
	public List<Rating> getRatingsOfWriter(int WriterID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from rating WHERE accomplishmentID " +
            		"IN (SELECT ID FROM storyaccomplishment WHERE AccountID=?) ");
            ps.setInt(1, WriterID);
            rs = ps.executeQuery();
            
            ArrayList<Rating> ratings=new ArrayList<Rating>();
            addResultsToList(ratings, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return ratings;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public void addRating(Rating r) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO rating (accomplishmentID,readerID,Score,Confidence) " +
        			"VALUES (?,?,?,?)");
            ps.setInt(1, r.getAccomplishmentID());
            ps.setInt(2, r.getReaderID());
            ps.setInt(3,r.getScore());
            ps.setFloat(4, r.getConfidence());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	@Override
	public void updateRating(Rating r) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("update * from rating WHERE accomplishmentID = ? " +
        			"SET readerID = ?, Score = ?");
            ps.setInt(1, r.getAccomplishmentID());
            ps.setInt(2, r.getReaderID());
            ps.setInt(3,r.getScore());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	/**
	 * gets the ratings of certain accomplishments
	 */
	@Override
	public List<Rating> getRatingsOfAccomplishment(int accomID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from rating WHERE accomplishmentID = ?");
            ps.setInt(1, accomID);
            rs = ps.executeQuery();
            
            ArrayList<Rating> ratings=new ArrayList<Rating>();
            addResultsToList(ratings, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return ratings;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * The the rating of the reader of a certain story
	 */
	@Override
	public Rating getRatingsOfReader(int readerID, int accomID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from rating WHERE readerID=? AND accomplishmentID=?");
            ps.setInt(1, readerID);
            ps.setInt(2, accomID);
            rs = ps.executeQuery();
            
            Rating Score=null;
            //ArrayList<Rating> ratings=new ArrayList<Rating>();
            if(rs.first()){
            	Score=new Rating();
            	Score.setAccomplishmentID(rs.getInt("accomplishmentID"));
            	Score.setReaderID(rs.getInt("readerID"));
            	Score.setScore(rs.getInt("Score"));
            	Score.setConfidence(rs.getFloat("Confidence"));
            }
            
            rs.close();
            ps.close();
            con.close();
            
            return Score;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public int getTotalScore(int accomID) {
		try {
            PreparedStatement ps;
            ResultSet rs;
            int total=0;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT sum(Score) AS Total from rating WHERE accomplishmentID=?");
            ps.setInt(1, accomID);
            rs = ps.executeQuery();
            
            if(rs.first())
            	total=rs.getInt("Total");
            rs.close();
            ps.close();
            con.close();
            
            return total;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return 0;
	}

	@Override
	public List<Rating> getRatingsOfStoriesWithLevel(int level,int readerID) {
		PreparedStatement ps;
        ResultSet rs;
        try{
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        Connection con = myFactory.getConnection();

        ps = con.prepareStatement("SELECT * from rating WHERE readerID=? AND accomplishmentID IN " +
        		"(SELECT ID from storyaccomplishment WHERE templateID IN " +
        		"(SELECT TemplateID from template WHERE LevelReq=?))");
        ps.setInt(1, readerID);
        ps.setInt(2, level);
        rs = ps.executeQuery();
       
        ArrayList<Rating> ratings=new ArrayList<Rating>();
        addResultsToList(ratings, rs);
        
        rs.close();
        ps.close();
        con.close();
        
        return ratings;
        }catch (Exception ex){
        Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
    	}
		return null;
	}/*End of Function*/
	@Override
	public List<Rating> getRatingsOfStoriesWithMinLevel(int level,int readerID) {
		PreparedStatement ps;
        ResultSet rs;
        try{
        DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        Connection con = myFactory.getConnection();

        ps = con.prepareStatement("SELECT * from rating WHERE readerID=? AND accomplishmentID IN " +
        		"(SELECT ID from storyaccomplishment WHERE templateID IN " +
        		"(SELECT TemplateID from template WHERE LevelReq>=?))");
        ps.setInt(1, readerID);
        ps.setInt(2, level);
        rs = ps.executeQuery();
       
        ArrayList<Rating> ratings=new ArrayList<Rating>();
        addResultsToList(ratings, rs);
        
        rs.close();
        ps.close();
        con.close();
        
        return ratings;
        }catch (Exception ex){
        Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
    	}
		return null;
	}/*End of Function*/

	@Override
	public List<Rating> getRatingsOfReaderToWriter(int readerID, int writerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from rating WHERE readerID=? AND " +
            		"accomplishmentID IN (SELECT ID from storyaccomplishment WHERE AccountID=?)");
            ps.setInt(1, readerID);
            ps.setInt(2, writerID);
            rs = ps.executeQuery();
           
            ArrayList<Rating> ratings=new ArrayList<Rating>();
            addResultsToList(ratings, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return ratings;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public int getMaximumScore(int userID) {
		try {
            PreparedStatement ps;
            ResultSet rs;
            int total=0;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT  Max(Score) AS BestScore from rating,storyaccomplishment " +
            		"WHERE accomplishmentID=ID AND AccountID=?");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            if(rs.first())
            	total=rs.getInt("BestScore");
            rs.close();
            ps.close();
            con.close();
            
            return total;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return 0;
		
	}

	@Override
	public int getMinimumScore(int userID) {
		try {
            PreparedStatement ps;
            ResultSet rs;
            int total=0;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT  Min(Score) AS LeastScore from rating,storyaccomplishment " +
            		"WHERE accomplishmentID=ID AND AccountID=?");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            if(rs.first())
            	total=rs.getInt("LeastScore");
            rs.close();
            ps.close();
            con.close();
            
            return total;
		}
        catch (Exception ex)
        {
            Logger.getLogger(RatingMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return 0;
	}

}
