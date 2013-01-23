<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Complete the Story</title>

<style>

.templateContainer{
	background: white;
	width:50%;
}

</style>

</head>
<body>

<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/LearnerNavBar.jsp" %>
	<div class="container">
	<h1>Choose a Template</h1>
	
	<table align="center" class="templateContainer">
	<caption>Pick a template to create story</caption>
	<tr>
	<th>
	Level
		<select>
		<option>5</option>
		<option>4</option>
		<option>3</option>
		<option>2</option>
		<option>1</option>
		</select>
	</th>
	<td>
		<button onClick="window.location.href='StoryToAnsSample.jsp'">Pick template</button>
	</td>
	</tr>
	
	</table>
	
	<h2>Can't Pick? Use a random template
	<button onClick="window.location.href='StoryToAnsSample.jsp'">Go</button></h2>
	</div>
	<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>
