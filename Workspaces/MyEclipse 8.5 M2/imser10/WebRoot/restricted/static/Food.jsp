<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="food"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

	 	<table class="content_table_main">
		<tr>
            <td class="allheader">Food</td>
        </tr>
        <tr>
        	<td>All food and beverages are provided for by F5 Networks from the "Hi-5 Arrival Cocktails" reception on Jan 28th through to lunch on Jan 30th. A highlight of this will be the F5 Partner Awards Gala on the evening of Jan 29th.<br>
				<br>All food served will be halal, and other special meals will be catered for - vegeterian, etc. Please let us know in advance using the Special Dietary Request tab in the online registration form.<br>
				<br>Please note that meals and drinks consumed by attendees outside of the event agenda (eg: room minibar, room service etc) will not be paid for by F5 Networks. These will be charged to your individual room account and settled by the attendee upon check-out. Thank you for your understanding.
			</td>
        </tr>
        </table>

<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>