/*******************************************************************************
 *Copyright (c) 2013 StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package ajaxLearner;

import infoResource.AttributeNames;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import servlets.BaseServlet;
import webEncoder.StoryEncoder;

/**
 * A servelt the 
 */
@WebServlet(description = "Async Call to generate an  incomplete story", urlPatterns = { "/AJAXStoryGen" })
public class AJAXStoryGen extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AJAXStoryGen() {}

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		int level=0;
		
		try{
			level=Integer.parseInt(request.getParameter(AttributeNames.Level.toString()));
		}catch(Exception ex){
			level=0;
		}
		
		StoryEncoder TheEncoder=new StoryEncoder();
		TheEncoder.encodeStory(level);
	}

}
