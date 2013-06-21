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
	if(name.length>0){
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
	var relBox=document.createElement('select');
	
	//bt.setAttribute("id",btElemName);
	nameBox.setAttribute("id",prefix+"Name");
	nameBox.setAttribute("onchange","enterStoryVariable("+givenVariables+")");
	cell.appendChild(nameBox);
	row.appendChild(cell);
	
	
	c1Box.setAttribute("id",prefix+"Conc1");
	c2Box.setAttribute("id",prefix+"Conc2");
	relBox.setAttribute("id",prefix+"Rel");
	
	c1Box.setAttribute("onchange","enterStoryVariable("+givenVariables+")");
	c2Box.setAttribute("onchange","enterStoryVariable("+givenVariables+")");
	
	cell=document.createElement('td');
	cell.appendChild(c1Box);
	row.appendChild(cell);
	cell=document.createElement('td');
	cell.appendChild(relBox);
	row.appendChild(cell);
	cell=document.createElement('td');
	cell.appendChild(c2Box);
	row.appendChild(cell);
	varTbl.appendChild(row);
	
	addRelationships(prefix+"Rel");
	addVarConcept(prefix+"Conc1");
	addVarConcept(prefix+"Conc2");
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
	
	else if(name.length>0&&(c1.length==0&&c2.length>0||c2.length==0&&c1.length>0)){
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

function createRelation(c1,rel,c2){
	return {"concept1":c1,"relation":rel,"concept2":c2};
}

function createVariable(name,c1,rel,c2){
	return {"name":name,"concept1":c1,"relation":rel,"concept2":c2};
}

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
	
	addRelationships(prefix+"Rel");
	setupConceptList(prefix+"C1");
	setupConceptList(prefix+"C2");
	
}

function generateRelationTemplatePreview(){
	var cell=document.getElementById(<% wEncoder.writeJsElementReference(rTemplateCell); %>);
	var list=document.createElement('ol');
	var c1Box=document.createElement('select'),c2Box=document.createElement('select');
	var relBox=document.createElement('select'),item=document.createElement('li');
	var text;
	/*Clean up the cell that previews the relation template*/
	//cell="";
	
	/*loop that adds the realtions to the preview*/
	for(var ctr=0;ctr<storyRelations.length;ctr++){
		text=document.createElement('b');
		text.innerHTML="|";
		
		
			//code=code+"<li>? | "+storyRelations[ctr].relation+" | "+storyRelations[ctr].concept2+"</li>";
			item.appendChild(c1Box);
			item.appendChild(text);
			item.appendChild(relBox);
			text=document.createElement('b');
			text.innerHTML="|";
			item.appendChild(text);
			item.appendChild(c2Box);
			list.appendChild(item);
			cell.appendChild(list);
		
			setUpRelationBoxesForTmplt(c1Box,c2Box,relBox,ctr);

			relBox.selectedIndex=storyRelations[ctr].relation;
			c1Box.selectedIndex=storyRelations[ctr].concept1;
			c2Box.selectedIndex=storyRelations[ctr].concept2;
			/*c1Box.setAttribute("value",storyRelations[ctr].c1);
			c2Box.setAttribute("value",storyRelations[ctr].c2);
			relBox.setAttribute("value",storyRelations[ctr].relation);
			*/
			
		c1Box=document.createElement('select');
		c2Box=document.createElement('select');
		relBox=document.createElement('select');
		item=document.createElement('li');
		
	}/*End of Loop*/
	
	
	
}


/**
Add a Relation based on the content of the Relation adding Panel
*/
function addRelation(){
	var relBox=document.getElementById(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	var c1Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	var c2Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
	var cell=document.getElementById(<% wEncoder.writeJsElementReference(rTemplateCell); %>);
	/* var c1=c1Box.options[c1Box.selectedIndex].innerHTML;
	var c2=c2Box.options[c2Box.selectedIndex].innerHTML;
	var rel=relBox.options[relBox.selectedIndex].innerHTML; */
	
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