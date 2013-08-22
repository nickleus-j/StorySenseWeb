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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokenizer;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class QuestionTokenizer {
    
    public ArrayList<String> tokenize(String toTokenize)
    {
        ArrayList<String> arrTokenized = new ArrayList<String>();
        char[] cArray;
        ArrayList<Character> aToken;
        String sToken;
        int i=0;
        
        cArray = toTokenize.toCharArray();
        while(cArray[i]!='(') //look for left parenthesis to begin
        {
            i++;
        }

        arrTokenized.add("("); // add the left parenthesis
        i++; // next character

        aToken = new ArrayList<Character>();
        while(cArray[i]!=',')
        {
        aToken.add(cArray[i]);
        i++;
        }
        sToken = "";
        for(int h=0; h<aToken.size(); h++)
        {
            sToken = sToken + aToken.get(h);
        }
        arrTokenized.add(RemoveFirstAndLastSpaces(sToken)); // add first concept

        i++;

        aToken = new ArrayList<Character>();
        while(cArray[i]!=',')
        {
        aToken.add(cArray[i]);
        i++;
        }
        sToken = "";
        for(int h=0; h<aToken.size(); h++)
        {
            sToken = sToken + aToken.get(h);
        }
        arrTokenized.add(RemoveFirstAndLastSpaces(sToken)); // add the relationship

        i++;

        aToken = new ArrayList<Character>();
        while(cArray[i]!=',')
        {
        aToken.add(cArray[i]);
        i++;
        }
        sToken = "";
        for(int h=0; h<aToken.size(); h++)
        {
            sToken = sToken + aToken.get(h);
        }
        arrTokenized.add(RemoveFirstAndLastSpaces(sToken)); // add the second concept
        
        
        i++;

        aToken = new ArrayList<Character>();
        while(cArray[i]!=',' && cArray[i]!=')')
        {
        aToken.add(cArray[i]);
        i++;
        }
        sToken = "";
        for(int h=0; h<aToken.size(); h++)
        {
            sToken = sToken + aToken.get(h);
        }
        arrTokenized.add(RemoveFirstAndLastSpaces(sToken)); // add the question
        
          
        
        i++;
        
        if(i<cArray.length)
        {
            aToken = new ArrayList<Character>();
            while(cArray[i]!=',')
            {
            aToken.add(cArray[i]);
            i++;
            }
            sToken = "";
            for(int h=0; h<aToken.size(); h++)
            {
                sToken = sToken + aToken.get(h);
            }
            arrTokenized.add(RemoveFirstAndLastSpaces(sToken)); // add option 1

            i++;

            aToken = new ArrayList<Character>();
            while(cArray[i]!=')')
            {
            aToken.add(cArray[i]);
            i++;
            }
            sToken = "";
            for(int h=0; h<aToken.size(); h++)
            {
                sToken = sToken + aToken.get(h);
            }
            arrTokenized.add(RemoveFirstAndLastSpaces(sToken)); // add option 2
        }
        else
        {
            arrTokenized.add("~"); // place holder for option 1
            arrTokenized.add("~"); // place holder for option 2
        }      
        
        arrTokenized.add(")"); // add the right parenthesis
        i++; // next character

        return arrTokenized;
    }
    
    public String RemoveFirstAndLastSpaces(String oldWord)
    {
        String newWord="";
        char word[];
        
        word = oldWord.toCharArray();
        
        for(int i=0; i<oldWord.length(); i++)
        {
            if(!(word[i]==' ' && (i==0 || (i+1)==oldWord.length())))
            {
                newWord = newWord + word[i];
            }
        }
        
        return newWord;
    }
}

