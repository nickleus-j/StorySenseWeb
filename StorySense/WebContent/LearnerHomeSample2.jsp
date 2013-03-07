<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 
  
  <script src="Scripts/AJAXscirpts.js"></script>
  <script src="Scripts/StoryFeedScript.js"></script>
</head>
<body bgcolor="CCFFFF" onload="loadStories(10)">
<%@ include file="Insertables/TopBar.jsp" %>
<div id="container">
<%@ include file="Insertables/StoryFeed.jsp" %>
<%@ include file="Insertables/LearnerNavBar.jsp" %>
<%@ include file="Insertables/FeaturedStory.jsp" %>
</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>