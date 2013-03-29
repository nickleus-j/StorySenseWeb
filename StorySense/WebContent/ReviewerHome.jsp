<%@page import="webEncoder.RatingFormEncoder"%>
<%@page import="webEncoder.WebCodeMaker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 
 <%@ include file="Scripts/ReviewerScripts.jsp" %>
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
	
.subheader a{
	color:white;
}
.subheader a:ACTIVE{
	color: yellow;
}

.subheader a:VISITED{
	color: skyblue;
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
}

.innerTableValidateSample {
	margin: 5%;
}

.assertions{
	margin: 25%;
	border-color: #000080;
	border-style: groove;
	text-align: center;
}

.assertions th{
	/*width: 40%;*/
	border-color: #000080;
	border-style: groove;
	text-align: center;
	border-width: .2em;
	}

.assertions td{
	border-color: #000080;
	border-style: groove;
	text-align: center;
	border-width: .1em;
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
	
		<th>Filter Users
		<% /*The webcodemaker known as encoder
			is already declared in an included jsp file
			//WebCodeMaker encoder=new WebCodeMaker(out); 
			*/
			
			out.write(encoder.getUsersToBeRated());
		%>
		</th>
	
		<th>Pick Minimum Level
		
			<%
			out.write(encoder.getTemplateComboBoxHTML());
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
	
	<div id="reviewArea">
	<form method="get" id="validationForm">
	<table id="validationTable" class="hiddenElem">
	<caption class="subheader">Validation</caption>
	
	<tr>
		<td id="descStage" colspan="4">
		
		</td>
	</tr>
	<tr >
		<th class="subheader" >Story </th>
		<td colspan="3" id="<% out.write(storyCellID); %>">
		</td>
	</tr>
	<tr class="innerTableValidateSample">
		<td colspan="4" id="assertionTbl" class="assertions">
		</td>
	</tr>
	
	<tr>
		<th>Quality</th><td>
		<% RatingFormEncoder rfe=new RatingFormEncoder();
			out.write(rfe.createSatisfactionSelectHtml());
		%>
		</td>
	</tr>
	
	<tr>
		<td class="subheader" colspan="2">
		<a href=<% encoder.writeJsElementReference(validatedStoriesTableID);%>>
			See Other Stories
			</a></td>
		<td class="ErrorMessage" id="errorCell"></td>
		<td><input type="reset" value="undo everything"/></td>
		<td><input type="submit" value="Done" /></td>
	</tr>
	</table></form>
	
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>