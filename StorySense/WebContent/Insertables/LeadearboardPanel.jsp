<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%><%@page import="webEncoder.WebCodeMaker"%>
<style TYPE="text/css">
#tableBorderLeaderboard
{
border: 2px solid black;
border-radius: 4px;
}

#fontStyle3 {
font-family: Segoe UI; font-size: 10pt;
color: light green;
border: 2px solid black;
}

#fontStyle2 {
font-family: Segoe UI; font-size: 11pt;
}

.lBoardbBox{
 font-family: Segoe UI; font-size: 10pt;
color: light green;
border: 2px solid black;
}
  
</style>

 <div id="left" class="column" >
 <table>
 <tr><td>
	<table id="tableBorderLeaderboard" bgcolor = "lightgreen" width="100%">
		<thead style="border-bottom-style: solid" ><tr id="fontStyle2"  align = "center"><th colspan = 3>Leaderboard</th></tr></thead>
	</table>
</td></tr>
 
 <tr><td>
	<table id="tableBorderLeaderboard" bgcolor = "white" >
	<tr id="fontStyle2">
	<th>Name</th><th>Level</th><th>Points</th>
	</tr>
		<%		WebCodeMaker encoder=new WebCodeMaker(out);
		out.write(encoder.getleaderBoardHTMLTable());
		%>
	</table>
</td></tr>
</table>

</div>
