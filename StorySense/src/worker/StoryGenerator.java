package worker;

import model.Story;
import Parser.TokenParser;
import Scanner.Scanner;
import Tokenizer.RelationTemplateTokenizer;
import Tokenizer.StoryTemplateTokenizer;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;

/**
 *
 * @author Roland Chua
 * Modified by Nickleus Jimenez
 */
public class StoryGenerator {
    private int NumberOfStoryTemplates, CONFIDENCE_THRESHOLD;
    private Story Story;
    private TokenParser tp;
    private ArrayList<Integer> arrNumbers = new ArrayList<Integer>();

public StoryGenerator(int template_count, int confidence)
{
    NumberOfStoryTemplates = template_count;
    CONFIDENCE_THRESHOLD = confidence;
    tp = new TokenParser(CONFIDENCE_THRESHOLD);
    
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
     
   //STfilename = FileSrch();
   //RTfilename = FileSrch();/home/nickleus/git/StorySense/StorySense/WebContent
   System.out.println(this.getClass().getResource(getClass().getName()));
   STfilename = "/home/nickleus/git/StorySense/StorySense/StoryTemplates/StoryTemplate" + i + ".txt";
   RTfilename = "/home/nickleus/git/StorySense/StorySense/RelationTemplates/RelationTemplate" + i + ".txt";
  
   System.out.println("opening: " + STfilename +"  ----- "+RTfilename);
   
   arrSTemplate = s.scan(STfilename);
   arrRTemplate = s.scan(RTfilename);
   
   RelationTemplateTokenizer RTT = new RelationTemplateTokenizer();
   StoryTemplateTokenizer STT = new StoryTemplateTokenizer();
   
   arrRTemplate = RTT.Tokenize(arrRTemplate);
   
   arrSTemplate = STT.Tokenize(arrSTemplate);
   
   
   /*for(int n=0; n<arrSTemplate.size(); n++)
   {
       System.out.println(arrSTemplate.get(n));
   }
   */
   Story = tp.parse(arrRTemplate, arrSTemplate,i);

   return Story;
}
public String FileSrch(){
	JFileChooser pick = new JFileChooser();
	int i=pick.showOpenDialog(null);
	if(i==JFileChooser.APPROVE_OPTION)
		return pick.getSelectedFile().toString();
	else
		return null;
	}
}
