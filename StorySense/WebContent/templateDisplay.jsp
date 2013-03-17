<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Complete the Story</title>

<style>

#tableBorder3
{
border: 2px solid black;
border-radius: 4px;
margin-left: -50%;
width: 200%;
}

.templateContainer{
	background: white;
	width:50%;
}


#fontStyle2{
font-family: Segoe UI; font-size: 20pt;
}


</style>

</head>
<body>

<%@ include file="Insertables/TopBar.jsp" %>
<div width="100%">
<table style="margin: auto;">
	<tr><td>
	<table id="tableBorder3" bgcolor = "Yellow">
	<thead></br><tr id="fontStyle2" ><th colspan = 2>Choose a template</th></tr></thead>	
	</table>
	</td></tr>
	
	<br /><br />
	
	<tr><td>
	<table colspan="3" id="tableBorder3" class="templateContainer" CELLPADDING="10" CELLSPACING="4">
	<tr>
	<th align="center">
	Level
		<% out.write(userEncoder.getChooseTemplateLevelHTML()); %>
		
		
	</th>
	<tr ><td colspan="2" align="center">Can't Pick? Use a random template 
	<button onClick="window.location.href='MakingStory.jsp'">Go</button></td></tr>
	</table>
	</td></tr>
	</table>
	</div>
	<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>