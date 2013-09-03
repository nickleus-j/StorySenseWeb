<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String wrtrBoxID="jsdfdsjn1010",searchBoxJqID="#"+wrtrBoxID; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="Style/Default.css"/> 

<title>Complete the Story</title>
<style>

  
#validatedStoriesHeader{
  	background: #002387;
  	color:white;
  	padding: 15px;
  }

.validatedStoriesTable{
	background: #B0E2FF;
	border: solid #1874CD 1px;
}


.validatedStoriesTable th{
	font-family: "Segoe UI";
	font-size: 14px;
	color: #6D929B;
	letter-spacing: 2px;
	text-align: center;
	padding: 6px 6px 6px 12px;
	background: #ADD8E6;
}

.validatedStoriesTable td{
	text-align: center;
	font-family: "Segoe UI";
	font-size: 14px;
}



</style>
<script src="Scripts/AJAXscirpts.js"></script>
  <script src="Scripts/StoryFeedScript.js"></script>
  <%@ include file="Scripts/ReviewerScripts.jsp" %>
  <link rel="stylesheet" href="Style/jquery-ui.css"> 
  <script src="Scripts/jquery.js"></script>
<script src="Scripts/jquery-ui.js"></script>
  <script>
  var writers=<% out.write(encoder.getUsersToBeRatedJSON());%>
  
  function readySearch(e){
		if (e.keyCode == 13) {
			ReviewStoriesInUser(20,1,
					document.getElementById(<%encoder.writeJsElementReference(wrtrBoxID); %>).value);
	    }
	}
  
  $(function() {
		
		$( <%encoder.writeJsElementReference(searchBoxJqID); %> ).autocomplete({
		      source: writers,
		      select:function( event, ui ) {
		    	  loadReviwedStoriesOfUser(ui.item.value);
		      }
		    });
	});
  </script>
</head>
<body onload="loadStoriesReviewed(10)" bgcolor="CCFFFF">

<%@ include file="Insertables/ReviewerNavBar.jsp" %>
<div id="container">
<script>
writers=<% out.write(encoder.getUsersToBeRatedJson(u.getAccountID()));%>
</script>

	<table>
	<tr>
	<th>Pick Stories of Users</th>
	<th>Template level</th>
	</tr>
	
	<tr>
	<td>
		<% out.write(encoder.getlearnerReviwedSelectionHTML(rRes.getLearnerListBox(),
				"loadReviwedStoriesOfUser(this.value)", u.getAccountID()));%>
		<label>Search Author and press Enter</label>
		<input id=<%encoder.writeJsElementReference(wrtrBoxID); %>
	onkeypress="readySearch(event)">
	</td>
	<td>
		<% out.write(encoder.getChooseTemplateLevelHTML(rRes.getTemplateLevBoxId(),
			"loadStoriesReviewedWithLevel(this.value)")); %>
	</td>
	</tr>
	</table>
	<table align="center" width="100%" class="validatedStoriesTable" id="validatedStoriesTable">
	
	<tr>
	<th colspan=6 id="validatedStoriesHeader" onclick="loadStoriesReviewed(10)" class="clickable">
	Stories from other learners
	</th>
	</tr>
	
	<tr>
	<th>Author</th><th>Story Title</th><th>Rating Given</th>
	</tr>
	</table>
	</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>