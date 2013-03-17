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

 * 
 * @author nickleus
 *
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
            	
            	/*Loop that inserts the stories into the list
            	while(rs.next()){
            		Story=new Acomplishment();
            		Story.setID(rs.getInt("ID"));
            		Story.setAccountID(rs.getInt("AccountID"));
            		Story.setTemplateID(rs.getInt("templateID"));
            		Story.setName(rs.getString("Name"));
            		Story.setFileURL(rs.getString("fileURL"));
            		Story.setFinishTime(rs.getTimestamp("finishTime"));
            		Stories.add(Story);
            	}*/
            	
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
            		"WHERE ID NOT IN (SELECT accomplishmentID from rating WHERE readerID =?) AND " +
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
            		"WHERE ID NOT IN (SELECT accomplishmentID from rating WHERE readerID =?) AND " +
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

}
