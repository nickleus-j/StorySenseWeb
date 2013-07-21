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

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dbConnection.DBConnectionFactory;
import entity.Acomplishment;


/**
 * Handles all mysql operations for the
 * Acomplishment record<hr/>
 * 
 *  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `templateID` int(11) DEFAULT NULL,
  `AccountID` int(11) DEFAULT NULL,
  `Name` varchar(80) DEFAULT NULL,
  `fileURL` text,
  `finishTime` timestamp NULL DEFAULT NULL,

 Most Liked Story
 * SELECT ID,account.Name AS Writer,count(storyAccomID) from storyaccomplishment,account,likedstory 
 * WHERE ID =storyAccomID AND storyaccomplishment.AccountID=account.accountID 
 * group by storyAccomID ORDER BY count(storyAccomID) DESC limit 1 ;
 * 
 * @author nickleus
 * SELECT Name, ID, count(storyAccomID) from likedstory,storyaccomplishment 
 * WHERE storyAccomID=ID GROUP BY storyAccomID 
 * ORDER by count(storyAccomID) DESC, Name;
 */
public class AcomplishmentMySQL extends AcomplishmentDAO {

	private void addResultsToList(ArrayList<Acomplishment> Stories,ResultSet rs) throws SQLException{
		Acomplishment Story;
		while(rs.next()){
        	Story=new Acomplishment();
        	Story.setID(rs.getInt("ID"));
        	Story.setAccountID(rs.getInt("AccountID"));
        	Story.setTemplateID(rs.getInt("templateID"));
        	Story.setName(rs.getString("Name"));
        	Story.setFileURL(rs.getString("fileURL"));
        	Story.setFinishTime(rs.getTimestamp("finishTime"));
        	Stories.add(Story);
        }
	}
	
	/**
	 * get all the stories accomplished in the database
	 * @return Stories : the stories accomplished
	 */
	@Override
	public List<Acomplishment> getAllStories() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment order by finishtime DESC");
            rs = ps.executeQuery();
            
            ArrayList<Acomplishment> Stories=null;
            
            
            	Stories=new ArrayList<Acomplishment>();
            	
            	addResultsToList(Stories, rs);
            
            
            rs.close();
            ps.close();
            con.close();
            
