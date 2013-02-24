<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="entity.User"%>
<%@page import="dao.ProfileDAO"%>
<%@page import="entity.Profile"%><%@page import="dao.DAOFactory"%>
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
<body >
<%@ include file="Insertables/TopBar.jsp" %>
<% User ProfileUser=u;
    DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
    ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
    Profile theProfile=profileDAO.getProfile(ProfileUser);
%>


<div id="container">

<div id="center" class="column">  <form method="post">
	<table class="centralForm">
  <tr>
  	<th>User name</th><td><% out.println(ProfileUser.getName()); %></td>
  </tr>
  <tr id="passwordRow">
  	<th>Password</th><td id="passwordCell"><input type="button" id="ChangePassBt" value="Change Password"></td>
  </tr>
  <tr id="changepasswordRow" class="hiddenElem">
  	<th>Password</th><td id="passwordCell"><input type="text" name="newPass" ></td>
  </tr>
  <tr id="confirmationPassRow" class="hiddenElem">
  	<th> Confirm Password</th><td id="passwordCell"><input type="text" name="ConfirmPass"></td>
  </tr>
  <tr id="submitPassRow" class="hiddenElem">
  	<th> </th><td id="passwordCell"><input type="submit" id="ChangePassBt"></td>
  </tr>
</table></form></div>

<%@ include file="Insertables/LearnerNavBar.jsp" %>
<%@ include file="Insertables/FeaturedStory.jsp" %>
</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>