<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Div comprenant les liens pour changer de mois et afficher le mois courant -->
<div class="row-fluid">
	<div class="span4 alignCenter">
		<c:if test="${urlPreviousMonth ne null}">
			<a class="btn" href="${contextPath}${urlPreviousMonth}"><i
				class="icon-chevron-left"></i> <spring:message
					code="compte.month.previous" /> </a>
		</c:if>
	</div>
	<div class="span4 alignCenter">
		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn dropdown-toggle" data-toggle="dropdown">
					${currentDate} <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<c:forEach items="${mapNamesUrlsForMonths}" var="entry">
						<li><a href="${contextPath}${entry.value}">${entry.key}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="span4 alignCenter">
		<c:if test="${urlNextMonth ne null}">
			<a class="btn" href="${contextPath}${urlNextMonth}"> <spring:message
					code="compte.month.next" /> <i class="icon-chevron-right"></i>
			</a>
		</c:if>
	</div>
</div>