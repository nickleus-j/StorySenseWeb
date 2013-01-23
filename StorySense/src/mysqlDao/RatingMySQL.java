package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            
            Rating Score;
            ArrayList<Rating> ratings=new ArrayList<Rating>();
            while(rs.next()){
            	Score=new Rating();
            	Score.setAccomplishmentID(rs.getInt("accomplishmentID"));
            	Score.setReaderID(rs.getInt("readerID"));
            	Score.setScore(rs.getInt("Score"));
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

            ps = con.prepareStatement("SELECT * FROM rating WHERE readerID = ?");
            ps.setInt(1, WriterID);
            rs = ps.executeQuery();
            
            Rating Score;
            ArrayList<Rating> ratings=new ArrayList<Rating>();
            while(rs.next()){
            	Score=new Rating();
            	Score.setAccomplishmentID(rs.getInt("accomplishmentID"));
            	Score.setReaderID(rs.getInt("readerID"));
            	Score.setScore(rs.getInt("Score"));
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

	@Override
	public void addRating(Rating r) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO rating (accomplishmentID,readerID,Score " +
        			"VALUES (?,?,?)");
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

}
