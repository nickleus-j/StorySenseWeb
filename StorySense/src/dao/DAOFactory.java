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
	    public abstract LikedStoryDAO createLikeDAO();
	    public abstract AchievementDAO createAchievementDAO();
	    public abstract LearnerAcievementDAO createLearnerAcievementDAO();
	    
}
