package webEncoder;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import entity.Acomplishment;

public class SidebarEncoder {

	public void showPopularStory(JspWriter out){
		DAOFactory myDaoFactory=DAOFactory.getInstance(DAOFactory.MYSQL);
		AcomplishmentDAO acomDao=myDaoFactory.createAcomplishmentDAO();
		Acomplishment accom=acomDao.getPopularStory();
		
		try {
			out.write(accom.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
