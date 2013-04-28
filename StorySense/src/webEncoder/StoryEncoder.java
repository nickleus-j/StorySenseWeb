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
package webEncoder;

import infoResource.AttributeNames;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;


import dao.DAOFactory;
import dao.TemplateDAO;
import entity.Template;


import model.Story;

/**
 * Encodes the Story generated into HTML
 * so that the browsers can show them to the users
 * @author nickleus
 *
 */
public class StoryEncoder {

	private HttpServletRequest Request;
	private JspWriter Out;
	
	public StoryEncoder(){}
	public StoryEncoder(HttpServletRequest request,JspWriter out){
		Request=request;
		Out=out;
	}
	
	public String writeStory(){
		
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateFactory=myDAOFactory.createTemplateDAO();
		ArrayList<Template> templateList=(ArrayList<Template>)templateFactory.getAlltemplates();
		StoryGenerator storyMaker=new StoryGenerator(templateList, getConfidence());//Number of templates and Confidence for now
		Story myStory=storyMaker.getStory();
		
		return myStory.getsStory();
	}
	
	/**
	 * Encode story based on the templates in the server
	 * Parts of the incomplete story will be generated in the server
	 * then the user will see blanks to fill
	 */
	public void encodeStory(){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateFactory=myDAOFactory.createTemplateDAO();
		ArrayList<Template> templateList=(ArrayList<Template>)templateFactory.getAlltemplates();
		StoryGenerator storyMaker=new StoryGenerator(templateList, getConfidence());//Number of templates and Confidence for now
		
		Story myStory=storyMaker.getStory();
		
		Request.getSession().setAttribute(AttributeNames.Story.toString(), myStory);
		Request.getSession().setAttribute(TEMPLATEID, storyMaker.getTemplateID());
		try {
			Out.write(myStory.getsStory());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Encodes a story to be completed based on the level
	 * @param level
	 */
	public String encodeStory(int level){
		DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
		TemplateDAO templateFactory=myDAOFactory.createTemplateDAO();
		ArrayList<Template> templateList;
		
		if(level==0)
			templateList=(ArrayList<Template>)templateFactory.getAlltemplates();
		else templateList=(ArrayList<Template>) templateFactory.getTemplatebyLevel(level);
		
		//Number of templates and Confidence for now
		StoryGenerator storyMaker=new StoryGenerator(templateList, getConfidence());
		
		Story myStory=storyMaker.getStory();
		
		Request.getSession().setAttribute(AttributeNames.Story.toString(), myStory);
		Request.getSession().setAttribute(TEMPLATEID, storyMaker.getTemplateID());
		
		if(myStory!=null)
			return myStory.getsStory();
		return "No story was generated";
	}
	
	public String getStoryAttributeName(){return "Story";}
	public int getConfidence(){ return 60;}
	public static final String  TEMPLATEID="templateID";
}
