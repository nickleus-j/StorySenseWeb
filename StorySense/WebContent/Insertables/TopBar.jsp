<%@page import="webEncoder.WebCodeMaker"%>
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
.divisionHeader {
   	width:100%;
   	height:35px;   /* Height of the footer */
	background-color: #159cdb;
	margin-bottom: 1%;
}
</style>


<%	//Load user from the session
	User u=(User)session.getAttribute("user");
%>

<div id="center">
	
<div style="Clear:both;"></div>
<div class="divisionHeader">
	   <%WebCodeMaker userEncoder=new WebCodeMaker(out);
		if(u!=null){
			//<img src="images/storysenselogo3.png" ></img>
			out.write(userEncoder.showUserHTMl(u));
			%>
			
	<%  }
		else {
	%><%@ include file="LogInForm.jsp" %> <% } %>
	</div>
	
	<div>
	
	<table bgcolor="white" align="center" id = "tableBorderTopBar">
	<tr>
	<td id="fontStyleTopbar"><img src="images/storysenselogo3.png"/></td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/LearnerHomeSample2.jsp"><img src="images/HomeButtons/home.png" onmouseover="this.src='images/HomeButtons/homeB.png'" onmouseout="this.src='images/HomeButtons/home.png'"  border="0" width="160"/></a> </td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/templateDisplay.jsp"><img src="images/HomeButtons/Create Stories.png" onmouseover="this.src='images/HomeButtons/Create StoriesB.png'" onmouseout="this.src='images/HomeButtons/Create Stories.png'"  border="0" width="160"/></a></td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/LearnerHomeSample.jsp"><img src="images/HomeButtons/My Stories.png" onmouseover="this.src='images/HomeButtons/My StoriesB.png'" onmouseout="this.src='images/HomeButtons/My Stories.png'"  border="0" width="160"/></a></td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/View_LearnerProfile.jsp"><img src="images/HomeButtons/Profile.png" onmouseover="this.src='images/HomeButtons/ProfileB.png'" onmouseout="this.src='images/HomeButtons/Profile.png'"  border="0" width="160"/></a></td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/leaderboard.jsp"><img src="images/HomeButtons/Help.png" onmouseover="this.src='images/HomeButtons/HelpB.png'" onmouseout="this.src='images/HomeButtons/Help.png'"  border="0" width="160"/></a></td>
	<td id="fontStyleTopbar2" width="15%" align="center"><a href="Logout"><img src="images/HomeButtons/Logout.png" onmouseover="this.src='images/HomeButtons/LogoutB.png'" onmouseout="this.src='images/HomeButtons/Logout.png'"  border="0" width="160" /></a></td>
	</tr>
	</table>
	
	</div>
	
</div>

