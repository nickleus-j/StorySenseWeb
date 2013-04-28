/*******************************************************************************
 *Copyright (c) 2013 IBM Corporation and others.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;

import dao.DAOFactory;

/**<p>
 * Connects to the database used by
 * the web application. This class will make it easier for modification
 * when there is a need to change the supported DBMS.</p>
 * @author Nickleus Jimenez
 */
public abstract class DBConnectionFactory {
	/*
	 * The values of these static variables will be determined
	 * when the data source is identified.
	 */
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;
    
    /**
     * The parameters for the connection to the DBMS are defined.
     * Those parameters will be used to identify a scema in the system.
     * @param dataSource
     * @return DBConnectionFactoryImpl
     */
    public static DBConnectionFactory getInstance(int dataSource){
    	/*	Use the following command to Mysql console
    	 * 	CREATE USER 'myUser'@'localhost' IDENTIFIED BY 'hello';
		*	GRANT SELECT,INSERT,UPDATE,DELETE ON *.* TO 'myUser'@'localhost';
    	 */
        switch (dataSource){
            case DAOFactory.MYSQL: 
            	//Constant that gets the name of the driver in the mysql library
               driverName  = "com.mysql.jdbc.Driver";
               
               //The URL of the database to be used
               url  = "jdbc:mysql://localhost:3306/ontology";
               
              // The username and password for the account in the MySQL server
               username  = "myUser";
               password = "hello";
            break;
        }
        return new DBConnectionFactoryImpl();
    }
    
    public abstract Connection getConnection();

    /**
     * @return the driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName the driverName to set
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
