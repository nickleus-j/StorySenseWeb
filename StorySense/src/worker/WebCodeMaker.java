package worker;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

/**
 * Used to return Stings or other data types in generating the
 * HTML code output to be interpreted by the web browser
 * @author nickleus
 *
 */
public class WebCodeMaker {

	private JspWriter out;
	
	
	public WebCodeMaker(JspWriter writer){
		out=writer;
	}
	
	/*	Methods	*/
	public void writeJsElementReference(String elementName){
		try {
			out.write("\""+elementName+"\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String giveJsStringParam(String elementName){
		return "\""+elementName+"\"";
	}
	
	
}
