<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/${adminFolder}/header.jsp"><c:param name="currentPg" value="userAccounts"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<c:set var="results" value="${sessionScope.listObject}"/>

<s:form name="deleteForm" action="deleteUserRegistration.${ext}" method="get"><s:hidden name="id"/><s:hidden name="contentOnly" value="false"/></s:form>

<!-- default results per page & current page -->
<%@ include file="/jspf/execDefaultMultipageSettings.jspf" %>

  <table class="content_table_main">
    <tr>
      <td class="allheader" colspan="2">User Registrations</td>
	</tr>
    <tr>
      <td colspan="2">
      <table class="content_table">
		<tr class="table_header_row">
          <td width="5%">S/N</td>
          <td>First Name</td>
          <td>Last Name</td>
          <td>Email</td>
          <td>Company</td>
          <td>Country</td>
          <td>Action(s)</td>
        </tr>
        <c:if test="${not empty results}">
		  <c:forEach var="model" items="${results}" varStatus="status" begin="${resultsPerPage * currentPage}" end="${(resultsPerPage * currentPage) + (resultsPerPage - 1)}">
	        <tr class="table_shade_alt<c:out value="${status.index%2}"/>">
	          <td><c:out value="${status.index+1}"/>.</td>
		      <td><c:out value="${model.firstName}"/></td>
		      <td><c:out value="${model.lastName}"/></td>
		      <td><c:out value="${model.user.email}"/></td>
		      <td><c:out value="${model.company}"/></td>
		      <td><c:out value="${model.country.name}"/></td>
		      <td>
			    <span class="available_actions">
			      <a href="<c:url value="preloadUpdateUserRegistration.${ext}?id=${model.id}&contentOnly=true"/>" target="embeddedFrame">Update</a>/<a href="#" onclick="confirmDelete('<c:out value="${model.id}"/>')">Delete</a>
			    </span>
		      </td>
	        </tr>
		  </c:forEach>
		  <tr><td colspan="7">&nbsp;</td></tr>
		  <tr><td colspan="7" align="right">
		    <s:url value="listing.jsp" includeParams="get" id="strutsurl"><s:param name="currentPage" value=""/><s:param name="resultsPerPage" value=""/><s:param name="totalPages" value=""/></s:url>
		    <s:set name="url" value="strutsurl"/>
		    <misc:printMultiPage urlPageVar="url" resultsPerPagePageVar="resultsPerPage" currentPagePageVar="currentPage" collectionPageVar="results"/>
		  </td></tr>
		</c:if>
		<c:if test="${empty results}"><td colspan="6" valign="top">No records found. Click here to <a href="<c:url value="preloadSearchUserRegistration.${ext}"/>">search</a> again.</td></c:if>      
      </table>
      </td>
    </tr>
  </table>
  <table class="embeddedFrameTable">
    <tr>
      <td colspan="2"><iframe name="embeddedFrame" height="0" width="100%" frameborder="0" marginwidth="0" marginheight="0" id="genericEmbeddedFrame" scrolling="<c:out value="${iframeScolling}"/>">Sorry but your browser doesn't support inline frames. Please get a newer browser.</iframe></td>
    </tr>
  </table>
<c:import url="/${adminFolder}/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>