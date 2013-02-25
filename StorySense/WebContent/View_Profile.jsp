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

<div id="center" class="column"> <!-- <form method="post">
    <table class="centralForm" align="center">
    <tr>
    <td align="center"> 
     <% WebCodeMaker webEncoder=new WebCodeMaker(out);
        out.write(webEncoder.enterUserImageTag(u));
		%>
     </td>
    </tr>
    </table>
    
    
	<table class="centralForm">
  <tr id="passwordRow">
  	<th>Password</th>
  	<td id="passwordCell">
  		<input type="button" id="ChangePassBt" value="Change Password" onclick="ShowPasswordChanger()" ></td>
  </tr>
  <tr id="changepasswordRow" class="hiddenElem">
  	<th>Password</th><td id="passwordCell"><input type="text" name="newPass" ></td>
  </tr>
  <tr id="confirmationPassRow" class="hiddenElem">
  	<th> Confirm Password</th><td id="passwordCell"><input type="text" name="ConfirmPass"></td>
  </tr>
  <tr id="submitPassRow" class="hiddenElem">
  	<th> <input type="button" id="CancelPassBt" value="Cancel" > </th>
  	<td id="passwordCell"><input type="submit" id="ChangePassBt"></td>
  </tr>
</table></form>

<form name="chnageProfile" id="chnageProfile" action="UserRegistrator" 
		method="post" ENCTYPE="multipart/form-data">
	<table  align="center" class="hiddenElem">
	
		  <tr>
		<th>Role</th>
			<td><select name="role">
				<option>Learner</option>
				<option>Reviewer</option>
			</select>
		</td>
		</tr> 
		
		<tr>
		<th>Username or Alias or Codename</th>
		<td><input type="text" name="username" id="username"/></td>
		<td class="ErrorMessage" name="usernameError" id="usernameError"></td>
		</tr>
		
	
		<tr>
		<th>Firstname</th>
		<td><input type="text" placeholder="your name" name="firstname" id="firstname"/></td>
		<td class="ErrorMessage" id="firstnameError"></td>
		</tr>
		
		<tr>
		<th>Surname</th>
		<td><input type="text" placeholder="your family name" name="surname" id="surname"/></td>
		<td class="ErrorMessage" id="surnameError"></td>
		</tr>
	
		<tr><th>BirthDay<br/></th><td>
		Month <select id="MonthBox" name="month" onchange="populateDayBox(Registration)">
		<% 
			DateProvider oP=new DateProvider();
				for(int ctr=0;ctr<12;ctr++)
			out.println("<option value='"+oP.getMonth(ctr)+"'>"+oP.getMonth(ctr)+"</option>");
		;
		%>

		</select> 
		Day <select id="DayBox" name="day">
		<%
		for(int ctr=1;ctr<=31;ctr++)
			out.println("<option value='"+ctr+"'>"+ctr+"</option>");
		%>
		</select>
	
		Year <select id="YearBox" name="year" onchange="populateDayBox(Registration)">
		<%=oP.provideYearOptions(100)%>
		
		</select>
		
		<br/></td>
		<td class="ErrorMessage" id="bdayError"></td>
		</tr>
		
		
		<tr>
		<th>Profile Picture</th>
		<td>

		 
		 <input type="file" name="profPic" id="profPic"/>
		 
		</td>
		<td class="ErrorMessage" id="pictureError"></td>
		</tr>
	
		
		<tr>
		<th>Reset Form <input type="reset" value="Reset form"></th>
		<th>Done <input type="button" value="Register" onclick="evaluateForm()"></th>
		</tr>
		
		
		
	</table>
	</form>
	-->
<%@ include file="Insertables/Profile.jsp" %>
</div>

<%@ include file="Insertables/LearnerNavBar.jsp" %>
<%@ include file="Insertables/FeaturedStory.jsp" %>
</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>