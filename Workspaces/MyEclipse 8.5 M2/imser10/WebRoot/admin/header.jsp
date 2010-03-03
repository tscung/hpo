<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Pump It Up Hi-5 2008</title>
    
    <link href="<c:url value="/css/styles.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/css/table.css"/>" rel="stylesheet" type="text/css" />
    
	<%@include file="/jspf/etcFunctions.jspf" %>	
  </head>
  
  <%@include file="/jspf/jsAdmin.jspf" %>

  <table class="mainTable" cellpadding="0" cellspacing="0" align="center">

  <c:if test="${param.contentOnly != true}">  
    <tr>
      <td class="tableTopLeft"><img src="<c:url value="/images/top-left.jpg"/>"></td>
      <td background="<c:url value="/images/top-rightbg.jpg"/>"><img src="<c:url value="/images/top-right.jpg"/>"></td>
    </tr>
    <tr>
      <td class="naviBar" align="center">
      	<c:choose><c:when test="${param.currentPg == 'records'}"><c:set var="recordsImg" value="yellow"/></c:when><c:otherwise><c:set var="recordsImg" value="white"/></c:otherwise></c:choose>
      	<c:choose><c:when test="${param.currentPg == 'archives'}"><c:set var="archivesImg" value="yellow"/></c:when><c:otherwise><c:set var="archivesImg" value="white"/></c:otherwise></c:choose>
      	<c:choose><c:when test="${param.currentPg == 'search'}"><c:set var="searchImg" value="yellow"/></c:when><c:otherwise><c:set var="searchImg" value="white"/></c:otherwise></c:choose>

        <p><a href="<c:url value="/${adminFolder}/userRegistrations/preloadSelectTemplateUserRegistration.${ext}"/>" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('records','','<c:url value="/images/nav/admin-records-yellow.jpg"/>',1)"><img src="<c:url value="/images/nav/admin-records-${recordsImg}.jpg"/>" name="records" width="150" height="40" border="0"></a></p>	      	          
        
      	<p><a href="<c:url value="/${adminFolder}/userRegistrations/preloadSelectTemplateUserRegistration.${ext}?archivePage=true"/>" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('archives','','<c:url value="/images/nav/admin-archives-yellow.jpg"/>',1)"><img src="<c:url value="/images/nav/admin-archives-${archivesImg}.jpg"/>" name="archives" width="150" height="40" border="0"></a></p>
      
      	<p><a href="<c:url value="/${adminFolder}/userRegistrations/preloadSearchUserRegistration.${ext}"/>" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('search','','<c:url value="/images/nav/admin-search-yellow.jpg"/>',1)"><img src="<c:url value="/images/nav/admin-search-${searchImg}.jpg"/>" name="search" width="150" height="40" border="0"></a></p>

		<p><a href="<c:url value="/${adminFolder}/logoutUser.${ext}"/>" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('logout','','<c:url value="/images/nav/logout-yellow.jpg"/>',1)"><img src="<c:url value="/images/nav/logout-white.jpg"/>" name="logout" width="150" height="40" border="0"></a></p>
		<br/><br/><br/><br/>
      </td>
      <td width="100%">
  </c:if>