<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<tiles:useAttribute id="title" name="title"/>

<html>
<head>
<title><spring:message code="${title}"/></title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="${contextPath}/content/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/content/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/content/css/style.css" />
<link rel="icon" type="image/ico" href="${contextPath}/content/images/heart.ico" />
<script src="${contextPath}/content/js/jquery.js"></script>
<script src="${contextPath}/content/js/bootstrap.js"></script>
<script src="${contextPath}/content/js/bootstrap-alert.js"></script>
<script src="${contextPath}/content/js/scripts.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container">
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>