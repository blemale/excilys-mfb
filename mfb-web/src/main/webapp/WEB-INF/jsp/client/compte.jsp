<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span8 offset2">
	<h1>
		<spring:message code="compte.pageTitle" />
	</h1>

	<p align="right">
		<a href="${contextPath}/client/home.html" class="btn btn-info"><spring:message
				code="compte.home" /></a>
	</p>
</header>

<section id="compte">

	<!-- Div comprenant les liens pour changer de mois et afficher le mois courant -->
	<div class="row-fluid">
		<div class="span4 alignCenter">
			<c:if test="${previousMonth eq true}">
				<a class="btn"
					href="${contextPath}/client/compte/${idCompte}/${currentYear}/${currentMonth - 1}/detail.html"><i
					class="icon-chevron-left"></i> <spring:message
						code="compte.month.previous" /> </a>
			</c:if>
		</div>
		<div class="span4 alignCenter">
			<button class="btn disabled">${currentMonth} /
				${currentYear}</button>
		</div>
		<div class="span4 alignCenter">
			<c:if test="${nextMonth eq true}">
				<a class="btn"
					href="${contextPath}/client/compte/${idCompte}/${currentYear}/${currentMonth + 1}/detail.html">
					<spring:message code="compte.month.next" /> <i
					class="icon-chevron-right"></i>
				</a>
			</c:if>
		</div>
	</div>

	<!-- Div comprenant une liste déroulante affichant les mois qu'on peut sélectionné -->
	<div class="row-fluid">
		<div class="span4"></div>
		<div class="span4 alignCenter">
			<div class="btn-toolbar">
				<div class="btn-group">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						${currentMonth} / ${currentYear} <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<c:forEach items="${monthHistory}" var="i">
							<li><a
								href="${contextPath}/client/compte/${idCompte}/${currentYear}/${i}/detail.html">${i}
									/ ${currentYear}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="span4"></div>
	</div>

	<!-- Div comprenant les différentes opérations -->
	<div class="row">
		<div class="span8 offset2">
			<!-- Tableau d'affichage du cumul carte -->
			<c:if test="${carte eq true}">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th><spring:message code="compte.operationCarte" /></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr class="clickLine"
							onclick="lienCompte('${contextPath}/client/compte/${idCompte}/carte/detail.html')">
							<td><spring:message code="compte.soldeCarte" /></td>
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
								href="${contextPath}/client/compte/${idCompte}/carte/detail.html"><spring:message
										code="home.account.details" /></a></td>
						</tr>
					</tbody>
				</table>
			</c:if>
			<c:if test="${carte eq false}">
				<div class="alert alert-info">
					<spring:message code="compte.noCarteOperation" />
				</div>
			</c:if>



			<!-- Tableau d'affichage du détail des opérations hors carte -->
			<c:if test="${fn:length(operations) ne 0}">
				<h2>
					<spring:message code="compte.title.detailOperations" />
				</h2>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th><spring:message code="compte.dateOperation" /></th>
							<th><spring:message code="compte.typeOperation" /></th>
							<th><spring:message code="compte.labelOperation" /></th>
							<th><spring:message code="compte.montantOperation" /></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${operations}" var="o">
							<tr class="clickLine">
								<td>${o.dateEffet}</td>
								<td>${o.type}</td>
								<td>${o.label}</td>
								<c:if test="${o.montant >= 0}">
									<td class="aligneSolde coloreVert">+ <fmt:formatNumber
											value="${o.montant}" minFractionDigits="2" pattern="#,###.##" />
									</td>
								</c:if>
								<c:if test="${o.montant < 0}">
									<td class="aligneSolde coloreRouge">- <fmt:formatNumber
											value="${c.montant*-1}" minFractionDigits="2"
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
	<div class="row-fluid">
		<div class="span12">
			<div class="pagination pagination-centered">
				<ul>
					<li><a href="#">«</a></li>
					<c:forEach var="i" begin="0" end="${numPageMonth-1}">
						<c:if test="${currentPage eq i}">
							<li class="active"><a href="#">${i}</a></li>
						</c:if>
						<c:if test="${currentPage ne i}">
							<li><a href="#">${i}</a></li>
						</c:if>
					</c:forEach>
					<li><a href="#">»</a></li>
				</ul>
			</div>
		</div>
	</div>


</section>