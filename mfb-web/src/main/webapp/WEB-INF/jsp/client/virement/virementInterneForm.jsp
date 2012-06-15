<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview">
	<%@ include file="../filAriane.jsp"%>

	<div class="row">
		<div class="span10 offset2">

			<h1>
				<spring:message code="home.title" />
			</h1>
			<p class="lead">
				<spring:message code="home.virementInterneForm" />
			</p>
		</div>
	</div>
</header>

<section id="virement">
	<div class="row">
		<div class="span8 offset2">
			<form:form cssClass="form-horizontal" method="post"
				action="${contextPath}/client/doVirementInterne.html"
				commandName="virementInterneForm">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="montant"><spring:message
								code="virementInterneForm.montant" /></label>
						<div class="controls">
							<form:input path="montant" cssClass="input-xlarge focused" />
							<form:errors path="montant" cssClass="colorError" element="div" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="debit"><spring:message
								code="virementInterneForm.compteDebit" /></label>
						<div class="controls">
							<form:select path="compteADebiter">
								<form:options items="${listComptes}" itemLabel="fullLabel"
									itemValue="id" />
							</form:select>
							<form:errors path="compteADebiter" cssClass="colorError"
								element="div" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="credit"><spring:message
								code="virementInterneForm.compteCredit" /></label>
						<div class="controls">
							<form:select path="compteACrediter">
								<form:options items="${listComptes}" itemLabel="fullLabel"
									itemValue="id" />
							</form:select>
							<form:errors path="compteACrediter" cssClass="colorError"
								element="div" />
						</div>

					</div>
					<div class="control-group">
						<label class="control-label" for="motif"><spring:message
								code="virementInterneForm.label" /></label>
						<div class="controls">
							<input id="motif" class="input-xlarge focused" type="text"
								name="motif">
							<form:errors path="motif" cssClass="colorError" element="div" />
						</div>
					</div>
					<div class="form-actions alignCenter">
						<button class="btn btn-success" type="submit">
							<i class="icon-ok"></i>
							<spring:message code="virementInterneForm.doVirement" />
						</button>
						<a class="btn" href="${contextPath}/client/home.html"><i
							class="icon-remove"></i> <spring:message
								code="virementInterneForm.cancel" /></a>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>

</section>
