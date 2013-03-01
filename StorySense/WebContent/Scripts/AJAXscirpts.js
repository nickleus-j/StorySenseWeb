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


/*
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","getcustomer.asp?q="+str,true);LikeChanger
xmlhttp.send();*/

function showNumberOfLikes(elemID,storyID){
var xmlhttp=getAJAXRequest();
if (elemID==null||elemID=="")
  {
  document.getElementById(elemID).innerHTML="";
  return;
  }

xmlhttp.onreadystatechange=function()
{
if (xmlhttp.readyState==4 && xmlhttp.status==200)
  {
  document.getElementById(elemID).innerHTML=xmlhttp.responseText;
  }
}

xmlhttp.open("GET","LikeChanger?q="+storyID,true);
xmlhttp.send();

}

