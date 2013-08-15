<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 
<script src="Scripts/AJAXscirpts.js"></script>
<%@ include file="../Scripts/AdminScripts.jsp" %>

<style>
.leftPanel{
width: 40%;
float: left;
margin:5%;
}
.rightPanel{
width: 40%;
float: right;
margin:5%;
}
</style>
<script>

RelationshipsSupported=<% out.write(adminEnc.getRelationshipsWithMeaningJSON());%>

</script>


</head>

<body bgcolor="white" onload="initializeAdminHome()">
<%@ include file="Insertables/AdminNavBar.jsp" %>
<div id="container">
<div class="leftPanel">
<% out.write(adminEnc.getRelationshipsWithMeaningHtmlTable()); %>
</div>
<div class="rightPanel">
<h3>Add Relationship</h3>
<table>
	<tr><th>Relationship Name</th><th>Relationship Meaning</th></tr>
	<tr>
	<td>	
	<input placeholder="Add Relation Name here" id=<% wEncoder.writeJsElementReference(addRelationshipNameID); %>/>	</td>
	<td>
	<input placeholder="Add Relation Meaning here" id=<% wEncoder.writeJsElementReference(addRelationshipSentenceID); %>/>	</td>
	</tr>

	<tr>
	<td>
	<button onclick="verifyAddedSupportedRelationship()">Add relationship</button>
	</td>
	<td id=<% wEncoder.writeJsElementReference(addStatus); %>></td>
	</tr>

</table>

</div>

</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>