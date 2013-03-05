<script language="javascript"> 
function toggle() {
	var ele = document.getElementById("toggleText");
	var text = document.getElementById("displayText");
	if(ele.style.display == "block") {
    		ele.style.display = "none";
		text.innerHTML = "show";
  	}
	else {
		ele.style.display = "block";
		text.innerHTML = "hide";
	}
}


function showonlyonev2(thechosenone) {
    var newboxes = document.getElementsByTagName("div");
    for(var x=0; x<newboxes.length; x++) {
          name = newboxes[x].getAttribute("class");
          if (name == 'newboxes-2') {
                if (newboxes[x].id == thechosenone) {
                      if (newboxes[x].style.display == 'block') {
                            newboxes[x].style.display = 'none';
                      }
                      else {
                            newboxes[x].style.display = 'block';
                      }
                }else {
                      newboxes[x].style.display = 'none';
                }
          }
    }
}
</script>