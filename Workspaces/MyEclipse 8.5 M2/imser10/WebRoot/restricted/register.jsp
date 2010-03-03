<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="register"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<%
  pageContext.setAttribute("submitted", new Integer(sg.com.stellarstudios.imser.common.GlobalKeys.REGISTRATION_STATUS_SUBMITTED));
  pageContext.setAttribute("saved", new Integer(sg.com.stellarstudios.imser.common.GlobalKeys.REGISTRATION_STATUS_SAVED)); 

  java.util.Calendar elevenDec = new java.util.GregorianCalendar();
  elevenDec.set(java.util.Calendar.DAY_OF_MONTH, 12);
  elevenDec.set(java.util.Calendar.MONTH, 11);
  elevenDec.set(java.util.Calendar.YEAR, 2007);
  elevenDec.set(java.util.Calendar.HOUR_OF_DAY, 0);
  elevenDec.set(java.util.Calendar.MINUTE, 0);
  
  pageContext.setAttribute("afterElevenDec", new Boolean(java.util.Calendar.getInstance().after(elevenDec)));
  
  java.util.Calendar thirdJan = new java.util.GregorianCalendar();
  thirdJan.set(java.util.Calendar.DAY_OF_MONTH, 4);
  thirdJan.set(java.util.Calendar.MONTH, 0);
  thirdJan.set(java.util.Calendar.YEAR, 2008);
  thirdJan.set(java.util.Calendar.HOUR_OF_DAY, 0);
  thirdJan.set(java.util.Calendar.MINUTE, 0);
  
  pageContext.setAttribute("afterThirdJan", new Boolean(java.util.Calendar.getInstance().after(thirdJan)));
%>
<c:set var="allowPageEntry" value="${sessionScope.userObject.email == 'stellarstudios@gmail.com'}"/>

<c:choose>
  <c:when test="${allowPageEntry == false and (afterElevenDec == true and model.f5Staff == false and model.privilegedUser == false)}">
    <table class="content_table_main">
      <tr><td>&nbsp;</td></tr>
      <tr><td colspan="2" align="center">
        <span class="highlight">Registration has closed on 11 Dec 2007.</span>
      </td></tr>
   	</table>
  </c:when>
  <c:otherwise>
    <c:choose>
	  <c:when test="${allowPageEntry == false and (afterThirdJan == true and model.privilegedUser == false)}">
	    <table class="content_table_main">
	      <tr><td>&nbsp;</td></tr>
	      <tr><td colspan="2" align="center">
	        <span class="highlight">Registration has closed on 3rd Jan 2008.</span>
	      </td></tr>
	   	</table>
	  </c:when>
	  <c:otherwise>
		<c:choose>
		  <c:when test="${model.registrationStatus != submitted}">
		        
			<%@include file="/jspf/jsLoadCalendar.jspf" %>
			<script>
			function validate() {
				success = true;
				
				form = document.mainForm;
			
				return success;
			}
			function alertSaveOnly() {
				alert('Your information has not been submitted for registration. No reservations have been made for your hotel accomodation, airport transfer or social activities. Please return and submit your registration before Nov, 30th.');
			}
			</script>
			
			<s:bean name="java.util.HashMap" id="qTableLayout"><s:param name="tablecolspan" value="2"/></s:bean>
		
		  <img id="loadingImage" src="<c:url value="/images/loadingAnimation.gif"/>" style="display:none"/>
		    <s:form name="mainForm" target="_top" cssClass="content_table_main" theme="qxhtml" onsubmit="return validate();">
			  <tr><td colspan="2" class="allheader">Register</td></tr>
		      <tr><td colspan="2">Please complete the following form to register for the F5 Pump It Up Hi-5 Annual Partner Submit</td></tr>
		      <tr><td class="registerred" colspan="2">* Indicates a required field.<br/><br/><s:actionmessage theme="simple" /><s:actionerror theme="simple" /></td></tr>
		
			  <%@include file="/jspf/templateRegister.jspf" %>
		      
		      <tr><td colspan="2">&nbsp;</td></tr>
		      <tr><td colspan="2">&nbsp;</td></tr>
		
		      <tr><td colspan="2"><div align="center"><span class="highlight">Please review your information prior to submitting your registration.</span></div></td></tr>
		      <tr>
		        <td colspan="2" align="center">
		          <input type="button" value="Submit Registration" class="form_button" onclick="this.form.action='<c:url value="/restricted/makeNewUserRegistration.${ext}"/>';this.form.submit();"/>
		          <s:reset value="Reset Form" cssClass="form_button" theme="simple"/>
		          <input type="button" value="Save" class="form_button" onclick="alertSaveOnly();this.form.action='<c:url value="/restricted/saveOnlyUserRegistration.${ext}"/>';this.form.submit();"/>
		        </td>
		      </tr>
		    </s:form>
		    
		  </c:when>
		  <c:otherwise>
		    <table class="content_table_main">
		      <tr><td>&nbsp;</td></tr>
		      <tr><td colspan="2" align="center">
		        <span class="highlight">
		          <c:choose>
		            <c:when test="${model.approvedStatus == 2}">
		              You have already submitted your registration on <misc:printDateTime property="model.dateSaved"/>.<br/>
		              For changes, please contact the <a href="mailto:eventteam@hi5event.com">Hi-5 event organizer</a>.
		            </c:when>
		            <c:otherwise>
		              <span class="success_register">Thank you for your registration.<br/>A confirmation email will be sent to you within 48 hrs.</span>
		            </c:otherwise>
		          </c:choose>
		        </span>
		      </td></tr>
		   	</table>
		  </c:otherwise>
		</c:choose>  	  
	  </c:otherwise>    
    </c:choose>
  </c:otherwise>
</c:choose>

<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>