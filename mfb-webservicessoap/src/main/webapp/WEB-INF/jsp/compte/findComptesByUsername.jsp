<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Test findComptesByUsername</h2>
	<table border="1">
		<thead>
			<tr>
				<th>numeroCompte</th>
				<th>label</th>
				<th>solde</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${comptes}" var="compte">
				<tr>
					<td>${compte.numeroCompte}</td>
					<td>${compte.label}</td>
					<td>${compte.solde}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/mfb-webservicessoap/index.html">Retour</a>
</body>
</html>