<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span10 offset2">
	<h1>
		<spring:message code="home.title" />
	</h1>
	<p class="lead">
		<spring:message code="home.welcome" />
	</p>
</header>

<section id="virement">
	<div class="row">
		<div class="span8 offset2">
			<form:form cssClass="form-horizontal" method="post"
				action="${contextPath}/client/doVirement.html"
				commandName="virementInterneForm">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="montant">Montant</label>
						<div class="controls">
							<form:input path="montant" cssClass="input-xlarge focused" />
							<form:errors path="montant" cssClass="colorError"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="debit">Compte à débiter</label>
						<div class="controls">
							<form:select path="compteADebiter">
								<form:options items="${comptesList}" itemLabel="fullLabel"
									itemValue="id" />
							</form:select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="credit">Compte à
							créditer</label>
						<div class="controls">
							<form:select path="compteACrediter">
								<form:options items="${comptesList}" itemLabel="fullLabel"
									itemValue="id" />
							</form:select>
							<form:errors path="compteADebiter" cssClass="colorError" element="div"/>
						</div>
						
					</div>
					<div class="control-group">
						<label class="control-label" for="motif">Motif</label>
						<div class="controls">
							<input id="motif" class="input-xlarge focused" type="text"
								name="motif">
						</div>
					</div>
					<div class="form-actions alignCenter">
						<button class="btn btn-success" type="submit">Faire
							virement</button>
						<a class="btn" href="${contextPath}/client/home.html">Annuler
							virement</a>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>

</section>
