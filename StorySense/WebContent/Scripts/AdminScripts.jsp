<%@page import="webEncoder.AdminHtmlEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="webEncoder.WebCodeMaker"%>
    
    <% String templateNameBox="templateNameBox";
    	String levelBox="templateLevelBox";
    	String pointBox="TemplatePointBox";
    	WebCodeMaker wEncoder=new WebCodeMaker(out); 
    	AdminHtmlEncoder adminEnc=new AdminHtmlEncoder();
    	
    	String showRelationsBox="showRelationsBox";
    	String showConceptsBox1="showConceptsBox1";
    	String showConceptsBox2="showConceptsBox2";
    	
    	String variablesTbl="varTbl";
    	String storyTemplateWorkSpaceID="storyTemplateWorkSpace";
    	String rTemplateCell="relationTemplateCell",sTemplateCell="storyTemplateCell";
    	String wrkSpaceTxtAreaID="workSpaceTextArea";
    	String storyFormID="StoryTemplateForm";
    	String addRelationshipNameID="addRelBox",addRelationshipSentenceID="addSenetenceBox",addStatus="addStatusCell";
    %>
<script>
var relations=<% out.write(adminEnc.getRelationshipsJs());%>;
var concepts=<% out.write(adminEnc.getConceptTextsJs());%>;
var storyRelations=new Array(),storyVariables=new Array();
var givenVariables=0;
var sTmplElems=new Array(),sTmplVarBoxes=new Array();
function initializeAdminHome(){
	addNewVariable("","","ColorOf","Jet");
	
	addVarRow();
	//displayRelationTemplate();
	
}

