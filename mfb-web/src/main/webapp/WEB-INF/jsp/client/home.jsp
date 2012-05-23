<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<header id="overview" class="span10 offset2">
	<h1>
		<spring:message code="home.title" />
	</h1>
	<p class="lead">
		<spring:message code="home.welcome" />
	</p>
</header>

<section id="comptes">
	<div class="row">
		<div class="span8 offset2">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th><spring:message code="home.accountNumber" /></th>
						<th><spring:message code="home.label" /></th>
						<th><spring:message code="home.sale" /></th>
						<%-- <th></th> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comptes}" var="c">
						<%-- <tr class="clickLine" onclick="lienCompte('${c.numeroCompte}')"> --%>
						<tr class="clickLine">
							<td>${c.numeroCompte}</td>
							<td>${c.label}</td>
							<c:if test="${c.solde >= 0}">
								<td class="aligneSolde coloreVert">
									+ <fmt:formatNumber value="${c.solde}" minFractionDigits="2" pattern="#,###.##"/>
								</td>
							</c:if>
							<c:if test="${c.solde < 0}">
								<td class="aligneSolde coloreRouge">
									- <fmt:formatNumber value="${c.solde*-1}" minFractionDigits="2" pattern="#,###.##"/>
								</td>
							</c:if>
							<%-- <td><a class="btn btn-mini btn-info" href="${c.numeroCompte}"><spring:message code="home.account.details"/></a></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>