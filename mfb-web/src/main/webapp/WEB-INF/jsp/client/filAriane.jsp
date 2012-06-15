<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:forEach items="${linksfilAriane}" var="link">
	> <a href="${contextPath}${link.value}"><spring:message code="${link.key}"/></a>
</c:forEach>