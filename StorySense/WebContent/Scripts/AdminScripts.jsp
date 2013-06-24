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
    %>
<script>
var relations=<% out.write(adminEnc.getRelationshipsJs());%>;
var concepts=<% out.write(adminEnc.getConceptTextsJs());%>;
var storyRelations=new Array(),storyVariables=new Array();
var givenVariables=0;

function initializeAdminHome(){
	addNewVariable("","","ColorOf","Jet");
	
	addVarRow();
	//displayRelationTemplate();
	
}

function addNewVariable(name,c1,rel,c2){
	if(name.length>00&&((c1.length==0&&c2.length>0)||(c2.length==0&&c1.length>0))){
		storyVariables.push(createVariable(name,c1,rel,c2));
		addVarRow();
	}
	addRelationships(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
}

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
	}/*End of loop that adds the variables*/
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
	generateVariableTable(index+1);
	givenVariables--;
	addVarRow();
}

/**
 * Returns an array that contains the selected indexes of the remaining rows that
 contain the relations
 */
function getSelectedValues(spliceIndex,suffix){
	var selectBox,prefix,arr=new Array();
	
	for(var ctr=0;ctr<storyVariables.length;ctr++){
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

function generateVariableTable(index){
	var varTbl=document.getElementById(<% wEncoder.writeJsElementReference(variablesTbl); %>);
	var delBt;
	var prefix,nameBox,row,cell,c1Box,c2Box,relBox;
	var c1Val=getSelectedValues(index,"Conc1"),c2Val=getSelectedValues(index,"Conc2"),relVal=getSelectedValues(index,"Rel");
	
	varTbl.innerHTML="";
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
	nameBox.setAttribute("onchange","enterStoryVariable("+givenVariables+")");
	cell.appendChild(nameBox);
	row.appendChild(cell);
	
	
	c1Box.setAttribute("id",prefix+"Conc1");
	c2Box.setAttribute("id",prefix+"Conc2");
	relBox.setAttribute("id",prefix+"Rel");
	delBt=createDeleteButton(prefix+"Delete");
	
	c1Box.setAttribute("onchange","modifyVariables("+givenVariables+",this,'Conc2')");
	c2Box.setAttribute("onchange","modifyVariables("+givenVariables+",this,'Conc1')");
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
		storyVariables[index].c1=c1;
		storyVariables[index].c2=c2;
		storyVariables[index].rel=rel;

		setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
		setupConceptList(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
	}
	
	//addNewVariable(nameBox.value,c1Box.value,relBox.value,c2Box.value);
}


function modifyVariables(index,curentConceptBox,couterConceptBoxSuffix){
	enterStoryVariable(index);
	resetOtherConceptBoxIndex(curentConceptBox,"var"+index+couterConceptBoxSuffix);
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

function setUpRelationBoxesForTmplt(c1Box,c2Box,relBox,index){
	var prefix="rBox"+index;
	
	c1Box.setAttribute("id",prefix+"C1");
	c2Box.setAttribute("id",prefix+"C2");
	relBox.setAttribute("id",prefix+"Rel");
	c1Box.setAttribute("onchange","resetOtherConceptBoxIndex(this,'"+prefix+"C2')");
	c2Box.setAttribute("onchange","resetOtherConceptBoxIndex(this,'"+prefix+"C1')");
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


function getVariableValuePreview(given){
	var val="(";
	
	if(given.concept1!="")
		val=val.concat(given.concept1+", "+given.relation+", ");
	else val=val.concat("?, "+given.relation+", ");
	
	if(given.concept2!="")
		val=val.concat(given.concept2);
	else val=val.concat("?");
	
	return val.concat(")");
}

function previewVariablesToTemplate(previewPanel){
	var code="";
	text=document.createElement('p');
	for(var ctr=0;ctr<storyVariables.length;ctr++){
		code+=("$"+storyVariables[ctr].name+" = "+getVariableValuePreview(storyVariables[ctr])+"<br/>");
	}/*End of loop*/
	text.innerHTML=code;
	previewPanel.appendChild(text);
}

function previewStoryTemplate(){
	var pane=document.getElementById(<% wEncoder.writeJsElementReference(sTemplateCell); %>);
	pane.innerHTML="";
	previewVariablesToTemplate(pane);
}

function deleteRelation(index){
	storyRelations.splice(index,1);
	generateRelationTemplatePreview();
}

/**
Add a Relation based on the content of the Relation adding Panel
*/
function addRelation(){
	var relBox=document.getElementById(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	var c1Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	var c2Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
	var cell=document.getElementById(<% wEncoder.writeJsElementReference(rTemplateCell); %>);
	
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

</script>