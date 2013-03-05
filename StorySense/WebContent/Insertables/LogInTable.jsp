<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!-- TrythisServlet -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>

<style>
.tableLogin {

	border: solid black 0.5px;
	border-radius: 0px 0px 15px 15px;
	background: white;
	padding: 10px;
}

.tableLogin2 {
	border: solid black 0.5px;
	border-radius: 15px 15px 0px 0px;
	background: #708090;
	width: 408px;
	padding: 10px;
}

.tableLogin td{
	padding-right: 55px;
	padding-left: 75px;
}


.tableLogin th{
	color: black;
	font-family: "Segoe UI";
}

#logInHeader{
color: white;
}
</style>

</head>
<body>
<form id="logInForm" action="LogIn" method="post">
<table align="center">
<tr><td align="center">
<img src="images/storysenselogo.png" width="70%" height="60%"/>
</td></tr>
</table>

<br><br>
<table class="tableLogin2" align="center">

<tr id="logInHeader" >
<th>
Log in
</th>
</tr>
</table>

<table class="tableLogin" align="center">


<tr>
	<th>Username</th>
</tr>
<tr><td colspan=2 id="nameCell"><input type="Text" name="username" style="width: 250px;"/></td></tr>

<tr><td></td></tr>
<tr>
	<th>Password</th>
</tr>
<tr><td colspan=2 id="passwordCell"><input type="password" name="password" style="width: 250px;"/></td></tr>

<tr><td colspan=3></td></tr>
<tr>
	<td align="left"><input type="reset"/></td><td align="right"><input type="Submit" value="Log In"/></td>
</tr>

<tr></tr>

</table>


</form>


</body>
</html>