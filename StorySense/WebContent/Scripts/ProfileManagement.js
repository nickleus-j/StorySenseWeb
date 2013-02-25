var hiddenElem="hiddenElem",revealed="r";

//Checks is a text box is empty
function isBoxEmpty(box){return box.value==null||box.value=="";}
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
	else if(dForm.month.options[8].selected||dForm.month.options[3].selected||
			dForm.month.options[5].selected||dForm.month.options[10].selected)
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

/**
 * Submits a form. A String that matches the form's id is needed as a parameter
 */
function submitForm(formName){document.getElementById(formName).submit();}

function ShowPasswordChanger(){
	
	var passwordRow=document.getElementById("passwordRow");
	var changepasswordRow=document.getElementById("changepasswordRow");
	var confirmationPassRow=document.getElementById("confirmationPassRow");
	var submitPassRow=document.getElementById("submitPassRow");	
	
	passwordRow.setAttribute("class",hiddenElem);
	changepasswordRow.setAttribute("class",revealed);
	confirmationPassRow.setAttribute("class",revealed);
	submitPassRow.setAttribute("class",revealed);
	
}

function hidePasswordChanger(){
	var passwordRow=document.getElementById("passwordRow");
	var changepasswordRow=document.getElementById("changepasswordRow");
	var confirmationPassRow=document.getElementById("confirmationPassRow");
	var submitPassRow=document.getElementById("submitPassRow");	
	
	passwordRow.setAttribute("class",revealed);
	changepasswordRow.setAttribute("class",hiddenElem);
	confirmationPassRow.setAttribute("class",hiddenElem);
	submitPassRow.setAttribute("class",hiddenElem);
}

function changeProfile(){
	var chnageProfile=document.getElementById("chnageProfile");	
	var orig1stName=document.getElementById("orig1stName");
	var origsurname=document.getElementById("origsurname");
	var origBday=document.getElementById("origBday");
	
	/*Hide and show certain elements*/
	chnageProfile.setAttribute("class",revealed);
	orig1stName.setAttribute("class",hiddenElem);
	origsurname.setAttribute("class",hiddenElem);
	origBday.setAttribute("class",hiddenElem);
}

function cancelProfileChange(){
	var chnageProfile=document.getElementById("chnageProfile");	
	var orig1stName=document.getElementById("orig1stName");
	var origsurname=document.getElementById("origsurname");
	var origBday=document.getElementById("origBday");
	
	/*Hide and show certain elements*/
	chnageProfile.setAttribute("class",hiddenElem);
	orig1stName.setAttribute("class",revealed);
	origsurname.setAttribute("class",revealed);
	origBday.setAttribute("class",revealed);
}

function passwordChangeValidation(){
	var valid=true;
	/*
	The password validation
	Check if the password boxes have values and if those values match
	 */
	var passwordBox1=document.getElementById("newPass");
	var passwordBox2=document.getElementById("ConfirmPass");
	errorCell=document.getElementById("passError");

	if(isBoxEmpty(passwordBox1) || isBoxEmpty(passwordBox2)){
		valid=false;
		errorCell.innerHTML="Password Boxes must not be empty";
	}
	else if(passwordBox1.value!=passwordBox2.value){
		valid=false;
		errorCell.innerHTML="Password Boxes must contain  matching text";
	}else errorCell.innerHTML="";
	
	if(valid==true)
		submitForm("PasswordForm");
}

