<%@page import="worker.RegistrationElements"%>
<%@page import="worker.WebCodeMaker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%!	/*String that represents the elements' ID and names*/
	String RegisFormName=RegistrationElements.RegisFormName.toString(); 
	String usernameElem=RegistrationElements.usernameElem.toString();
	String uNameError=RegistrationElements.uNameError.toString();
	String iniPassID=RegistrationElements.iniPassID.toString(),confirPassID=RegistrationElements.confirPassID.toString();
	String passErorrID=RegistrationElements.passErorrID.toString();
	String fNameID=RegistrationElements.fNameID.toString(),fNameError=RegistrationElements.fNameError.toString();
	String sNameID=RegistrationElements.sNameID.toString(),sNameError=RegistrationElements.sNameError.toString();
	String bdayError=RegistrationElements.bdayError.toString();
	String profilePicID=RegistrationElements.profilePicID.toString(),pictureError=RegistrationElements.pictureError.toString();
%>
<% WebCodeMaker encoder=new WebCodeMaker(out); %>

  <script type="text/javascript">
  
/**
 * This function populates the dropdown box that will contain the day in a month.
 * The parameter dForm is the form about dates. It must have month, year and day as elements
 */
function populateDayBox(dForm){
	var limit=0,dayIndex=dForm.day.selectedIndex;
	
	if(dForm.month.options[1].selected){
		var theYear=dForm.year.options[dForm.year.selectedIndex].value;
		
		if(theYear%4>0)
			limit=28;
		else limit=29;  //Leap year case
	}
	//Set up to 30 to 31 days in a month
	else if(dForm.month.options[8].selected||dForm.month.options[3].selected||dForm.month.options[5].selected||dForm.month.options[10].selected)
		limit=30;
	else limit=31;
	
        if(dForm.day.options.length!=limit){
        
            //Loop to reset the values
            for(var ctr=0;ctr<31;ctr++)
		dForm.day.options[ctr]=null;
	
            //loop to populate the combo box
            for(var ctr=0;ctr<limit;ctr++)
		dForm.day.options[ctr]=new Option(ctr+1);
            
            //do not change the index of the day comboboix if not needed
            if(dayIndex<limit)
                dForm.day.options[dayIndex].selected=true;
	}
	
}

/*Submit the registration form
 */
function submitRegistration()
{	
	 document.getElementById(<% encoder.writeJsElementReference(RegisFormName);%>).submit();
	//document.getElementById("Registration").submit();
}

/**
 * Submits a form. A String that matches the form's id is needed as a parameter
 */
function submitForm(formName){document.getElementById(formName).submit();}

//Checks is a text box is empty
function isBoxEmpty(box){return box.value==null||box.value=="";}


function evaluateForm(){
	var valid=true; 
	var errorCell;
	var nameBox=document.getElementById(<% encoder.writeJsElementReference(usernameElem);%>);
	
	/*
		Check if a username is valid
	*/
	errorCell=document.getElementById(<% encoder.writeJsElementReference(uNameError);%>);
	if(isBoxEmpty(nameBox)){
		valid=false;
		errorCell.innerHTML="There must be a username";
	} else errorCell.innerHTML="";
	
	/*
		The password validation
		Check if the password boxes have values and if those values match
	*/
	var passwordBox1=document.getElementById(<% encoder.writeJsElementReference(iniPassID);%>);
	var passwordBox2=document.getElementById(<% encoder.writeJsElementReference(confirPassID);%>);
	errorCell=document.getElementById(<% encoder.writeJsElementReference(passErorrID);%>);
	
	if(isBoxEmpty(passwordBox1) || isBoxEmpty(passwordBox2)){
		valid=false;
		errorCell.innerHTML="Password Boxes must not be empty";
	}
	else if(passwordBox1.value!=passwordBox2.value){
		valid=false;
		errorCell.innerHTML="Password Boxes must contain  matching text";
	}else errorCell.innerHTML="";
	
	

	/*
	Firstname Validation firstnameError
		Check if the first name textbox has values
	*/
	nameBox=document.getElementById(<% encoder.writeJsElementReference(fNameID);%>);
	errorCell=document.getElementById(<% encoder.writeJsElementReference(fNameError);%>);
	
	if(isBoxEmpty(nameBox)){
		valid=false;
		errorCell.innerHTML="Enter you first name";
	}else errorCell.innerHTML="";
	
	
	
	/* Surname validation
		Check if the surname textbox is not empty
	*/
	nameBox=document.getElementById(<% encoder.writeJsElementReference(sNameID);%>);
	errorCell=document.getElementById(<% encoder.writeJsElementReference(sNameError);%>);
	
	if(isBoxEmpty(nameBox)){
		valid=false;
		errorCell.innerHTML="Enter you surname";
	}else errorCell.innerHTML="";
	
	/*The picture*/
	var profilePic=document.getElementById(<% encoder.writeJsElementReference(profilePicID);%>);
	var errorPic=document.getElementById(<% encoder.writeJsElementReference(pictureError);%>);
	errorPic.innerHTML="Uploading "+profilePic.value;
	
	if(valid==true)
		submitRegistration();
	
}
</script>