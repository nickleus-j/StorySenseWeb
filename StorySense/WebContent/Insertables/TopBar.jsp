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
border: none;
}
#fontStyleTopbar2{
font-family: Segoe UI; font-size: 20pt;
border: none;
}
.divisionHeader {
   	width:30%;
   /* 	height:55px;   Height of the footer */
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
			if(User.Roles.learner.isLearner(u.getRole())){%>
		<script type="text/javascript">var userName=<% userEncoder.writeJsElementReference(u.getName());%></script>
		<%@ include file="NotificationPanel.jsp" %>
	<% }/*End of learner condition*/ 
	}/*End of null user condition*/
		else {
	%><%@ include file="LogInForm.jsp" %> <% } %>
	
	</div>
	<% 
	if(u!=null){
		if(User.Roles.learner.isLearner(u.getRole())) {%>
		
	<div style="max-width:82%; margin:0 auto;">
	
	<table id = "tableBorderTopBar" bgcolor="white" cellspacing="0" cellpadding="0"> <!--   -->
	<tr>
	<td id="fontStyleTopbar"><img src="images/storysenselogo4.png" border="0" width="166"/></td>
	<td id="fontStyleTopbar" width="15%"><a href="../StorySense/LearnerHomeSample2.jsp"><img src="images/HomeButtons2/home.png" onmouseover="this.src='images/HomeButtons2/homeB.png'" onmouseout="this.src='images/HomeButtons2/home.png'" width="155"/></a> </td>
	<td id="fontStyleTopbar" width="15%" ><a href="../StorySense/templateDisplay.jsp"><img src="images/HomeButtons2/Create Stories.png" onmouseover="this.src='images/HomeButtons2/Create StoriesB.png'" onmouseout="this.src='images/HomeButtons2/Create Stories.png'" width="155"/></a></td>
	<td id="fontStyleTopbar" width="15%"><a href="../StorySense/LearnerHomeSample.jsp"><img src="images/HomeButtons2/My Stories.png" onmouseover="this.src='images/HomeButtons2/My StoriesB.png'" onmouseout="this.src='images/HomeButtons2/My Stories.png'"  width="155"/></a></td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/View_LearnerProfile.jsp"><img src="images/HomeButtons2/Profile.png" onmouseover="this.src='images/HomeButtons2/ProfileB.png'" onmouseout="this.src='images/HomeButtons2/Profile.png'"  width="155"/></a></td>
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/Help.jsp"><img src="images/HomeButtons2/Help.png" onmouseover="this.src='images/HomeButtons2/HelpB.png'" onmouseout="this.src='images/HomeButtons2/Help.png'" width="155"/></a></td>
	<td id="fontStyleTopbar2" width="15%" align="center"><a href="Logout"><img src="images/HomeButtons2/Logout.png" onmouseover="this.src='images/HomeButtons2/LogoutB.png'" onmouseout="this.src='images/HomeButtons2/Logout.png'"  width="155" /></a></td>
	</tr>
	</table>
	
	</div>
	<%}//End of Learner Condition
		
		else if(User.Roles.reviewer.isReviwer(u.getRole())){ %>
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
	<td id="fontStyleTopbar" width="15%" align="center"><a href="../StorySense/Help.jsp"><img src="images/HomeButtons/Help.png" onmouseover="this.src='images/HomeButtons/HelpB.png'" onmouseout="this.src='images/HomeButtons/Help.png'"  border="0" width="160"/></a></td>	
	<td id="fontStyleTopbar2" width="15%" align="center">
	<a href="Logout">
	<img src="images/HomeButtons/Logout.png" onmouseover="this.src='images/HomeButtons/LogoutB.png'" onmouseout="this.src='images/HomeButtons/Logout.png'"  border="0" width="160" />
		</a></td>
		
	</tr>
	</table>
	
	</div>
		<%} //End of Reviewer condition
			
		}//End of not null condtion %>
</div>
