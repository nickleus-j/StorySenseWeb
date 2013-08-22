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

import dao.AchievementDAO;
import dao.AcomplishmentDAO;
import dao.ConceptDAO;
import dao.ConfigValuesDAO;
import dao.DAOFactory;
import dao.LearnerAcievementDAO;
import dao.LikedStoryDAO;
import dao.NotificationDao;
import dao.NotificationMessageDao;
import dao.NotificationTypeDao;
import dao.ProfileDAO;
import dao.RatingDAO;
import dao.RelationDAO;
import dao.RelationshipDAO;
import dao.TemplateDAO;
import dao.UserDAO;
/**
 * Instantiates Mysql implementations of DAOs
 * so that database operations can be done
 * @author nickleus
 *
 */
public class MysqlDAOFactory extends DAOFactory{

	@Override
	public ConceptDAO createConceptDAO() {return new ConceptMySQL();}

	@Override
	public RelationshipDAO createRelationshipDAO() {return new RelationshipMySQL();}

	@Override
	public RelationDAO createRelationDAO() {return new RelationMysql();}

	@Override
	public AcomplishmentDAO createAcomplishmentDAO() {
		return new AcomplishmentMySQL();
	}

	@Override
	public UserDAO createUserDAO() {return new UserMySQL();}

	@Override
	public ProfileDAO createProfileDAO() {return new ProfileMySQL();}

	@Override
	public RatingDAO createRatingDAO() {return new RatingMySQL();}

	@Override
	public TemplateDAO createTemplateDAO() {return new TemplateMySQL();}

	@Override
	public LikedStoryDAO createLikeDAO() {
		return new LikedStoryMysql();
	}

	@Override
	public AchievementDAO createAchievementDAO() {return new AchievementMysql();}

	@Override
	public LearnerAcievementDAO createLearnerAcievementDAO() {return new LearnerAchievementMysql();}

	@Override
	public NotificationTypeDao createNotificationTypeDao() {return new NotificationTypeMySQL();}

	@Override
	public NotificationDao createNotificationDao() {return new NotificationMySQL();}

	@Override
	public NotificationMessageDao createNotificationMessageDao() {return new NotificationMessageMysql();}

	@Override
	public ConfigValuesDAO createConfigValuesDAO() {
		return new ConfigValuesMySQL();
	}

	
}
