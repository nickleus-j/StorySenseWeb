/*******************************************************************************
 *Copyright (c) 2013 StorySense
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DAOFactory;
import dao.RelationshipDAO;
import dbConnection.DBConnectionFactory;
import entity.Relationship;

/**
 * handles Relationship related Data Access Operations
 * in a Mysql DBMS
 * @author nickleus
 *
 */
public class RelationshipMySQL extends RelationshipDAO {

	/**
	 * Adds a relationship in the knowledge base/Database
	 */
	@Override
	public void addRelationship(String Relationship, String Sentence) {
		PreparedStatement ps;

        try
        {            
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("INSERT INTO relationship (Relationship, Sentence_pattern ) VALUES (?,?)");
            ps.setString(1, Relationship);
            ps.setString(2, Sentence);
            ps.execute();
            ps.close();

            con.close();
        }
        catch (Exception ex) {
            Logger.getLogger(RelationshipMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	/**
	 * Gets the sentence for a given relationship
	 */
	@Override
	public String getRelationshipSentence(String Relationship) {
		String sentence="";
        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT sentence_pattern FROM relationship WHERE Relationship = ?");
            ps.setString(1, Relationship);
            rs = ps.executeQuery();

            rs.next();
            sentence = rs.getString("sentence_pattern");
                      
            ps.close();
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(RelationshipMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            return sentence;
	}

	/**
	 * Gets all the Relationships in the database
	 */
	@Override
	public List<Relationship> getRelationships() {
		try {
            PreparedStatement ps;
            ResultSet rs;
            List<Relationship> Relationships=new ArrayList<Relationship>();

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM relationship");
            rs = ps.executeQuery();
            Relationship aRelationship;
            
            while(rs.next()){
            	aRelationship=new Relationship();
            	aRelationship.setRelationshipID(rs.getInt("RelationshipID"));
            	aRelationship.setRelationship(rs.getString("Relationship"));
            	aRelationship.setSentence_pattern(rs.getString("Sentence_pattern"));
            	Relationships.add(aRelationship);
            }
            
            return Relationships;
		}catch (Exception ex)
            {
                Logger.getLogger(RelationshipMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
		return null;
	}

	/*@Override
	public Relationship getMatchingRelationship(String Relationship) {
		// TODO Auto-generated method stub
		return null;
	}

	 */
}
