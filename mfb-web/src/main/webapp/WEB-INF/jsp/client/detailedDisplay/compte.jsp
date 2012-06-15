<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview">
	<div class="row-fluid">
		<div class="span12">
			<h1 align="center">
				<spring:message code="compte.pageTitle" />
				"${compte.label}" (${compte.numeroCompte})
			</h1>

			<p align="right">
				<a class="btn btn-success" href="export.html"><spring:message
						code="home.account.exportExcel" /></a> <a href="${contextPath}${linksVirement}" class="btn"><spring:message
						code="home.account.hitory" /></a> <a href="${contextPath}/client/home.html"
					class="btn btn-info"><spring:message code="compte.home" /></a>
			</p>
		</div>
	</div>
</header>

<section id="compte">

	<!-- Div comprenant les liens pour changer de mois et afficher le mois courant -->
	<%@ include file="common/monthSelection.jsp"%>

	<!-- Div comprenant les différentes opérations -->
	<div class="row">
		<div class="span10 offset1">
			<!-- Affichage de la balance -->
			<h2>
				<spring:message code="compte.balance.title" />
			</h2>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><spring:message code="compte.balance.credit" /></td>
						<td class="aligneSolde coloreVert">+ <fmt:formatNumber
								value="${credit}" minFractionDigits="2" pattern="#,###.##" />
						</td>
					</tr>
					<tr>
						<td><spring:message code="compte.balance.debit" /></td>
						<td class="aligneSolde coloreRouge">- <fmt:formatNumber
								value="${debit * (-1)}" minFractionDigits="2" pattern="#,###.##" />
						</td>
					</tr>
					<tr>
						<td><spring:message code="compte.balance.total" /></td>
						<c:choose>
							<c:when test="${total gt 0 }">
								<td class="aligneSolde coloreVert">+ <fmt:formatNumber
										value="${total}" minFractionDigits="2" pattern="#,###.##" />
								</td>
							</c:when>
							<c:when test="${total lt 0 }">
								<td class="aligneSolde coloreRouge">- <fmt:formatNumber
										value="${total * (-1)}" minFractionDigits="2"
										pattern="#,###.##" />
								</td>
							</c:when>
							<c:otherwise>
								<td class="aligneSolde"><fmt:formatNumber value="${total}"
										minFractionDigits="2" pattern="#,###.##" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</tbody>
			</table>
			<!-- Tableau d'affichage du cumul carte -->
			<c:if test="${soldeCarte ne null}">
				<h2>
					<spring:message code="compte.operationsCarte.title" />
				</h2>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th><spring:message code="compte.soldeCarte" /></th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr class="clickLine"
							onclick="lienCompte('${contextPath}${urlDetailCarte}')">
							<c:if test="${soldeCarte >= 0}">
								<td class="aligneSolde coloreVert">+ <fmt:formatNumber
										value="${soldeCarte}" minFractionDigits="2" pattern="#,###.##" />
								</td>
							</c:if>
							<c:if test="${soldeCarte < 0}">
								<td class="aligneSolde coloreRouge">- <fmt:formatNumber
										value="${soldeCarte*-1}" minFractionDigits="2"
										pattern="#,###.##" />
								</td>
							</c:if>
							<!-- TODO -->
							<td><a class="btn btn-mini btn-info"
								href="${contextPath}${urlDetailCarte}"><spring:message
										code="home.account.carte.details" /></a></td>
						</tr>
					</tbody>
				</table>
			</c:if>
			<c:if test="${soldeCarte eq null}">
				<div class="alert alert-info">
					<spring:message code="compte.noCarteOperation" />
				</div>
			</c:if>



			<!-- Tableau d'affichage du détail des opérations hors carte -->
			<c:if test="${fn:length(operations) ne 0}">
				<h2>
					<spring:message code="compte.detailOperations.title" />
				</h2>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th class="fixedCol"><spring:message
									code="compte.dateOperation" /></th>
							<th class="fixedCol"><spring:message
									code="compte.typeOperation" /></th>
							<th><spring:message code="compte.labelOperation" /></th>
							<th class="colMontant"><spring:message
									code="compte.montantOperation" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${operations}" var="o">
							<tr>
								<td><joda:format value="${o.dateValeur}" style="SS" /></td>
								<td><spring:message code="operationType.${o.type.label}" /></td>
								<td>${o.label}</td>
								<c:if test="${o.montant >= 0}">
									<td class="aligneSolde coloreVert">+ <fmt:formatNumber
											value="${o.montant}" minFractionDigits="2" pattern="#,###.##" />
									</td>
								</c:if>
								<c:if test="${o.montant < 0}">
									<td class="aligneSolde coloreRouge">- <fmt:formatNumber
											value="${o.montant * (-1)}" minFractionDigits="2"
											pattern="#,###.##" />
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${fn:length(operations) eq 0}">
				<div class="alert alert-info">
					<spring:message code="compte.noOperation" />
				</div>
			</c:if>
		</div>
	</div>



	<!-- Div comprenant la pagination -->
	<%@ include file="common/pageSelection.jsp"%>

</section>