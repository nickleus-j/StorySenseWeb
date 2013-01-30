/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tokenizer;

import java.util.ArrayList;

import entity.Relation;

/**
 *Gets the tokens of the relation template
 * @author Jimenez
 */
public class RelationTemplateTokenizer {
    
    public RelationTemplateTokenizer()
    {
        
    }
    
    public ArrayList<String> Tokenize(ArrayList<String> arrRTemplate)
    {
        ArrayList<String> arrTokenized = new ArrayList<String>();
        String[] OneLine;
        
        for(int i=0; i<arrRTemplate.size(); i++)
        {
            OneLine = arrRTemplate.get(i).split("\\|");
            
            OneLine[0] = RemoveSpaces(OneLine[0]);
            OneLine[1] = RemoveSpaces(OneLine[1]);
            OneLine[2] = RemoveSpaces(OneLine[2]);
            
            arrTokenized.add(OneLine[0]);
            arrTokenized.add(OneLine[1]);
            arrTokenized.add(OneLine[2]);
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
