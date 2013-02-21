
package Parser;

import dao.DAOFactory;
import dao.RelationDAO;
import entity.Relation;
import model.Query;
import model.Question;
import model.Story;
import mysqlDao.MysqlDAOFactory;
import Tokenizer.AssignmentAndOntologyFunctionTokenizer;
import Tokenizer.ConditionTokenizer;
import Tokenizer.QuestionTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
//import storyapp.InformGUI;

/**
 *Modified by Nickleus Jimenez
 * @author Roland Chua
 * 
 * 
 */
public class TokenParser {
    
    HashMap<String, String> Variable_Memory = new HashMap<String, String>();
    
    int CONFIDENCE_THRESHOLD, blank_counter=1, currentTemplate;
    String sStory = "";
  //"____("+ blank_counter +")____";
    String Blank =getBlankHtmlCode();
    int global_iterator;
    ArrayList<ArrayList<Relation>> Assertions = new ArrayList<ArrayList<Relation>>();
    ArrayList<ArrayList<Integer>> perBlankRuleArray = new ArrayList<ArrayList<Integer>>();
    
    ArrayList<Query> Query_Memory = new ArrayList<Query>();
    ArrayList<Question> arrQuestion = new ArrayList<Question>();
    boolean backtrack;
    
    public TokenParser(int confidence)
    {
        CONFIDENCE_THRESHOLD = confidence; 
    }
    
