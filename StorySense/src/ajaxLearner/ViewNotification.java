package ajaxLearner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.NotificationDao;

import servlets.BaseServlet;

/**
 * Servlet implementation class ViewNotification
 */
@WebServlet(description = "Changes the view state of a notification", urlPatterns = { "/ViewNotification" })
public class ViewNotification extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewNotification() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html"); 
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		NotificationDao nDao=myDAOFactory.createNotificationDao();
		int nID=Integer.valueOf(request.getParameter("noticeID"));
		nDao.updateNotificationView(nID, request.getParameter("viewStat"));
		
	}

}
