<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="webEncoder.*"%>
<%
WebCodeMaker wEncoder=new WebCodeMaker(out); 
AdminHtmlEncoder adminEnc=new AdminHtmlEncoder();
String searchBoxID="srchBox1010",relTableID="relationsTable4574778Ajsdfjs",searchBoxJqID="#"+searchBoxID;
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
	    	  searchRelations()
	      }
	    });
});
</script>

</head>
<body>
<%@ include file="Insertables/AdminNavBar.jsp" %>
<div id="container">
<label>Search Concept</label><input id=<%wEncoder.writeJsElementReference(searchBoxID); %>
	onkeypress="readySearch(event)">
<button onclick="searchRelations()">Search</button>
<table id=<%wEncoder.writeJsElementReference(relTableID); %> align="center">
<tr id="headerRow">
<th>Concept 1</th><th>Relationship</th><th>Concept 2</th>
<th>Confidence</th>
</tr>
</table>
<div id="part">

</div>
</div><%@ include file="Insertables/Footer.jsp" %>
</body>
</html>