<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="${contextPath}">
				<spring:message code="header.title" />
			</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
					<li class=""><a href="${contextPath}"><spring:message code="header.link.home" /></a></li>
					<%-- <sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
					<li class=""><a href="${contextPath}/admin.html"><spring:message code="header.link.admin" /></a></li>
					<%-- </sec:authorize> --%>
					
				</ul>
				
				<form action="<c:url value='j_spring_security_check'/>" class="navbar-form form-inline pull-right" method="post">
<%-- 					<sec:authorize access="isAnonymous()"> --%>
						<input name="j_username" type="text" id="form-top" class="input-small form-top" placeholder="<spring:message code="header.placeholder.username" />">
						<input name="j_password" type="password" id="form-top" class="input-small form-top" placeholder="<spring:message code="header.placeholder.password" />">
						<button type="submit" class="btn">
							<spring:message code="header.button.login" />
						</button>
<%-- 					</sec:authorize> --%>
<%-- 					<sec:authorize access="isAuthenticated()"> --%>
						<button type="submit" class="btn">
							<spring:message code="header.button.logout" />
						</button>
<%-- 					</sec:authorize> --%>
					<a href="?lang=en"><img src="${contextPath}/content/images/drapeaux/en.png" height="30" width="30"/></a> 
						<a href="?lang=fr"><img src="${contextPath}/content/images/drapeaux/fr.png" height="30" width="30"/></a>	
				</form>
				
			</div>
		</div>
	</div>
</div>
