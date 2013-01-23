package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DAOFactory;
import dao.UserDAO;
import dbConnection.DBConnectionFactory;
import entity.Profile;
import entity.User;

/**
 * This is made for accessing The User table in the Mysql database
 * @author nickleus
 *
 */
public class UserMySQL extends UserDAO {

	//Default constructor
	public UserMySQL(){}
	
	/**Adds a user into the MySQL database
	 * 
	 * @param U --> The user to be added in the database
	 */
	@Override
	public void addUser(User U){
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO account (Name,Password,role) VALUES (?,MD5(?),?)");
            ps.setString(1, U.getName());
            ps.setString(2, U.getPassword());
            ps.setInt(3, U.getRole());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	/**Adds a user and its profile into the MySQL database
	 * @param U --> The user to be added in the database
	 * profile --> The profile
	 */
	@Override
	public void addUser(User U,Profile profile) {
		
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO account (Name,Password,role) VALUES (?,MD5(?),?)");
            ps.setString(1, U.getName());
            ps.setString(2, U.getPassword());
            ps.setInt(3, U.getRole());
            ps.execute();
            ps.close();
            
            U=getUser(U.getName(), U.getPassword());
            
            ps = con.prepareStatement("INSERT INTO profile (Account,picUrl,Birthday,Firstname,Surname) " +
        			"VALUES (?,?,?,?,?)");
            /*
             * INSERT INTO profile (Account,picUrl,Birthday,Firstname,Surname) VALUES 
             * (5,'/home/nickleus/Pictures/upload/logo_992108506.png','2003-02-07','Neji','Hyuga');

             */
            ps.setInt(1, U.getAccountID());
            //ps.setInt(2, profile.getLevel());
            ps.setString(2, profile.getImageURL());
            ps.setDate(3, profile.getBirthDay());
            ps.setString(4, profile.getFirstName());
            ps.setString(5, profile.getSurname());
            ps.execute();
            ps.close();
            
            
            //ps = con.prepareStatement("INSERT INTO profile (Name,Password,role) VALUES (?,MD5(?),?)");

            con.close();
        }catch(Exception ex){
        	Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	/**
	 * This is used to change the activation status of the user
	 * <br>
	 * <b>0</b> for inactive<br>
	 * <b>1</B> for active<hr>
	 */
	@Override
	public void changeActivation(User U,int active) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update account SET Active = ? where accountID = ? ");
			
			ps.setInt(1, active);
			ps.setInt(2,U.getAccountID());
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Update all information about a user
	 */
	@Override
	public void updateUser(User U) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update account  SET Name= ?, Password = ?, role = ?,Active = ? where accountID = ?");
			
			ps.setString(1, U.getName());
			ps.setString(2, U.getPassword());
			ps.setInt(3, U.getRole());
			ps.setBoolean(4, U.isAccountActive());
			ps.setInt(5,U.getAccountID());
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
			Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Get a user with the following username and password
	 */
	@Override
	public User getUser(String Name, String Password) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM account WHERE Name = ? AND Password = MD5(?)");
            ps.setString(1, Name);
            ps.setString(2, Password);
            rs = ps.executeQuery();
            
            User u=null;
            if(rs.first()){
            	u=new User();
            	u.setAccountID(rs.getInt("accountID"));
            	u.setName(rs.getString("Name"));
            	u.setPassword(rs.getString("Password"));
            	u.setRole(rs.getInt("role"));
            	u.setActiveStatus(rs.getInt("Active"));
            }
            

            rs.close();
            ps.close();
            con.close();
            
            return u;
		}
        catch (Exception ex)
        {
            Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * See if the username is taken another user
	 */
	@Override
	public User findUserWithName(String name) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM account WHERE Name = ?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            User u=null;
            if(rs.first()){
            	u=new User();
            	u.setAccountID(rs.getInt("accountID"));
            	u.setName(rs.getString("Name"));
            	u.setPassword(rs.getString("Password"));
            	u.setRole(rs.getInt("role"));
            	u.setActiveStatus(rs.getInt("Active"));
            }

            rs.close();
            ps.close();
            con.close();
            
            return u;
		}
        catch (Exception ex)
        {
            Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Gets all the users in the database
	 */
	@Override
	public List<User> getUsers() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM account");
            rs = ps.executeQuery();
            
            User u;
            ArrayList<User> Users=new ArrayList<User>();
            while(rs.next()){
            	u=new User();
            	u.setAccountID(rs.getInt("accountID"));
            	u.setName(rs.getString("Name"));
            	u.setPassword(rs.getString("Password"));
            	u.setRole(rs.getInt("role"));
            	u.setActiveStatus(rs.getInt("Active"));
            	Users.add(u);
            }

            rs.close();
            ps.close();
            con.close();
            
            if(!Users.isEmpty())
            	return Users;
            else return null;
		}
        catch (Exception ex)
        {
            Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * See if a user name and password matches an entry in the mysql database
	 */
	@Override
	public boolean authenticateUser(String userName, String Password) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM account WHERE Name = ? AND Password = MD5(?)");
            ps.setString(1, userName);
            ps.setString(2, Password);
            rs = ps.executeQuery();
            
            boolean value=rs.first();

            rs.close();
            ps.close();
            con.close();
            
            return value;
		}
        catch (Exception ex)
        {
            Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return false;
	}

	/**
	 * Get users of a certain role
	 */
	@Override
	public List<User> getUsersWithRole(int role) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * from account WHERE role=?");
            ps.setInt(1, role);
            rs = ps.executeQuery();
            
            User u;
            ArrayList<User> Users=new ArrayList<User>();
            while(rs.next()){
            	u=new User();
            	u.setAccountID(rs.getInt("accountID"));
            	u.setName(rs.getString("Name"));
            	u.setPassword(rs.getString("Password"));
            	u.setRole(rs.getInt("role"));
            	u.setActiveStatus(rs.getInt("Active"));
            	Users.add(u);
            }

            rs.close();
            ps.close();
            con.close();
            
            if(!Users.isEmpty())
            	return Users;
            else return null;
		}
        catch (Exception ex)
        {
            Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Gets the highest scoring learners
	 */
	@Override
	public List<User> getTopLearners() {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement(" SELECT * from account WHERE role=1 ORDER BY Points LIMIT 10");
            rs = ps.executeQuery();
            
            User u;
            ArrayList<User> Users=new ArrayList<User>();
            while(rs.next()){
            	u=new User();
            	u.setAccountID(rs.getInt("accountID"));
            	u.setName(rs.getString("Name"));
            	u.setPassword(rs.getString("Password"));
            	u.setRole(rs.getInt("role"));
            	u.setActiveStatus(rs.getInt("Active"));
            	Users.add(u);
            }
            

            rs.close();
            ps.close();
            con.close();
            
            if(!Users.isEmpty())
            	return Users;
            else return null;
		}
        catch (Exception ex)
        {
            Logger.getLogger(UserMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	
}
