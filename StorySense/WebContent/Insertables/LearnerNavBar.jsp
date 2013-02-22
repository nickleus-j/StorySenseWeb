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

.lBoardbBox{
 font-family: Segoe UI; font-size: 10pt;
color: light green;
border: 2px solid black;
}
  
</style>

 <div id="left" class="column" >
 <table>
 <tr><td>
	<table id="tableBorderLeaderboard" bgcolor = "lightgreen">
		<thead style="border-bottom-style: solid" ><tr id="fontStyle2"  align = "center"><th colspan = 3>LEADERBOARD</th></tr></thead>
	</table>
</td></tr>
 
 <tr><td>
	<table id="tableBorderLeaderboard" bgcolor = "white" width="100%">
		<tr align="center"><td id="fontStyle3">1</td> <td id="fontStyle3">Gab</td> <td id="fontStyle3">100</td></tr>
		<tr align="center"><td id="fontStyle3">2</td> <td id="fontStyle3">Kaizer</td> <td id="fontStyle3">90</td></tr>
		<tr align="center"><td id="fontStyle3">3</td> <td id="fontStyle3">Nickleus</td> <td id="fontStyle3">80</td></tr>
		<tr align="center"><td id="fontStyle3">4</td> <td id="fontStyle3">Eph</td> <td id="fontStyle3">70</td></tr>
		<tr align="center"><td id="fontStyle3">5</td> <td id="fontStyle3">John</td> <td id="fontStyle3">60</td></tr>
		<tr align="center"><td id="fontStyle3">6</td> <td id="fontStyle3">Juan</td> <td id="fontStyle3">50</td></tr>
		<tr align="center"><td id="fontStyle3">7</td> <td id="fontStyle3">Ned</td> <td id="fontStyle3">40</td></tr>
		<tr align="center"><td id="fontStyle3">8</td> <td id="fontStyle3">Ted</td> <td id="fontStyle3">30</td></tr>
		<tr align="center"><td id="fontStyle3">9</td> <td id="fontStyle3">Chris</td> <td id="fontStyle3">20</td></tr>
		<tr align="center"><td id="fontStyle3">10</td> <td id="fontStyle3">Stan</td> <td id="fontStyle3">10</td></tr>	
		<%		WebCodeMaker encoder=new WebCodeMaker(out);
		out.write(encoder.getleaderBoardHTMLTable());
		%>
	</table>
</td></tr>
</table>

</div>