            if(!Stories.isEmpty())
              return Stories;
            return null;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Returns the stories made by a specified user
	 * @param AccountID : the ID of the user whose accomplishments
	 * are required
	 */
	@Override
	public List<Acomplishment> getAllStoriesOfUser(int AccountID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment WHERE AccountID = ? ORDER BY finishTime DESC");
            ps.setInt(1, AccountID);
            rs = ps.executeQuery();
            
            //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Returns the accomplished stories generated from a certain template
	 */
	@Override
	public List<Acomplishment> getAllStoriesOfTemplate(int TemplateID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment WHERE templateID = ? order by finishtime DESC");
            ps.setInt(1, TemplateID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Insert a story to the database
	 * @param story : the story saved
	 */
	@Override
	public void addStoryAcomplishment(Acomplishment story) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO storyaccomplishment" +
        			" (AccountID,templateID,Name,fileURL, finishTime) " +
        			"VALUES (?,?,?,?,now())");
            ps.setInt(1, story.getAccountID());
            ps.setInt(2, story.getTemplateID());
            ps.setString(3, story.getName());
            ps.setString(4, story.getFileURL());
            //ps.setTimestamp(5, story.getFinishTime());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	/**
	 * In case there needs to be an update in the record regarding the file
	 */
	@Override
	public void updateStory(Acomplishment story) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update storyaccomplishment SET AccountID= ?, templateID = ?, Name = ?," +
					"fileURL = ?, finishTime = ? where ID = ?");
			
			ps.setInt(1,story.getAccountID());
			ps.setInt(2,story.getTemplateID());
			ps.setString(3, story.getName());
			ps.setString(4, story.getFileURL());
			ps.setTimestamp(5, story.getFinishTime());
			ps.setInt(6, story.getID());
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public Acomplishment getStory(int ID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment WHERE ID = ? ");
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            
            Acomplishment Story=null;
            
            if(rs.first()){
            	Story=new Acomplishment();
            	Story.setID(rs.getInt("ID"));
            	Story.setAccountID(rs.getInt("AccountID"));
            	Story.setTemplateID(rs.getInt("templateID"));
            	Story.setName(rs.getString("Name"));
            	Story.setFileURL(rs.getString("fileURL"));
            	Story.setFinishTime(rs.getTimestamp("finishTime"));
            }
            
            ps.close();
			con.close();
            return Story;
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public List<Acomplishment> getAllStories(int limit) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment order by finishtime DESC LIMIT ?");
            ps.setInt(1, limit);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            
            rs.close();
            ps.close();
            con.close();
            
            if(!Stories.isEmpty())
              return Stories;
            return null;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<Acomplishment> getUserLikedStories(int userID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID IN (SELECT storyAccomID from likedstory WHERE userID=?) " +
            		"ORDER by finishTime DESC");
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            //if(!Stories.isEmpty())
              return Stories;
           // return null;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<Acomplishment> getStoriesToRate(int AccountID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID NOT IN (SELECT accomplishmentID from rating WHERE readerID =?)");
            ps.setInt(1, AccountID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Gets the stories made by an author to be revieed by a certain
	 * reviewer
	 */
	@Override
	public List<Acomplishment> getUserStoriesToRatedbyReader(int readerID,
			int writerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID NOT IN (SELECT accomplishmentID from rating WHERE readerID =?) AND AccountID=?");
            ps.setInt(1, readerID);
            ps.setInt(2, writerID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}
	
	/**
	 * Gets the stories made by an author to be revieed by a certain
	 * reviewer
	 */
	@Override
	public List<Acomplishment> getUserStoriesratedByReader(int readerID,
			int writerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID IN (SELECT accomplishmentID from rating WHERE readerID =?) AND AccountID=?");
            ps.setInt(1, readerID);
            ps.setInt(2, writerID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * get the stories alreaDY Rated
	 */
	@Override
	public List<Acomplishment> getStoriesRated(int readerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID IN (SELECT accomplishmentID from rating WHERE readerID =?)");
            ps.setInt(1, readerID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Gets the stories where their template basis has the following level specified
	 */
	@Override
	public List<Acomplishment> getStoryWithLevel(int readerID,int level) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID IN (SELECT accomplishmentID from rating WHERE readerID =?) AND " +
            		"templateID IN (SELECT TemplateID from template WHERE LevelReq=?)");
            ps.setInt(1, readerID);
            ps.setInt(2, level);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Gets stories with at least this level
	 */
	@Override
	public List<Acomplishment> getStoryWithAtLeastLevel(int readerID,int level) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID IN (SELECT accomplishmentID from rating WHERE readerID =?) AND " +
            		"templateID IN (SELECT TemplateID from template WHERE LevelReq>=?)");
            ps.setInt(1, readerID);
            ps.setInt(2, level);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public List<Acomplishment> getUserStoryWithAtLeastLevel(int level,
			int writerID, int readerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE ID NOT IN (SELECT accomplishmentID from rating WHERE readerID =?) AND " +
            		"templateID IN (SELECT TemplateID from template WHERE LevelReq>=?) AND " +
            		"AccountID=?");
            ps.setInt(1, readerID);
            ps.setInt(2, level);
            ps.setInt(3, writerID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Have a list of story accomplishments that have been rated by reviewers
	 */
	@Override
	public List<Acomplishment> getAllStoriesRated() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment WHERE ID IN " +
            		"(SELECT accomplishmentID from rating) ORDER BY finishtime DESC");
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Gets the story with the most likes
	 */
	@Override
	public Acomplishment getPopularStory() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Name, ID, count(storyAccomID) AS likeNum " +
            		"from likedstory,storyaccomplishment " +
            		"WHERE storyAccomID=ID AND Date(LikeTime)=Date(now()) " +
            		"GROUP BY storyAccomID  ORDER by likeNum DESC, ID");
            rs = ps.executeQuery();
            
            Acomplishment Story=null;
            
            if(rs.first()){
            	Story=getStory(rs.getInt("ID"));
            }
            
            ps.close();
			
			if(Story==null)
				Story=getPopularStory(1, con, ps, rs);
			con.close();
            return Story;
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	private Acomplishment getPopularStory(int dateOffset,Connection con,PreparedStatement ps,ResultSet rs){
		try {
            /*PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();
            Date(Date(now()-?)
            */

            ps = con.prepareStatement("SELECT ID, count(storyAccomID) AS likeNum  " +
            		"from likedstory,storyaccomplishment  " +
            		"WHERE storyAccomID=ID AND Date(LikeTime)=Date(Date(now())- ?) " +
            		"GROUP BY storyAccomID  ORDER by likeNum DESC, ID LIMIT 1");
            ps.setInt(1, dateOffset);
            rs = ps.executeQuery();
            
            Acomplishment Story=null;
            
            if(rs.first()){
            	Story=getStory(rs.getInt("ID"));
            }
            
            
            ps.close();
			
			
			if(Story==null&&dateOffset<10)
				Story=getPopularStory(dateOffset+1, con, ps, rs);
			else if(dateOffset>=10){
				getPopularStory(con, ps, rs);
			}
			con.close();
            return Story;
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	private Acomplishment getPopularStory(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
		ps = con.prepareStatement("SELECT Name, ID, count(storyAccomID) AS likeNum  " +
				"from likedstory,storyaccomplishment  " +
				"WHERE storyAccomID=ID GROUP BY storyAccomID  " +
				"ORDER by likeNum DESC, ID LIMIT 1");
        rs = ps.executeQuery();
        
        Acomplishment Story=null;
        
        if(rs.first()){
        	Story=getStory(rs.getInt("ID"));
        }
        
        
        ps.close();
		con.close();
		return Story;
	}
	
	@Override
	public List<Acomplishment> getStoriesOfWriterRated(int writerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment WHERE AccountID=? AND " +
            		"ID IN  (SELECT accomplishmentID from rating)");
            ps.setInt(1, writerID);
            rs = ps.executeQuery();
            
          //Acomplishment Story;
            ArrayList<Acomplishment> Stories=new ArrayList<Acomplishment>();
            addResultsToList(Stories, rs);
            
            rs.close();
            ps.close();
            con.close();
            
            return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public String getMostLikeStoryTitle(int writerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Name, ID, count(storyAccomID) from likedstory,storyaccomplishment " +
            		"WHERE storyAccomID=ID AND AccountID=? " +
            		"GROUP BY storyAccomID " +
            		"ORDER by count(storyAccomID) DESC, ID LIMIT 1");
            ps.setInt(1, writerID);
            rs = ps.executeQuery();
            
            String Story="";
            
            if(rs.first()){
            	Story=rs.getString("Name");
            }
            
            ps.close();
			con.close();
            return Story;
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "";
	}

	@Override
	public int getMaximumNumberLikesForStory(int writerID) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Name, ID, count(storyAccomID) from likedstory,storyaccomplishment " +
            		"WHERE storyAccomID=ID AND AccountID=? " +
            		"GROUP BY storyAccomID " +
            		"ORDER by count(storyAccomID) DESC, ID LIMIT 1");
            ps.setInt(1, writerID);
            rs = ps.executeQuery();
            rs = ps.executeQuery();
            
            int likes=0;
            
            if(rs.first()){
            	likes=rs.getInt("count(storyAccomID)");
            }
            
            ps.close();
			con.close();
            return likes;
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}

	@Override
	public List<Acomplishment> getStoriesWrittenOn(int userID, String date) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment " +
            		"WHERE AccountID=? AND DATE(finishTime)=Date(?)" +
            		" order by finishtime DESC");
            ps.setInt(1, userID);
            ps.setString(2, date);
            rs = ps.executeQuery();
            
            ArrayList<Acomplishment> Stories=null;
            
            
            	Stories=new ArrayList<Acomplishment>();
            	
            	addResultsToList(Stories, rs);
            
            
            rs.close();
            ps.close();
            con.close();
            
              return Stories;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}/*End of method*/

	@Override
	public List<Acomplishment> getStoriesRatedWithConfidence(
			float minimumConfidence,int limit) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from storyaccomplishment," +
            		"(SELECT accomplishmentID,AVG(Confidence) AS Reliability  " +
            		"FROM rating  GROUP BY accomplishmentID) AS Reliability " +
            		"WHERE ID=accomplishmentID AND Reliability.Reliability >= ?" +
            		" order by finishtime DESC LIMIT ?");
            ps.setFloat(1, minimumConfidence);
            ps.setInt(2, limit);
            rs = ps.executeQuery();
            
            ArrayList<Acomplishment> Stories=null;
            
            
            	Stories=new ArrayList<Acomplishment>();
            	
            	addResultsToList(Stories, rs);
            
            
            rs.close();
            ps.close();
            con.close();
            
            if(!Stories.isEmpty())
              return Stories;
            return null;
		}
        catch (Exception ex)
        {
            Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public String getHighestAverageScoredStoryJson() {
		try {
            PreparedStatement ps;
            ResultSet rs;
            float avg=0f;
            String authorName="";

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT accomplishmentID,storyaccomplishment.Name,account.Name AS author " +
            		",AVG(Score) AS AveScore from rating,storyaccomplishment,account " +
            		"WHERE ID=accomplishmentID AND storyaccomplishment.AccountID=account.accountID  " +
            		"group BY ID ORDER BY AveScore DESC LIMIT 1");
            rs = ps.executeQuery();
            
            Acomplishment Story=null;
            
            if(rs.first()){
            	Story=getStory(rs.getInt("accomplishmentID"));
            	avg=rs.getFloat("AveScore");
            	authorName=rs.getString("author");
            }
            
            ps.close();
			
			if(Story==null)
				Story=getPopularStory(1, con, ps, rs);
			con.close();
			
            return "{\"StoryName\":\""+Story.getName()+"\",\"Avg\":"+avg+",\"userID\":"+
				Story.getAccountID()+",\"storyID\":"+Story.getID()+",\"Author\":\""+authorName+"\"}";
				
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public Acomplishment getHighestAverageScoredStory() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT ID,Name,AVG(Score) AS AveScore " +
            		"from rating,storyaccomplishment " +
            		"WHERE ID=accomplishmentID  group BY ID ORDER BY AveScore DESC LIMIT 1");
            rs = ps.executeQuery();
            
            Acomplishment Story=null;
            
            if(rs.first()){
            	Story=getStory(rs.getInt("ID"));
            }
            
            ps.close();
			
			con.close();
            return Story;
		}catch(Exception ex){
			Logger.getLogger(AcomplishmentMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
