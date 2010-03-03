<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="home"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<script>
function tryAlertRegistrationClose() {
<%
	sg.com.stellarstudios.imser.entity.User user = (sg.com.stellarstudios.imser.entity.User) session.getAttribute("userObject");
  	if (user != null) {
  		pageContext.setAttribute("userRegistration", user.getUserRegistration());
 	}
    java.util.Calendar elevenDec = new java.util.GregorianCalendar();
    elevenDec.set(java.util.Calendar.DAY_OF_MONTH, 12);
    elevenDec.set(java.util.Calendar.MONTH, 11);
    elevenDec.set(java.util.Calendar.YEAR, 2007);
    elevenDec.set(java.util.Calendar.HOUR_OF_DAY, 0);
    elevenDec.set(java.util.Calendar.MINUTE, 0);
    
    pageContext.setAttribute("beforeElevenDec", new Boolean(java.util.Calendar.getInstance().before(elevenDec)));
%>
	<c:if test="${beforeElevenDec == true and userRegistration.registrationStatus != 2}">alert('Registration has closed on 11 Dec 07.');</c:if>
}
</script>  

<body onload="tryAlertRegistrationClose();"/>

<table class="content_table_main">
			<tr>
        		<td>&nbsp;</td>
      		</tr>
      		<tr>
        		<td class="allheader" align="center">Thank you for attending the Hi-5 2008 Partner Summit!</td>
      		</tr>
      		<!-- 
      		<tr>
       			<td align="center"><img src="<c:url value="/images/home-mid.jpg"/>"/></td>
      		</tr>
      		<tr>
       			<td align="center">&nbsp;</td>
      		</tr>
     		<tr>
       			<td align="center"><img src="<c:url value="/images/home-bottom.jpg"/>"/></td>
    		</tr>
    		 -->
      		<tr>
       			<td align="center">&nbsp;</td>
      		</tr>
    		<tr>
       			<td align="center">
					To access the presentations, video and photos from this event, we require your feedback in a brief survey.<br/><br/>
					
					This information will help us to improve future F5 partner events.<br/><br/>
					
					<a href="<c:url value="/restricted/pnpHome.${ext}"/>"><img src="<c:url value="/images/button_start_survey.jpg"/>" border="0"/></a>
				</td>
    		</tr>
</table>

<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>