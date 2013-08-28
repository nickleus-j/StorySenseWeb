package ajaxAdmin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConfigValuesDAO;
import dao.DAOFactory;
import entity.ConfigValues;

import servlets.BaseServlet;

/**
 * Servlet implementation class SettingChanger
 */
@WebServlet("/SettingChanger")
public class SettingChanger extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SettingChanger() { }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		ConfigValuesDAO configDao=myDAOFactory.createConfigValuesDAO();
		ConfigValues setting;
		PrintWriter out;
		try{
			out=response.getWriter();
			setting=configDao.getConfigSetting(Integer.parseInt(request.getParameter("ref")));
			setting.setValue(request.getParameter("value"));
			configDao.updateSetting(setting);
			out.write("Save complete");
		}catch(IOException ioex){}
		
	}

}
