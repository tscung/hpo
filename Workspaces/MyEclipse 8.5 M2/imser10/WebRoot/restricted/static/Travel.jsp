<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>F5</title>
<link href="<c:url value="reset-min.jpg"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="style.jpg"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/ddaccordion.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/cufon-yui.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/Frutiger_CE_55_Roman_400.font.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/Frutiger_CE_45_Light_300.font.js"/>"></script>
<script type="text/javascript" src="<c:url value="js/Frutiger_CE_45_Light_700.font.js"/>"></script>
<script type="text/javascript">
Cufon.replace('div.regpagetitle, p.reg12pt, p.reg10pt, p.bold12pt, p.bold12ptred, p.reg10ptred,  div.regorangetitle, td.regtitle, span.reg12pt', { fontFamily: 'Frutiger CE 45 Light' });
</script>
<script type="text/javascript" src="<c:url value="js/onload.js"/>"></script>
</head>
<body>
<div id="header"> <img class="logo" src="<c:url value="/images/logo.jpg"/>"/>" width="350" height="92" /> <img class="decortop" src="<c:url value="/images/decor_topright.jpg"/>"/>" width="165" height="65" /> </div>
<div id="leftcol">
  <ul class="nav">
    <li><a href="<c:url value="Home.jsp"/>" >Home</a></li>
    <li><a href="<c:url value="Register.jsp"/>">Register</a></li>
    <li style="padding-top: 5px;">
      <div class="subnavhead">Event Information</div>
      <ul class="subnav">
        <li><a href="<c:url value="Agenda.jsp"/>">agenda</a></li>
        <li><a href="<c:url value="Speakers.jsp"/>">speaker profiles</a></li>
        <li><a href="<c:url value="DressCode.jsp"/>">dress code</a></li>
      </ul>
    </li>
    <li><a href="<c:url value="Venue.jsp"/>">Venue Information</a></li>
    <li><a href="<c:url value="Travel.jsp"/>" class="navactive">Travel Information</a></li>
    <li><a href="<c:url value="Logout.jsp"/>">Log Out</a></li>
  </ul>
</div>
<div id="rightcol">
  <div style="margin: 10px;">
    <p class="bold12ptred">Air Fare</p>
    <p class="reg12pt">The cost for airfare will be borne by F5 in association with our partners. To obtain your flight details, please
      contact your F5 sales person who will assist to make arrangements for your return flight to Singapore. You
      will be required to provide your flight details upon registration.</p>
    <p class="bold12ptred" style="margin-top:30px;">Expenses</p>
    <p class="reg12pt">Hotel room (including tax), breakfast and in-room Internet access will be paid for all attendees staying at The
St Regis Singapore for the 3 nights of May 13th to May 15th. All other incidentals incurred at The St Regis
Singapore will be paid by the individual attendee. All other expenses related to the plenary and breakout
sessions, dining and social events (e.g. Golf, Culture Tour, etc.) outside the hotel will be borne by F5 Networks
as long as they are part of APAC CIO Forum agenda.</p>
    <p class="bold12ptred" style="margin-top:30px;">Food</p>
    <p class="reg12pt">All food and beverages are provided for by F5 Networks from the Welcome Cocktail reception on May 13th
through to Country-hosted Dinners on May 16th.</p><p class="reg12pt" style="margin-top: 10px;">
We will endeavor to cater to all special dietary requirements – halal, vegetarian etc.. Please let us know in
advance using the Special Dietary Request tab in the online registration form.</p><p class="reg12pt" style="margin-top: 10px;">
Please note that meals and drinks consumed by attendees outside of the event agenda (e.g. room minibar,
room service etc) will not be paid for by F5 Networks. These will be charged to your individual room account
and settled by the attendee upon check-out. Thank you for your understanding.</p>
      <p class="bold12ptred" style="margin-top:30px;">Companion/Spouses</p>
    <p class="reg12pt">Companions/Spouses are not included in the APAC CIO Forum and will be excluded from any part of the
conference or activities.</p>
      <p class="bold12ptred" style="margin-top:30px;">Travel Insurance</p>
    <p class="reg12pt">F5 Networks will not be responsible for the attendees’ travel insurance. However, we advise that you purchase
the necessary travel insurance before you leave your respective country.</p>
    <hr style="width:100%;height:1px;background-color:#5B7F8A;border:0;clear:both" />
    <div class="copyright">&copy; 1998- 2010 F5 Networks, Inc. All rights reserved.</div>
    <img id="logo2" src="<c:url value="/images/logo2.jpg"/>"/>" width="116" height="36" /> </div>
</div>
</body>
</html>
