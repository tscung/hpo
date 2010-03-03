<%@ include file="/jspf/execTaglibImports.jspf"%>
<%@ include file="/jspf/execStandard.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>F5</title>
		<link href="<c:url value="/css/reset-min.css"/>" rel="stylesheet"
			type="text/css" />
		<link href="<c:url value="css/style.css"/>" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="<c:url value="/js/jquery.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/ddaccordion.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/cufon-yui.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/Frutiger_CE_55_Roman_400.font.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/Frutiger_CE_45_Light_300.font.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/Frutiger_CE_45_Light_700.font.js"/>"></script>
		<script type="text/javascript">
	Cufon.replace('span.dates', {
		fontFamily : 'Frutiger CE 45 Light'
	});
	Cufon.replace('span.toopen', {
		fontFamily : 'Frutiger CE 45 Light'
	});
</script>

		<script type="text/javascript" src="<c:url value="js/onload.js"/>"></script>
	</head>
	<body>
		<div id="header">
			<img class="logo" src="<c:url value="/images/logo.jpg"/>" width="350"
				height="92" />
			<img class="decortop" src="<c:url value="img/decor_topright.jpg"/>"
				width="165" height="65" />
		</div>
		<div id="leftcol">
			<ul class="nav">
    <li><a href="<c:url value="/restricted/getHome.${ext}"/>" >Home</a></li>
    <li><a href="<c:url value="/restricted/getRegister.${ext}"/>">Register</a></li>
    <li style="padding-top: 5px;">
      <div class="subnavhead">Event Information</div>
      <ul class="subnav" style="display: block;">
        <li><a href="<c:url value="/restricted/getAgenda.${ext}"/>" >agenda</a></li>
        <li><a href="<c:url value="/restricted/getSpeakers.${ext}"/>">speaker profiles</a></li>
        <li><a href="<c:url value="/restricted/getDressCode.${ext}"/>" class="navactive">dress code</a></li>
      </ul>
    </li>
    <li><a href="<c:url value="/restricted/getVenue.${ext}"/>">Venue Information</a></li>
    <li><a href="<c:url value="/restricted/getTravel.${ext}"/>">Travel Information</a></li>
    <li><a href="<c:url value="/restricted/getLogout.${ext}"/>">Log Out</a></li>
  </ul>
		</div>
		<div id="rightcol">
			<span class="dates" style="margin: 10px auto auto 10px;">May
				13th:</span>
			<span class="toopen">Smart Casual</span>
			<br />
			<span class="dates" style="margin: 10px auto auto 10px;">May
				14th:</span>
			<span class="toopen">Day Session, Plenary and Breakout
				Sessions – Business Casual</span>
			<br />
			<span class="toopen" style="margin: 10px auto auto 75px;">Evening
				Session, Gala Dinner - Smart Casual</span>
			<div style="height: 400px; width: 20px"></div>
			<hr
				style="margin-top: 24px; width: 78%; height: 1px; background-color: #5B7F8A; border: 0; float: none" />
			<div class="copyright">
				&copy; 1998- 2010 F5 Networks, Inc. All rights reserved.
			</div>
			<img id="logo2" src="<c:url value="/images/logo2.jpg"/>" width="116"
				height="36" />
		</div>
		
	</body>
</html>
