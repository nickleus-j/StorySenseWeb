package servlets;

import infoResource.ExternalResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.TemplateDAO;
import entity.Relation;
import entity.Template;

/**
 * Servlet implementation class TemplateEditLoader
 */
@WebServlet("/TemplateEditLoader")
public class TemplateEditLoader extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TemplateEditLoader() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO tDao=myDAOFactory.createTemplateDAO();
		Template currentTemplate;
		try{
			out = response.getWriter();
			currentTemplate=tDao.getTemplate(Integer.parseInt(request.getParameter("t")));
			
			if(currentTemplate!=null){
				showRelations(currentTemplate,out);
				out.write(getQuerieVariablesJSON(currentTemplate));
			}
			else out.write("Invalid Entry");
			
		}catch(IOException ioEx){}
	}/*End of method*/

	public void showRelations(Template template,PrintWriter out)throws IOException{
		List<Relation> relations=getRelations(template);
		Relation current;
		for(int ctr=0;ctr<relations.size();ctr++){
			current=relations.get(ctr);
			out.write(current.getConcept1()+" | "+current.getRelationship()+" | "+current.getConcept2()+" \n");
		}
	}
	
	public String getRealtionParameter(String scanned,Scanner scn){
		String next=scn.next();
		
		if(scanned=="?"||scanned.charAt(0)=='?')
			return "";
		
		if(!next.equalsIgnoreCase("|")){
			return getRealtionParameter(scanned+next,scn);
		}
		return scanned;
	}
	
	public List<Relation> getRelations(Template template) throws FileNotFoundException{
		List<Relation> relations=new ArrayList<Relation>();
		File relationTemplate=new File(ExternalResources.getPrefix()+template.getRelationURL());
		//FileReader fReader=new FileReader(relationTemplate);
		Scanner scanner=new Scanner(relationTemplate);
		String scanned;
		while(scanner.hasNext()){
			Relation relationMade=new Relation();
			/*	1st concept */
			scanned=scanner.next();
			relationMade.setConcept1(getRealtionParameter(scanned,scanner));
			
			/*Relationship*/
			scanned=scanner.next();
			relationMade.setRelationship(getRealtionParameter(scanned,scanner));
			
			relationMade.setConcept2(scanner.nextLine());
			
			relations.add(relationMade);
		}
		
		scanner.close();
		
		return relations;
	}
	
	public List<Relation> getQuerieVariables(Template template) throws FileNotFoundException{
		List<Relation> variables=new ArrayList<Relation>();
		File storyTemplate=new File(ExternalResources.getPrefix()+template.getStoryURL());
		Scanner scanner=new Scanner(storyTemplate);
		String scanned;
		
		while(scanner.hasNext()){
			Relation relationMade=new Relation();
			
			/*	1st concept */
			scanned=scanner.next();
			relationMade.setConcept1(getRealtionParameter(scanned,scanner));
		}
		scanner.close();
		return variables;
	}
	
	
	private String getVariableName(String scanned,Scanner scn){
		String trimmed=scanned.substring(2);
		
		if(scn.hasNext()){
		String next=scn.next();
		
		/*Remove <$*/
		
		
		if(next!=" = "&&next!="="&&next!=null&&next.charAt(0)!='=')
			return getVariableName(scanned+next,scn);
		}
		return trimmed;
	}
	
	private String getStrinUntilComma(String scanned,Scanner scn,char lastC){
		
		if(scanned.charAt(scanned.length()-1)==',')
			return scanned.substring(2,scanned.length()-2);
		if(scanned.charAt(scanned.length()-1)=='>')
			return scanned.substring(2,scanned.length()-3);
		
		if(scn.hasNext()){
			String next=scn.next();
			
			if(next.length()>1&&next.charAt(next.length()-1)==lastC)
				return scanned.substring(2)+" "+next.substring(0, next.length()-2);
			
			
			if(next.charAt(next.length()-1)!=lastC)
				return getStrinUntilComma(scanned+" "+next,scn,lastC);
			
		}
		return scanned.substring(2);
	}/*end of method*/
	
	private String getVaraibleRelation(String scanned,Scanner scn){
		if(scanned.charAt(scanned.length()-1)==',')
			return scanned.substring(0,scanned.length()-1);
		return getVaraibleRelation(scanned+scn.next(),scn);
	}
	
	private String getVariableConcept(String scanned,Scanner scn,char lastC){
		
		if(scanned.charAt(1)=='"'||scanned.charAt(0)=='"')
			return getStrinUntilComma(scanned, scn,lastC);
		return "";
	}
	
	private String scanTherest(String scanned,Scanner scn){
		String text="";
		while(scn.hasNextLine())
			text+=scn.nextLine();
		return text;
	}
	
	/**
	 * Gets the query variables in story templates
	 * and return them in JSON format
	 * <$rabbit1 = (? , Is-A , "name")>
	 */
	public String getQuerieVariablesJSON(Template template) throws FileNotFoundException{
		
		File storyTemplate=new File(ExternalResources.getPrefix()+template.getStoryURL());
		Scanner scanner=new Scanner(storyTemplate);
		String scanned="<",json="[";
		String entry;
		
		while(scanner.hasNext()&&scanned.charAt(0)=='<'){
			if(scanned.length()==1)
				entry="{\"name\":\"";
			else entry=",{\"name\":\"";
			/* Name */
			scanned=scanner.next();
			
			if(scanned.charAt(0)=='<'){
				entry+=getVariableName(scanned,scanner);
				//entry+=scanned.substring(2);;getStrinUntilComma
				entry+="\"";
			
				/*Concept1*/
				entry+=(",\"concept1\":\""+getVariableConcept(scanner.next(),scanner,',')+"\"");
				entry+=(",\"relation\":\""+getVaraibleRelation(scanner.next(),scanner)+"\"");
				entry+=(",\"concept2\":\""+getVariableConcept(scanner.next(),scanner,'>')+"\"");
				//entry+=(",\"concept2\":\""+scanner.next()+"\"");
				entry+="}";
				scanner.nextLine();
				json+=entry;
				
			}
		}
		
		json+=("],\"text\":\""+scanTherest(scanner.next(),scanner)+"\"");
		scanner.close();
		return json;
	}
}