    public Story parse(ArrayList<String> arrRTemplate, ArrayList<String> arrSTemplate, int temp_count)
    {
        currentTemplate = temp_count;
        sStory = "";
        global_iterator = 0;
        Story Story = new Story();
        String append;
        String ValueReturned;
        boolean false_if;
        int loop_count = 0;
        
        global_iterator = 0;
        ArrayList<Integer> arrInt;
        
        
        //parse story template
        do
        {
            backtrack = false;
            Story = new Story();
            false_if = false;
            blank_counter=1;
            //Blank = "____("+ blank_counter +")____";
            Blank =getBlankHtmlCode();
            Assertions = new ArrayList<ArrayList<Relation>>();
            perBlankRuleArray = new ArrayList<ArrayList<Integer>>();
            arrQuestion = new ArrayList<Question>();
            
            if(loop_count>=100)
            {
                //InformGUI notif = new InformGUI("Story Template " + currentTemplate + " cannot complete due to lack of knowledge. Manually add knowledge if you wish for this template to work.");
                sStory = "";
                global_iterator = 0;
                break;
            }
            
        while(global_iterator<arrSTemplate.size() && !backtrack)
        {
            append = arrSTemplate.get(global_iterator);
            if(append.contains("["))
            {
                char[] cArray;
                
                cArray = append.toCharArray();
                arrInt = new ArrayList<Integer>();
                
                for(int i=1; i<(cArray.length-1); i++) // 1 to skip [ and -1 to skip ]
                {
                    
                    String number="";
                    while(i<(cArray.length-1) && cArray[i]!=',')
                    {
                        number += cArray[i];
                        i++;
                    }
                    System.out.println("Blank spotted: " + number);
                    arrInt.add(Integer.parseInt(number)-1); //minus one so that rule number starts from 1
                }
                perBlankRuleArray.add(arrInt);
                sStory = sStory + Blank;
                increment_blank();
            }
            else if(append.contains("%"))
            {
                sStory = sStory + Variable_Memory.get(RemovePercents(append));
            }
            else if(append.contains("\\"))
            {
                sStory = sStory + '\n';
            }
            else if(append.contains("^"))
            {
                QuestionTokenizer qtTokenizer = new QuestionTokenizer();
                ArrayList<String> arrToProcess = qtTokenizer.tokenize(append);
                Relation oneRel = new Relation();
                Question oneQuestion = new Question();
                
                int i=1; // 1 to skip the ( index
                String temp;
                if(arrToProcess.get(i).contains("\""))
                {
                    temp = RemoveQuotes(arrToProcess.get(i));
                }
                else if(arrToProcess.get(i).contains("$"))
                {
                    temp = Variable_Memory.get(arrToProcess.get(i));
                }
                else
                {
                    temp = arrToProcess.get(i);
                }
                
                oneRel.setConcept1(temp);
                i++;
                oneRel.setRelationship(arrToProcess.get(i));
                i++;
                
                if(arrToProcess.get(i).contains("\""))
                {
                    temp = RemoveQuotes(arrToProcess.get(i));
                }
                else if(arrToProcess.get(i).contains("$"))
                {
                    temp = Variable_Memory.get(arrToProcess.get(i));
                }
                else
                {
                    temp = arrToProcess.get(i);
                }
                
                oneRel.setConcept2(temp);
                i++;
                
                oneQuestion.setRelation(oneRel);
                
                if(arrToProcess.get(i).contains("$"))
                {
                    temp = processVariableInSentence(arrToProcess.get(i));
                }
                else
                {
                    temp = arrToProcess.get(i);
                }
                oneQuestion.setQuestion(temp);
                i++;
                
                oneQuestion.setOption1(arrToProcess.get(i));
                i++;
                
                oneQuestion.setOption2(arrToProcess.get(i));
                i++;               
                
                arrQuestion.add(oneQuestion);
            }
            else if(append.contains("<"))
            {
                append = RemoveArrows(append);
                AssignmentAndOntologyFunctionTokenizer tokenizer = new AssignmentAndOntologyFunctionTokenizer();
                ArrayList<String> arrToProcess = tokenizer.tokenize(append);
                
                /*
                for(int y=0; y<arrToProcess.size(); y++)
                {
                    System.out.println("getfunc: " + arrToProcess.get(y));
                }
                */
                
                ValueReturned = executeAssignmentOrGetFromOntology(arrToProcess);
                
                System.out.println("pulled from ontology: " + ValueReturned);
                
                if(ValueReturned.equals("%backtrack%"))
                {
                    backtrack = true;
                    sStory = "";
                    global_iterator = 0;
                    break;
                }
                else
                {
                    backtrack = false;
                }
                
                //sStory = sStory + pulledFromOntology;
            }
            else if(append.contains("#if") || append.contains("#if!"))
            {
                boolean negate = false;
                
                if(append.contains("#if!"))
                {
                    negate = true;
                }
                
                boolean condition;
                int bracket_counter=1;
                global_iterator++;
                append = arrSTemplate.get(global_iterator);
                
                ConditionTokenizer CT = new ConditionTokenizer();
                ArrayList<String> arrToEval = CT.tokenize(append);
                
                for(int y=0; y<arrToEval.size(); y++)
                {
                    System.out.println("condition tokens: " + arrToEval.get(y));                        
                }
                
                if(arrToEval.get(1).equals("*")) // for randoms
                {
                    int temp = random(2);
                    
                    if(temp==0)
                    {
                        condition = true;
                    }
                    else
                    {
                        condition = false;
                    }
                }
                else // for ifs with condition
                {
                condition = evaluateCondition(arrToEval);
                
                }
                
                if(negate)
                {
                    if(condition)
                    {
                        condition = false;
                    }
                    else
                    {
                        condition = true;
                    }
                }
                
                System.out.println("condition is: " + condition);

                if(condition)
                {
                    ArrayList<String> arrIfContents = new ArrayList<String>();
                    global_iterator+=2; //move to { then first token
                    while(bracket_counter>0)
                    {
                        String temp = arrSTemplate.get(global_iterator);
                        arrIfContents.add(temp);
                        
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        global_iterator++;
                    }
                    arrIfContents.remove(arrIfContents.size()-1);
                    
                    executeST(arrIfContents); // execute if contents
                    false_if = false;
                }
                else
                {
                    global_iterator+=2; //move to { then first token
                    while(bracket_counter>0)
                    {
                        String temp = arrSTemplate.get(global_iterator);
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        global_iterator++;
                    }
                    false_if = true;
                }
                global_iterator--;
            }
            else if(append.contains("#elseif") || append.contains("#elseif!"))
            {
                boolean negate = false;
                
                if(append.contains("#elseif!"))
                {
                    negate = true;
                }
                
                int bracket_counter=1;
                if(false_if)
                {
                    false_if = false;
                    boolean condition;
                    global_iterator++;
                    append = arrSTemplate.get(global_iterator);

                    ConditionTokenizer CT = new ConditionTokenizer();
                    ArrayList<String> arrToEval = CT.tokenize(append);


                    for(int y=0; y<arrToEval.size(); y++)
                    {
                        System.out.println("condition tokens: " + arrToEval.get(y));                        
                    }

                    if(arrToEval.get(1).equals("*")) // for randoms
                {
                    int temp = random(2);
                    
                    if(temp==0)
                    {
                        condition = true;
                    }
                    else
                    {
                        condition = false;
                    }
                }
                else // for ifs with condition
                {
                condition = evaluateCondition(arrToEval);
                
                }                   
                    if(negate)
                    {
                        if(condition)
                        {
                            condition = false;
                        }
                        else
                        {
                            condition = true;
                        }
                    }
                    System.out.println("condition is: " + condition);
                    if(condition)
                    {
                        ArrayList<String> arrIfContents = new ArrayList<String>();
                        global_iterator+=2; //move to { then first token
                        while(bracket_counter>0)
                        {
                            String temp = arrSTemplate.get(global_iterator);
                            arrIfContents.add(temp);

                            if(temp.equals("}"))
                            {
                                bracket_counter--;
                            }
                            else if(temp.equals("{"))
                            {
                                bracket_counter++;
                            }
                            global_iterator++;
                        }
                        arrIfContents.remove(arrIfContents.size()-1);

                        executeST(arrIfContents); // execute if contents

                    }
                    else
                    {
                        global_iterator+=2; //move to { then first token
                        while(bracket_counter>0)
                        {
                            String temp = arrSTemplate.get(global_iterator);
                            if(temp.equals("}"))
                            {
                                bracket_counter--;
                            }
                            else if(temp.equals("{"))
                            {
                                bracket_counter++;
                            }
                            global_iterator++;
                        }
                        false_if = true;
                    }
                    
                }
                else // skip thing cause went in on previous condition already
                {
                    global_iterator+=3; //move to condition then { then first token
                    while(bracket_counter>0)
                    {
                        String temp = arrSTemplate.get(global_iterator);
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        global_iterator++;
                    }
                }
                global_iterator--;
            }
            else if(append.contains("#else"))
            {
                int bracket_counter=1;
                if(false_if)
                {
                    false_if = false;
                        ArrayList<String> arrIfContents = new ArrayList<String>();
                        global_iterator+=2; //move to { then first token
                        while(bracket_counter>0)
                        {
                            String temp = arrSTemplate.get(global_iterator);
                            arrIfContents.add(temp);

                            if(temp.equals("}"))
                            {
                                bracket_counter--;
                            }
                            else if(temp.equals("{"))
                            {
                                bracket_counter++;
                            }
                            global_iterator++;
                        }
                        arrIfContents.remove(arrIfContents.size()-1);

                        executeST(arrIfContents); // execute else contents
                }
                else // skip thing cause went in on previous condition already
                {
                    global_iterator+=2; //move to { then first token
                    while(bracket_counter>0)
                    {
                        String temp = arrSTemplate.get(global_iterator);
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        global_iterator++;
                    }
                    false_if = true;
                }
                global_iterator--;
                
            }
            else
            {
                sStory = sStory + append;
            }
            
        global_iterator++;
        }

        loop_count++;
        System.out.println("loop count: " + loop_count);
        
        }while(backtrack && (loop_count<101));
        Story.setsStory(sStory);
        
        Story.setRelationRules(parseRR(arrRTemplate));
        
        //for(int x=0; x<Story.getRelationRules().size();x++)
          //  System.out.println("Rel Rule: " + Story.getRelationRules().get(x).getConcept1() + "," + Story.getRelationRules().get(x).getRelationship() + ", " + Story.getRelationRules().get(x).getConcept2());
        
        ArrayList<Relation> arrRel;
        for(int i=0; i<perBlankRuleArray.size(); i++)
        {
            arrRel = new ArrayList<Relation>();
            Assertions.add(arrRel);
            
            ArrayList<Integer> temp = perBlankRuleArray.get(i);
            System.out.println("blank " + i);
            for(int j=0; j<temp.size(); j++)
            {
                System.out.println("value: "+temp.get(j));
                Relation newRelation = new Relation();
                newRelation.setConcept1(Story.getRelationRules().get(temp.get(j)).getConcept1());
                newRelation.setConcept2(Story.getRelationRules().get(temp.get(j)).getConcept2());
                newRelation.setRelationship(Story.getRelationRules().get(temp.get(j)).getRelationship());
                
                Assertions.get(i).add(newRelation);                
            }
        }
        Story.setAssertions(Assertions);
        Story.setQuestion(arrQuestion);
        Story.setBlanks(blank_counter);
        
      for(int i=0; i<Assertions.size(); i++)
        {
            //System.out.print("NEXT BLANK");
            for(int j = 0;j<Assertions.get(i).size(); j++)
            {
                System.out.println(Assertions.get(i).get(j).getConcept1() + ", " + Assertions.get(i).get(j).getRelationship() + ", " + Assertions.get(i).get(j).getConcept2());
            }
        }
        
        return Story;
    }
    
