<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span10 offset2">
	<h1>
		<spring:message code="home.title" />
	</h1>
	<p class="lead">
		<spring:message code="home.welcome" />
	</p>

</header>

<section id="confirmVirement">
	<div class="row">
		<div class="span4 offset4 alignCenter">
			<c:choose>
				<c:when test="${not empty isOK }">
					<div class="alert alert-info">
						<spring:message code="${message}" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-error">
						<spring:message code="${message}" />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</section>