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
package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Story;

import serializableObjects.StoryFileAccess;

/**
 * Servlet implementation class StoryLoader
 */
@WebServlet(description = "Loads a story", urlPatterns = { "/StoryLoader" })
public class StoryLoader extends BaseServlet {

    /**
     * Default constructor. 
     */
    public StoryLoader() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void executeCustomCode(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		try{
			out = response.getWriter();/*/home/nickleus/eclipse/uploadedFiles/The introduction of Simba522066365Simba.story*/
			//FileInputStream fileIn=new FileInputStream("Spicy1844764482Simba.story");
			FileInputStream fileIn=new FileInputStream("The introduction of Simba522066365Simba.story");
			ObjectInputStream oi = new ObjectInputStream(fileIn);
			StoryFileAccess storyFile=(StoryFileAccess)oi.readObject();
			out.println("The story");
			out.write(preview(storyFile));
			oi.close();
			fileIn.close();
		}catch(IOException ioEx){
			out.println("Error in reading the story"+ioEx.getMessage());
		}
		catch(Exception ex){
			out.println("Error in getting the story\n"+ex.getMessage());
		}
		out.flush();
	}
	
	private String preview(StoryFileAccess StoryF)
    {   
		Story Story=StoryF.getMyStory();
        String story_preview = Story.getsStory();
        for (int i=0; i<StoryF.getAnswers().size(); i++)
        {
        story_preview = story_preview.replaceFirst("<input type='text' width='15' name='answer"+(i+1)+"' />.",
        		StoryF.getAnswers().get(i)+" ");
        }
        
        return story_preview;
    }

}
