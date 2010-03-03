<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Hi-5 2008</title>
<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>
<style>
body {
	font-family: Arial;
	font-size: 14px;
	background: white;
}
.maintable {
	width: 900px;
	border-top: 1px solid #999;
	border-bottom: 1px solid #999;
	border-right: 1px solid #999;
	border-left: 1px solid #999;
}
.congrats {
	font-family: Arial;
	font-size: 20px;
	color: #CA0034;
	font-style: italic;
}
.tableleft {
	width: 100%;
}
.tableheader {
	font-family: Arial;
	font-size: 14px;
	color: #FFFFFF;
	font-weight: bold;
	background-color: #CA0034;
}
.notered {
	font-family: Arial;
	color: #CA003A;
	font-size: 12px;
	font-weight: bold;
}
</style>
</head>

<body>
<%
sg.com.stellarstudios.imser.service.ConfigurationService configurationService = (sg.com.stellarstudios.imser.service.ConfigurationService) sg.com.stellarstudios.imser.common.ServiceLocator.getInstance().getApplicationContext().getBean("configurationService");
%>
<img src="http://www.hi5event.com/images/email_header.jpg" width="900" height="208">
<br>
<span class="congrats">You've successfully submitted your registration for Pump It Up Hi-5 2008.</span><br/>
<br><strong>Your registration information are as follows:-</strong><br/>
<br>
<table class="maintable">
  <tr>
    <td class="tableheader">Personal Information</td>
  </tr>
  <tr>
    <td class="tableleft">First Name: <c:out value="${model.firstName}"/></td>
  </tr>
  <tr>
    <td class="tableleft">Last Name: <c:out value="${model.lastName}"/></td>
  </tr>
  <tr>
    <td class="tableleft">Title: <c:out value="${model.title}"/></td>
  </tr>
  <tr>
    <td class="tableleft">Company: <c:out value="${model.company}"/></td>
  </tr>
  <tr>
    <td class="tableleft">Address 1: <c:out value="${model.address1}"/></td>
  </tr>
  <c:if test="${not empty model.address2}">
    <tr>
      <td class="tableleft">Address 2: <c:out value="${model.address2}"/></td>
    </tr>
  </c:if>
  <tr>
    <td class="tableleft">Postal Code: <c:out value="${model.postalCode}"/></td>
  </tr>
  <tr>
    <td class="tableleft">Email: <c:out value="${model.user.email}"/></td>
  </tr>
  <tr>
    <td class="tableleft">Country: <c:out value="${model.country.name}"/></td>
  </tr>
  <tr>
    <td class="tableleft">City: <c:out value="${model.city}"/></td>
  </tr>
  <tr>
    <td class="tableleft">Phone: <c:out value="${model.phone}"/></td>
  </tr>
  <c:if test="${not empty model.fax}">
    <tr>
      <td class="tableleft">Fax: <c:out value="${model.fax}"/></td>
    </tr>
  </c:if>
  <c:if test="${not empty model.additionalInfoSpecialDietaryNeeds or not empty model.additionalInfoSpecialNeeds}">
    <tr>
      <td class="tableheader">Additional Information</td>
    </tr>
    <c:if test="${not empty model.additionalInfoSpecialDietaryNeeds}">
      <tr>
        <td class="tableleft">Special Dietary Needs: <c:out value="${model.additionalInfoSpecialDietaryNeeds}"/></td>
      </tr>
    </c:if>
    <c:if test="${not empty model.additionalInfoSpecialNeeds}">
      <tr>
        <td class="tableleft">Special Needs: <c:out value="${model.additionalInfoSpecialNeeds}"/></td>
      </tr>
    </c:if>
  </c:if>
  <tr>
    <td class="tableleft">Shirt Size: <c:out value="${model.shirtSize}"/></td>
  </tr>
  <tr>
    <td class="tableleft"><c:choose><c:when test="${model.fromSingapore == true}">Yes, I'm an attendee from Malaysia.</c:when><c:otherwise>No, I'm not an attendee from Malaysia.</c:otherwise></c:choose></td>
  </tr>
  <c:if test="${model.fromSingapore == false}">
    <c:if test="${not empty model.flightInfoArrivalAirline or not empty model.flightInfoArrivalFlightNo or not empty model.flightInfoArrivalDate or not empty model.flightInfoArrivalTime or not empty model.flightInfoSpecialArrivalRqmt or not empty model.flightInfoDepartureAirline or not empty model.flightInfoDepartureFlightNo or not empty model.flightInfoDepartureDate or not empty model.flightInfoDepartureTime or not empty model.flightInfoSpecialDepartureRqmt}">
	  <tr>
	    <td class="tableheader">Flight Information</td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoArrivalAirline}">
	  <tr>
	    <td class="tableleft">Arrival Airline: <c:out value="${model.flightInfoArrivalAirline}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoArrivalFlightNo}">
	  <tr>
	    <td class="tableleft">Arrival Flight No: <c:out value="${model.flightInfoArrivalFlightNo}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoArrivalDate}">
	  <tr>
	    <td class="tableleft">Arrival Date: <misc:printDate property="model.flightInfoArrivalDate"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoArrivalTime}">
	  <tr>
	    <td class="tableleft">Arrival Time: <c:out value="${model.flightInfoArrivalTime}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoSpecialArrivalRqmt}">
	  <tr>
	    <td class="tableleft">Special Arrival Requirement: <c:out value="${model.flightInfoSpecialArrivalRqmt}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoDepartureAirline}">
	  <tr>
	    <td class="tableleft">Departure Airline: <c:out value="${model.flightInfoDepartureAirline}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoDepartureFlightNo}">
	  <tr>
	    <td class="tableleft">Departure Flight No: <c:out value="${model.flightInfoDepartureFlightNo}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoDepartureDate}">
	  <tr>
	    <td class="tableleft">Departure Date: <misc:printDate property="model.flightInfoDepartureDate"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoDepartureTime}">
	  <tr>
	    <td class="tableleft">Departure Time: <c:out value="${model.flightInfoDepartureTime}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.flightInfoSpecialDepartureRqmt}">
	  <tr>
	    <td class="tableleft">Special Departure Requirement: <c:out value="${model.flightInfoSpecialDepartureRqmt}"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.hotelCheckinDate or not empty model.hotelCheckoutDate or not empty model.hotelSmokingRoom}">
	  <tr>
	    <td class="tableheader">Hotel Accomodation</td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.hotelCheckinDate}">
	  <tr>
	    <td class="tableleft">Check In Date: <misc:printDate property="model.hotelCheckinDate"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.hotelCheckoutDate}">
	  <tr>
	    <td class="tableleft">Check Out Date: <misc:printDate property="model.hotelCheckoutDate"/></td>
	  </tr>
	</c:if>
    <c:if test="${not empty model.hotelSmokingRoom}">
	  <tr>
	    <td class="tableleft">Smoking Room?: <c:choose><c:when test="${model.hotelSmokingRoom == true}">Yes</c:when><c:otherwise>No</c:otherwise></c:choose></td>
	  </tr>
	</c:if>
    <c:if test="${preloadData.displayHotelNote == true}">
	  <tr>
	    <td class="tableleft"><span class="notered">Note: Hotel rooms from 28 - 30 January 2008 will be paid by F5 Networks. Additional costs incurred due to room nights outside this period will be borne by respective guests.</span></td>
	  </tr>
	</c:if>
  </c:if>
  <tr>
    <td class="tableheader">Pump It Up Hi-5 Track - 29 Jan 2008</td>
  </tr>
  <tr>
    <td class="tableleft">
	<c:if test="${model.track == 1}"><c:set var="track" value="Sales Track"/></c:if>
	<c:if test="${model.track == 2}"><c:set var="track" value="Technical Track"/></c:if>
	<c:if test="${model.track == 3}"><c:set var="track" value="Business Track"/></c:if>
	You've selected <c:out value="${track}" escapeXml="false"/>.
    </td>
  </tr>
  <c:if test="${not empty model.coolDownSocialEvents and model.coolDownSocialEvents != 0}">
	  <tr>
	    <td class="tableheader">Social Activities - 30 Jan 2008</td>
	  </tr>
	  <tr>
	    <td class="tableleft">
		<c:if test="${model.coolDownSocialEvents == 1}"><c:set var="socialEvents" value="Third F5 Hi-5 Golf Tournament"/></c:if>
		<c:if test="${model.coolDownSocialEvents == 2}"><c:set var="socialEvents" value="Go-Kart at Sepang International Circuit"/></c:if>
		<c:if test="${model.coolDownSocialEvents == 3}"><c:set var="socialEvents" value="Horse Back Riding at Taman Equnie Club"/></c:if>
		<c:if test="${model.coolDownSocialEvents == 4}"><c:set var="socialEvents" value="Spa Indrani @ StarHill Gallery"/></c:if>
		<c:if test="${model.coolDownSocialEvents == 5}"><c:set var="socialEvents" value="City Tour of Kuala Lumpur"/></c:if>		
		<c:if test="${model.coolDownSocialEvents == 6}"><c:set var="socialEvents" value="None of the Above"/></c:if>
		You've selected <c:out value="${socialEvents}"/>.
		</td>
	  </tr>
  </c:if>
  <c:if test="${model.coolDownSocialEvents == 1}">
	  <tr>
	    <td class="tableleft">
		No. of Handicap: <c:out value="${model.golfNoOfHandicap}"/>
		</td>
	  </tr>
  </c:if>
</table>
<br/>
<p>This is a system generated e-mail.<br>
If you wish to amend your travel details, please e-mail <a href="mailto:eventteam@hi5event.com">event organiser</a> for changes.</p>

<p>Regards.<br>
Pump It Up Hi-5 2008 Committee</p>

</body>
</html>