<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="span10 offset2">
		<ul class="nav nav-tabs">
			<li class="${isClassActive[0]}"><a
				href="${contextPath}/admin/createClient.html"><spring:message
						code="admin.home.createClient" /></a></li>
			<li class="${isClassActive[1]}"><a
				href="${contextPath}/admin/createCompte.html"><spring:message
						code="admin.home.createCompte" /></a></li>
			<li class="${isClassActive[2]}"><a
				href="${contextPath}/admin/createOperation.html"><spring:message
						code="admin.home.createOperation" /></a></li>
		</ul>
</div>
