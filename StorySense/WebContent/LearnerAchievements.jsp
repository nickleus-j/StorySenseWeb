<%@page import="webEncoder.AchievementHtmlEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Achievements</title>
<link rel="stylesheet" href="Style/Default.css"> 
   <script src="Scripts/AJAXscirpts.js"></script>
    <%@ include file="Scripts/LearnerScripts.jsp" %>
   
</head>
<body>
<% AchievementHtmlEncoder aEncoder=new AchievementHtmlEncoder();
	User myUser=(User)request.getAttribute("viewedUser");
	if(myUser==null)
		myUser=(User)session.getAttribute("user");
		
	WebCodeMaker webEncoder=new WebCodeMaker(out);	
		%>

<%@ include file="Insertables/TopBar.jsp" %>
<div id="container">
<div id="center" class="column">
<table align="center" bgcolor="dodgerblue">
	<tr>
	<td rowspan="2"><% out.print(webEncoder.enterUserImageTag(myUser)); %></td>
	<td><% out.print(myUser.getName()); %></td>
	</tr>
	<tr>
	<td><% out.print("Level "+myUser.getLevel()); %></td>
	</tr>
</table>
<% out.write(aEncoder.writeHtmlUserAchievements(myUser)); %>

</div>

<%@ include file="Insertables/LeadearboardPanel.jsp" %>
<%@ include file="Insertables/FeaturedStory.jsp" %>
</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>