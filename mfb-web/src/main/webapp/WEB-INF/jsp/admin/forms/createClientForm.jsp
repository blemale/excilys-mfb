<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span10 offset1">
	<h1>
		<spring:message code="admin.createClientForm.title" />
	</h1>
	<p class="lead">
		<spring:message code="admin.createClientForm.welcome" />
	</p>
</header>

<section id="createClient">
	<div class="row">
		<%@ include file="../common/formSelection.jsp"%>

		<div class="span12">
			<form:form cssClass="form-horizontal" method="post"
				action="${contextPath}/admin/doCreateClient.html"
				commandName="clientForm">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="username"><spring:message
								code="admin.createClientForm.username" /></label>
						<div class="controls">
							<form:input path="username" cssClass="input-xlarge focused" />
							<form:errors path="username" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="firstname"><spring:message
								code="admin.createClientForm.firstname" /></label>
						<div class="controls">
							<form:input path="firstname" cssClass="input-xlarge focused" />
							<form:errors path="firstname" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="lastname"><spring:message
								code="admin.createClientForm.lastname" /></label>
						<div class="controls">
							<form:input path="lastname" cssClass="input-xlarge focused" />
							<form:errors path="lastname" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password"><spring:message
								code="admin.createClientForm.password" /></label>
						<div class="controls">
							<form:password path="password" cssClass="input-xlarge focused" />
							<form:errors path="password" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password2"><spring:message
								code="admin.createClientForm.password" /></label>
						<div class="controls">
							<form:password path="password2" cssClass="input-xlarge focused" />
							<form:errors path="password2" cssClass="colorError" />
						</div>
					</div>
					<div class="form-actions alignCenter">
						<button class="btn btn-success" type="submit">
							<spring:message code="admin.createClientForm.doCreateClient" />
						</button>
						<a class="btn" href="${contextPath}/admin/home.html"><spring:message
								code="admin.createClientForm.cancel" /></a>
					</div>
				</fieldset>

			</form:form>
		</div>
	</div>
</section>