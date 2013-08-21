package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		// TODO Auto-generated method stub

	}

	@Override
	public String getStringValue(String settingName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIntValue(String settingName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
