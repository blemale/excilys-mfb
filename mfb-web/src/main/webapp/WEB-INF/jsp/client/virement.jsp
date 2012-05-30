<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<header id="overview" class="span10 offset2">
	<h1>
		<spring:message code="historiqueVirement.pageTitle" />
	</h1>
</header>

<section id="comptes">
	<div class="row">
		<div class="span8 offset2">
			<c:if test="${fn:length(comptes) ne 0}">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th><spring:message code="historiqueVirement.accountNumber" /></th>
							<th><spring:message code="historiqueVirement.label" /></th>
							<th><spring:message code="historiqueVirement.solde" /></th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${comptes}" var="c">
							<tr class="clickLine" onclick="lienCompte('${contextPath}/client/virement/compte/${c.id}/historique.html')">
								<td>${c.numeroCompte}</td>
								<td>${c.label}</td>
								<c:if test="${c.solde >= 0}">
									<td class="aligneSolde coloreVert">+ <fmt:formatNumber
											value="${c.solde}" minFractionDigits="2" pattern="#,###.##" />
									</td>
								</c:if>
								<c:if test="${c.solde < 0}">
									<td class="aligneSolde coloreRouge">- <fmt:formatNumber
											value="${c.solde*-1}" minFractionDigits="2"
											pattern="#,###.##" />
									</td>
								</c:if>
								<td><a class="btn btn-mini btn-info" href="${contextPath}/client/virement/compte/${c.id}/historique.html"><spring:message code="historiqueVirement.account.details"/></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${fn:length(comptes) eq 0}">
				<div class="alert alert-info">
					<spring:message code="home.emptyCompte" />
				</div>
			</c:if>
		</div>
	</div>
</section>