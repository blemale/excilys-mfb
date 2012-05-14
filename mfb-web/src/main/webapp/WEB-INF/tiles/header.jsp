<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="${contextPath}">MF Banking</a>
			<form class="navbar-form form-inline pull-right">
				<input type="text" id="form-top" class="input-small" placeholder="Login">
				<input type="password" id="form-top" class="input-small form-top" placeholder="Password">
				<button type="submit" class="btn">Connexion</button>
			</form>
		</div>
	</div>
</div>
