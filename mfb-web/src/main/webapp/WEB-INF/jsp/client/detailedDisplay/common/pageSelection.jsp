<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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