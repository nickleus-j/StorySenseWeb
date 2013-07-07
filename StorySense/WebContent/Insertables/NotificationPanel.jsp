<%@page import="infoResource.LearnerElemAttr"%><%@page import="infoResource.AttributeNames"%>
<%! 
LearnerElemAttr leAttr=new LearnerElemAttr();
String notifPaneId=leAttr.getNotificationPanelId(),listId=leAttr.notificationListId("");
%>
<script>
var Notifications;

function showMessages(Messages,stage){
	var item;
	for(var ctr=0;ctr<Messages.length;ctr++){
		item=document.createElement("li");
		item.innerHTML=Messages[ctr].Message;
		stage.appendChild(item);
	}/*End of loop*/
}

function setUpNotifications(username){
	var xmlhttp=getAJAXRequest();
	var Messages;
	var stage=document.getElementById(<% out.write("\""+listId+"\""); %>),item;
	xmlhttp.onreadystatechange=function(){
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			Notifications=JSON.parse(xmlhttp.responseText);
			for(var ctr=0;ctr<Notifications.length;ctr++){
				Messages=Notifications[ctr].Notifications;
				showMessages(Messages,stage);
			}/*End of loop*/
			if(Notifications=null||Notifications.length==0)
				stage.innerHTML="No notification";
		}
		//else stage.innerHTML="<h1>Broken....</h1>";
	  };
	  
	  xmlhttp.open("GET","learnerNotif?"+<% out.write("\""+AttributeNames.user.toString()+"\"");%>+"="+username,
	  	true);
	  xmlhttp.send();
	
}

function changeToNotifPanel(elemID){
	elem=document.getElementById(elemID);
	elem.setAttribute("class","notifPane");
}

function changeToHidenElem(elemID){
	elem=document.getElementById(elemID);
	elem.setAttribute("class","hiddenElem");
}
</script>
<button onmousedown="changeToNotifPanel(<% out.write("'"+notifPaneId+"'"); %>)">press</button>
<div class="hiddenElem" id=<% out.write("\""+notifPaneId+"\""); %>
	onmouseover="changeToNotifPanel(<% out.write("'"+notifPaneId+"'"); %>)"
	onmouseout="changeToHidenElem(<% out.write("'"+notifPaneId+"'"); %>)">

<h3>Notifications</h3><hr/>
<ul id=<% out.write("\""+listId+"\""); %>>

</ul>
</div>