    public void executeST(ArrayList<String> arrSTemplate)
    {
        /*
        System.out.println("execute ST tokens received: ");
                for(int i=0; i<arrSTemplate.size(); i++)
                {
                    System.out.println("executeST token " + i + ". " + arrSTemplate.get(i));
                }
        */
        
        String append;
        String ValueReturned;
        boolean false_if = false;
        int local_iterator=0;

        Relation oneAssertion = new Relation();
        ArrayList<Integer> arrInt;
        
        //parse story template
        //do
        //{
            
        while(local_iterator<arrSTemplate.size() && !backtrack)
        {                      
            append = arrSTemplate.get(local_iterator);
            if(append.contains("["))
            {
                char[] cArray;
                
                cArray = append.toCharArray();
                arrInt = new ArrayList<Integer>();
                
                for(int i=1; i<(cArray.length-1); i++) // 1 to skip [ and -1 to skip ]
                {
                    String number="";
                    while(i<(cArray.length-1) && cArray[i]!=',')
                    {
                        number += cArray[i];
                        i++;
                    }
                    arrInt.add(Integer.parseInt(number)-1); //minus one so that rule number starts from 1
                }
                perBlankRuleArray.add(arrInt);
                sStory = sStory + Blank;
                increment_blank();
            }
            else if(append.contains("%"))
            {
                sStory = sStory + Variable_Memory.get(RemovePercents(append));
            }
            else if(append.contains("\\"))
            {
                sStory = sStory + '\n';
            }
            else if(append.contains("^"))
            {
                QuestionTokenizer qtTokenizer = new QuestionTokenizer();
                ArrayList<String> arrToProcess = qtTokenizer.tokenize(append);
                Relation oneRel = new Relation();
                Question oneQuestion = new Question();
                
                int i=1; // 1 to skip the ( index
                String temp;
                if(arrToProcess.get(i).contains("\""))
                {
                    temp = RemoveQuotes(arrToProcess.get(i));
                }
                else if(arrToProcess.get(i).contains("$"))
                {
                    temp = Variable_Memory.get(arrToProcess.get(i));
                }
                else
                {
                    temp = arrToProcess.get(i);
                }
                
                oneRel.setConcept1(temp);
                i++;
                oneRel.setRelationship(arrToProcess.get(i));
                i++;
                
                if(arrToProcess.get(i).contains("\""))
                {
                    temp = RemoveQuotes(arrToProcess.get(i));
                }
                else if(arrToProcess.get(i).contains("$"))
                {
                    temp = Variable_Memory.get(arrToProcess.get(i));
                }
                else
                {
                    temp = arrToProcess.get(i);
                }
                
                oneRel.setConcept2(temp);
                i++;
                
                oneQuestion.setRelation(oneRel);
                
                if(arrToProcess.get(i).contains("$"))
                {
                    temp = processVariableInSentence(arrToProcess.get(i));
                }
                else
                {
                    temp = arrToProcess.get(i);
                }
                oneQuestion.setQuestion(temp);
                i++;
                
                oneQuestion.setOption1(arrToProcess.get(i));
                i++;
                
                oneQuestion.setOption2(arrToProcess.get(i));
                i++;               
                
                arrQuestion.add(oneQuestion);
            }
            else if(append.contains("<"))
            {
                append = RemoveArrows(append);
                AssignmentAndOntologyFunctionTokenizer tokenizer = new AssignmentAndOntologyFunctionTokenizer();
                ArrayList<String> arrToProcess = tokenizer.tokenize(append);
                
                
                for(int y=0; y<arrToProcess.size(); y++)
                {
                    System.out.println("getfunc: " + arrToProcess.get(y));
                }
                
                
                ValueReturned = executeAssignmentOrGetFromOntology(arrToProcess);
                
                //System.out.println("pulled from ontology: " + pulledFromOntology);
                
                if(ValueReturned.equals("%backtrack%"))
                {
                    backtrack = true;
                    sStory = "";
                    global_iterator = 0;
                    local_iterator = 0;
                    break;
                }
                else
                {
                    backtrack = false;
                }
                
                //sStory = sStory + ValueReturned;
            }
            else if(append.contains("#if") || append.contains("#if!"))
            {
                boolean negate = false;
                
                if(append.contains("#if!"))
                {
                    negate = true;
                }
                
                boolean condition;
                int bracket_counter=1;
                local_iterator++;
                append = arrSTemplate.get(local_iterator);
                
                ConditionTokenizer CT = new ConditionTokenizer();
                ArrayList<String> arrToEval = CT.tokenize(append);
                
                /*
                for(int y=0; y<arrToEval.size(); y++)
                {
                    System.out.println("condition tokens: " + arrToEval.get(y));                        
                }
                */
                if(arrToEval.get(1).equals("*")) // for randoms
                {
                    int temp = random(2);
                    
                    if(temp==0)
                    {
                        condition = true;
                    }
                    else
                    {
                        condition = false;
                    }
                }
                else // for ifs with condition
                {
                condition = evaluateCondition(arrToEval);
                
                }
                
                if(negate)
                {
                    if(condition)
                    {
                        condition = false;
                    }
                    else
                    {
                        condition = true;
                    }
                }
                
                System.out.println("condition is: " + condition);
                if(condition)
                {
                    ArrayList<String> arrIfContents = new ArrayList<String>();
                    local_iterator+=2; //move to { then first token
                    while(bracket_counter>0)
                    {
                        String temp = arrSTemplate.get(local_iterator);
                        arrIfContents.add(temp);
                        
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        local_iterator++;
                    }
                    arrIfContents.remove(arrIfContents.size()-1);
                    
                    executeST(arrIfContents); // execute if contents
                    false_if = false;
                }
                else
                {
                    local_iterator+=2; //move to { then first token
                    while(bracket_counter>0)
                    {
                        String temp = arrSTemplate.get(local_iterator);
                        
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        local_iterator++;
                    }
                    
                    false_if = true;
                }
                local_iterator--;
            }
            else if(append.contains("#elseif") || append.contains("elseif!"))
            {
                boolean negate = false;
                
                if(append.contains("#elseif!"))
                {
                    negate = true;
                }
                
                int bracket_counter=1;
                if(false_if)
                {
                    false_if = false;
                    boolean condition;
                    local_iterator++;
                    append = arrSTemplate.get(local_iterator);

                    ConditionTokenizer CT = new ConditionTokenizer();
                    ArrayList<String> arrToEval = CT.tokenize(append);

                    /*
                    for(int y=0; y<arrToEval.size(); y++)
                    {
                        System.out.println("condition tokens: " + arrToEval.get(y));                        
                    }
                    */
                    if(arrToEval.get(1).equals("*")) // for randoms
                {
                    int temp = random(2);
                    
                    if(temp==0)
                    {
                        condition = true;
                    }
                    else
                    {
                        condition = false;
                    }
                }
                else // for ifs with condition
                {
                condition = evaluateCondition(arrToEval);
                
                }
                    
                if(negate)
                {
                    if(condition)
                    {
                        condition = false;
                    }
                    else
                    {
                        condition = true;
                    }
                }
                    
                    System.out.println("condition is: " + condition);
                    if(condition)
                    {
                        ArrayList<String> arrIfContents = new ArrayList<String>();
                        local_iterator+=2; //move to { then first token
                        while(bracket_counter>0)
                        {
                            String temp = arrSTemplate.get(local_iterator);
                            arrIfContents.add(temp);

                            if(temp.equals("}"))
                            {
                                bracket_counter--;
                            }
                            else if(temp.equals("{"))
                            {
                                bracket_counter++;
                            }
                            local_iterator++;
                        }
                        arrIfContents.remove(arrIfContents.size()-1);

                        executeST(arrIfContents); // execute if contents

                    }
                    else
                    {
                        local_iterator+=2; //move to { then first token
                        while(bracket_counter>0)
                        {
                            String temp = arrSTemplate.get(local_iterator);
                            if(temp.equals("}"))
                            {
                                bracket_counter--;
                            }
                            else if(temp.equals("{"))
                            {
                                bracket_counter++;
                            }
                            local_iterator++;
                        }
                        false_if = true;
                    }
                }
                else //skip thing since went in on previous condition already
                {
                    local_iterator+=3; //move to condition then { then first token
                    while(bracket_counter>0)
                    {
                        
                        String temp = arrSTemplate.get(local_iterator);
                        
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        local_iterator++;
                    }
                }
                local_iterator--;
            }
            else if(append.contains("#else"))
            {
                                    int bracket_counter=1;
                if(false_if)
                {
                    false_if = false;
                        ArrayList<String> arrIfContents = new ArrayList<String>();
                        local_iterator+=2; //move to { then first token
                        while(bracket_counter>0)
                        {
                            String temp = arrSTemplate.get(local_iterator);
                            arrIfContents.add(temp);

                            if(temp.equals("}"))
                            {
                                bracket_counter--;
                            }
                            else if(temp.equals("{"))
                            {
                                bracket_counter++;
                            }
                            local_iterator++;
                        }
                        arrIfContents.remove(arrIfContents.size()-1);

                        executeST(arrIfContents); // execute else contents
                        
                }
                else //skip thing since went in on previous condition already
                {
                    local_iterator+=2; //move to { then first token
                    while(bracket_counter>0)
                    {
                        String temp = arrSTemplate.get(local_iterator);
                        
                        if(temp.equals("}"))
                        {
                            bracket_counter--;
                        }
                        else if(temp.equals("{"))
                        {
                            bracket_counter++;
                        }
                        local_iterator++;
                    }
                    
                    false_if = true;
                }
                local_iterator--;
            }
            else
            {
                sStory = sStory + append;
                //System.out.println("appended from inside if: " + append);
            }
            
        local_iterator++;
        }
        
        //}while(backtrack);
    }

