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
    %>
<script>
var relations=<% out.write(adminEnc.getRelationshipsJs());%>;
var concepts=<% out.write(adminEnc.getConceptTextsJs());%>;
var storyRelations=new Array(),storyVariables=new Array();
var givenVariables=1;

function initializeAdminHome(){
	addRelationships(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	addConcepts(<% wEncoder.writeJsElementReference(showConceptsBox1); %>);
	addConcepts(<% wEncoder.writeJsElementReference(showConceptsBox2); %>);
	
	addRelationships("var1Rel");
	addVarConcept("var1Conc1");
	addVarConcept("var1Conc2");
	addVarRow();
}

function addRelationships(elemId){
	var relationSelectBox=document.getElementById(elemId);
	var option;
	
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

function createRelation(c1,rel,c2){
	return {"concept1":c1,"relation":rel,"concept2":c2};
}


</script>