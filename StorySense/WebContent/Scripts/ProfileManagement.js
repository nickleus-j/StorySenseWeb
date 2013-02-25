var hiddenElem="hiddenElem",revealed="r";
function submitRegistration()
{	
	 document.getElementById("Answers").submit();
	//document.getElementById("Registration").submit();
}

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
	
	chnageProfile.setAttribute("class",revealed);
}
