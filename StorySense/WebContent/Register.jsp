<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="unclassified.DateProvider"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<style>
#fontStyle2{
font-family: Segoe UI; font-size: 20pt;
}
#tableBorderReg
{
border: 2px solid black;
border-radius: 4px;
margin: auto;
width: 100%;
}
.divisionHeader {
   	width:100%;
   	height:30%;   /* Height of the footer */
	background-color: #159cdb;
	margin-bottom: 1%;
	align: left;
	border-radius: 4px;
	
}
</style>
  <link rel="stylesheet" href="Style/Default.css"> 

  <%@ include file="Scripts/FormScripts.jsp" %>

</head>
<body bgcolor="CCFFFF">
<div style="Clear:both;"></div>
<div class="divisionHeader">
	<img src="images/storysenselogo3.png"/>
</div>

<div width="100%">
	<table style="margin: auto;">
	<tr><td>
		<table id="tableBorderReg" bgcolor = "Yellow">
			<thead></br><tr id="fontStyle2" ><th colspan = 3>Fill in the details</th></tr></thead>	
		</table>
	</td></tr>
	<tr><td>
	  <!-- LearnerHomeSample.jsp -->
	<form name="Registration" id=<% encoder.writeJsElementReference(RegisFormName);%> action="UserRegistrator" 
		method="post" ENCTYPE="multipart/form-data">
	<table align="center" id="tableBorderReg" bgcolor="white" >
	
		<tr>
		<th align="right">Role</th>
			<td><select name="role">
				<option>Learner</option>
				<option>Reviewer</option>
			</select>
		</td>
		</tr>
		
		<tr>
		<th align="right">Nickname/Display name</th>
		<td><input type="text" name="username" id="username"/></td>
		<td class="ErrorMessage" name="usernameError" id="usernameError"></td>
		</tr>
		
		<tr>
		<th align="right">Password</th>
		<td><input type="password" name="initialPassword" id="initialPassword"/></td>
		<td class="ErrorMessage" id="PasswordError" colspan="2"></td>
		</tr>
		
		<tr>
		<th align="right">Confirm Password</th>
		<td><input type="password" name="confirmPassword" id="confirmPassword"/></td>
		
		</tr>
	
		<tr>
		<th align="right">Firstname</th>
		<td><input type="text" placeholder="your name" name="firstname" id="firstname"/></td>
		<td class="ErrorMessage" id="firstnameError"></td>
		</tr>
		
		<tr>
		<th align="right">Surname</th>
		<td><input type="text" placeholder="your family name" name="surname" id="surname"/></td>
		<td class="ErrorMessage" id="surnameError"></td>
		</tr>
	
		<tr><th align="right">Birthday<br/></th><td>
		<select id="MonthBox" name="month" onchange="populateDayBox(Registration)">
		<% 
			DateProvider oP=new DateProvider();
				for(int ctr=0;ctr<12;ctr++)
			out.println("<option value='"+oP.getMonth(ctr)+"'>"+oP.getMonth(ctr)+"</option>");
		;
		%>

		</select> 
		<select id="DayBox" name="day">
		<%
		for(int ctr=1;ctr<=31;ctr++)
			out.println("<option value='"+ctr+"'>"+ctr+"</option>");
		%>
		</select>
	
		<select id="YearBox" name="year" onchange="populateDayBox(Registration)">
		<%=oP.provideYearOptions(100)%>
		
		</select>
		
		<br/></td>
		<td class="ErrorMessage" id="bdayError"></td>
		</tr>
		
		
		<tr>
		<th align="right">Profile Picture</th>
		<td>
		<!-- 
		<input type="file" value="Upload picture"/>
		<input type="radio" value="a" name="profPic"><img src="images/disPic.jpg"/>
		<input type="radio" name="profPic"><img src="images/Untitled.jpg" />
		<input type="radio" name="profPic"><img src="images/ConstwError.png" /><hr>
		<button>More pictures</button>
		 -->
		 
		 <input type="file" name="profPic" id="profPic" />
		 
		</td>
		<td class="ErrorMessage" id="pictureError"></td>
		</tr>
	
		
		<tr align="center">
		<th align="right">Reset Form</th>
		<td align="left"><input type="reset" value="Retry"></td>
		</tr>
		<tr>
		<th align="right">Done</th>
		<td align="left"> <input type="button" value="Finish" onclick="evaluateForm()"></td>
		</tr>
		
		
		
	</table>
	</form>
	</td></tr>
	</table>
	</div>
<%@ include file="Insertables/Footer.jsp" %>


</body>
</html>