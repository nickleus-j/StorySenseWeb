/*******************************************************************************
 *Copyright (c) 2013 StorySense.
 *All rights reserved. This program and the accompanying materials
 *are made available under the terms of the Eclipse Public License v1.0
 *which accompanies this distribution, and is available at
 *http://www.eclipse.org/legal/epl-v10.html
 *
 *Contributors:
 *    Nickelus Jimenez
 *******************************************************************************/
function submitRegistration()
{	
	 document.getElementById("Answers").submit();
	//document.getElementById("Registration").submit();
}

//Checks is a text box is empty
function isBoxEmpty(box){return box.value==null||box.value=="";}

function validateAnsers(){
	var valid=true; 
	var ctr=1;
	var answer,errorCell=document.getElementById("nameValidation"),ansName;
	
	if(isBoxEmpty(document.getElementById("storyName"))){
		errorCell.innerHTML="Story must have a name <input type='reset'/>";
		valid=false;
	}
	
	ansName="answer"+ctr;
	errorCell=document.getElementById("errorStory");
	answer=document.getElementById(ansName);
	while(answer!=null){
		
		if(isBoxEmpty(answer)==true)
			{
			valid=false;
			errorCell.innerHTML="Complete all textboxes";
			}
		
		ctr++;
		ansName="answer"+ctr;
		answer=document.getElementById(ansName);
	}
	
	if(valid==true){
		errorCell.innerHTML="done ";
		submitRegistration();
	}
	
}