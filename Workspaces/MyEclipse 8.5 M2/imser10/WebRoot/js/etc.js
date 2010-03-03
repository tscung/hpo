function validateEmail(str) {
		var at="@"
		var dot="."
		var lat=str.indexOf(at)
		var lstr=str.length
		var ldot=str.indexOf(dot)
		if (str.indexOf(at)==-1){
		   alert("Please enter a valid email address.")
		   return false
		}

		if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
		   alert("Please enter a valid email address.")
		   return false
		}

		if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
		    alert("Please enter a valid email address.")
		    return false
		}

		 if (str.indexOf(at,(lat+1))!=-1){
		    alert("Please enter a valid email address.")
		    return false
		 }

		 if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
		    alert("Please enter a valid email address.")
		    return false
		 }

		 if (str.indexOf(dot,(lat+2))==-1){
		    alert("Please enter a valid email address.")
		    return false
		 }
		
		 if (str.indexOf(" ")!=-1){
		    alert("Please enter a valid email address.")
		   return false
		}

	 return true					
}

function resizeIframe(iframeSelf,iframeID) {
  if(self==parent) return false; /* Checks that page is in iframe. */
  else {
    var framePageHeight = document.getElementById(iframeSelf).scrollHeight + 10;
    /* framePage is the ID of the framed page's BODY tag. The added 10 pixels
    prevent an unnecessary scrollbar. */
    parent.document.getElementById(iframeID).height=framePageHeight+"px";
    /* "iframeID" is the ID of the inline frame in the parent page. */
  }
}
function toggleDisplay(elementId) {
	divDisplay = document.getElementById(elementId);
	if (divDisplay.style.display == '') divDisplay.style.display = 'none';
	else divDisplay.style.display = '';
	resizeIframe('iframeSelf','genericEmbeddedFrame');
}
function changeImage(img_name, img_src) {
   document[img_name].src = img_src;
}
function submitenter(myfield,e) {
  var keycode;
  if (window.event) keycode = window.event.keyCode;
  else if (e) keycode = e.which;
  else return true;

  if (keycode == 13) {
   return false;
  }
  else return true;
}
function refresh() {
	//true - request new resource from server
	window.location.reload();
}
function popup(page) {
	var factor=2;
	var aw = screen.availWidth / factor;
	var ah = screen.availHeight / factor;

	//popup = window.open(page,"Popup","dependent=1,,resizable=1,scrollbars=1,status=0");

	day = new Date();
	id = day.getTime();
	eval("page" + id + " = window.open(page, 'popup', 'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=1,height="+ah+",width="+aw+",left = 0,top = 0');");
	//popup.moveTo(0,0);
	//popup.focus();
}
function confirmDelete(id) {
	if (confirm('Confirm delete?')) {
		document.deleteForm.elements['id'].value = id;
		document.deleteForm.submit();
	}
}