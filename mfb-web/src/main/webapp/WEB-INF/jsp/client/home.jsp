<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr class="clickLine" onclick="lienCompte('toto')">
						<td>45215425740</td>
						<td>Livret de mon cul</td>
						<td class="aligneSolde">452.894,45 $</td>
						<td><a class="btn btn-mini btn-info" href="toto"><spring:message code="home.account.details"/></a>
						</td>
					</tr>
					<c:forEach items="${comptes}" var="c">
						<tr class="clickLine" onclick="lienCompte('${c}')">
							<td>${c}</td>
							<td>${c}</td>
							<td>${c}</td>
							<td><a class="btn btn-mini btn-info" href="${c}"><spring:message code="home.account.details"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>