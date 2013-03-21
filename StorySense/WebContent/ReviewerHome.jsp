<%@page import="webEncoder.WebCodeMaker"%>
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

.subheader{
		background: #002387;
		color: white;
		align: center;
		size: 18px;
		padding: 10px;
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
	

	<table align="center" width="100%" >
	<tr>
		<th>Pick Minimum Level
		
			<% 
			WebCodeMaker htmlWriter=new WebCodeMaker(out); 
			out.write(htmlWriter.getTemplateComboBoxHTML());
			%>
		
		</th>
	</tr></table>
	<table align="center" width="100%" class="validatedStoriesTable" id="validatedStoriesTable">
	
	<tr>
	<th colspan=6 id="validatedStoriesHeader">
	Stories from other learners
	</th>
	</tr>
	
	<tr>
	<th>Author</th><th>Story Title</th><th>Show Story</th>
	</tr>
	</table>
	</div>
	
	<div id="reviewArea" >
	
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>