<%@page import="infoResource.LearnerElemAttr"%><%@page import="infoResource.AttributeNames"%>
<%! 
LearnerElemAttr leAttr=new LearnerElemAttr();
String notifPaneId=leAttr.getNotificationPanelId(),listId=leAttr.notificationListId("");
String notifBtID="notificationButton";
%>
<script>
var Notifications,lastNoticeID=0;

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
	var stage=document.getElementById(<% out.write("\""+listId+"\""); %>);
	xmlhttp.onreadystatechange=function(){
		
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			Notifications=JSON.parse(xmlhttp.responseText);
			for(var ctr=0;ctr<Notifications.length;ctr++){
				Messages=Notifications[ctr].Notifications;
				showMessages(Messages,stage);
				
			}/*End of loop*/
			updateNotificationButton(<%out.write("\""+notifBtID+"\"");%>);
			if(Notifications=null||Notifications.length==0)
				stage.innerHTML="No notification";
			
			
			
		}
		// else stage.innerHTML="<h1>Broken....</h1>";
	  };
	  
	  xmlhttp.open("GET","learnerNotif?"+<% out.write("\""+AttributeNames.user.toString()+"\"");%>+"="+username,
	  	true);
	  xmlhttp.send();
	
}

function viewNotice(){
	var xmlhttp=getAJAXRequest(),elem;
	
	//setUpNotifications(userName);
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		elem=document.getElementById("notificationButton" );
		elem.innerHTML="  --  ";
		};
  
  xmlhttp.open("GET","ViewNotification?noticeID="+lastNoticeID+"&viewStat=1",
  	true);
  xmlhttp.send();
}


function changeToNotifPanel(elemID){
	elem=document.getElementById(elemID);
	elem.setAttribute("class","notifPane");
	if(document.getElementById(elemID).innerHTML!="  --  ")
		viewNotice();
}

function changeToHidenElem(elemID){
	elem=document.getElementById(elemID);
	elem.setAttribute("class","hiddenElem");
}

function updateNotificationButton(elemID){
	elem=document.getElementById(elemID);
	if(Notifications!=null&&Notifications.length>0&&Notifications[0].Viewed=="false"){
		elem.innerHTML="  --  "+Notifications[0].Notifications.length+" -- ";
		lastNoticeID=Notifications[0].nID;
	}
	else elem.innerHTML="  --  ";
	
}

</script>
<button id=<%out.write("\""+notifBtID+"\"");%> 
	onmousedown="changeToNotifPanel(<% out.write("'"+notifPaneId+"'"); %>)">press this</button>
<div class="hiddenElem" id=<% out.write("\""+notifPaneId+"\""); %>
	onmouseover="changeToNotifPanel(<% out.write("'"+notifPaneId+"'"); %>)"
	onmouseout="changeToHidenElem(<% out.write("'"+notifPaneId+"'"); %>)">

<h3>Notifications</h3><hr/>
<ul id=<% out.write("\""+listId+"\""); %>>

</ul>
</div>
