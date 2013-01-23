/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Scanner 
{
    public Scanner()
    {
  
    }
    
    public ArrayList<String> scan(String filename)
    {        
        ArrayList<String> arrSentence = new ArrayList<String>();
        try{
        // Open the file that is the first 
        // command line parameter
        FileInputStream fstream = new FileInputStream(filename);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
        // Print the content on the console
        //System.out.println (strLine);
        arrSentence.add(strLine);
        }
        //Close the input stream
        in.close();
            }catch (Exception e){//Catch exception if any
        System.err.println("Error: " + e.getMessage());
        }
        return arrSentence;
    }
}

