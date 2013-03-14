<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
 
  <%@ include file="Scripts/evaluatedStoriesScript.jsp" %>
<title>Complete the Story</title>
<style>

  
#validatedStoriesHeader{
  	background: #002387;
  	color:white;
  	padding: 15px;
  }

.validatedStoriesTable{
	background: #B0E2FF;
	border: solid #1874CD 1px;
}


.validatedStoriesTable th{
	font-family: "Segoe UI";
	font-size: 14px;
	color: #6D929B;
	letter-spacing: 2px;
	text-align: center;
	padding: 6px 6px 6px 12px;
	background: #ADD8E6;
}

.validatedStoriesTable td{
	text-align: center;
	font-family: "Segoe UI";
	font-size: 14px;
}



</style>
<script src="Scripts/AJAXscirpts.js"></script>
  <script src="Scripts/StoryFeedScript.js"></script>
</head>
<body onload="loadStoriesToReview(10)">

<%@ include file="Insertables/ReviewerNavBar.jsp" %>
<div id="container">
	

	<table align="center" width="100%" class="validatedStoriesTable">
	
	<tr>
	<th colspan=6 id="validatedStoriesHeader">
	Stories from other learners
	</th>
	</tr>
	
	<tr>
	<th>Profile Picture</th><th>Author</th><th>Story Title</th><th>Rating Given</th><th>Show Story</th>
	</tr>
	
	<tr>
	<td><img src="images/Untitled.jpg" class="profPic"/> </td>
	<td><b>KyleXY</b> </td>
	<td>Park Trip</td>
	<td>6</td>
	<td><a id="myHeader1-2" href="javascript:showonlyonev2('newboxes1-2')">show</a></td>
	
	</tr>
	<tr>
	<td colspan="5"><div class="newboxes-2" id="newboxes1-2" style="display: none">
	<table><tr><td colspan="5">Let's take a trip to park. 
		A skate board is an object we can find in the park. 
		Last week, I was relaxing when I was at the park. 
		After going to the park, I went to the skyscraper. </td></tr></table>
	</div></td>
	</tr>
	
	
	<tr>
	
	<td><img src="images/disPic.jpg" class="profPic"/> </td>
	<td><b>Viziox</b> </td>
	<td>Delightful Message</td>
	<td>7</td>
	<td><a id="myHeader2-2" href="javascript:showonlyonev2('newboxes2-2')">show</a></td>
	
	</tr>
	
	
	
	<tr>
	<td colspan="5"><div class="newboxes-2" id="newboxes2-2" style="display: none">
	<table><tr><td colspan="5">
		I was given a message by a mailman on a sunny day. After reading the letter
		I felt delightful. </td></tr></table>
	</div></td>
	</tr>
	
	
	
	
	
	</table>
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>