<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<header id="overview" class="span10 offset2">		
	<h1><spring:message code="body.title" /></h1>
	<p class="lead"><spring:message code="body.welcome" /></p>
</header>
