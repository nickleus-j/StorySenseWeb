/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connects to the database with the defined parameters
 * The defined database from the parameters must be in the system
 * for a successful connection.
 * @author Nickleus
 *
 */
public class DBConnectionFactoryImpl extends DBConnectionFactory{

	
    @Override
    public Connection getConnection() {
        try {
            Class.forName(getDriverName());
            Connection conn = DriverManager.getConnection(getUrl(),getUsername(),getPassword());
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
