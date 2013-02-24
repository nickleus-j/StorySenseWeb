<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!-- TrythisServlet -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
</head>
<body>

<form id="logInForm" action="LogIn" method="post">
<table class="Logo" align="center">
<tr><td>
<img src="images/storysenselogo.jpg" />
</td></tr>
</table>
<table class="logIn" align="center">


<tr>
	<th>User name</th><td id="nameCell"><input type="Text" name="username"/></td>
</tr>

<tr>
	<th>Password</th><td id="passwordCell"><input type="password" name="password"/></td>
</tr>

<tr>
	<td align="left"><input type="reset"/></td><td align="right"><input type="Submit" value="Log In"/></td>
</tr>

</table>
</form>


</body>
</html>