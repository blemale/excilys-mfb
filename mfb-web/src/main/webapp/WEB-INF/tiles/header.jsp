<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="${contextPath}/home.html">
				<spring:message code="header.title" />
			</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
					<sec:authorize access="isAuthenticated()">
						<li class=""><a href="${contextPath}/home.html"><spring:message code="header.link.home" /></a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN') and hasRole('ROLE_CLIENT')">
						<li class=""><a href="${contextPath}/admin/home.html"><spring:message code="header.link.admin" /></a></li>
					</sec:authorize>
					
				</ul>
				
				<sec:authorize access="isAnonymous()">
					<form action="<c:url value='/j_spring_security_check'/>" class="navbar-form form-inline pull-right" method="post">
						<input name="j_username" type="text" id="form-top" class="input-small form-top" placeholder="<spring:message code="header.placeholder.username" />">
						<input name="j_password" type="password" id="form-top" class="input-small form-top" placeholder="<spring:message code="header.placeholder.password" />">
						<button type="submit" class="btn">
							<spring:message code="header.button.login" />
						</button>
						<a href="?lang=en"><img src="${contextPath}/content/images/drapeaux/en.png" height="30" width="30"/></a> 
						<a href="?lang=fr"><img src="${contextPath}/content/images/drapeaux/fr.png" height="30" width="30"/></a>
					</form>
				</sec:authorize>
				
				<sec:authorize access="isAuthenticated()">
					<form action="<c:url value='/j_spring_security_logout'/>" class="navbar-form form-inline pull-right" method="post">
						<button class="btn"><spring:message code="header.button.logout" /></button>
						<a href="?lang=en"><img src="${contextPath}/content/images/drapeaux/en.png" height="30" width="30"/></a> 
						<a href="?lang=fr"><img src="${contextPath}/content/images/drapeaux/fr.png" height="30" width="30"/></a>
					</form>
				</sec:authorize>
				
					
			</div>
		</div>
	</div>
</div>
