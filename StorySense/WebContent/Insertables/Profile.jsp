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
</tr><tr><td></td><td></td><td></td><td>
<input type="button" value="Edit Profile" onclick="changeProfile()">
</td></tr>

<tr>

	<td width="25%" class = "datacellone">
		Password Settings
	</td></tr>
	<tr>
	<td></td><td colspan="2">
		
        <form method="post" id="PasswordForm" name="PasswordForm" action="PasswordChanger"">
		<table>
  		<tr id="passwordRow">
  	
  		<td id="passwordCell">
  			<input type="button" id="ChangePassBt" value="Change Password"  onclick="ShowPasswordChanger()" />
  			</td>
  		</tr>
  		<tr id="changepasswordRow" class="hiddenElem">
  		<th>Password</th><td id="passwordCell"><input type="password" name="newPass" id="newPass"/></td>
  		</tr>
  		<tr id="confirmationPassRow" class="hiddenElem">
  		<th> Confirm Password</th><td id="passwordCell">
  		<input type="password" name="ConfirmPass" id="ConfirmPass"/></td>
  		</tr>
  		<tr id="submitPassRow" class="hiddenElem" >
  			<th> <input type="button" id="CancelPassBt" value="Cancel"  onclick='hidePasswordChanger()'/> </th>
  			<td id="passwordCell">
  			<input type="button" id="ChangePasswordBt" onclick="passwordChangeValidation()" value="Use new Password"/>
  			</td>
  		</tr>
  		<tr>
  			<td id="passError" colspan="2" class="ErrorMessage"></td>
  		</tr>
		</table></form>
	</td>
 	</tr>
<tr>
<td width="25%" class = "datacellone">
Information
</td>
</tr>
	<tr id="orig1stName"> 
		<td> </td>
		<td width="30%"><h4>First Name:</h4></td> 
		<td><% out.print(theProfile.getFirstName());%></td>
		<td width="20%"></td>
	</tr>
	
	<tr id="origsurname"> 
		<td> </td>
		<td><h4>Last Name:</h4></td> 
		<td> <% out.print(theProfile.getSurname());%></td>
		<td></td>
	</tr>

	 <tr id="origBday"> 
		<td> </td>
		<td><h4>Birthday:</h4></td> 
		<td><% out.print(theProfile.getBirthDay());%></td>
		<td></td>
	</tr>
	
	<tr> 
		<td> </td>
		<td colspan="3">
			<form name="chnageProfile" id="chnageProfile" action="UserUpdator" 
		method="post" ENCTYPE="multipart/form-data" class="hiddenElem">
		<table  align="center" >
	
		  <tr>
		</tr> 
		
		<tr>
		<th>Username</th>
		<td>
		<input type="text" name="username" id="username" value="<% out.write(sessionUser.getName());%>"/>
		</td>
		<td class="ErrorMessage" name="usernameError" id="usernameError"></td>
		</tr>
		
	
		<tr>
		<th>Firstname</th>
		<td>
		<input type="text" placeholder="your name" name="firstname" id="firstname"
			value="<% out.write(theProfile.getFirstName());%>"/>
		</td>
		<td class="ErrorMessage" id="firstnameError"></td>
		</tr>
		
		<tr>
		<th>Surname</th>
		<td>
		<input type="text" placeholder="your family name" name="surname" id="surname"
			value="<% out.write(theProfile.getSurname());%>"/>
		</td>
		<td class="ErrorMessage" id="surnameError"></td>
		</tr>
		
		<!-- No need to modify birthday -->
		
		<tr>
		<th>Profile Picture</th>
		<td>
         Click to change<br/>
		 <% out.write(profileEncoder.enterUserImageTag(sessionUser)); %>
		 <input type="file" name="profPic" id="profPic" value="<% out.write(theProfile.getImageURL());%>"/>
		 
		</td>
		<td class="ErrorMessage" id="pictureError"></td>
		</tr>
	
		
		<tr>
		<th><input type="reset" value="Reset form">
			<input type="button" value="cancel">
		</th>
		<th> <input type="submit" value="Save Changes" ></th>
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
