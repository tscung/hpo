<%@ include file="/jspf/execTaglibImports.jspf"%>
<%@ include file="/jspf/execStandard.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>F5</title>
		<link href="<c:url value="/css/reset-min.css"/>" rel="stylesheet"
			type="text/css" />
		<link href="<c:url value="/css/style.css"/>" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="<c:url value="/js/jquery.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/ddaccordion.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/cufon-yui.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/Frutiger_CE_55_Roman_400.font.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/Frutiger_CE_55_Roman_italic_700.fontfull.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/Frutiger_CE_45_Light_300.font.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/js/Frutiger_CE_45_Light_700.font.js"/>"></script>
		<script type="text/javascript">
	Cufon.replace('div.agendadate', {
		fontFamily : 'Frutiger CE 55 Roman'
	});
	Cufon.replace('div.agendatitle, td.num, td.events, p.reg12pt', {
		fontFamily : 'Frutiger CE 45 Light'
	});
</script>
		<script type="text/javascript" src="<c:url value="js/onload.js"/>"></script>
	</head>
	<body>
		<div id="header">
			<img class="logo" src="<c:url value="img/logo.jpg"/>" width="350"
				height="92" />
			<img class="decortop"
				src="<c:url value="images/decor_topright.jpg"/>" width="165"
				height="65" />
		</div>
		<div id="leftcol">
			<ul class="nav">
				<li>
					<c:choose>
						<c:when test="${param.currentPg == 'home'}">
							<a href="<c:url value="/restricted/getHome.${ext}"/>"
								class="navactive">Home</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/restricted/getHome.${ext}"/>">Home</a>
						</c:otherwise>
					</c:choose>

				</li>
				<li>
					<c:choose>
						<c:when test="${param.currentPg == 'register'}">
							<a href="<c:url value="/restricted/getRegister.${ext}"/>"
								class="navactive">Register</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/restricted/getRegister.${ext}"/>">Register</a>
						</c:otherwise>
					</c:choose>
				</li>
				<li style="padding-top: 5px;">
					<div class="subnavhead">
						Event Information
					</div>

					<c:choose>
						<c:when
							test="${(param.currentPg == 'agenda') or (param.currentPg == 'speakers') or (param.currentPg == 'dresscode')}">
							<ul class="subnav" style="display: block">
						</c:when>
						<c:otherwise>
							<ul class="subnav">
						</c:otherwise>
					</c:choose>
				<li>
					<c:choose>
						<c:when test="${(param.currentPg == 'agenda')}">
							<a href="<c:url value="/restricted/getAgenda.${ext}"/>"
								class="navactive">agenda</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/restricted/getAgenda.${ext}"/>">agenda</a>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${param.currentPg == 'speakers'}">
							<a href="<c:url value="/restricted/getSpeakers.${ext}"/>"
								class="navactive">speaker profiles</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/restricted/getSpeakers.${ext}"/>">speaker profiles</a>
						</c:otherwise>
					</c:choose>
				</li>
				<li>
					<c:choose>
						<c:when test="${param.currentPg == 'venue'}">
							<a href="<c:url value="/restricted/getDressCode.${ext}"/>"
								class="navactive">dress code</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/restricted/getDressCode.${ext}"/>">dress code</a>
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
			</li>
			<li>
				<li>
					<c:choose>
						<c:when test="${param.currentPg == 'venue'}">
							<a href="<c:url value="/restricted/getRegister.${ext}"/>"
								class="navactive">Venue Information</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/restricted/getRegister.${ext}"/>">Venue
								Information</a>
						</c:otherwise>
					</c:choose>
				</li>
			</li>
			<li>
				<li>
					<c:choose>
						<c:when test="${param.currentPg == 'travel'}">
							<a href="<c:url value="/restricted/getRegister.${ext}"/>"
								class="navactive">Travel Infomation</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/restricted/getRegister.${ext}"/>">Travel
								information</a>
						</c:otherwise>
					</c:choose>
				</li>
			</li>
			<li>
				<a href="<c:url value="/restricted/getLogout.${ext}"/>">Log Out</a>
			</li>
			</ul>
		</div>
		<div id="rightcol">