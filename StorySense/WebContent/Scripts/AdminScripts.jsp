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
	
	/*addRelationships("var1Rel");
	addVarConcept("var1Conc1");
	addVarConcept("var1Conc2");
	*/
	
	addVarRow();
	
	
	storyRelations.push(createRelation("Happy","Is-A",""));
	storyRelations.push(createRelation("","Is-A","person"));
	displayRelationTemplate();
	
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

function addVarRow(){
	givenVariables++;
	var varTbl=document.getElementById(<% wEncoder.writeJsElementReference(variablesTbl); %>);
	var prefix="var"+givenVariables;
	var nameBox=document.createElement('input'),row=document.createElement('tr'),cell=document.createElement('td');
	var c1Box=document.createElement('select'),c2Box=document.createElement('select');
	var relBox=document.createElement('select');
	
	//bt.setAttribute("id",btElemName);
	nameBox.setAttribute("id",prefix+"Name");
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
	
	for(var ctr=0;ctr<storyRelations.length;ctr++){
		if(storyRelations[ctr].concept1==""&&storyRelations[ctr].concept2.length>0){
			code=code+"<li>? | "+storyRelations[ctr].relation+" | "+storyRelations[ctr].concept2+"</li>";
		}
		else if(storyRelations[ctr].concept2==""&&storyRelations[ctr].concept1.length>0){
			code=code+"<li>"+storyRelations[ctr].concept1+" | "+storyRelations[ctr].relation+" | ?</li>";
		}
		
	}/*End of Loop*/
	code=code+"</ol>";
	cell.innerHTML=code;
}/*End of Function*/

/**
Add a Relation based on the content of the Relation adding Panel
*/
function addRelation(){
	var relBox=document.getElementById(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	var c1Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	var c2Box=document.getElementById(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
	var rel=relBox.options[relBox.selectedIndex].innerHTML;
	var c1=c1Box.options[c1Box.selectedIndex].innerHTML;
	var c2=c2Box.options[c2Box.selectedIndex].innerHTML;
	
	/*Condition must be fullfilled to add the relation*/
	if(c1==""&&c2.length>0||c2==""&&c1.length>0){
		storyRelations.push(createRelation(c1,rel,c2));
		displayRelationTemplate();
		c1Box.selectedIndex=0;
		c2Box.selectedIndex=0;
	}
	
}/*End of Function*/

</script>