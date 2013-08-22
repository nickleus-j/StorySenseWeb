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
public class ConditionTokenizer {
    
    public ConditionTokenizer()
    {
        
    }
    
    public ArrayList<String> tokenize(String toTokenize)
    {
        ArrayList<String> arrTokenized = new ArrayList<String>();
        char[] cArray;
        ArrayList<Character> aToken;
        String sToken;
        
        cArray = toTokenize.toCharArray();
        
        for(int i=0; i<cArray.length; i++)
        {
            switch(cArray[i])
            {
                case '(':
                    arrTokenized.add("("); // add the left parenthesis
                    i++; // next character
                    
                    if(cArray[i]=='*') // for randomizer
                    {
                        sToken = "*";
                        arrTokenized.add(sToken);
                        sToken = ")";
                        arrTokenized.add(sToken);
                    }
                    else
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
                    while(cArray[i]!=')' && cArray[i]!='&')
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
                            
                    if(cArray[i]==')')
                    {
                    arrTokenized.add(")"); // add the right parenthesis
                    i++; // next character
                    }
                    else
                    {
                        i--;
                    }
                    }
                    break;
                    
                case '&':
                    sToken = "&";
                    arrTokenized.add(sToken);
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
                    while(cArray[i]!=')' && cArray[i]!='&')
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
                            
                    if(cArray[i]==')')
                    {
                    arrTokenized.add(")"); // add the right parenthesis
                    i++; // next character
                    }
                    break;
            }
        }
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