    public ArrayList<Relation> parseRR(ArrayList<String> arrRTemplate)
    {
        Relation oneAssertion = new Relation();
        ArrayList<Relation> RelationRules = new ArrayList<Relation>();
        
        //parse relation learning template
        int j=0;
        for(int i=0; i<arrRTemplate.size(); i++)
        {   
            switch(j)
            {
                case 0:
                    if(arrRTemplate.get(i).contains("$"))
                    {
                        oneAssertion.setConcept1(Variable_Memory.get(arrRTemplate.get(i)));
                    }
                    else
                    {   
                        if(arrRTemplate.get(i).contains("\""))
                                {
                                    oneAssertion.setConcept1(RemoveQuotes(arrRTemplate.get(i))); 
                                }
                        else
                        {
                          oneAssertion.setConcept1(arrRTemplate.get(i));  
                        }
                    }
                    break;
                    
                case 1:
                    oneAssertion.setRelationship(arrRTemplate.get(i));
                    break;
                    
                case 2:
                    if(arrRTemplate.get(i).contains("$"))
                    {
                        oneAssertion.setConcept2(Variable_Memory.get(arrRTemplate.get(i)));
                    }
                    else
                    {
                        if(arrRTemplate.get(i).contains("\""))
                                {
                                    oneAssertion.setConcept2(RemoveQuotes(arrRTemplate.get(i))); 
                                }
                        else
                        {
                          oneAssertion.setConcept2(arrRTemplate.get(i));  
                        }
                    }
            }
            if(j==2)
            {
            //System.out.println(oneAssertion.getConcept1() + " and " + oneAssertion.getConcept2() + " and " + oneAssertion.getRelationship());
            RelationRules.add(oneAssertion);
            oneAssertion = new Relation();
            j=-1;
            }
            
            j++;
        }
        return RelationRules;
    }
    
