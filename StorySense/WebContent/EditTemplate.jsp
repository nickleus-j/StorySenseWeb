<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Template</title>
<link rel="stylesheet" href="Style/Default.css"> 
<script src="Scripts/AJAXscirpts.js"></script>
<%@ include file="../Scripts/AdminScripts.jsp" %>
<script>
var templateElements=<% out.write(request.getAttribute("elms")+"");%>;
function loadTemplateForEditing(){
	var templateIDIn=document.getElementById("templateKeeper");
	var relText=document.getElementById("relText");
	var sText=document.getElementById("storyText");
	var nameBox=document.getElementById(<% out.write(wEncoder.giveJsStringParam(templateNameBox));%>);
	var levelBox=document.getElementById(<% out.write(wEncoder.giveJsStringParam(levelBox));%>);
	var pointBox=document.getElementById(<% out.write(wEncoder.giveJsStringParam(pointBox));%>);
	
	storyRelations=templateElements.Relations;
	storyVariables=templateElements.storyVar;
	//generateRelationTemplatePreview();
	//relText.setAttribute("value",templateElements.RelationContent);
	relText.value=getLines(templateElements.RelationContent);
	sText.value=getLines(templateElements.storyContent);
	
	templateIDIn.setAttribute("value",""+templateElements.tID);
	nameBox.setAttribute("value",""+templateElements.nameField);
	levelBox.setAttribute("value",""+templateElements.levelrequired);
	pointBox.setAttribute("value",""+templateElements.bonusFactor);
}

function getLines(content){
	var code="";
	for(var ctr=0;ctr<content.length;ctr++){
		code+=content[ctr].line+"\n";
	}
	return code;
}

function addStoryVariobles(templateElements){
	storyVariables=templateElements.storyVar;
}

function resetElement(ID,origText){
	elem=document.getElementById(ID);
	elem.value=origText;
}

</script>
</head>
<body onload="loadTemplateForEditing()">
<%@ include file="Insertables/AdminNavBar.jsp" %>




<div id="container">
<form method="post" action="TemplateEditor">
<input type="hidden" name="tID" id="templateKeeper"/>

<table bgcolor=white id="tableBorderfeed3" style="margin-top:2%; width: 100%; ">
	<tr><th id="fontStylefeed2" colspan="6" >Template Details</th></tr>
	<tr>
	<th>Template Name</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(templateNameBox));%> name="nameField" /></td>
	
	<th>Level Required</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(levelBox));%> name="lvlField"/></td>
	
	<th>Bonus points Factor</th>
	<td><input type="text" id=<% out.write(wEncoder.giveJsStringParam(pointBox));%> name="ptField"/></td>
	</tr>
	
	<tr>
	<td colspan="3" id="dbStatus"></td>
	</tr>
</table>
<hr/>
<table width="100%">
<tr>
<th>Relation Template</th><th>Story Template</th>
</tr>
<tr>
<td id=<% wEncoder.writeJsElementReference(rTemplateCell); %>>
<textarea rows="20" name="relT" cols="35" id="relText"></textarea>

</td>
<td id=<% wEncoder.writeJsElementReference(sTemplateCell); %>>
<textarea rows="20" name="storyT" cols="35" id="storyText"></textarea>

</td>
</tr>

<tr>
<td>
<input type="button" value="Reset RelationBox" onclick="resetElement('relText',getLines(templateElements.RelationContent))"/>
</td>
<td>
<input type="button" value="Reset StoryBox" onclick="resetElement('storyText',getLines(templateElements.storyContent))"/>
</td>
</tr>

<tr>
<td id="statusCell"></td>
</tr>
</table>
<input type="submit" />
	
	</form>
</div>
<%@ include file="Insertables/Footer.jsp" %>
</body>
</html>