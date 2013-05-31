/*******************************************************************************
 *Copyright (c) 2013 StorySense.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickleus Jimenez
 *******************************************************************************/
package unclassified;

//import java.util.ArrayList;
import java.util.Calendar;
/**
 * Provides information involving dates like the months
 * and days
 * Provides HTML code for picking a date
 */ 
public class DateProvider {

	//private ArrayList<String> Countires;
	private String[] Months;
	
	public DateProvider(){
		Months=new String[12];
		
		Months[0]="January";
		Months[1]="Febuary";
		Months[2]="March";
		Months[3]="April";
		Months[4]="May";
		Months[5]="June";
		Months[6]="July";
		Months[7]="August";
		Months[8]="September";
		Months[9]="October";
		Months[10]="November";
		Months[11]="December";
		
	}
	
	public String getMonth(int n){
		try{
			return Months[n];
		}catch(ArrayIndexOutOfBoundsException ex){
			if(n<0)
				n*=-1;
			
			return getMonth(n%12);
		}
		//return Months[0];
	}
	
	public int getYear(){
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}
	
	public String provideYearOptions(int limit){
		Calendar cal=Calendar.getInstance();
		String val="";
		
		for(int ctr=0;ctr<limit;ctr++)
			val+=("<option>"+(cal.get(Calendar.YEAR)-ctr)+"</option>");
		
		
		return val;
	}

	public String[] getMonths() {
		return Months;
	}

	public void setMonths(String[] months) {
		Months = months;
	}
	
}