function addNewVariable(name,c1,rel,c2){
	if(name.length>0&&((c1.length==0&&c2.length>0)||(c2.length==0&&c1.length>0))){
		storyVariables.push(createVariable(name,c1,rel,c2));
		addVarRow();
	}
	addRelationships(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
}

/**
 * Add values that connect the concepts
 */
function addRelationships(elemId){
	var relationSelectBox=document.getElementById(elemId);
	var option;
	
	relationSelectBox.innerHTML="";
	for(var ctr=0;ctr<relations.length;ctr++){
		option=document.createElement('option');
		option.innerHTML=relations[ctr];
		relationSelectBox.appendChild(option);
	}/*End of loop*/
}

function addConcepts(elemId){
	var conceptSelectBox=document.getElementById(elemId);
	var option;
	
	for(var ctr=0;ctr<concepts.length;ctr++){
		option=document.createElement('option');
		option.innerHTML=concepts[ctr];
		conceptSelectBox.appendChild(option);
	}/*End of loop*/
}

function setupConceptList(elemId){
	var conceptSelectBox=document.getElementById(elemId);
	var option;
	conceptSelectBox.innerHTML="";
	option=document.createElement('option');
	conceptSelectBox.appendChild(option);
	for(var ctr=0;ctr<storyVariables.length;ctr++){
		option=document.createElement('option');
		option.innerHTML="$"+storyVariables[ctr].name;
		conceptSelectBox.appendChild(option);
	} /*End of loop that adds the variables */
	
	addConcepts(elemId);
}

function addVarConcept(elemId){
	var conceptSelectBox=document.getElementById(elemId);
	var option=document.createElement('option');
	option.innerHTML="";
	conceptSelectBox.appendChild(option);
	
	addConcepts(elemId);
}

/**
 * Add a row in the web page to indicate the variables in the template
 */
function addVarRow(){
	givenVariables++;
	var varTbl=document.getElementById(<% wEncoder.writeJsElementReference(variablesTbl); %>);
	var prefix="var"+givenVariables;
	var nameBox=document.createElement('input'),row=document.createElement('tr'),cell=document.createElement('td');
	var c1Box=document.createElement('select'),c2Box=document.createElement('select');
	var relBox=document.createElement('select'),delBt;
	
	//bt.setAttribute("id",btElemName);
	nameBox.setAttribute("id",prefix+"Name");
	nameBox.setAttribute("onchange","enterStoryVariable("+givenVariables+")");
	cell.appendChild(nameBox);
	row.appendChild(cell);
	
	
	c1Box.setAttribute("id",prefix+"Conc1");
	c2Box.setAttribute("id",prefix+"Conc2");
	relBox.setAttribute("id",prefix+"Rel");
	delBt=createDeleteButton(prefix+"Delete");
	
	c1Box.setAttribute("onchange","modifyVariables("+givenVariables+",this,'Conc2')");
	c2Box.setAttribute("onchange","modifyVariables("+givenVariables+",this,'Conc1')");//deleteVariable
	relBox.setAttribute("onchange","modifyVariables("+givenVariables+",this,'')");
	delBt.setAttribute("onclick","deleteVariable("+(givenVariables-1)+")");
	
	cell=document.createElement('td');
	cell.appendChild(c1Box);
	row.appendChild(cell);
	cell=document.createElement('td');
	cell.appendChild(relBox);
	row.appendChild(cell);
	cell=document.createElement('td');
	cell.appendChild(c2Box);
	cell.appendChild(delBt);
	row.appendChild(cell);
	varTbl.appendChild(row);
	
	addRelationships(prefix+"Rel");
	addVarConcept(prefix+"Conc1");
	addVarConcept(prefix+"Conc2");
}

/**
 * Deletes a variable from the list
 then reflect it on the page
 */
function deleteVariable(index){
	storyVariables.splice(index,1);
	generateVariableTable(index);
	givenVariables=storyVariables.length;
	addVarRow();
}


/**
 * Returns an array that contains the selected indexes of the remaining rows that
 contain the relations
 */
function getSelectedValues(spliceIndex,suffix){
	var selectBox,prefix,arr=new Array();
	
	for(var ctr=0;ctr<=storyVariables.length;ctr++){
		if(ctr!=spliceIndex){
			prefix="var"+(ctr+1);
			selectBox=document.getElementById(prefix+suffix);
			if(selectBox!=null)
				arr.push(selectBox.selectedIndex);
			else arr.push(0);
		}/*End of spliceIndex Condition*/
		
	}/*End of loop*/
	return arr;
}

function createVarTblHdr(){
	return "<tr><th colspan=\"4\" class=\"templateProperties\">Variables</th>"+
	"</tr><tr><th>Name</th><th>Concept 1</th><th>relationship</th><th>Concept 2</th></tr>";
}

/**
 * Generates a table containing the variables of the template
 */
function generateVariableTable(index){
	var varTbl=document.getElementById(<% wEncoder.writeJsElementReference(variablesTbl); %>);
	var delBt;
	var prefix,nameBox,row,cell,c1Box,c2Box,relBox;
	var c1Val=getSelectedValues(index,"Conc1"),c2Val=getSelectedValues(index,"Conc2"),relVal=getSelectedValues(index,"Rel");
	
	varTbl.innerHTML=createVarTblHdr();
	for(var ctr=0;ctr<storyVariables.length;ctr++){
	 prefix="var"+(ctr+1);
	 nameBox=document.createElement('input');
	 row=document.createElement('tr');
	 cell=document.createElement('td');
	 c1Box=document.createElement('select');
	 c2Box=document.createElement('select');
	 relBox=document.createElement('select');
	 
	
	//bt.setAttribute("id",btElemName);
	nameBox.setAttribute("id",prefix+"Name");
	nameBox.setAttribute("onchange","enterStoryVariable("+(ctr+1)+")");
	cell.appendChild(nameBox);
	row.appendChild(cell);
	
	
	c1Box.setAttribute("id",prefix+"Conc1");
	c2Box.setAttribute("id",prefix+"Conc2");
	relBox.setAttribute("id",prefix+"Rel");
	delBt=createDeleteButton(prefix+"Delete");
	
	c1Box.setAttribute("onchange","modifyVariables("+(ctr+1)+",this,'Conc2')");
	c2Box.setAttribute("onchange","modifyVariables("+(ctr+1)+",this,'Conc1')");
	relBox.setAttribute("onchange","modifyVariables("+(ctr+1)+",this,'')");
	delBt.setAttribute("onclick","deleteVariable("+ctr+")");
	
	cell=document.createElement('td');
	cell.appendChild(c1Box);
	row.appendChild(cell);
	cell=document.createElement('td');
	cell.appendChild(relBox);
	row.appendChild(cell);
	cell=document.createElement('td');
	cell.appendChild(c2Box);
	cell.appendChild(delBt);
	row.appendChild(cell);
	varTbl.appendChild(row);
	
	addRelationships(prefix+"Rel");
	addVarConcept(prefix+"Conc1");
	addVarConcept(prefix+"Conc2");
	
	c1Box.selectedIndex=c1Val[ctr];
	c2Box.selectedIndex=c2Val[ctr];
	relBox.selectedIndex=relVal[ctr];
	
	/*c2Box.setAttribute("value",storyVariables[ctr].concept2);
	relBox.setAttribute("value",storyVariables[ctr].relation);
	*/
	nameBox.setAttribute("value",storyVariables[ctr].name);
	}/*End of loop*/
	setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
}


/**
 * Modfies the list of variables in an array
 (data structure containing the template variables)
 */
function enterStoryVariable(index){
	var prefix="var"+index;
	var nameBox=document.getElementById(prefix+"Name");
	var c1Box=document.getElementById(prefix+"Conc1"),c2Box=document.getElementById(prefix+"Conc2");
	var relBox=document.getElementById(prefix+"Rel");
	var name=nameBox.value,c1=c1Box.value,c2=c2Box.value,rel=relBox.value;
	
	
	if(index>storyVariables.length)
		addNewVariable(name,c1,rel,c2);
	
	else if(name.length>0&&((c1.length==0&&c2.length>0)||(c2.length==0&&c1.length>0))){
		index--;
		storyVariables[index].name=name;
		storyVariables[index].concept1=c1;
		storyVariables[index].concept2=c2;
		storyVariables[index].relation=rel;

		setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
		setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
	}
	
	//addNewVariable(nameBox.value,c1Box.value,relBox.value,c2Box.value);
}

/**
 * Modify the properties of a variable in the story template
 */
function modifyVariables(index,curentConceptBox,couterConceptBoxSuffix){
	enterStoryVariable(index);
	
	if(couterConceptBoxSuffix!='')
		resetOtherConceptBoxIndex(curentConceptBox,"var"+index+couterConceptBoxSuffix);
	
	refreshVariableList();
}

function createRelation(c1,rel,c2){return {"concept1":c1,"relation":rel,"concept2":c2};}
function createVariable(name,c1,rel,c2){return {"name":name,"concept1":c1,"relation":rel,"concept2":c2};}

/**
 * Display the contents of the To be
 generated Relational Template based on the Relation Template created
 */
function displayRelationTemplate(){
	var cell=document.getElementById(<% wEncoder.writeJsElementReference(rTemplateCell); %>);
	var code="<ol>";
	
	/*loop that adds the realtions to the preview*/
	for(var ctr=0;ctr<storyRelations.length;ctr++){
		if(storyRelations[ctr].concept1==""&&storyRelations[ctr].concept2.length>0){
			code=code+"<li>? | "+storyRelations[ctr].relation+" | "+storyRelations[ctr].concept2+"</li>";
		}
		else if(storyRelations[ctr].concept2==""&&storyRelations[ctr].concept1.length>0){
			code=code+"<li>"+storyRelations[ctr].concept1+" | "+storyRelations[ctr].relation+" | ?</li>";
		}
		
	}/*End of Loop*/
	code=code+"</ol>";
	cell.innerHTML=cell.innerHTML+code;
	//generateRelationTemplatePreview();
}/*End of Function*/

/**
 * Set up a row of combo boxes to preview the relation template
 */
function setUpRelationBoxesForTmplt(c1Box,c2Box,relBox,index){
	var prefix="rBox"+index;
	
	c1Box.setAttribute("id",prefix+"C1");
	c2Box.setAttribute("id",prefix+"C2");
	relBox.setAttribute("id",prefix+"Rel");
	c1Box.setAttribute("onchange","saveRelationModification("+index+",this,'"+prefix+"C2')");
	c2Box.setAttribute("onchange","saveRelationModification(this,'"+prefix+"C1')");
	relBox.setAttribute("onchange","saveRelationChange("+index+")");
	addRelationships(prefix+"Rel");
	setupConceptList(prefix+"C1");
	setupConceptList(prefix+"C2");
	
}

function createDeleteButton(ID){
	var bt=document.createElement('button');
	bt.innerHTML="X";
	bt.setAttribute("ID",ID);
	return bt;
}

/** 
 * Previews the relations to be filled
 in comboboxes
 */
function generateRelationTemplatePreview(){
	var cell=document.getElementById(<% wEncoder.writeJsElementReference(rTemplateCell); %>);
	var list=document.createElement('ol');
	var c1Box,c2Box,relBox,item,delBt;
	var text;
	/*Clean up the cell that previews the relation template*/
	//cell="";
	cell.innerHTML="";
	/*loop that adds the realtions to the preview*/
	for(var ctr=0;ctr<storyRelations.length;ctr++){
		text=document.createElement('b');
		text.innerHTML="|";
		c1Box=document.createElement('select');
		c2Box=document.createElement('select');
		relBox=document.createElement('select');
		delBt=createDeleteButton("deleteRel"+ctr);
		
		delBt.setAttribute("onclick","deleteRelation("+ctr+")");
		item=document.createElement('li');
		
			//code=code+"<li>? | "+storyRelations[ctr].relation+" | "+storyRelations[ctr].concept2+"</li>";
			item.appendChild(c1Box);
			item.appendChild(text);
			item.appendChild(relBox);
			text=document.createElement('b');
			text.innerHTML="|";
			item.appendChild(text);
			item.appendChild(c2Box);
			item.appendChild(delBt);
			list.appendChild(item);
			cell.appendChild(list);
		
			setUpRelationBoxesForTmplt(c1Box,c2Box,relBox,ctr);

			relBox.selectedIndex=storyRelations[ctr].relation;
			c1Box.selectedIndex=storyRelations[ctr].concept1;
			c2Box.selectedIndex=storyRelations[ctr].concept2;
		
	}/*End of Loop*/
}

function resetOtherConceptBoxIndex(currentBox,otherBoxID){
	var elem=document.getElementById(otherBoxID);
	
	if(currentBox.selectedIndex>0)
		elem.selectedIndex=0;
}

function saveRelationModification(index,currentBox,otherBoxID){
	
	
	resetOtherConceptBoxIndex(currentBox,otherBoxID);
	saveRelationChange(index);
	
}
function saveRelationChange(index){
	var prefix="rBox"+index,c1Box,relBox,c2Box;
	c1Box=document.getElementById(prefix+"C1");
	relBox=document.getElementById(prefix+"Rel");
	c2Box=document.getElementById(prefix+"C2");
	
	
	storyRelations[index].relation=relBox.selectedIndex;
	storyRelations[index].concept1=c1Box.selectedIndex;
	storyRelations[index].concept2=c2Box.selectedIndex;
	
}
function showTemplateElementValues(panel){
	for(var ctr=0;ctr<sTmplElems.length;ctr++){
		panel.innerHTML+=(sTmplElems[ctr].value+" ");
	}/*End of loop*/
}

/**
 * Generates what the variable declaration
 of the template will look like
 */
function getVariableValuePreview(given){
	//var val="(";
	var val="<$"+given.name+" = (";
	
	if(given.concept1!="")
		val=val.concat("\""+given.concept1+"\", "+given.relation+", ");
	else val=val.concat("?, "+given.relation+", ");
	
	if(given.concept2!="")
		val=val.concat("\""+given.concept2+"\"");
	else val=val.concat("?");
	
	return val.concat(")>\n");
}

/**
 * Shows the variables of the to be generated template
 */
function previewVariablesToTemplate(previewPanel){
	var code="";
	text=document.createElement('p');
	for(var ctr=0;ctr<storyVariables.length;ctr++){
		//code+=("$"+storyVariables[ctr].name+" = "+getVariableValuePreview(storyVariables[ctr])+"<br/>");
		code+=(getVariableValuePreview(storyVariables[ctr])+"<br/>");
	}/*End of loop*/
	text.innerHTML=code;
	previewPanel.appendChild(text);
}

/**
 * Displays what the story template will look like
 */
function previewStoryTemplate(){
	var pane=document.getElementById(<% wEncoder.writeJsElementReference(sTemplateCell); %>);
	var storyBox=document.getElementById(<% wEncoder.writeJsElementReference(wrkSpaceTxtAreaID); %>);
	pane.innerHTML="";
	previewVariablesToTemplate(pane);
	<% /*showTemplateElementValues(pane);*/ %>
	pane.innerHTML+=storyBox.value;
}


/**
 * Deletes a relation
 and reflect the changes in the user interface
 */
function deleteRelation(index){
	storyRelations.splice(index,1);
	generateRelationTemplatePreview();
}

/**
 * Creates a container for the element to represent a part of the 
 to be generated story template
 */
function createTemplateElementContainer(headerText,elem){
	var tbl=document.createElement('table'),row=document.createElement('tr');
	var hdr=document.createElement('th'),cell=document.createElement('td');
	var appendBT=document.createElement("button"),cancelBT=document.createElement("button");
	
	hdr.innerHTML=headerText;
	row.appendChild(hdr);
	tbl.appendChild(row);
	tbl.setAttribute("ID","storyContainer");
	
	appendBT.setAttribute("ID","appendingBt");
	appendBT.innerHTML="Add to story";
	
	appendBT.setAttribute("onclick",
	"appendVariableToStoryTemplate('appendingVarBox','appendingBt','storyContainer')");
	
	/*cancel button*/
	cancelBT.setAttribute("ID","cancelBt");
	cancelBT.innerHTML="X";
	cancelBT.setAttribute("onclick","removeVriableAppenders('storyContainer')");
	
	row=document.createElement('tr');
	cell.appendChild(elem);
	cell.appendChild(appendBT);
	cell.appendChild(cancelBT);
	row.appendChild(cell);
	tbl.appendChild(row);
	sTmplElems.push(elem);
	
	
	
	return tbl;
}

<% /**<input type="button" value="Add text" onclick="addTemplateText()"/>**/%>


function addTemplateText(){
	var workSpace=document.getElementById(<% wEncoder.writeJsElementReference(storyTemplateWorkSpaceID); %>);
	var tbl=createTemplateElementContainer("text",document.createElement('input'));
	
	workSpace.appendChild(tbl);
}

/**
 * Create a select box that contains the variable names
 */
function createChooseVariableElement(){
	var choices=document.createElement('select');
	
	refreshVariableChoices(choices);
	return choices;
}

/**
 * Updates the select boxes that contains the
 list of variable names
 */
function refreshVariableList(){
	var current;
	for(var ctr=0;ctr<sTmplVarBoxes.length;ctr++){
		current=sTmplVarBoxes[ctr].selectedIndex;
		refreshVariableChoices(sTmplVarBoxes[ctr]);
		sTmplVarBoxes[ctr].selectedIndex=current;
	}/*End of Loop*/
}

/**
 * Makes a select box contain the names of
 the variables of the story template
 */
function refreshVariableChoices(vBox){
	vBox.innerHTML="";
	
	for(var ctr=0;ctr<storyVariables.length;ctr++){
		opt=document.createElement('option');
		opt.innerHTML="$"+storyVariables[ctr].name;
		vBox.appendChild(opt);
	}/*End of loop*/
}


var readOnlyElem;
function changeElementEditability(elem,classGiven){
	readOnlyElem=elem
	elem.setAttribute("class",classGiven);
}

/**
 * Adds a selectbox that contains the variable names in the workspace
 */
function addTemplateVariable(source){
	var workSpace=document.getElementById(<% wEncoder.writeJsElementReference(storyTemplateWorkSpaceID); %>);
	var elem=createChooseVariableElement(),tbl=createTemplateElementContainer("Variable",elem);
	
	changeElementEditability(source,"hiddenElem");
	sTmplVarBoxes.push(elem);
	workSpace.appendChild(tbl);
	
	elem.setAttribute("ID","appendingVarBox");
	
	
}

function appendVariableToStoryTemplate(varBoxID,eventSourceID,containerID){
	var storyBox=document.getElementById(<% wEncoder.writeJsElementReference(wrkSpaceTxtAreaID); %>);
	var varBox=document.getElementById(varBoxID);
	
	//workSpace.removeChild(document.getElementById(eventSourceID));
	storyBox.value+=(" %"+varBox.value+"% ");
	removeVriableAppenders(containerID);
}

function removeVriableAppenders(containerID){
	var workSpace=document.getElementById(<% wEncoder.writeJsElementReference(storyTemplateWorkSpaceID); %>);
	workSpace.removeChild(document.getElementById(containerID));
	
	/*Enable add var button*/
	changeElementEditability(readOnlyElem,"");
}

/**
Add a Relation based on the content of the Relation adding Panel
*/
function addRelation(){
	var relBox=document.getElementById(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	var c1Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	var c2Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
	
	var c1=c1Box.selectedIndex;
	var c2=c2Box.selectedIndex;
	var rel=relBox.selectedIndex;
	
	/*Condition must be fullfilled to add the relation*/
	/*if(c1==""&&c2.length>0||c2==""&&c1.length>0) {*/
	if(c1==0&&c2>0||c2==0&&c1>0){
		storyRelations.push(createRelation(c1,rel,c2));
		generateRelationTemplatePreview();
		 c1Box.selectedIndex=0;
		c2Box.selectedIndex=0; 
	}
	
}/*End of Function*/

function getValueofRelationIndex(index){
	var relBox=document.getElementById(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	var RelValue,oldVal=relBox.selectedIndex;
	relBox.selectedIndex=index;
	RelValue= relBox.value;
	relBox.selectedIndex=oldVal;
	return RelValue;
}

function getValueFromRelationConcept(index){
	var c1Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	var cValue,oldVal=c1Box.selectedIndex;
	
	c1Box.selectedIndex=index;
	cValue= c1Box.value;
	c1Box.selectedIndex=oldVal;
	return cValue;
}

function converRelationsToString(){
	/*	| "+storyRelations[ctr].relation+" | "+storyRelations[ctr].concept2	*/
	var text="";
	for(var ctr=0;ctr<storyRelations.length;ctr++){
		if(storyRelations[ctr].concept1!=0)
			text+=(getValueFromRelationConcept(storyRelations[ctr].concept1)+" | ");
		else text+="? | ";
		
		//text+=(storyRelations[ctr].relation+" | "); 
		text+=(getValueofRelationIndex(storyRelations[ctr].relation)+" | ");
		if(storyRelations[ctr].concept2!=0)
			text+=(getValueFromRelationConcept(storyRelations[ctr].concept2)+" \n");
		else text+="? \n";
	}/*End of loop*/
	return text;
}

function verifyTemplateProperties(name,level,points){
	
	/*there must be a name.
	Level and points must be at least 1
	the level and points have to be integer values
	*/
	if(name==""||level<1||points<1||Math.floor(level)!=level||Math.floor(points)!=points)
		return false;
	
	return true;
}


function sendToTemplatesServer(relations,storyText){
	var storyForm=document.getElementById(<% wEncoder.writeJsElementReference(storyFormID); %>);
	var relationField=document.createElement("textarea"),storyTextField=document.createElement("textarea");
	
	relationField.value=relations;
	storyTextField.value=storyText;
	
	relationField.setAttribute("name","relT");
	storyTextField.setAttribute("name","storyT");
	/* Set Attributes to the form*/
	storyForm.setAttribute("action","TemplateWriter");
	storyForm.appendChild(storyTextField);
	storyForm.appendChild(relationField);
	storyForm.submit();
}

function submitStory(){
	var code="";
	var storyBox=document.getElementById(<% wEncoder.writeJsElementReference(wrkSpaceTxtAreaID); %>);
	var storyCell=document.getElementById(<% wEncoder.writeJsElementReference(sTemplateCell); %>);
	var nameBox=document.getElementById(<% wEncoder.writeJsElementReference(templateNameBox); %>);
	var levelBox=document.getElementById(<% wEncoder.writeJsElementReference(levelBox); %>);
	var pointBox=document.getElementById(<% wEncoder.writeJsElementReference(pointBox); %>);
	text=document.createElement('p');
	
	storyCell.innerHTML="";
	
	for(var ctr=0;ctr<storyVariables.length;ctr++){
		code+=(getVariableValuePreview(storyVariables[ctr]));
	}/*End of loop*/
	code+=storyBox.value;
	
	
	text.innerHTML=code;
	storyCell.appendChild(text);
	if(verifyTemplateProperties(nameBox.value,levelBox.value,pointBox.value)){
		storyCell.innerHTML+=" Parameters Okay"
		sendToTemplatesServer(converRelationsToString(),code);
	}
	else storyCell.innerHTML+=" Error in properties";
	
	/*window.location.href="TemplateWriter?name="+nameBox.value+"&lvl="+levelBox.value+
			"&relT="+converRelationsToString()+"&storyT="+code;
	*/
}/*End of function*/

/*
 * 
 The following funtions are for the admin relationship page where the admin can manage the relationship supported
 for story Sense
 */
 
 /**
 This function verifies if the entries in the new relationship textboxes have non empty valid values
 */
 
 var RelationshipsSupported;
 function verifyAddedSupportedRelationship(){
	 var relBox=document.getElementById(<% wEncoder.writeJsElementReference(addRelationshipNameID); %>);
	 var sentenceBox=document.getElementById(<% wEncoder.writeJsElementReference(addRelationshipSentenceID); %>);
	 
	 if(relBox.value!=""&&sentenceBox.value!=""){
		 addSupportedRelationship(relBox.value,sentenceBox.value);
	 }
	 else{
		 var statusBox=document.getElementById(<% wEncoder.writeJsElementReference(addStatus); %>);
		 statusBox.innerHTML="Please check your values. No empty values";
	 }
 }


function addSupportedRelationship(relationship,meaning){
	var xmlhttp=getAJAXRequest();
	var statusBox=document.getElementById(<% wEncoder.writeJsElementReference(addStatus); %>);
	
	xmlhttp.onreadystatechange=function(){
		statusBox.innerHTML="Connecting to Server";
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			statusBox.innerHTML=xmlhttp.responseText;
			window.location.href='RelationshipPage.jsp';
			//showSupportedRelationshipsTable();
		}
	  };

	  /*Send a request to the server*/
	xmlhttp.open("GET","RelationshipSupporter?rl="+relationship+"&sntc="+meaning,true);
	xmlhttp.send();
}

function showSupportedRelationshipsTable(){
	var table=document.getElementById(<% wEncoder.writeJsElementReference(adminEnc.getSupportedRelationshipsTableId()); %>);;
	var row,RelationshipCell,SentenceCell,sentenceBox;
	/*Check if supported table is already on the page*/
	RelationshipsSupported=<% out.write(adminEnc.getRelationshipsWithMeaningJSON());%>;
	if(table!=null){
		table.innerHTML="<tr><th>Relationship name</th><th>Relationship Meaning</th></tr>";
		
		for(var ctr=0;ctr<RelationshipsSupported.length;ctr++){
			row=document.createElement("tr");
			RelationshipCell=document.createElement("td");
			SentenceCell=document.createElement("td");
			sentenceBox=document.createElement("input");
			
			RelationshipCell.innerHTML=RelationshipsSupported[ctr].Relationship;
			//sentenceBox.value=RelationshipsSupported[ctr].Meaning;
			sentenceBox.setAttribute("value",RelationshipsSupported[ctr].Meaning);
			SentenceCell.appendChild(sentenceBox);
			row.appendChild(RelationshipCell);
			row.appendChild(SentenceCell);
			table.appendChild(row);
			
		}/*End of loop*/
		table.innerHTML+="<tr><td><input type=\"button\" value='Save'/></td></tr>";
	}/*End of If condition*/
	
}

/*
 *Scripts for the templates made 
 */

 function viewTemplateMade(tID){
	 /*var xmlhttp=getAJAXRequest();
	 
	 xmlhttp.onreadystatechange=function(){
			
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				//statusBox.innerHTML=xmlhttp.responseText;
				
			}
		  };

		  
		xmlhttp.open("GET","TemplateEditLoader?t="+tID,true);
		xmlhttp.send(); */
		window.location.href="TemplateEditLoader?t="+tID;
 }
 
</script>