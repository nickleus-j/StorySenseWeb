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
<style>
#fontStylefeed{
font-family: Segoe UI; font-size: 12pt;
} 
#tableBorderfeed
{
border: 2px solid black;
border-radius: 4px;
margin-left: 15%;
margin-top: 2%;
margin-right: 2%;
margin-bottom: 2%;
width: 75%;
}

</style>
<body bgcolor="CCFFFF">


<%@ include file="Insertables/TopBar.jsp" %>

	<div id="container">
	<div id="center" class="column">
	
	<table id="tableBorderfeed" bgcolor="pink" width="60%" align="center"><tr><td>
	<h1>Come on let us write a story! Help me finish the story by putting words into the blanks</h1>
	</td></tr></table>

	<form name="Answers" id="Answers" action="StoryWriter">
	<table id="tableBorderfeed" align="center" width="50%" bgcolor="skyblue">
	
	<tr>
	<td>Story Name<input type="text" id="storyName" name="storyName"/></td>
	<td id="nameValidation" class="ErrorMessage"><input type="reset"/></td>
	</tr>
	
	<tr>
		
	<td colspan="2" id="storyRow">
	<hr>
		
		<%		/*LearnerStoryFininshedSample.jsp*/
		StoryEncoder TheEncoder=new StoryEncoder(request,out);
			out.write(TheEncoder.encodeStory(u.getLevel()));
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