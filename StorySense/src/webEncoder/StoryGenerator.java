/*******************************************************************************
 *Copyright (c) StorySense
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package webEncoder;

import model.Story;
import Parser.TokenParser;
import Scanner.Scanner;
import Tokenizer.RelationTemplateTokenizer;
import Tokenizer.StoryTemplateTokenizer;
import infoResource.ExternalResources;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;

import entity.Template;

/**
 *
 * @author Roland Chua
 * Modified by Nickleus Jimenez
 */
public class StoryGenerator {
    private int NumberOfStoryTemplates, CONFIDENCE_THRESHOLD,templateID;
    private Story Story;
    private TokenParser tp;
    private ArrayList<Integer> arrNumbers = new ArrayList<Integer>();
    private ArrayList<Template> templateList;


public StoryGenerator(int template_count, int confidence)
{
	templateList=null;
    NumberOfStoryTemplates = template_count;
    CONFIDENCE_THRESHOLD = confidence;
    tp = new TokenParser(CONFIDENCE_THRESHOLD);
    templateID=1;
    for(int t=1; t<=NumberOfStoryTemplates; t++)
    {
        arrNumbers.add(t);
    }
}

public StoryGenerator(ArrayList<Template> templates, int confidence)
{
	templateList=templates;
	if(templates!=null)
		NumberOfStoryTemplates = templates.size();
	else NumberOfStoryTemplates =5;
	
    CONFIDENCE_THRESHOLD = confidence;
    tp = new TokenParser(CONFIDENCE_THRESHOLD);
    templateID=1;
    for(int t=1; t<=NumberOfStoryTemplates; t++)
    {
        arrNumbers.add(t);
    }
}

public int random(int Total)
{
 int rand;
 Random r = new Random();
 rand = r.nextInt(Total);
 return rand;
}
   
public Story getStory()
{
   ArrayList<String> arrSTemplate, arrRTemplate;
   String STfilename, RTfilename;
   
   Scanner s = new Scanner();
   int i, temp;
   
   if(arrNumbers.isEmpty())
   {
        for(int t=1; t<=NumberOfStoryTemplates; t++)
        {
            arrNumbers.add(t);
        }
   }
   temp = random(arrNumbers.size());
   i = arrNumbers.get(temp);
   arrNumbers.remove(temp);
   templateID=i;
   /*	/var/lib/openshift/51dd87aa5973ca662000002e/app-root/data/	*/
   String prefix=ExternalResources.getPrefix();
   STfilename = prefix+"StoryTemplates/StoryTemplate" + i + ".txt";
   RTfilename = prefix+"RelationTemplates/RelationTemplate" + i + ".txt";
   
   /*If there are templates in the database*/
   if(templateList!=null){
	   templateID=templateList.get(i-1).getTemplateID();
	   STfilename = prefix+templateList.get(i-1).getStoryURL();
	   RTfilename = prefix+templateList.get(i-1).getRelationURL();
   }
   System.out.println("opening: " + STfilename +"  ----- "+RTfilename);
   
   arrSTemplate = s.scan(STfilename);
   arrRTemplate = s.scan(RTfilename);
   
   RelationTemplateTokenizer RTT = new RelationTemplateTokenizer();
   StoryTemplateTokenizer STT = new StoryTemplateTokenizer();
   
   arrRTemplate = RTT.Tokenize(arrRTemplate);
   
   arrSTemplate = STT.Tokenize(arrSTemplate);
   
   

   Story = tp.parse(arrRTemplate, arrSTemplate,i);

   return Story;
}
/**
 * Use a propmt to look for a file
 * @return
 */
public String FileSrch(){
	JFileChooser pick = new JFileChooser();
	int i=pick.showOpenDialog(null);
	if(i==JFileChooser.APPROVE_OPTION)
		return pick.getSelectedFile().toString();
	else
		return null;
	}

public int getTemplateID() {return templateID;}
public void setTemplateID(int templateID) {this.templateID = templateID;}

}
