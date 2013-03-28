<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="unclassified.DateProvider"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
  <link rel="stylesheet" href="Style/Default.css"> 

  <%@ include file="Scripts/FormScripts.jsp" %>

</head>
<body>

<div class="header">
	<div id="LogoHere">	<h1>Story Sense</h1></div>
	<div id="log">Please register</div>	
</div>

	<div class="container">
	<h1>Fill out the form</h1>
	  <!-- LearnerHomeSample.jsp -->
	<form name="Registration" id=<% encoder.writeJsElementReference(RegisFormName);%> action="UserRegistrator" 
		method="post" ENCTYPE="multipart/form-data">
	<table align="center">
	
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
		<td class="ErrorMessage" name="usernameError" id="usernameError">:[</td>
		</tr>
		
		<tr>
		<th>Password</th>
		<td><input type="password" name="initialPassword" id="initialPassword"/></td>
		<td class="ErrorMessage" id="PasswordError" colspan="2"></td>
		</tr>
		
		<tr>
		<th>Confirm Password</th>
		<td><input type="password" name="confirmPassword" id="confirmPassword"/></td>
		
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
		<!-- 
		<input type="file" value="Upload picture"/>
		<input type="radio" value="a" name="profPic"><img src="images/disPic.jpg"/>
		<input type="radio" name="profPic"><img src="images/Untitled.jpg" />
		<input type="radio" name="profPic"><img src="images/ConstwError.png" /><hr>
		<button>More pictures</button>
		 -->
		 
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
	</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>