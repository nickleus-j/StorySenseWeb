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
#fontStylefeed2{
font-family: Segoe UI; 
background-color: #660000; 
color: white;
}
#tableBorderfeed3
{
border: 4px solid #660000;
border-radius: 4px;
/*width: 75%;*/
}

</style>
<script>

RelationshipsSupported=<% out.write(adminEnc.getRelationshipsWithMeaningJSON());%>

</script>


</head>

<body bgcolor="CCFFFF" onload="initializeAdminHome()">
<%@ include file="Insertables/AdminNavBar.jsp" %>
<div id="container">
<div class="leftPanel">
<% out.write(adminEnc.getRelationshipsWithMeaningHtmlTable()); %>
</div>
<div class="rightPanel">

<table id="tableBorderfeed3" bgcolor="white">
	<tr><th colspan="2" id="fontStylefeed2">Add Relationship</th></tr>
	<tr><th>Relationship Name</th><th>Relationship Meaning</th></tr>
	<tr>
	<td>	
	<input placeholder="Add Relation Name here" id=<% wEncoder.writeJsElementReference(addRelationshipNameID); %>/>	</td>
	<td>
	<input placeholder="Add Relation Meaning here" id=<% wEncoder.writeJsElementReference(addRelationshipSentenceID); %>/>	</td>
	</tr>

	<tr>
	<td align="center" colspan="2">
	<button onclick="verifyAddedSupportedRelationship()">Add relationship</button>
	</td>
	</tr>
	<tr>
	<td id=<% wEncoder.writeJsElementReference(addStatus); %>></td>
	</tr>

</table>

</div>

</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>