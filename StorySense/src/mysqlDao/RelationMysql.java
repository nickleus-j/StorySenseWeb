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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.ConfigValuesDAO;
import dao.DAOFactory;
import dao.RelationDAO;
import dbConnection.DBConnectionFactory;
import entity.Relation;
/**
 * Does Relation related database task in Mysql
 * @author nickleus
 *
 */
public class RelationMysql extends RelationDAO {

	/** This gets the records who has a specified value for relation and second concept.
	 * This gets the concept1 from a record with a certain relationship to a certain
	 * concept2 value.
	 * 
	 * @return ArrayList<String> an Arraylist of values for Concept1
	 */
	@Override
	public ArrayList<String> getConcept1ByRelationship(String concept2,
			String relationship, int confidence) {
		ArrayList<String> arrConcept = new ArrayList<String>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Concept1 FROM Relation WHERE Concept2 = ? AND Relationship = ? AND confidence_percentage >= ?");
            ps.setString(1, concept2);
            ps.setString(2, relationship);
            ps.setInt(3, confidence);
            rs = ps.executeQuery();

            while(rs.next())
            {
            arrConcept.add(rs.getString("Concept1"));
            }
            
            ps.close();
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            return arrConcept;
	}

	/** This gets the records who has a specified value for relation and second concept.
	 * This gets the concept2 from a record with a certain relationship to a certain
	 * concept1 value.
	 * 
	 * @return ArrayList<String> an Arraylist of values for Concept1
	 */@Override
	public ArrayList<String> getConcept2ByRelationship(String concept1,
			String relationship, int confidence) {
		ArrayList<String> arrConcept = new ArrayList<String>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Concept2 FROM Relation WHERE Concept1 = ? AND Relationship = ? AND confidence_percentage >= ?");
            ps.setString(1, concept1);
            ps.setString(2, relationship);
            ps.setInt(3, confidence);
            rs = ps.executeQuery();

            while(rs.next())
            {
            arrConcept.add(rs.getString("Concept2"));
            }
            
            ps.close();
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            return arrConcept;
	}

