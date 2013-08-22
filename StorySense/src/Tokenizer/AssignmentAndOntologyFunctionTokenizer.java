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
public class AssignmentAndOntologyFunctionTokenizer {
    
    public AssignmentAndOntologyFunctionTokenizer()
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
                case '$': 
                    aToken = new ArrayList<Character>();
                    while(i<cArray.length && cArray[i]!=' '&&cArray[i]!='='&&cArray[i]!='>')
                    {
                        aToken.add(cArray[i]);
                        i++;
                    }
                    sToken = "";
                    for(int h=0; h<aToken.size(); h++)
                    {
                        sToken = sToken + aToken.get(h);
                    }
                    arrTokenized.add(sToken);
                    break;
                    
                case '=': 
                    sToken = "=";
                    arrTokenized.add(sToken);
                    i++;
                    break;
                    
                case '"':   
                    aToken = new ArrayList<Character>();
                    
                    do
                    {
                        aToken.add(cArray[i]);
                        i++;
                    }
                    while(i<cArray.length && cArray[i]!='"');
                    
                    aToken.add(cArray[i]);
                        
                    sToken = "";
                    for(int h=0; h<aToken.size(); h++)
                    {
                        sToken = sToken + aToken.get(h);
                    }
                    
                    //System.out.println("sidjfidsjfidsojfdsf: " + sToken);
                    
                    arrTokenized.add(sToken);
                    break;
                    
                case '(':
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
                    arrTokenized.add(RemoveSpaces(sToken)); // add first concept

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
                    arrTokenized.add(RemoveSpaces(sToken)); // add the relationship

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
                    arrTokenized.add(RemoveSpaces(sToken)); // add the second concept
                            

                    arrTokenized.add(")"); // add the right parenthesis
                    i++; // next character
                    break;
                    
                case '&':
                    sToken = "&";
                    arrTokenized.add(sToken);
                    i++;
                    break;
            }
        }
        return arrTokenized;
    }
    
    public String RemoveSpaces(String oldWord)
    {
        String newWord="";
        char word[];
        
        word = oldWord.toCharArray();
        
        for(int i=0; i<oldWord.length(); i++)
        {
            if(word[i]!=' ')
            {
                newWord = newWord + word[i];
            }
        }
        
        return newWord;
    }
}
