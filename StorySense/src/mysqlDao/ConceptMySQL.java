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
package mysqlDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;

import dbConnection.*;

import dao.ConceptDAO;
import dao.DAOFactory;
import entity.Concept;
/**
 * handles the Data access operations for the Concepts
 * in a Mysql DBMS
 * @author Nickleus Jimenez
 *
 */
public class ConceptMySQL extends ConceptDAO {

	
	/**
	 * Determine if a Concept exist
	 * @param concept
	 * @return conceptExistance
	 */
	public boolean conceptIsExisting(String concept)
    {
        boolean isExisting=false;
        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT ConceptID FROM concept WHERE word_phrase = ?");
            ps.setString(1, concept);
            rs = ps.executeQuery();

            if(rs.next())
            {
                isExisting = true;
            }    
                      
            ps.close();
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(ConceptMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            return isExisting;
    }
	
	/**
	 * Adds a concept into the knowledge base/database
	 */
	@Override
	public void AddConcept(String Word_Phrase) {
		if(!conceptIsExisting(Word_Phrase))
        {
            PreparedStatement ps;

            try
            {            
            	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
                Connection con = myFactory.getConnection();

                ps = con.prepareStatement("INSERT INTO concept (word_phrase) VALUES (?)");
                ps.setString(1, Word_Phrase);
                ps.execute();
                ps.close();

                con.close();
            }
            catch (Exception ex) {
                Logger.getLogger(ConceptMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

	}

	/**
	 * Gets the concepts in the database
	 */
	@Override
	public List<Concept> getConcepts() {
		try {
            PreparedStatement ps;
            ResultSet rs;
            List<Concept> Concepts=new ArrayList<Concept>();
            Concept c;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM concept ");
            rs = ps.executeQuery();
            
            while(rs.next()){
            	c=new Concept();
            	c.setConceptID(rs.getInt("ConceptID"));
            	c.setWord_phrase("Word_phrase");
            	Concepts.add(c);
            }
            
            ps.close();
            con.close();
            
            return Concepts;
		}catch(Exception ex) {
            Logger.getLogger(ConceptMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		return null;
	}

	/**
	 * Gets the Concepts with a matching name
	 */
	@Override
	public List<Concept> getConceptWithMatchingTitle(String concept) {
		try {
            PreparedStatement ps;
            ResultSet rs;
            List<Concept> Concepts=new ArrayList<Concept>();
            Concept c;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT * FROM concept WHERE Word_phrase=?");
            ps.setString(1, concept);
            rs = ps.executeQuery();
            
            while(rs.next()){
            	c=new Concept();
            	c.setConceptID(rs.getInt("ConceptID"));
            	c.setWord_phrase("Word_phrase");
            	Concepts.add(c);
            }
            
            ps.close();
            con.close();
            
            return Concepts;
		}catch(Exception ex) {
            Logger.getLogger(ConceptMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	/**
	 * Get the first concept with a matching name
	 */
	@Override
	public Concept getConcept(String concept) {
		try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT ConceptID FROM concept WHERE word_phrase = ?");
            ps.setString(1, concept);
            rs = ps.executeQuery();

            Concept c=null;
            if(rs.next()){
            	c=new Concept();
            	c.setConceptID(rs.getInt("ConceptID"));
            	c.setWord_phrase("Word_phrase");
            	
            }
                      
            ps.close();
            con.close();
            return c;

        }
        catch (Exception ex)
        {
            Logger.getLogger(ConceptMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

}
