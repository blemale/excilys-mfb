<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="/login.htm"><spring:message code="header.title" /></a>
			<form class="navbar-form form-inline pull-right">
				<input type="text" class="input-small" placeholder="<spring:message code="header.placeholder.login" />">
				<input type="password" class="input-small" placeholder="<spring:message code="header.placeholder.password" />">
				<button type="submit" class="btn">
					<spring:message code="header.connection" />
				</button>
			</form>
		</div>
	</div>
</div>
