<%@page import="webEncoder.StoryEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
<title>Complete the Story</title>
<script src="Scripts/AJAXscirpts.js"></script>
<script src="Scripts/CompleteStoriesForm.js"></script>
</head>
<body bgcolor="CCFFFF">


<%@ include file="Insertables/TopBar.jsp" %>

	<div id="container">
	<div id="center" class="column">
	<table style="margin: auto;" >
	<tr><td>
	
	<tr><td>
	<table colspan="3" id="tableBorder3" class="templateContainer" CELLPADDING="10" CELLSPACING="4">
	<tr>
	<th align="center">
	Level
		<% 
		out.write(userEncoder.getChooseTemplateLevelHTML("generateStory('storyRow',this.value)")); 
		%>
		
		
	</th>
	<tr ><td>
	<button onClick="window.location.href='MakingStory.jsp'">Go</button></td></tr>
	</table>
	</td></tr>
	</table>
	
	
	<h1>Come on let us write a story! Help me finish the story by putting words into the blanks</h1>
	
	<form name="Answers" id="Answers" action="StoryWriter">
	<table align="center" width="50%" bgcolor="skyblue">
	<tr>
	<td>Story Name<input type="text" id="storyName" name="storyName"/></td>
	<td id="nameValidation" class="ErrorMessage"><input type="reset"/></td>
	</tr>
	
	<tr>
		
	<td colspan="2" id="storyRow">
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
		<td><input type="button" value="Generate new Story" onClick="window.location.href='MakingStory.jsp'"></td>
		<td><input type="button" value="Submit Story" onclick="validateAnsers()"></td>
	</tr>
	
	</table>
	</form>
	</div>
	<%@ include file="Insertables/LeadearboardPanel.jsp" %>
	<%@ include file="Insertables/FeaturedStory.jsp" %>
	</div>
	
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>
