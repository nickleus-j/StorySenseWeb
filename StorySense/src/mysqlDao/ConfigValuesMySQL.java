package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ConfigValuesDAO;
import dao.DAOFactory;
import dbConnection.DBConnectionFactory;
import entity.ConfigValues;

public class ConfigValuesMySQL extends ConfigValuesDAO {

	@Override
	public void insertSetting(ConfigValues config) {
		PreparedStatement ps;
        try{
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
        	
        	ps = con.prepareStatement("INSERT INTO ConfigValues (settingName, Value) " +
        			"VALUES (?, ?)");
            ps.setString(1, config.getSettingName());
            ps.setString(2, config.getValue());
            ps.execute();
            ps.close();
            
            con.close();
        }catch(Exception ex){
        	Logger.getLogger(ConfigValuesMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void updateSetting(ConfigValues config) {
		PreparedStatement ps;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("update ConfigValues SET settingName= ?, Value = ? where valueID = ?");
			
			ps.setString(1, config.getSettingName());
			ps.setString(2, config.getValue());
			ps.setInt(3, config.getValueID());
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch(Exception ex){
        	Logger.getLogger(ConfigValuesMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	@Override
	public String getStringValue(String settingName) {
		PreparedStatement ps;
		ResultSet rs;
		String value="";
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("SELECT * from ConfigValues WHERE settingName= ?");
			
			ps.setString(1, settingName);
			rs=ps.executeQuery();
			
			if(rs.first()){
				value=rs.getString("Value");
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch(Exception ex){
        	Logger.getLogger(ConfigValuesMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return value;
	}

	@Override
	public int getIntValue(String settingName) {
		PreparedStatement ps;
		ResultSet rs;
		int value=0;
		
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("SELECT * from ConfigValues WHERE settingName= ?");
			
			ps.setString(1, settingName);
			rs=ps.executeQuery();
			
			if(rs.first()){
				value=rs.getInt("Value");
			}
			
			rs.close();
			ps.close();
			con.close();
		}catch(Exception ex){
        	Logger.getLogger(ConfigValuesMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return value;
	}

}
