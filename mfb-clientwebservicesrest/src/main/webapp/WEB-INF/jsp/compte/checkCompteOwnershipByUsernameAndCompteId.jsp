<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<body>
	<h2>Test checkCompteOwnershipByUsername</h2>
	<table border="1">
		<thead>
			<tr>
				<th>User</th>
				<th>IdCompte</th>
				<th>Check</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>User</td>
				<td>1</td>
				<td>${boolUser1}</td>
			</tr>
			<tr>
				<td>User</td>
				<td>3</td>
				<td>${boolUser3}</td>
			</tr>
			<tr>
				<td>useradmin</td>
				<td>3</td>
				<td>${boolUseradmin3}</td>
			</tr>						
		</tbody>
	</table>
	<a href="${contextPath }/index.html">Retour</a>
</body>
</html>