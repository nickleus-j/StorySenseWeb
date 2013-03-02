/**
	This File is for ajax javascript events
*/
function getAJAXRequest(){
	try {// Non IE Browser?
		var request = new XMLHttpRequest();
	}
	catch(e1)	{
		try{ // IE 6+?
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e2){
			try {// IE 5?

				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e3){ // There is no Ajax Support
				request = false;
			}
		}
	}
	return request;
}


function showNumberOfLikes(elemID,storyID,res,btIDElemName){
var xmlhttp=getAJAXRequest();
var bt=document.getElementById(btIDElemName);
if (elemID==null||elemID=="")
  {
  document.getElementById(elemID).innerHTML="";
  return;
  }

xmlhttp.onreadystatechange=function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		document.getElementById(elemID).innerHTML=xmlhttp.responseText;
	}
  };

xmlhttp.open("GET","LikeChanger?q="+storyID+"&res="+res,true);
xmlhttp.send();


var dislikeFunction="showNumberOfLikes('"+elemID+"'," +storyID+","+"'--','"+btIDElemName+"')";
var likeFunction="showNumberOfLikes('"+elemID+"'," +storyID+","+"'like','"+btIDElemName+"')";

if(res=="like"){
	bt.innerHTML="Like No more";
	bt.setAttribute("onclick",dislikeFunction);
}
else{
	bt.innerHTML="Like";
	bt.setAttribute("onclick",likeFunction);
}

}

