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
    %>
<script>
var relations=<% out.write(adminEnc.getRelationshipsJs());%>;

function initializeAdminHome(){
	var relationSelectBox=document.getElementById(<% wEncoder.writeJsElementReference(showRelationsBox); %>);
	var option;
	
	for(var ctr=0;ctr<relations.length;ctr++){
		option=document.createElement('option');
		option.innerHTML=relations[ctr];
		relationSelectBox.appendChild(option);
	}/*End of loop*/
}

</script>