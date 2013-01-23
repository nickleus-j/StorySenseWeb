package dao;


/*
 * This class connects to the mysql database
 * 
 */

import mysqlDao.MysqlDAOFactory;

public abstract class DAOFactory {

	 public static final int MYSQL = 1;
     public enum ConnetionType{
    	 Mysql;
     }
	    public static DAOFactory getInstance(int dataSource){
	        switch(dataSource){
	            case MYSQL: return new MysqlDAOFactory();
	        }
	        return null;
	    }
	    
	    public static DAOFactory getInstance(ConnetionType type){
	    	if(type == ConnetionType.Mysql)
	    		return new MysqlDAOFactory();
	    	return null;
	    }
	    
	    public abstract ConceptDAO createConceptDAO();
	    public abstract RelationshipDAO createRelationshipDAO();
	    public abstract RelationDAO createRelationDAO();
	    public abstract AcomplishmentDAO createAcomplishmentDAO();
	    public abstract UserDAO createUserDAO();
	    public abstract ProfileDAO createProfileDAO();
	    public abstract RatingDAO createRatingDAO();
	    public abstract TemplateDAO createTemplateDAO();
	    
}
