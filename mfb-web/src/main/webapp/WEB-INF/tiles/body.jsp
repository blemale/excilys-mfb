<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header id="overview" class="span10 offset2">		
	<h1><spring:message code="body.title" /></h1>
	<p class="lead"><spring:message code="body.welcome" /></p>
	 <c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION']}">
		<div class="alert alert-error alertDisparait">
			<strong><spring:message code="login.warning" /></strong><br/> <spring:message code="login.badcredential" />
		</div>
		<c:set var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" value="${ null }"/>
	</c:if>
</header>
