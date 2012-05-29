<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- Div comprenant la pagination -->
<div class="row-fluid">
	<div class="span12">
		<c:if test="${fn:length(mapUrlPages) gt 1}">
			<div class="pagination pagination-centered">
				<ul>
					<li><a href="#">«</a></li>
					<c:forEach items="${mapUrlPages}" var="entry">
						<c:if test="${currentPage eq entry.key}">
							<li class="active"><a href="${contextPath}${entry.value}">${entry.key +1}</a></li>
						</c:if>
						<c:if test="${currentPage ne entry.key}">
							<li><a href="${contextPath}${entry.value}">${entry.key + 1}</a></li>
						</c:if>
					</c:forEach>
					<li><a href="#">»</a></li>
				</ul>
			</div>
		</c:if>
	</div>
</div>