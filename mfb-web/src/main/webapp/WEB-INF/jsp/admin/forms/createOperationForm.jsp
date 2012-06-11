<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span10 offset1">
	<h1>
		<spring:message code="admin.createOperationForm.title" />
	</h1>
	<p class="lead">
		<spring:message code="admin.createOperationForm.welcome" />
	</p>
</header>

<section id="createClient">
	<div class="row">
		<%@ include file="../common/formSelection.jsp"%>

		<div class="span12">
			<form:form cssClass="form-horizontal" method="post"
				action="${contextPath}/admin/doCreateOperation.html"
				commandName="operationForm">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="montant"><spring:message
								code="admin.createOperationForm.montant" /></label>
						<div class="controls">
							<form:input path="montant" cssClass="input-xlarge focused" />
							<form:errors path="montant" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for=compte><spring:message
								code="admin.createOperationForm.compte" /></label>
						<div class="controls">
							<form:select path="compte">
								<form:options items="${comptesList}" itemLabel="fullCompte"
									itemValue="id" />
							</form:select>
							<form:errors path="compte" cssClass="colorError" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="type"><spring:message
								code="admin.createOperationForm.type" /></label>
						<div class="controls">
							<form:select path="type">
								<form:options items="${typesList}" />
							</form:select>
							<form:errors path="type" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="dateEffet"><spring:message
								code="admin.createOperationForm.dateEffet" /></label>
						<div class="controls">
							<form:input path="dateEffet" cssClass="input-xlarge focused" />
							<form:errors path="dateEffet" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="dateValeur"><spring:message
								code="admin.createOperationForm.dateValeur" /></label>
						<div class="controls">
							<form:input path="dateValeur" cssClass="input-xlarge focused" />
							<form:errors path="dateValeur" cssClass="colorError" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="label"><spring:message
								code="admin.createOperationForm.label" /></label>
						<div class="controls">
							<form:input path="label" cssClass="input-xlarge focused" />
							<form:errors path="label" cssClass="colorError" />
						</div>
					</div>
					<div class="form-actions alignCenter">
						<button class="btn btn-success" type="submit">
							<spring:message
								code="admin.createOperationForm.doCreateOperation" />
						</button>
						<a class="btn" href="${contextPath}/admin/home.html"><spring:message
								code="admin.createOperationForm.cancel" /></a>
					</div>
				</fieldset>

			</form:form>
		</div>
	</div>
</section>