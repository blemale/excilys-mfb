<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span10 offset1">
	<h1>
		<spring:message code="admin.createCompteForm.title" />
	</h1>
	<p class="lead">
		<spring:message code="admin.createCompteForm.welcome" />
	</p>
</header>

<section id="createCompte">
	<div class="row show-grid">
		<%@ include file="../common/formSelection.jsp"%>

		<div class="span12">
			<form:form cssClass="form-horizontal" method="post"
				action="${contextPath}/admin/doCreateCompte.html"
				commandName="compteForm">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="label"><spring:message
								code="admin.createCompteForm.label" /></label>
						<div class="controls">
							<form:input path="label" cssClass="input-xlarge focused" />
							<form:errors path="label" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="owner"><spring:message
								code="admin.createCompteForm.owner" /></label>
						<div class="controls">
							<form:select path="owner">
								<form:options items="${ownersList}" itemLabel="fullPerson"
									itemValue="id" />
							</form:select>
							<form:errors path="owner" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="solde"><spring:message
								code="admin.createCompteForm.solde" /></label>
						<div class="controls">
							<form:input path="solde" cssClass="input-xlarge focused" />
							<form:errors path="solde" cssClass="colorError" />
						</div>
					</div>
					<div class="form-actions alignCenter">
						<button class="btn btn-success" type="submit">
							<spring:message code="admin.createCompteForm.doCompteClient" />
						</button>
						<a class="btn" href="${contextPath}/admin/home.html"><spring:message
								code="admin.createCompteForm.cancel" /></a>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</section>