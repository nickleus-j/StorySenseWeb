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
<div id="center">
<div style="Clear:both;"></div>
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
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/AdminHome.jsp"><img src="images/HomeButtonsAdmin/home.png" onmouseover="this.src='images/HomeButtonsAdmin/home-selected.png'" onmouseout="this.src='images/HomeButtonsAdmin/home.png'"  border="0" width="160"/></a> </td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/ViewTemplatesMade.jsp"><img src="images/HomeButtonsAdmin/template.png" onmouseover="this.src='images/HomeButtonsAdmin/template-selected.png'" onmouseout="this.src='images/HomeButtonsAdmin/template.png'"  border="0" width="160"/></a></td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/RelationshipPage.jsp"><img src="images/HomeButtonsAdmin/relation.png" onmouseover="this.src='images/HomeButtonsAdmin/relation-selected.png'" onmouseout="this.src='images/HomeButtonsAdmin/relation.png'"  border="0" width="160"/></a></td>	
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/AdminControlCenter.jsp"><img src="images/HomeButtonsAdmin/SettingDummy.PNG" height="200"/></a></td>	
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/ViewRelationsAdmin.jsp">Relations Learned</a></td>
	<td id="fontStyleTopbar2" width="15%" align="center"><a href="Logout"><img src="images/HomeButtonsAdmin/logout.png" onmouseover="this.src='images/HomeButtonsAdmin/logout-selected.png'" onmouseout="this.src='images/HomeButtonsAdmin/logout.png'"  border="0" width="160" /></a></td>
	</tr>
	</table>
	
	</div>
	
	</div>


