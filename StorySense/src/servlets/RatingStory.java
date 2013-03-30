package servlets;

import infoResource.ReviewerResource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Story;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import ajaxReviewer.AjaxStoryReviewer;

import webEncoder.RatingFormEncoder;

import dao.AcomplishmentDAO;
import dao.DAOFactory;
import dao.RatingDAO;
import dao.RelationDAO;
import entity.Acomplishment;
import entity.Rating;
import entity.Relation;
import entity.User;

/**
 * Servlet implementation class RatingStory
 */
@WebServlet(description = "rates a story submitted", urlPatterns = { "/RatingStory" })
public class RatingStory extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RatingStory() {
        
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		
		try{
			response.setContentType("text/html");
			//HttpSession theSession=request.getSession();
			out = response.getWriter();
			
			String title = "Reading All Request Parameters";
		    out.println("<H1 ALIGN=CENTER>" + title + "</H1>\n" +
		                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
		                "<TR BGCOLOR=\"#FFAD00\">\n" +
		                "<TH>Parameter Name<TH>Parameter Value(s)");
		    Enumeration<String>paramNames = request.getParameterNames();
		    while(paramNames.hasMoreElements()) {
		      String paramName = (String)paramNames.nextElement();
		      out.println("<TR><TD>" + paramName + "\n<TD>");
		      String[] paramValues = request.getParameterValues(paramName);
		      if (paramValues.length == 1) {
		        String paramValue = paramValues[0];
		        if (paramValue.length() == 0)
		          out.print("<I>No Value</I>");
		        else
		          out.print(paramValue);
		      } else {
		        out.println("<UL>");
		        for(int i=0; i<paramValues.length; i++) {
		          out.println("<LI>" + paramValues[i]);
		        }
		        out.println("</UL>");
		      }
		    }
		    out.println("</TABLE>");
			
			rateStory(request, out);
			response.sendRedirect("../StorySense/ReviewerHome.jsp");
		}catch(IOException IOe){
			out.print("IO problem");
		}
		catch(Exception ex){
			out.print("Problem in rating "+ex);
		}
		
	}
	
	private ArrayList<Integer> getAssertionScores(HttpServletRequest request) throws FileUploadException{
		ArrayList<Integer> scores=new ArrayList<Integer>();
		int value=0;
		 Enumeration<String>paramNames = request.getParameterNames();
		 while(paramNames.hasMoreElements()) {
		      String paramName = (String)paramNames.nextElement();
		      if(paramName.startsWith(RatingFormEncoder.Assert)){
		    	  value=Integer.parseInt(request.getParameter(paramName));
				  scores.add(value);
		      }
		 }
		
		 /*FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
			
	        List<FileItem> items = null;	//List that will contain the items
	        items = upload.parseRequest(request);
			
	        for(FileItem item: items){
				  if (item.isFormField()&&item.getFieldName().startsWith(RatingFormEncoder.Assert)){
					  value=Integer.parseInt(request.getParameter(item.getFieldName()));
					  scores.add(value);
				  } 
	        }/*End of Loop*/
		 
		return scores;
	}
	
	public void rateStory(HttpServletRequest request,PrintWriter out)throws IOException,Exception{
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RatingDAO myRatingDao=myDAOFactory.createRatingDAO();
		AcomplishmentDAO myAcomDAO=myDAOFactory.createAcomplishmentDAO();
		Acomplishment ratedStory;
		HttpSession theSession=request.getSession();
		ArrayList<Integer> scores=getAssertionScores(request);
		ReviewerResource RRes=new ReviewerResource();
		int sID=Integer.parseInt(request.getParameter(RRes.getStoryIDParameter()));
		Story theStory;
		AjaxStoryReviewer ajaxSReviewer=new AjaxStoryReviewer();
		User currentUser=(User) theSession.getAttribute("user");
		
		ratedStory=myAcomDAO.getStory(sID);
		theStory=ajaxSReviewer.getStoryFile(ratedStory.getFileURL()).getMyStory();
		updateRelationScores(scores, theStory.getAssertions());
		
		out.println("Story: "+ratedStory.getName()+"--");
		
		
		Rating theRating=new Rating();
		theRating.setReaderID(currentUser.getAccountID());
		theRating.setAccomplishmentID(sID);
		theRating.setScore(calculateScore(scores, request.getParameter(RRes.getSatisfactionBoxId())));
		myRatingDao.addRating(theRating);
		//relationDAO.
	}
	
	private int calculateScore(ArrayList<Integer> scores,String qual){
		int result=0,QualIndex=0;
		ReviewerResource RRes=new ReviewerResource();
		String[] qualNames=RRes.getSatisfactionOptions();
		
		while(QualIndex<qualNames.length&&!qual.equalsIgnoreCase(qualNames[QualIndex]))
			QualIndex++;
		
		if(QualIndex==qualNames.length)
			QualIndex=0;
		
		for(int ctr=0;ctr<scores.size();ctr++){
			result+=(scores.get(ctr)*10);
		}
		return result+(QualIndex+1)*10;
	}
	
	private void updateRelationScores(ArrayList<Integer> scores,ArrayList<ArrayList<Relation>> assertions){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		RelationDAO relationDAO=myDAOFactory.createRelationDAO();
		ArrayList<Relation> relations;
		int scoreIndex=0;
		for(int ctr=0;ctr<assertions.size();ctr++){
			relations=assertions.get(ctr);
			for(int i=0;i<relations.size();i++){
				relationDAO.updateRelationScore(relations.get(i).getConcept1(), relations.get(i).getConcept2(),
						relations.get(i).getRelationship(), scores.get(scoreIndex));
				scoreIndex++;
			}/*End of relation Loop*/
		}/*End of Assertion loop*/
		
	}

}