	 /**
	  * Gets the relations with synonyms
	  */
	@Override
	public ArrayList<String> getSynonyms(String concept, int confidence) {
		ArrayList<String> arrConcept = new ArrayList<String>();

        try {
            PreparedStatement ps, ps2;
            ResultSet rs, rs2;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Concept1 FROM Relation WHERE Concept2 = ? AND Relationship = ? AND confidence_percentage >= ?");
            ps.setString(1, concept);
            ps.setString(2, "Synonym");
            ps.setInt(3, confidence);
            rs = ps.executeQuery();

            while(rs.next())
            {
            arrConcept.add(rs.getString("Concept1"));
            }
            
            ps2 = con.prepareStatement("SELECT Concept2 FROM Relation WHERE Concept1 = ? AND Relationship = ? AND confidence_percentage >= ?");
            ps2.setString(1, concept);
            ps2.setString(2, "Synonym");
            ps2.setInt(3, confidence);
            rs2 = ps.executeQuery();
            
            while(rs2.next())
            {
            arrConcept.add(rs2.getString("Concept1"));
            }
            
            ps.close();
            ps2.close();
            
            
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            return arrConcept;
	}

	/**
	 * get the first concept with a certain relationship to a given concept
	 * @return Concept
	 */
	@Override
	public String getSingleConcept1ByRelationship(String concept2,
			String relationship, int confidence) {
		String concept = "";

        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Concept1 FROM Relation WHERE Concept2 = ? AND Relationship = ? AND confidence_percentage >= ?");
            ps.setString(1, concept2);
            ps.setString(2, relationship);
            ps.setInt(3, confidence);
            rs = ps.executeQuery();

            if(rs.next())
            {
            concept = rs.getString("Concept1");
            }
            
            ps.close();
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            return concept;
	}

	/**
	 * get the first concept with a certain relationship to a given concept
	 * @return Concept
	 */
	@Override
	public String getSingleConcept2ByRelationship(String concept1,
			String relationship, int confidence) {
		String concept = "";

        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Concept2 FROM Relation WHERE Concept1 = ? AND Relationship = ? AND confidence_percentage >= ?");
            ps.setString(1, concept1);
            ps.setString(2, relationship);
            ps.setInt(3, confidence);
            rs = ps.executeQuery();

            if(rs.next())
            {
            concept = rs.getString("Concept1");
            }
            
            ps.close();
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            return concept;
	}

	/**
	 * Determines if a Relation exist in the knowledge base /Database
	 */
	@Override
	public boolean RelationIsExisting(String concept1, String concept2,
			String relationship) {
		boolean isExisting = false;

        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT Concept1 FROM Relation WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps.setString(1, concept1);
            ps.setString(2, concept2);
            ps.setString(3, relationship);
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
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExisting;
	}

	/**
	 * Returns all relations in the knowledge base/Database
	 * @return Relations
	 */
	@Override
	public ArrayList<Relation> getRelations() {
		 ArrayList<Relation> arrRelations = new ArrayList<Relation>();

	        try {
	            PreparedStatement ps;
	            ResultSet rs;

	            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
	            Connection con = myFactory.getConnection();

	            ps = con.prepareStatement("SELECT * FROM Relation");
	            arrRelations=getRelationsResult(ps.executeQuery(),arrRelations);
	            
	            ps.close();
	            con.close();

	        }
	        catch (Exception ex)
	        {
	            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
	        }
	            return arrRelations;
	}

	/**
	 * Returns the latest number of validations and score of a relation 
	 */
	@Override
	public Relation getRelationScoreAndValidate(String concept1,
			String concept2, String relationship) {
		Relation oneRelation = new Relation();;

        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT times_validated, total_score FROM Relation WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps.setString(1, concept1);
            ps.setString(2, concept2);
            ps.setString(3, relationship);
            rs = ps.executeQuery();

            if(rs.next())
            {
                oneRelation.setTimes_validated(rs.getInt("times_validated"));
                oneRelation.setTotal_score(rs.getInt("total_score"));
            }
            
            ps.close();
            con.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            return oneRelation;
	}

	/**
	 * Determines if a relation has good confidence
	 */
	@Override
	public boolean RelationIsConfident(String concept1, String concept2,
			String relationship, int confidence) {
		boolean isConfident = false;

        try {
            PreparedStatement ps;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT confidence_percentage FROM Relation WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps.setString(1, concept1);
            ps.setString(2, concept2);
            ps.setString(3, relationship);
            rs = ps.executeQuery();

            if(rs.next())
            {
                if(rs.getInt("confidence_percentage") >= confidence)
                {
                    isConfident = true;
                }
            }
            
            ps.close();
            con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isConfident;
	}

	/**
	 * Makes a relation to be more meaningless
	 */
	@Override
	public void incrementIsMeaningless(String concept1, String concept2,
			String relationship) {
		try {
            PreparedStatement ps;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("UPDATE Relation SET is_meaningless = (is_meaningless + 1) WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps.setString(1, concept1);
            ps.setString(2, concept2);
            ps.setString(3, relationship);
            ps.execute();

            ps.close();
            con.close();
            }
            catch (Exception ex)
            {
                Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            }

	}

	/**
	 * Increases the frequency of a relation
	 */
	@Override
	public void incrementFrequencyCount(String concept1, String concept2,
			String relationship) {
		try {
            PreparedStatement ps;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("UPDATE Relation SET frequency_count = (frequency_count + 1) WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps.setString(1, concept1);
            ps.setString(2, concept2);
            ps.setString(3, relationship);
            ps.execute();

            ps.close();
            con.close();
            }
            catch (Exception ex)
            {
                Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
            }

	}

	/**
	 * Modify the score of a Relation.
	 */
	@Override
	public void updateRelationScore(String concept1, String concept2,
			String relationship, int added_score) {
		float temp;
        int new_confidence;
        try {
            PreparedStatement ps, ps2;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("UPDATE Relation SET times_validated = (times_validated + 1), total_score = (total_score + ?) WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps.setInt(1, added_score);
            ps.setString(2, concept1);
            ps.setString(3, concept2);
            ps.setString(4, relationship);
            ps.execute();


            
            Relation r;
            r = getRelationScoreAndValidate(concept1, concept2, relationship);
            
            //con = CC.connect("ontology");

            temp = ((float)r.getTotal_score()/((float)r.getTimes_validated()*4))*100;
            new_confidence = (int) temp;
            
            ps2 = con.prepareStatement("UPDATE Relation SET confidence_percentage = ? WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps2.setInt(1, new_confidence);
            ps2.setString(2, concept1);
            ps2.setString(3, concept2);
            ps2.setString(4, relationship);
            ps2.execute();

            ps.close();
            ps2.close();
            con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }   

	}

	/**
	 * Removes a relation if it turned out to be meaningless
	 * or not knowledge at all
	 */
	@Override
	public void deleteIfMeaningless(String concept1, String concept2,
			String relationship, int meaningless_count) {
		try {
            PreparedStatement ps, ps2;
            ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();

            ps = con.prepareStatement("SELECT is_meaningless FROM Relation WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
            ps.setString(1, concept1);
            ps.setString(2, concept2);
            ps.setString(3, relationship);
            rs = ps.executeQuery();

            if(rs.next())
            {
                String temp = rs.getString("is_meaningless");
                int count = Integer.parseInt(temp);
                
                if(count>=meaningless_count)
                {
                ps2 = con.prepareStatement("DELETE FROM Relation WHERE Concept1 = ? AND Concept2 = ? AND Relationship = ?");
                ps2.setString(1, concept1);
                ps2.setString(2, concept2);
                ps2.setString(3, relationship);
                ps2.execute();
                ps2.close();
                }
            }
            ps.close();
            con.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	@Override
	public void AddRelation(String Concept1, String Concept2,
			String Relationship) {
		PreparedStatement ps;

        try
        {            
        	DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();
            
            ps = con.prepareStatement("INSERT INTO Relation (Concept1, Concept2, Relationship, confidence_percentage, total_score, times_validated, frequency_count, is_meaningless) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, Concept1);
            ps.setString(2, Concept2);
            ps.setString(3, Relationship);
            ps.setInt(4, 50);
            ps.setInt(5, 4);
            ps.setInt(6, 1);
            ps.setInt(7, 1);
            ps.setInt(8, 0);
            ps.execute();
            
            ps.close();
            con.close();
        }
        catch (Exception ex) {
            Logger.getLogger(RelationMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	private float getConfidenceNeeded(){
		DAOFactory daofactory=DAOFactory.getInstance(DAOFactory.MYSQL);
        ConfigValuesDAO configDao=daofactory.createConfigValuesDAO();
        return configDao.getIntValue("Confidence_THRESHOLD")+0.0f;
	}
	
	/**
	 * Returns the relation knowledge 
	 */
	@Override
	public ArrayList<String> getRelationsOfConcept(String concept) {
		float minimumConfidence=getConfidenceNeeded();
		try{
			PreparedStatement ps;
			ResultSet rs;

            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
            Connection con = myFactory.getConnection();
            
            ps=con.prepareStatement("SELECT Concept1,Sentence_pattern,Concept2 from Relation,relationship  " +
            		"WHERE concept1=? AND  Relation.relationship=relationship.relationship " +
            		"AND Confidence_percentage >=?");
            ps.setString(1, concept);
            ps.setFloat(2, minimumConfidence);
            rs=ps.executeQuery();
            
            ArrayList<String> relationSentences=new ArrayList<String>();
            String sentence;
            
            while(rs.next()){
            	sentence=rs.getString("Concept1")+" "+rs.getString("Sentence_pattern")+" "+rs.getString("Concept2");
            	relationSentences.add(sentence);
            }
            
            rs.close();
            ps.close();
            con.close();
            return relationSentences;
		}catch(Exception ex) {
            Logger.getLogger(RelationMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return null;
	}

	@Override
	public ArrayList<Relation> getRelationsOfConceptSearch(String searchKey) {
		 ArrayList<Relation> arrRelations = new ArrayList<Relation>();

	        try {
	            PreparedStatement ps;

	            DBConnectionFactory myFactory = DBConnectionFactory.getInstance(DAOFactory.MYSQL);
	            Connection con = myFactory.getConnection();

	            ps = con.prepareStatement("SELECT * from Relation WHERE " +
	            		"concept1 LIKE ? OR concept2 LIKE ?");
	            ps.setString(1, searchKey);
	            ps.setString(2, searchKey);

	            arrRelations=getRelationsResult(ps.executeQuery(),arrRelations);
	            
	            
	            ps.close();
	            con.close();

	        }
	        catch (Exception ex)
	        {
	            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
	        }
	            return arrRelations;
	}

	/**
	 * Returns a List of relations that represent the knowledge learned
	 * The list includes the results from the query made
	 * @param rs - a result set from the executed query
	 * @param arrRelations - List of relations that represent the knowledge learned
	 * @return
	 * @throws SQLException
	 */
	private ArrayList<Relation> getRelationsResult(ResultSet rs,ArrayList<Relation> arrRelations) throws SQLException{
		if(arrRelations==null)
			arrRelations = new ArrayList<Relation>();
		while(rs.next())
        {
        Relation oneRelation = new Relation();
            oneRelation.setConcept1(rs.getString("Concept1"));
            oneRelation.setConcept2(rs.getString("Concept2"));
            oneRelation.setRelationship(rs.getString("Relationship"));
            oneRelation.setConfidence_percentage(rs.getInt("Confidence_percentage"));
            oneRelation.setTimes_validated(rs.getInt("Times_validated"));
            oneRelation.setTotal_score(rs.getInt("Total_score"));
        arrRelations.add(oneRelation);
        }
		rs.close();
		return arrRelations;
	}
}
