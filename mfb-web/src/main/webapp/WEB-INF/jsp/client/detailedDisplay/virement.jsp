<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<header id="overview" class="span10 offset2">
	<h1>
		<spring:message code="historiqueVirement.pageTitle" />
		<spring:message code="historiqueVirement.accountNumber" />	: 123456789	
	</h1>
</header>

<section id="virements">
	<div class="row">
		<div class="span10 offset1">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th><spring:message code="historiqueVirement.dateEffet" /></th>
						<th><spring:message code="historiqueVirement.dateValeur" /></th>
						<th><spring:message code="historiqueVirement.label" /></th>
						<th><spring:message code="historiqueVirement.montant" /></th>
					</tr>
				</thead>
				<tbody>
				<tr>
					<td>23 / 02 / 1923</td>
					<td>23 / 02 / 1923</td>
					<td>Rembourser roger. Compte 265846731</td>
					<td class="aligneSolde coloreRouge">-452,00</td>	
				</tr>
				<tr>
					<td>12 / 02 / 1987</td>
					<td>24 / 02 / 1992</td>
					<td>Remboursement de christophe. Compte 197566783</td>
					<td class="aligneSolde coloreVert">187,00</td>	
				</tr>
				<tr>
					<td>12 / 02 / 1986</td>
					<td>12 / 02 / 1986</td>
					<td>Achat de diamant. Compte 138459721</td>
					<td class="aligneSolde coloreRouge">-1000,00</td>	
				</tr>
				<tr>
					<td>03 / 04 / 2012</td>
					<td>04 / 04 / 2012</td>
					<td>APL. Compte 587463259</td>
					<td class="aligneSolde coloreVert">1000,00</td>	
				</tr>
				<tr>
					<td>03 / 04 / 2012</td>
					<td>04 / 04 / 2012</td>
					<td>IPOd. Compte 796542389</td>
					<td class="aligneSolde coloreVert">1000,00</td>	
				</tr>
				<tr>
					<td>08 / 07 / 2011</td>
					<td>09 / 07 / 2011</td>
					<td>Loyer de mon apparteme. Compte 467692132</td>
					<td class="aligneSolde coloreRouge">-86542,10</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</section>