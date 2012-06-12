<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<body>
	<h2>Test des Web Services REST</h2>
	<h3>COMPTE</h3>
	<div>
		<a href="${contextPath }/getCompteById.html">getCompteById(2)</a>
	</div>
	<div>
		<a href="${contextPath }/findComptesByUsername.html">findComptesByUsername(user)</a>
	</div>
	<div>
		<a href="${contextPath }/checkCompteOwnershipByUsernameAndCompteId.html">checkCompteOwnershipByUsernameAndCompteId</a>
	</div>

	<h3>PERSON</h3>
	<div>
		<a href="${contextPath }/findPersonByUsername.html">findPersonByUsername(user)</a>
	</div>
</body>
</html>
