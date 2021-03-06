package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

	@Override
	public List<ConfigValues> getConfigurationSettings() {
		PreparedStatement ps;
		ResultSet rs;
		List<ConfigValues> settings=new ArrayList<ConfigValues>();

		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("SELECT * from ConfigValues");
			rs=ps.executeQuery();
		
			ConfigValues setting;
			while(rs.next()){
				setting=new ConfigValues();
				setting.setValueID(rs.getInt("valueID"));
				setting.setSettingName(rs.getString("settingName"));
				setting.setValue(rs.getString("Value"));
				settings.add(setting);
			}
			rs.close();
			ps.close();
			con.close();
			return settings;
		}catch(Exception ex){
        	Logger.getLogger(ConfigValuesMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	@Override
	public ConfigValues getConfigSetting(int id) {
		PreparedStatement ps;
		ResultSet rs;
		ConfigValues value=null;
		try{
			DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
        	Connection con = myFactory.getConnection();
			ps = con.prepareStatement("SELECT * from ConfigValues WHERE valueID= ?");
			
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.first()){
				value=new ConfigValues();
				value.setValueID(id);
				value.setValue(rs.getString("Value"));
				value.setSettingName(rs.getString("settingName"));
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