    public boolean evaluateCondition(ArrayList<String> tokens)
    {
        //DBClass dbc = new DBClass();
    	//DBConnectionFactoryImpl dbc= new DBConnectionFactoryImpl();
    	DAOFactory dao= DAOFactory.getInstance(DAOFactory.ConnetionType.Mysql);
        ArrayList<String> arrQuery;
        boolean condition = true;
        String con1="", con2="", rel;

        int i;
        for(i=0; i<tokens.size(); i++) //loop whole thing
        {
            if(tokens.get(i).equals(")")) // this means end of condition so break
            {
                break;
            }
            if(tokens.get(i).equals("&") || tokens.get(i).equals("(")) // look for ( and & skip it (& means more than 1 condition)
            {                   
                i++; //next token
            }   
                if(tokens.get(i).equals("?")) //first concept is blank
                {
                    i++;
                        rel = tokens.get(i);
                    i++;
                    if(tokens.get(i).contains("\""))
                        {
                            con2 = RemoveQuotes(tokens.get(i));
                        }
                        else if(tokens.get(i).contains("$"))
                        {
                            con2 = Variable_Memory.get(tokens.get(i));
                        }
                    arrQuery =new MysqlDAOFactory().createRelationDAO().getConcept1ByRelationship(con2, rel, CONFIDENCE_THRESHOLD);
                    //arrQuery = dbc.getConcept1ByRelationship(con2, rel, CONFIDENCE_THRESHOLD);
                    
                    //dao.
                    
                    if(arrQuery.isEmpty())
                    {
                        condition = false;
                        break;
                    }
                    /*for(int q=0; q<arrQuery1.size(); q++)
                    {
                        System.out.println("arr1: " + q + " : " + arrQuery1.get(q));
                    }*/
                }
                else if(tokens.get(i+2).equals("?")) // second concept is blank
                {
                    if(tokens.get(i).contains("\""))
                        {
                            con1 = RemoveQuotes(tokens.get(i));
                        }
                        else if(tokens.get(i).contains("$"))
                        {
                            con1 = Variable_Memory.get(tokens.get(i));
                        }
                     i++;
                        rel = tokens.get(i);
                     i++;
                     
                    arrQuery=dao.createRelationDAO().getConcept2ByRelationship(con1, rel, CONFIDENCE_THRESHOLD);
                    //arrQuery = dbc.getConcept2ByRelationship(con1, rel, CONFIDENCE_THRESHOLD);         
                    
                    if(arrQuery.isEmpty())
                    {
                        condition = false;
                        break;
                    }
                    
                    /*for(int q=0; q<arrQuery1.size(); q++)
                    {
                        System.out.println("arr1: " + q + " : " + arrQuery1.get(q));
                    }*/
                }
                else // exact relation query
                {
                    if(tokens.get(i).contains("\""))
                        {
                            con1 = RemoveQuotes(tokens.get(i));
                        }
                        else if(tokens.get(i).contains("$"))
                        {
                            con1 = Variable_Memory.get(tokens.get(i));
                        }
                    i++;
                        rel = tokens.get(i);
                    i++;
                    if(tokens.get(i).contains("\""))
                        {
                            con2 = RemoveQuotes(tokens.get(i));
                        }
                        else if(tokens.get(i).contains("$"))
                        {
                            con2 = Variable_Memory.get(tokens.get(i));
                        }
                    
                    boolean temp = dao.createRelationDAO().RelationIsConfident(con1, con2, rel, CONFIDENCE_THRESHOLD);
                    		//dbc.RelationIsConfident(con1, con2, rel, CONFIDENCE_THRESHOLD);
                    
                    if(temp==false)
                    {
                        condition = false;
                        break;
                    }
                }         
        }
        return condition;
    }
    
