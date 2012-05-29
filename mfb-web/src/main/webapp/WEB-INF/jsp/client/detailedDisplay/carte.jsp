<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span8 offset2">
	<h1>
		<spring:message code="carte.pageTitle" />
	</h1>

	<p align="right">
		<a href="${contextPath}${urlDetailCompte}" class="btn btn-info"><spring:message
				code="carte.home" /></a>
	</p>
</header>

<section id="carte">

	<!-- Div comprenant les liens pour changer de mois et afficher le mois courant -->
	<%@ include file="common/monthSelection.jsp" %>

	<!-- Div comprenant le d�tails des op�rations CARTE -->
	<div class="row">
		<div class="span8 offset2">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th><spring:message code="carte.dateOperation" /></th>
						<th><spring:message code="carte.labelOperation" /></th>
						<th><spring:message code="carte.montantOperation" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${operations}" var="o">
						<tr class="clickLine">
							<td><joda:format value="${o.dateEffet}" style="SS" /></td>
							<td>${o.label}</td>
							<c:if test="${o.montant >= 0}">
								<td class="aligneSolde coloreVert">+ <fmt:formatNumber
										value="${o.montant}" minFractionDigits="2" pattern="#,###.##" />
								</td>
							</c:if>
							<c:if test="${o.montant < 0}">
								<td class="aligneSolde coloreRouge">- <fmt:formatNumber
										value="${o.montant*-1}" minFractionDigits="2"
										pattern="#,###.##" />
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>
	
	<!-- Div comprenant la pagination -->
	<%@ include file="common/pageSelection.jsp" %>
	
</section>