<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="entity.*"
    %>


<STYLE TYPE="text/css">
#tableBorderTopBar
{
border: 2px solid black;
border-radius: 4px;
}
#fontStyleTopbar{
font-family: Segoe UI; font-size: 20pt;
border-right-style: dotted;
}
#fontStyleTopbar2{
font-family: Segoe UI; font-size: 20pt;
}
</style>


<%	//Load user from the session
	User u=(User)session.getAttribute("user");
%>


	<div id="LogoHere">	
	  <h1> <%
		if(u!=null){
			//out.println("Hello "+u.getName());
			%>
			
	<%  }
		else {
	%><%@ include file="LogInForm.jsp" %> <% } %></h1></div>
	<div>
	
	<table bgcolor="white" align="center" id = "tableBorderTopBar">
	<tr>
	<td id="fontStyleTopbar"><img src="images/storysenselogo3.png" ></img></td>
	<td id="fontStyleTopbar" width="15%" align="center">
	<a href="../StorySense/ReviewerHome.jsp">
	<img src="images/HomeButtons/home.png" onmouseover="this.src='images/HomeButtons/homeB.png'" onmouseout="this.src='images/HomeButtons/home.png'"  border="0" width="160"/>
	</a> </td>
	
	<!--  
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/ValidateSample.jsp"><img src="images/HomeButtons/Create Stories.png" onmouseover="this.src='images/HomeButtons/Create StoriesB.png'" onmouseout="this.src='images/HomeButtons/Create Stories.png'"  border="0" width="160"/></a></td>
	-->
	<td id="fontStyleTopbar" width="15%" align="center">
		<a href="../StorySense/ValidatedStories.jsp">
		<img src="images/evalStories.png" width="160"/>
		</a>
		
		</td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/ReviewerHelp.jsp"><img src="images/HomeButtons/Help.png" onmouseover="this.src='images/HomeButtons/HelpB.png'" onmouseout="this.src='images/HomeButtons/Help.png'"  border="0" width="160"/></a></td>	
	<td id="fontStyleTopbar2" width="15%" align="center">
	<a href="Logout">
	<img src="images/HomeButtons/Logout.png" onmouseover="this.src='images/HomeButtons/LogoutB.png'" onmouseout="this.src='images/HomeButtons/Logout.png'"  border="0" width="160" />
		</a></td>
		
	</tr>
	</table>
	
	</div>
	
	


