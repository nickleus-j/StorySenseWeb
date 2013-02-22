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
	
	<% sLoader.showUserStoryPreviews((User)request.getSession().getAttribute("user"), out); %>
	</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>