    public String executeAssignmentOrGetFromOntology(ArrayList<String> tokens)
    {
        //DBClass dbc = new DBClass();
        boolean exists=false, exists2=false;
        boolean is_var = false, is_assignment = false;
        ArrayList<String> arrQuery1 = new ArrayList<String>();
        ArrayList<String> arrQuery2;
        ArrayList<String> arrFiltered = new ArrayList<String>();
        String value="", var_name="", con1="", con2="", rel, temp="";
        
        if(tokens.get(0).contains("$") && tokens.get(1).contains("="))
        {
            var_name = tokens.get(0);
            is_var = true;
            if(tokens.get(2).contains("("))
            {
                is_assignment = false;
            }
            else
            {
                is_assignment = true;
            }
        }
        if(!is_assignment)
        {
            int i;
            for(i=0; i<tokens.size(); i++) //loop whole thing
            {
                while(!tokens.get(i).equals("(")) // loop until left parenthesis
                {
                    i++;
                }

                if(tokens.get(i).equals("(")) // look for ( to start ontology query
                {

                    i++; //next token

                    if(tokens.get(i).equals("?")) //first concept is blank
                    {

                        i++;
                            rel = tokens.get(i);
                        i++;
                        if(tokens.get(i).contains("\""))
                            {
                                con2 = RemoveQuotes(tokens.get(i));
                            }
                            else if(tokens.get(i).contains("$"))
                            {
                                con2 = Variable_Memory.get(tokens.get(i));
                            }
                        i++;
                        temp = "?" + rel + con2;
                        for(int a=0; a<Query_Memory.size(); a++)
                        {
                            if(Query_Memory.get(a).getQuery().equals(temp))
                            {
                                arrQuery1 = Query_Memory.get(a).getArrValues();
                                exists = true;
                                break;
                            }
                        }
                        if(!exists)
                        {
                        RelationDAO rDao=new MysqlDAOFactory().createRelationDAO();
                        arrQuery1=rDao.getConcept1ByRelationship(con2, rel, CONFIDENCE_THRESHOLD);
                        //arrQuery1 = dbc.getConcept1ByRelationship(con2, rel, CONFIDENCE_THRESHOLD);
                        Query oneQuery = new Query();                       
                        oneQuery.setQuery(temp);
                        oneQuery.setArrValues(arrQuery1);
                        Query_Memory.add(oneQuery);
                        }
                        
                        /*for(int q=0; q<arrQuery1.size(); q++)
                        {
                            System.out.println("arr1: " + q + " : " + arrQuery1.get(q));
                        }*/
                    }
                    else // second concept is blank
                    {
                        if(tokens.get(i).contains("\""))
                            {
                                con1 = RemoveQuotes(tokens.get(i));
                            }
                            else if(tokens.get(i).contains("$"))
                            {
                                con1 = Variable_Memory.get(tokens.get(i));
                            }

                        i++;

                            rel = tokens.get(i);

                        i+=2;
                        temp = con1 + rel + "?";
                        
                        for(int a=0; a<Query_Memory.size(); a++)
                        {
                            if(Query_Memory.get(a).getQuery().equals(temp))
                            {
                                arrQuery1 = Query_Memory.get(a).getArrValues();
                                exists = true;
                                break;
                            }
                        }
                        if(!exists)
                        {
                        RelationDAO rDao=new MysqlDAOFactory().createRelationDAO();
                        arrQuery1 = rDao.getConcept2ByRelationship(con1, rel, CONFIDENCE_THRESHOLD);
                        Query oneQuery = new Query();                       
                        oneQuery.setQuery(temp);
                        oneQuery.setArrValues(arrQuery1);
                        Query_Memory.add(oneQuery);
                        }
                        
                        /*for(int q=0; q<arrQuery1.size(); q++)
                        {
                            System.out.println("arr1: " + q + " : " + arrQuery1.get(q));
                        }*/
                    }
                }
                i++;
                if(i<tokens.size() && tokens.get(i).equals("&")) //if has 2nd condition
                {
                    i+=2;
                        if(tokens.get(i).equals("?")) //first concept is blank
                        {
                            i++;
                                rel = tokens.get(i);
                            i++;
                            if(tokens.get(i).contains("\""))
                                {
                                    con2 = RemoveQuotes(tokens.get(i));
                                }
                                else if(tokens.get(i).contains("$"))
                                {
                                    con2 = Variable_Memory.get(tokens.get(i));
                                }
                            i++;
                            temp = temp + "?" + rel + con2;
                            //System.out.println("temp: " + temp);
                            
                            arrQuery2 = new MysqlDAOFactory().createRelationDAO().getConcept1ByRelationship(con2, rel, CONFIDENCE_THRESHOLD);
                        /* for(int q=0; q<arrQuery2.size(); q++)
                        {
                            System.out.println("arr2: " + q + " : " + arrQuery2.get(q));
                        }*/
                        }
                        else // second concept is blank
                        {
                            if(tokens.get(i).contains("\""))
                                {
                                    con1 = RemoveQuotes(tokens.get(i));
                                }
                                else if(tokens.get(i).contains("$"))
                                {
                                    con1 = Variable_Memory.get(tokens.get(i));
                                }

                            i++;

                                rel = tokens.get(i);

                            i+=2;
                            temp = temp + con1 + rel + "?";
                            //System.out.println("temp: " + temp);
                            RelationDAO rDao=new MysqlDAOFactory().createRelationDAO();
                            arrQuery2 = rDao.getConcept2ByRelationship(con1, rel, CONFIDENCE_THRESHOLD);
                        /* for(int q=0; q<arrQuery2.size(); q++)
                        {
                            System.out.println("arr2: " + q + " : " + arrQuery2.get(q));
                        }*/
                        }

                        for(int c=0;c<Query_Memory.size();c++)
                        {
                            if(Query_Memory.get(c).getQuery().equals(temp))
                            {
                                System.out.println("temp: " + temp);
                                exists2 = true;
                                arrFiltered = Query_Memory.get(c).getArrValues();
                            }
                        }
                        if(!exists2)
                        {
                            //get intersection of query 1 and 2
                            for(int h=0; h<arrQuery1.size(); h++)
                            {
                                for(int j=0; j<arrQuery2.size(); j++)
                                {
                                    if(arrQuery1.get(h).equals(arrQuery2.get(j)))
                                    {
                                        arrFiltered.add(arrQuery1.get(h));
                                        //System.out.println("intersection: " + arrQuery1.get(h));
                                    }
                                }
                            }
                            Query oneQuery = new Query();
                            oneQuery.setArrValues(arrFiltered);
                            oneQuery.setQuery(temp);
                            Query_Memory.add(oneQuery);
                        }

                        if(arrFiltered.isEmpty())
                        {
                            value = "%backtrack%";
                            
                            for(int c=0;c<Query_Memory.size();c++)
                            {
                                if(Query_Memory.get(c).getQuery().equals(temp))
                                {
                                    Query_Memory.remove(c);
                                }
                            }
                            break;
                        }
                        else
                        {
                            for(int b=0; b<Query_Memory.size(); b++)
                            {
                                if(Query_Memory.get(b).getQuery().equals(temp))
                                {
                                    int rand = random(Query_Memory.get(b).getArrValues().size());
                                    value = Query_Memory.get(b).getArrValues().get(rand);
                                    Query_Memory.get(b).getArrValues().remove(rand);
                                    if(Query_Memory.get(b).getArrValues().isEmpty())
                                    {
                                        Query_Memory.remove(b);
                                    }
                                }
                            }
                        }

                        if(is_var)
                        {
                            Variable_Memory.put(var_name, value);
                            //System.out.println("memory: " + var_name + " has " + value);
                        }
                }
                else // only 1 condition
                {
                    if(arrQuery1.isEmpty())
                        {
                            value = "%backtrack%";
                            for(int b=0; b<Query_Memory.size(); b++)
                            {
                                if(Query_Memory.get(b).getQuery().equals(temp))
                                {
                                    Query_Memory.remove(b);
                                }
                            }
                            break;
                        }
                    else
                    {
                        for(int b=0; b<Query_Memory.size(); b++)
                            {
                                if(Query_Memory.get(b).getQuery().equals(temp))
                                {
                                    int rand = random(Query_Memory.get(b).getArrValues().size());
                                    value = Query_Memory.get(b).getArrValues().get(rand);
                                    Query_Memory.get(b).getArrValues().remove(rand);
                                    if(Query_Memory.get(b).getArrValues().isEmpty())
                                    {
                                        Query_Memory.remove(b);
                                    }
                                }
                            }
                    }
                    if(is_var)
                    {
                        Variable_Memory.put(var_name, value);
                    }
                    
                }
            }
        }
        else
        {
            var_name = tokens.get(0);
            if(tokens.get(2).contains("\""))
            {
                value = RemoveQuotes(tokens.get(2));
            }
            else
            {
                value = Variable_Memory.get(tokens.get(2));
            }
            Variable_Memory.put(var_name, value);
            
            value = ""; //so that this will not 
        }
        
        return value;
    }
    
