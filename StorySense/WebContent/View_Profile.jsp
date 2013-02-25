<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<%@page import="dao.ProfileDAO"%><%@ page import="worker.DateProvider"%>
<%@page import="entity.Profile"%><%@page import="dao.DAOFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Story Sense</title>

  <link rel="stylesheet" href="Style/Default.css"> 
  <script src="Scripts/ProfileManagement.js"></script>
</head>
<body >
<%@ include file="Insertables/TopBar.jsp" %>



<div id="container">

<div id="center" class="column">
<%@ include file="Insertables/Profile.jsp" %>
</div>

<%@ include file="Insertables/LearnerNavBar.jsp" %>
<%@ include file="Insertables/FeaturedStory.jsp" %>
</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>