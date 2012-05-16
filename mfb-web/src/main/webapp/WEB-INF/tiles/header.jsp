<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="${contextPath}">
				<spring:message code="header.title" />
			</a>
			<form class="navbar-form form-inline pull-right">
				<input type="text" id="form-top" class="input-small form-top" placeholder="<spring:message code="header.placeholder.login" />">
				<input type="password" id="form-top" class="input-small form-top" placeholder="<spring:message code="header.placeholder.password" />">
				<button type="submit" class="btn">
					<spring:message code="header.connection" />
				</button>
				<a href="?lang=en">en</a> | <a href="?lang=fr">fr</a>
			</form>
		</div>
	</div>
</div>
