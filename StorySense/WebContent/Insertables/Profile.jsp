<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="webEncoder.WebCodeMaker"%>
<%@page import="entity.User"%>
<%@page import="dao.ProfileDAO"%><%@ page import="worker.DateProvider"%>
<%@page import="entity.Profile"%><%@page import="dao.DAOFactory"%>
<!DOCTYPE html>


  <link rel="stylesheet" href="Style/Default.css"> 
  
  <style type="text/css">
  
 .profileHeader{
  background-color: maroon;
  color: white;
  size: 23px;
  }
  
  td.datacellone {
	background-color: #B22222; 
	color: white;
	}
	
	td{
	font-family: "Segoe UI";
	padding: 10px;
	}
	
.tableStyleProfile{
	background: #FEDFDF;
	border: 5px solid maroon;
	
	}

#profileDiv{
	max-width:60%;
	}

h4{
	margin: 5px;
	}

  </style>


<% User sessionUser=(User)request.getSession().getAttribute("user"); %>
<div id="profileDiv">
<table class="tableStyleProfile">
<tr><td colspan=4 class="profileHeader" align="Left">Profile</td></tr>
<tr></tr>
<tr> 
<td colspan=4 align="center">
	<% WebCodeMaker profileEncoder=new WebCodeMaker(out);
        out.write(profileEncoder.enterUserImageTag(sessionUser));
        DAOFactory myDAOFactory = DAOFactory.getInstance(DAOFactory.MYSQL);
        ProfileDAO profileDAO=myDAOFactory.createProfileDAO();
        Profile theProfile=profileDAO.getProfile(sessionUser);
		%>
	</td>
</tr>

<tr>
<td colspan=4 align="center"><h1><% out.print(sessionUser.getName());%></h1> 
</td>
</tr><tr><td></td><td></td><td></td><td><input type="button" value="Edit Profile"></td></tr>

<tr>

	<td width="25%" class = "datacellone">
		Password Settings
	</td></tr>
	<tr><td></td><td>
		<form method="post">

        
		<table>
  		<tr id="passwordRow">
  	
  		<td id="passwordCell">
  			<input type="button" id="ChangePassBt" value="Change Password" onclick="ShowPasswordChanger()" >
  			</td>
  		</tr>
  		<tr id="changepasswordRow" class="hiddenElem">
  		<th>Password</th><td id="passwordCell"><input type="text" name="newPass" ></td>
  		</tr>
  		<tr id="confirmationPassRow" class="hiddenElem">
  		<th> Confirm Password</th><td id="passwordCell"><input type="text" name="ConfirmPass"></td>
  		</tr>
  		<tr id="submitPassRow" class="hiddenElem">
  			<th> <input type="button" id="CancelPassBt" value="Cancel"  onclick='hidePasswordChanger()'> </th>
  			<td id="passwordCell"><input type="submit" id="ChangePassBt"></td>
  		</tr>
		</table></form>
	</td>
</tr>
<tr>
<td width="25%" class = "datacellone">
Information
</td>
</tr>
	<tr> 
		<td> </td>
		<td width="30%"><h4>First Name:</h4></td> 
		<td><% out.print(theProfile.getFirstName());%></td>
		<td width="20%"></td>
	</tr>
	
	<tr> 
		<td> </td>
		<td><h4>Last Name:</h4></td> 
		<td> <% out.print(theProfile.getSurname());%></td>
		<td></td>
	</tr>

	<tr> 
		<td> </td>
		<td><h4>Birthday:</h4></td> 
		<td><% out.print(theProfile.getDateString());%></td>
		<td></td>
	</tr>
	
	<tr> 
		<td> </td>
		<td colspan="2">
			<form name="chnageProfile" id="chnageProfile" action="UserRegistrator" 
		method="post" ENCTYPE="multipart/form-data">
		<table  align="center" class="hiddenElem">
	
		  <tr>
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
		
		
		
		</table></form>
		</td>
		<td></td>
	</tr>
	
	
<tr>
<td width="25%" class = "datacellone">Badges</td>
</tr>

<tr>
<td></td>
<td> TEMPORARILY UNAVAILABLE. </td>
</tr>


<tr>
<td width="25%" class = "datacellone">
Statistics
</td>
</tr>

<tr>
		<td> </td>
		<td><h4>Number of Stories Made:</h4></td> 
		<td>10</td>
		<td></td>
</tr>

<tr>
		<td> </td>
		<td><h4>Highest Score:</h4></td> 
		<td>95%</td>
		<td></td>
</tr>


<tr>
		<td> </td>
		<td><h4>Lowest Score:</h4></td> 
		<td>65%</td>
		<td></td>
</tr>

</table>

</div>
