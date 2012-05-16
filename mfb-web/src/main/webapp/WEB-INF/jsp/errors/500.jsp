<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">
	<header id="overview" class="span8 offset2">		
		<div id="colore500"><h1><spring:message code="500.title" /></h1></div>
		<p class="lead"><spring:message code="500.explanation" /></p>
	</header>
	<section class="span4 offset8">
		<p class="lead"><a href="${contextPath}"><spring:message code="500.redirectionLink" /></a></p>
	</section>
</div>