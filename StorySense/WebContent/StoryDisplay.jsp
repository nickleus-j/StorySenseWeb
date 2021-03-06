<%@page import="ajaxLearner.StoryScoreLoader"%>
<%@page import="webEncoder.CompleteStoryLoader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<style>
   #tableBorderfeed2
{
border: 2px solid black;
border-radius: 4px;
margin-left: 15%;
margin-right: 2%;
margin-top: 2%;
width: 75%;
height: 525;
}
   </style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Achievements</title>
<link rel="stylesheet" href="Style/Default.css"> 
   <script src="Scripts/AJAXscirpts.js"></script>
    <%@ include file="Scripts/LearnerScripts.jsp" %>
   <% 
   
   int storyID=0;
   StoryScoreLoader scoreLoader=new StoryScoreLoader();
   try{
	   storyID=Integer.parseInt(request.getParameter("aID"));
	   }catch(Exception ex){
			response.sendRedirect("LearnerHomeSample.jsp") ;  
	   } 
	   %>
   
</head>
<body bgcolor="CCFFFF">
<%@ include file="Insertables/TopBar.jsp" %>
<div id="container">
<div id="center" class="column">
<table id="tableBorderfeed2" bgcolor="pink" align="center"><tr><td>
	<% 
	CompleteStoryLoader cLoader=new CompleteStoryLoader(u);
		if(storyID!=0)
	cLoader.encodeStory(storyID, out);
		cLoader.showUsersWhoLikedStory(storyID, out);
		out.write("<h2>Scores given</h2>");
		scoreLoader.generateScoreHtmlTbl(out, storyID);
	%>
</td></tr></table></div>

<%@ include file="Insertables/LeadearboardPanel.jsp" %>
<%@ include file="Insertables/FeaturedStory.jsp" %>
</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>