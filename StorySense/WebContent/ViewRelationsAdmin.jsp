<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="webEncoder.*"%>
<%
WebCodeMaker wEncoder=new WebCodeMaker(out); 
AdminHtmlEncoder adminEnc=new AdminHtmlEncoder();
String searchBoxID="srchBox1010",relTableID="relationsTable4574778Ajsdfjs",searchBoxJqID="#"+searchBoxID;
String c1Box="cBuz1_dsfj",relBox="relBuz_dsnfhs",c2Box="cBuz2_dsfjs";
%>

<!DOCTYPE html>
<html>
<head>
<title>Relations</title>
<link rel="stylesheet" href="Style/Default.css"> 
<link rel="stylesheet" href="Style/jquery-ui.css"> 

<style>

.ui-autocomplete {
    max-height: 25%;
    overflow-y: auto;
   }
</style>

<script src="Scripts/AJAXscirpts.js"></script>
<script src="Scripts/jquery.js"></script>
<script src="Scripts/jquery-ui.js"></script>
<script type="text/javascript">

var concepts=<% out.write(adminEnc.getConceptTextsJs());%>;
var relations=<% out.write(adminEnc.getRelationshipsJs());%>;

function readySearch(e){
	if (e.keyCode == 13) {
		searchRelations();
    }
}

function searchRelations(){
	var key=document.getElementById(<%wEncoder.writeJsElementReference(searchBoxID); %>).value;
	var xmlhttp=getAJAXRequest();
	
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			showResults(JSON.parse(xmlhttp.responseText));
			
		}
	};
	/*Send a request to the server*/
	xmlhttp.open("GET","RelationSearchAdmin?key="+key,true);
	xmlhttp.send();
}

function showResults(arr){
	var elem=document.getElementById(<%wEncoder.writeJsElementReference(relTableID); %>);
	elem.innerHTML="<tr><th>Concept 1</th><th>Relationship</th><th>Concept 2</th><th>Confidence</th></tr>";
	
	for(var ctr=0;ctr<arr.length;ctr++){
		elem.innerHTML+=("<tr><td>"+arr[ctr].c1+"</td><td>"+
				arr[ctr].relationship+"</td><td>"+
				arr[ctr].c2+"</td><td>"+arr[ctr].confidence+"</td></tr>");
		
		
	}/*End of loop*/
	
	if(arr.length<1)
		elem.innerHTML+=("<tr><td colspan=\"4\">No results from concept</td></tr>");
	
}

$(function() {
	
	$( <%wEncoder.writeJsElementReference(searchBoxJqID); %> ).autocomplete({
	      source: concepts,select:function( event, ui ) {
	    	  document.getElementById(<%wEncoder.writeJsElementReference(searchBoxID); %>).value=ui.item.value;
	    	  searchRelations();
	      }
	    });
	
	$( <%wEncoder.writeJsElementReference("#"+c1Box); %> ).autocomplete({
		source: concepts
	});
	$( <%wEncoder.writeJsElementReference("#"+c2Box); %> ).autocomplete({
		source: concepts
	});
	$( <%wEncoder.writeJsElementReference("#"+relBox); %> ).autocomplete({
		source: relations
	});
});

function addRelation(){
	var c1=document.getElementById(<%wEncoder.writeJsElementReference(c1Box); %>).value;
	var c2=document.getElementById(<%wEncoder.writeJsElementReference(c2Box); %>).value;
	var rel=document.getElementById(<%wEncoder.writeJsElementReference(relBox); %>).value;
	var status=document.getElementById("status");
	var xmlhttp=getAJAXRequest();
	
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			status.innerHTML=xmlhttp.responseText;
			
		}
	};
	/*Send a request to the server*/
	xmlhttp.open("GET","addKnwoledge?c1="+c1+"&c2="+c2+"&rel="+rel,true);
	xmlhttp.send();
}
</script>

</head>
<body bgcolor="CCFFFF">
<%@ include file="Insertables/AdminNavBar.jsp" %>
<div id="container">
<br>
<label>Search Concept</label><input id=<%wEncoder.writeJsElementReference(searchBoxID); %>
	onkeypress="readySearch(event)">
<button onclick="searchRelations()">Search</button>

<table border="2" style="margin-top: 2%; border-collapse: collapse;" id=<%wEncoder.writeJsElementReference(relTableID); %> align="center">
<tr id="headerRow">
<th>Concept 1</th><th>Relationship</th><th>Concept 2</th>
<th>Confidence</th>
</tr>
</table>
<div id="part">
<table align="center" style="margin-top: 2%;">
<tr>
<th>Concept 1</th><th>Relationship</th><th>Concept2</th>
</tr>

<tr>
<td>	<input id=<%wEncoder.writeJsElementReference(c1Box); %>/>	</td>
<td>	<input id=<%wEncoder.writeJsElementReference(relBox); %>/>	</td>
<td>	<input id=<%wEncoder.writeJsElementReference(c2Box); %>/>	</td>
<td>	<button onclick="addRelation()">Add</button></td>
</tr>

<tr>
<th id="status" colspan="4">

</th>
</tr>
</table>
</div>
</div><%@ include file="Insertables/Footer.jsp" %>
</body>
</html>