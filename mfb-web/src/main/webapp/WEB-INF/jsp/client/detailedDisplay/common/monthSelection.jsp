<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Div comprenant les liens pour changer de mois et afficher le mois courant -->
<div class="row-fluid">
	<div class="span4 alignCenter">
		<c:if test="${previousMonth eq true}">
			<a class="btn"
				href="${contextPath}/${url}"><i
				class="icon-chevron-left"></i> <spring:message
					code="compte.month.previous" /> </a>
		</c:if>
	</div>
	<div class="span4 alignCenter">
		<button class="btn disabled">${currentMonth} / ${currentYear}</button>
	</div>
	<div class="span4 alignCenter">
		<c:if test="${nextMonth eq true}">
			<a class="btn"
				href="${contextPath}/${url}">
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
							href="${contextPath}/${url}">${i}
								/ ${currentYear}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="span4"></div>
</div>