<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title><!-- ??? -->
<meta charset="utf-8" />
<link rel="shortcut icon" href="${contextPath}/content/images/favicon.ico" type="image/vnd.microsoft.icon" />
<link rel="stylesheet" type="text/css" href="${contextPath}/content/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/content/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/content/css/style.css" />
<link rel="icon" type="image/ico" href="${contextPath}/content/img/heart.ico" />
<script src="${contextPath}/content/js/jquery.js"></script>
<script src="${contextPath}/content/js/bootstrap.js"></script>
<script src="${contextPath}/content/js/bootstrap-alert.js"></script>
<script>
	$(document).ready(function() {
		$(".alert").fadeOut(10000);
	});
</script>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container">
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>