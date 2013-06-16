<%@page import="infoResource.LearnerElemAttr"%><%@page import="infoResource.AttributeNames"%>
<%! 
LearnerElemAttr leAttr=new LearnerElemAttr();
String notifPaneId=leAttr.getNotificationPanelId(),listId=leAttr.notificationListId(""); %>
<script>
var Messages;
function setUpNotifications(username){
	var xmlhttp=getAJAXRequest();
	var stage=document.getElementById(<% out.write("\""+listId+"\""); %>),item;
	xmlhttp.onreadystatechange=function(){
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			Messages=JSON.parse(xmlhttp.responseText);
			for(var ctr=0;ctr<Messages.length;ctr++){
				item=document.createElement("li");
				item.innerHTML=Messages[ctr].Message;
				stage.appendChild(item);
			}/*End of loop*/
		}
		//else stage.innerHTML="<h1>Broken....</h1>";
	  };
	  
	  xmlhttp.open("GET","learnerNotif?"+<% out.write("\""+AttributeNames.user.toString()+"\"");%>+"="+username,
	  	true);
	  xmlhttp.send();
	
}

function showNotifications(username){
	var stage=document.getElementById(<% out.write("\""+listId+"\""); %>),item;
	setUpNotifications(username);
	
	//stage.innerHTML="";
	
	
}

</script>
<div class="notifPane" id=<% out.write("\""+notifPaneId+"\""); %>>
<h3>Notifications</h3><hr/>
<ul id=<% out.write("\""+listId+"\""); %>>

</ul>
</div>