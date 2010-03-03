<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/${adminFolder}/header.jsp"><c:param name="currentPg" value="userRegistrations"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<c:if test="${param.archivePage != true}">
	<c:if test="${not empty preloadData.disapproved}"><body onload="toggleDisplay('entriesRejected');"/></c:if>
	
	<script src="<c:url value="/dwr/interface/UserRegistrationAction.js"/>"></script>
	<%@include file="/jspf/jsLoadAjaxDWR.jspf" %>
	
	<script>
	function approve(id) {
		UserRegistrationAction.updateApprovedStatus(id, true, approve_callback);
	}
	function approve_callback(data) {
		if (data) {
			alert('User registration approved. Page will now refresh.');
			refresh();
		}
		else {
			alert('User registration not approved. Please try again.');
		}
	}
	function reject(id) {
		UserRegistrationAction.updateApprovedStatus(id, false, reject_callback);
	}
	function reject_callback(data) {
		if (data) {
			alert('User registration rejected. Page will now refresh.');
			refresh();
		}
		else {
			alert('User registration not rejected. Please try again.');
		}
	}
	</script>
</c:if>
	
<table class="content_table_main">
  <tr>
    <td <c:if test="${param.archivePage != true or not empty preloadData.notApprovedYet or not empty preloadData.disapproved}">width="40%"</c:if>>
<!-- ARCHIVAL TABLE -->
		<table width="100%">
		 <c:if test="${param.archivePage != true}">
		  <tr><td class="allheader">Summary</td></tr>
		  <tr><td><c:out value="${preloadData.dataFigureSubmitted}"/> record(s) have been submitted. <a href="<c:url value="retrieveAllSubmittedUserRegistration.${ext}"/>">Download</a></td></tr>
		  <tr><td>&nbsp;</td></tr>
		  <tr><td><c:out value="${preloadData.dataFigureSaved}"/> record(s) have been saved. <a href="<c:url value="retrieveAllSavedUserRegistration.${ext}"/>">Download</a></td></tr>
		 </c:if>
		
		 <c:if test="${param.archivePage == true}">
		  <tr><td class="allheader">Archives - Daily Reports</td></tr>
		 </c:if>
		 
		 <c:if test="${not empty preloadData.submittedDates}">
		   <c:if test="${param.archivePage != true}">
		     <tr><td>&nbsp;</td></tr>
		     <tr><td class="allheader">Today's Submission</td></tr>  
		   </c:if>
		   <c:forEach var="date" items="${preloadData.submittedDates}">
		     <tr><td><a href="<c:url value="retrieveByDateSubmittedUserRegistration.${ext}?date=${date}"/>"><c:out value="${date}"/> Download</a></td></tr>
		   </c:forEach>
		 </c:if>
		 <c:if test="${param.archivePage == true and empty preloadData.submittedDates}">
		   <tr><td>No records found.</td></tr>
		 </c:if>
		</table>
    </td>
<!-- END ARCHIVAL TABLE -->

<!-- DISPLAY APPROVAL TABLE -->
<c:if test="${param.archivePage != true and (not empty preloadData.notApprovedYet or not empty preloadData.disapproved)}">
    <td width="60%">
	  <table width="100%">
	    <c:if test="${not empty preloadData.notApprovedYet}">
	      <tr><td colspan="2" class="allheader">Entries Pending Approval</td></tr>
	      <tr><td colspan="2">
	        <table border="1" bordercolor="#000" cellpadding="3" width="100%">
	          <c:forEach var="userRegistration" items="${preloadData.notApprovedYet}">
	            <tr>
	              <td><a href="<c:url value="/${adminFolder}/userRegistrations/preloadUpdateUserRegistration.${ext}?id=${userRegistration.id}"/>" target="_blank"><c:out value="${userRegistration.firstName}"/> <c:out value="${userRegistration.lastName}"/></a></td>
	              <td width="25%"><a href="#" onclick="approve(<c:out value="${userRegistration.id}"/>, true);">Approve</a>/<a href="#" onclick="reject(<c:out value="${userRegistration.id}"/>, false);">Reject</a></td>
	            </tr>
	          </c:forEach>
	        </table>
	      </td></tr>
	    </c:if>
	    
	    <c:if test="${not empty preloadData.disapproved}">
	      <tr><td class="allheader">Entries Rejected</td><td align="right" valign="middle"><input type="button" class="tight_button" value="Toggle display" onclick="toggleDisplay('entriesRejected');"/></td></tr>      
	      <tr><td colspan="2">
	        <table id="entriesRejected" border="1" bordercolor="#000" cellpadding="3" width="100%">
	          <c:forEach var="userRegistration" items="${preloadData.disapproved}">
	            <tr>
	              <td><a href="<c:url value="/${adminFolder}/userRegistrations/preloadUpdateUserRegistration.${ext}?id=${userRegistration.id}"/>" target="_blank"><c:out value="${userRegistration.firstName}"/> <c:out value="${userRegistration.lastName}"/></a></td>
	              <td width="25%"><a href="#" onclick="approve(<c:out value="${userRegistration.id}"/>, true);">Approve</a></td>
	            </tr>
	          </c:forEach>
	        </table>
	      </td></tr>
	    </c:if>
	  </table>
    </td>
</c:if>    
<!-- END DISPLAY APPROVAL TABLE -->
  </tr>
  <tr><td>&nbsp;</td></tr>
  <tr><td>Click <a href="<c:url value="/${adminFolder}/userRegistrations/preloadReminderEmailUserRegistration.${ext}"/>">here</a> to send a reminder email.</td></tr>
  <tr><td>&nbsp;</td></tr>
  <tr><td><a href="<c:url value="retrieveAllEvaluationFormsUserRegistration.${ext}"/>">Download Evaluation Forms</a></td></tr>  
</table>
<c:import url="/${adminFolder}/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>