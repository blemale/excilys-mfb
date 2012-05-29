<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	<div class="row-fluid">
		<div class="span4 alignCenter">
			<c:if test="${urlPreviousMonth ne null}">
				<a class="btn"
					href="${contextPath}${urlPreviousMonth}"><i
					class="icon-chevron-left"></i> <spring:message
						code="compte.month.previous" /> </a>
			</c:if>
		</div>
		<div class="span4 alignCenter">
			<button class="btn disabled">${currentDate}</button>
		</div>
		<div class="span4 alignCenter">
			<c:if test="${urlNextMonth ne null}">
				<a class="btn"
					href="${contextPath}${urlNextMonth}">
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
						${currentDate} <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<c:forEach items="${mapNamesUrlsForMonths}" var="entry">
							<li><a
								href="${contextPath}${entry.value}">${entry.key}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="span4"></div>
	</div>

	<!-- Div comprenant le détails des opérations CARTE -->
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
							<td>${o.dateEffet}</td>
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
	<div class="row-fluid">
		<div class="span12">
			<div class="pagination pagination-centered">
				<ul>
					<li><a href="#">«</a></li>
					<c:forEach items="${mapUrlPages}" var="entry">
						<c:if test="${currentPage eq entry.key}">
							<li class="active"><a href="${contextPath}${entry.value}">${entry.key}</a></li>
						</c:if>
						<c:if test="${currentPage ne entry.key}">
							<li><a href="${contextPath}${entry.value}">${entry.key}</a></li>
						</c:if>
					</c:forEach>
					<li><a href="#">»</a></li>
				</ul>
			</div>
		</div>
	</div>


</section>