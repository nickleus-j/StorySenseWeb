package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DAOFactory;
import dao.ProfileDAO;
import dbConnection.DBConnectionFactory;
import entity.Profile;
import entity.User;

/**
 * Handles mysql operations regarding the Profile Record
 * @author nickleus
 *
 */
public class ProfileMySQL extends ProfileDAO {

	/**
	 * Add the profile to the mysql database
	 */
	@Override
	public void addProfile(Profile profile) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO profile (Account,Level,picUrl,Birthday,Firstname,Surname) " +
        			"VALUES (?,?,?,?,?,?");
            ps.setInt(1, profile.getAccount());
            ps.setInt(2, profile.getLevel());
            ps.setString(3, profile.getImageURL());
            ps.setDate(4, profile.getBirthDay());
            ps.setString(5, profile.getFirstName());
            ps.setString(6, profile.getSurname());
            ps.execute();
            ps.close();

            con.close();
        }catch(Exception ex){
        	Logger.getLogger(ProfileMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	//Change Level into Point
	
	/**
	 * Make changes on the profile
	 */
	@Override
	public void setProfile(Profile profile) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update profile  SET FirstName= ?, Surname = ?, Birthday = ?, Point = ?, " +
					"picUrl = ? where Account = ?");
			ps.setString(1, profile.getFirstName());
			ps.setString(2, profile.getSurname());
			ps.setDate(3, profile.getBirthDay());
			ps.setInt(4, profile.getPoint());
			ps.setString(5, profile.getImageURL());
			ps.setInt(6,profile.getAccount());
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(ProfileMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Get a profile of a certain user
	 */
	@Override
	public Profile getProfile(User u) {
		try {
            PreparedStatement ps;
            ResultSet rs;
            Profile P=new Profile();

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();
            
            ps = con.prepareStatement("SELECT * from profile WHERE Account=?");
            ps.setInt(1, u.getAccountID());
            rs = ps.executeQuery();
            
            if(rs.first()){
            	P.setAccount(u.getAccountID());
            	P.setFirstName(rs.getString("FirstName"));
            	P.setSurname(rs.getString("Surname"));
            	P.setBirthDay(rs.getDate("Birthday"));
            	P.setLevel(rs.getInt("Level"));
            	P.setImageURL(rs.getString("picUrl"));
            }
            
            rs.close();
            ps.close();
            con.close();
            return P;
		}
        catch (Exception ex)
        {
            Logger.getLogger(ProfileMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Get the user profile from an accountID obtained
	 */
	@Override
	public Profile getProfile(int account) {
		try {
            PreparedStatement ps;
            ResultSet rs;
            Profile P=new Profile();

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();
            
            ps = con.prepareStatement("SELECT * from profile WHERE Account=?");
            ps.setInt(1, account);
            rs = ps.executeQuery();
            
            if(rs.first()){
            	P.setAccount(account);
            	P.setFirstName(rs.getString("FirstName"));
            	P.setSurname(rs.getString("Surname"));
            	P.setBirthDay(rs.getDate("Birthday"));
            	P.setLevel(rs.getInt("Level"));
            	P.setImageURL(rs.getString("picUrl"));
            }
            
            rs.close();
            ps.close();
            con.close();
            return P;
		}
        catch (Exception ex)
        {
            Logger.getLogger(ProfileMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

}
