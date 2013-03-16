<%@page import="webEncoder.StoryEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Complete the Story</title>

<script src="Scripts/CompleteStoriesForm.js"></script>
</head>
<body bgcolor="CCFFFF">


<%@ include file="Insertables/TopBar.jsp" %>

	<div id="container">
	<div id="center" class="column">
	<h1>Come on let us write a story! Help me finish the story by putting words into the blanks</h1>
	
	<form name="Answers" id="Answers" action="StoryWriter">
	<table align="center" width="50%" bgcolor="skyblue">
	<tr>
	<td>Story Name<input type="text" id="storyName" name="storyName"/></td>
	<td id="nameValidation"><input type="reset"/></td>
	</tr>
	
	<tr>
		
	<td colspan="2">
	<hr>
		
		<%		/*LearnerStoryFininshedSample.jsp*/
		StoryEncoder TheEncoder=new StoryEncoder(request,out);
			TheEncoder.encodeStory();
		%>
	<hr>
	</td></tr>
	
	<tr>
		<td id="errorStory" rowspan="2" class="ErrorMessage">
		</td>
	</tr>
	
	<tr>
		<td><input type="button" value="Generate new Story"></td>
		<td><input type="button" value="Submit Story" onclick="validateAnsers()"></td>
	</tr>
	
	</table>
	</form>
	</div>
	<%@ include file="Insertables/LearnerNavBar.jsp" %>
	<%@ include file="Insertables/FeaturedStory.jsp" %>
	</div>
	
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>
