<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span10 offset1">
	<h1>
		<spring:message code="admin.home.title" />
	</h1>
	<p class="lead">
		<spring:message code="admin.home.welcome" />
	</p>
</header>

<section id="admin">
	<div class="row">
		<%@ include file="common/formSelection.jsp"%>

		<div class="span10 offset1">
			<p class="lead">
				<spring:message code="admin.home.presentation" />
			</p>

		</div>
	</div>
</section>
