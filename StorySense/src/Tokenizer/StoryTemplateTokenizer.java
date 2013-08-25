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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokenizer;

import java.util.ArrayList;

/**
 * Splits the lines of the story template into tokens
 * @author Jimenez
 */
public class StoryTemplateTokenizer {
    
    public StoryTemplateTokenizer()
    {
        
    }
    
    public ArrayList<String> Tokenize(ArrayList<String> arrTemplate)
    {
        // < > means getconcept from ontology
        // && means must satisfy both relations
        // { } means pull from memory with variable
        // [?] means a blank
        // $ indicates a variable to be stored in the memory
        
        ArrayList<String> arrTokenized = new ArrayList<String>();
        String oneLine, currentToken;
        char[] cLine;
        
        for(int i=0; i<arrTemplate.size(); i++)
        {
            oneLine = arrTemplate.get(i);
            
            cLine = oneLine.toCharArray();
            currentToken = "";
            
            for(int j=0; j<cLine.length; j++)
            {
                //System.out.println("checker");
                switch(cLine[j])
                {
                    //Today I feel <1 = Is-A | "emotion" && "Positive Emotion" | Is-A>.
                    //[?] is something I do when I am {1}.
                    
                    case '<': 
                        while( j<cLine.length && cLine[j]!='>')
                        {
                            currentToken = currentToken + cLine[j];
                            j++;
                        } 
                        currentToken = currentToken + cLine[j];
                        arrTokenized.add(currentToken);
                        //System.out.println("token added: " + currentToken);
                        currentToken="";
                        break;
                        
                    case '^':
                        while( j<cLine.length && cLine[j]!=')')
                        {
                            currentToken = currentToken + cLine[j];
                            j++;
                        } 
                        currentToken = currentToken + cLine[j];
                        arrTokenized.add(currentToken);
                        //System.out.println("token added: " + currentToken);
                        currentToken="";
                        break;
                        
                        case '\\':
                        while( j<cLine.length && cLine[j]!='n')
                        {
                            currentToken = currentToken + cLine[j];
                            j++;
                        } 
                        currentToken = currentToken + cLine[j];
                        arrTokenized.add(currentToken);
                        System.out.println("token added: " + currentToken);
                        currentToken="";
                        break;
                        
                    case '#': 
                        if(cLine[j+1]=='i' || ((cLine.length>(j+5)) && cLine[j+5]=='i'))
                        {
                            while( j<cLine.length && cLine[j]!='(' && cLine[j]!=' ') //#if #elseif
                            {
                                currentToken = currentToken + cLine[j];
                                j++;
                            } 
                            arrTokenized.add(currentToken);
                            //System.out.println("token added: " + currentToken);

                            currentToken="";

                            while( j<cLine.length && cLine[j]!=')') // parenthesis condition
                            {
                                currentToken = currentToken + cLine[j];
                                j++;
                            } 
                            currentToken = currentToken + cLine[j];
                            arrTokenized.add(currentToken);

                            currentToken="";
                        }
                        else
                        {
                            while( j<cLine.length && cLine[j]!='{') //#else
                            {
                                currentToken = currentToken + cLine[j];
                                j++;
                            } 
                            arrTokenized.add(currentToken);
                            //System.out.println("token added: " + currentToken);

                            currentToken="";
                        }
                        break;
                        
                    case '{': 
                        arrTokenized.add("{"); //add the left brace as a token
                        j++; //next character
                        break; 
                        
                    case '}': 
                        arrTokenized.add("}"); //add the right brace as a token
                        j++; //next character
                        break; 
                        
                    case '%': 
                        currentToken = currentToken + cLine[j];
                        j++;
                        while(j<cLine.length && cLine[j]!='%')
                        {
                            currentToken = currentToken + cLine[j];
                            j++;
                        }
                        currentToken = currentToken + cLine[j];
                        arrTokenized.add(currentToken);
                        //System.out.println("token added: " + currentToken);
                        currentToken="";
                        break;

                    case '[': 
                        while(j<cLine.length && cLine[j]!=']')
                        {
                            currentToken = currentToken + cLine[j];
                            j++;
                        }
                        currentToken = currentToken + cLine[j];
                        arrTokenized.add(currentToken);
                        //System.out.println("token added: " + currentToken);
                        currentToken="";
                        break;

                    default:
                        while(j<cLine.length && cLine[j]!='<' && cLine[j]!='[' && cLine[j]!='%' && cLine[j]!='\\')
                        {
                            //System.out.println("checker: " + j + "|" + cLine.length);
                            currentToken = currentToken + cLine[j];
                            j++;
                        }
                       j--;
                        arrTokenized.add(currentToken);
                       // System.out.println("token added: " + currentToken);
                        currentToken="";
                        break;      
                }
                if(j>=cLine.length)
                {
                    //System.out.println("checker: " + cLine.length + " " + j);
                    break;
                }
            }
        }
        
        return arrTokenized;
    }
}