    public String RemoveQuotes(String oldWord)
    {
        String newWord="";
        char word[];
        
        word = oldWord.toCharArray();
        
        for(int i=0; i<oldWord.length(); i++)
        {
            if(word[i]!='"')
            {
                newWord = newWord + word[i];
            }
        }
        
        return newWord;
    }
    
    public String RemovePercents(String oldWord)
    {
        String newWord="";
        char word[];
        
        word = oldWord.toCharArray();
        
        for(int i=0; i<oldWord.length(); i++)
        {
            if(word[i]!='%')
            {
                newWord = newWord + word[i];
            }
        }
        
        return newWord;
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
    
    public String RemoveArrows(String oldWord)
    {
        String newWord="";
        char word[];
        
        word = oldWord.toCharArray();
        
        for(int i=0; i<oldWord.length(); i++)
        {
            if(word[i]!='<' && word[i]!='>')
            {
                newWord = newWord + word[i];
            }
        }
        
        return newWord;
    }
    
    public void increment_blank()
    {
    blank_counter++;
    Blank =getBlankHtmlCode();
    }
    
    public int random(int Total)
    {
    int rand;
    Random r = new Random();
    rand = r.nextInt(Total);
    return rand;
    }

    private String processVariableInSentence(String toProcess) {
        String processed = "";
        
        char[] cArray = toProcess.toCharArray();
        ArrayList<Character> aToken;
        String sToken;
        int i=0;
        
        aToken = new ArrayList<Character>();
        while(cArray[i]!='$')
        {
        aToken.add(cArray[i]);
        i++;
        }
        sToken = "";
        for(int h=0; h<aToken.size(); h++)
        {
            sToken = sToken + aToken.get(h);
        }
        processed = sToken; // add 1st part
        
        aToken = new ArrayList<Character>();
        while(cArray[i]!='?' && cArray[i]!=' ' && cArray[i]!='\'')
        {
        aToken.add(cArray[i]);
        i++;
        }
        sToken = "";
        for(int h=0; h<aToken.size(); h++)
        {
            sToken = sToken + aToken.get(h);
        }
        processed += Variable_Memory.get(sToken); // add variable replacement
        
        aToken = new ArrayList<Character>();
        while(i<cArray.length)
        {
        aToken.add(cArray[i]);
        i++;
        }
        sToken = "";
        for(int h=0; h<aToken.size(); h++)
        {
            sToken = sToken + aToken.get(h);
        }
        processed += sToken; // add 2nd part
        
        
        
        return processed;
    }
    private String getBlankHtmlCode(){
    	return "<input type='text' width='15' name='answer"+blank_counter+"' id='answer"+blank_counter+"'/>";
    }
}
