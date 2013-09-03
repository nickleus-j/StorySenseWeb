<%@page import="webEncoder.AdminHtmlEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Settings</title>
<script src="Scripts/AJAXscirpts.js"></script>

<script>
<link rel="stylesheet" href="Style/Default.css"> 
function changeSetting(ID,valueSource){
	var xmlhttp=getAJAXRequest();
	var value=document.getElementById(valueSource).value;
	var statusElem=document.getElementById("statusP");
	xmlhttp.onreadystatechange=function(){
		//statusBox.innerHTML="Connecting to Server";
		statusElem.innerHTML="Saving";
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			statusElem.innerHTML="Save Complete";
		}
		else if (xmlhttp.status==500){
			statusElem.innerHTML="Save Failed. Value: "+value+" was rejected";
		}
		else statusElem.innerHTML="Please wait. Value: "+value+" is being processed";
	  };

	  /*Send a request to the server*/
	xmlhttp.open("GET","SettingChanger?ref="+ID+"&value="+value,true);
	xmlhttp.send();
}
</script>

<style>

/*Change style of setting table from here*/
.settingTbl{

}
/*Style for status notice*/
#statusP{
	font-size: 150%;
}

</style>

</head>
<body>
<%@ include file="Insertables/AdminNavBar.jsp" %>
<div id="container">

<% AdminHtmlEncoder adminEnc=new AdminHtmlEncoder();
	out.write(adminEnc.getSettingsHTML());
%>
<hr>
<p id="statusP"></p>
</div>
<%@ include file="Insertables/Footer.jsp" %>

</body>
</html>