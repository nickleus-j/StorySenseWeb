<%@page import="webEncoder.CompleteStoryLoader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 
  
  <style type="text/css">
  
  .storyTbl{
  	width: 100%;
  	height: 100%;
  	background: skyblue;
  }
  
  </style>
  
</head>
<body>

<%@ include file="Insertables/TopBar.jsp" %>
<%@ include file="Insertables/LearnerNavBar.jsp" %>
	<div class="container">
	<h1>Welcome to Story Sense</h1>
	<hr/>
	
	<table><tr><td>
	<% CompleteStoryLoader sLoader=new CompleteStoryLoader();
		 sLoader.showStories(out);
		 %>
   </td></tr> </table>
	
	<table align="center" bgcolor="orange" >
	<caption>Your Stories</caption>
	
	<tr>
	<td>
		<table class="storyTbl">
			<tr><th>Story Name</th><td>As I sit</td></tr>
			<tr><th>Score Earned</th><td>45</td></tr>
			<tr><th>Date Finished</th><td>October 28, 2012</td></tr>
			<tr><th colspan="2"><a href="ScoredStory.jsp">See Story</a></th></tr>
		</table>
	</td>
	<td>
		<table class="storyTbl">
			<tr><th>Story Name</th><td>My stay at home</td></tr>
			<tr><th>Score Earned</th><td>65</td></tr>
			<tr><th>Date Finished</th><td>October 28, 2012</td></tr>
			<tr><th colspan="2"><a href="ScoredStory.jsp">See Story</a></th></tr>
		</table>
	</td>
	<td>
		<table class="storyTbl">
			<tr><th>Story Name</th><td>Today I saw a bottle</td></tr>
			<tr><th>Score Earned</th><td>50</td></tr>
			<tr><th>Date Finished</th><td>October 29, 2012</td></tr>
			<tr><th colspan="2"><a href="ScoredStory.jsp">See Story</a></th></tr>
		</table>
	</td>
	</tr>
	
	<tr>
	<td>
		<table class="storyTbl">
			<tr><th>Story Name</th><td>More to Come</td></tr>
			<tr><th>Score Earned</th><td>60</td></tr>
			<tr><th>Date Finished</th><td>October 30, 2012</td></tr>
			<tr><th colspan="2"><a href="ScoredStory.jsp">See Story</a></th></tr>
		</table>
	</td>
	<td>

		<table class="storyTbl">
			<tr><th>Story Name</th><td>My visit to the Villa</td></tr>
			<tr><th>Score Earned</th><td>30</td></tr>
			<tr><th>Date Finished</th><td>October 31, 2012</td></tr>
			<tr><th colspan="2"><a href="ScoredStory.jsp">See Story</a></th></tr>
		</table>
		
	</td>
	
	<td>
		<table class="storyTbl">
			<tr><th>Story Name</th><td>What was Lost</td></tr>
			<tr><th>Score Earned</th><td>Unfinished Story</td></tr>
			<tr><th>Last time Edited</th><td>November 3, 2012</td></tr>
			<tr><th colspan="2"><a href="StoryToAnsSample.jsp">Work On Story</a></th></tr>
		</table>
	</td>
	</tr>
	
	</table>
	
	</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>