<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Complete the Story</title>
</head>
<body>


<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/LearnerNavBar.jsp" %>
	<div class="container">
	<h1>Fill the blanks with your answers to complete the story</h1>
	
	<form name="Answers" action="LearnerStoryFininshedSample.jsp">
	<table align="center" width="50%" bgcolor="skyblue">
	<tr>
	<td>Story Name<input type="text" name="storyName"/></td>
	<td><input type="reset"/></td>
	</tr>
	
	<tr>
		
	<td colspan="2">
	<hr>
		Let's take a trip to park. 
		A <input type="text" name="answer1"/> is an object we can find in the park. 
		Last week, I was <input type="text" name="answer2"/>when I was at the park. 
		After going to the park, I went to the <input type="text" name="answer3"/>. 
	<hr>
	</td></tr>
	
	<tr>
		<td><input type="button" value="Generate new Story"></td>
		<td><input type="Submit" value="Submit Story"></td>
	</tr>
	
	</table>
	</form>
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>