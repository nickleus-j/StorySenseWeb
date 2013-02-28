package mysqlDao;

import dao.AcomplishmentDAO;
import dao.ConceptDAO;
import dao.DAOFactory;
import dao.LikedStoryDAO;
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

	
}
