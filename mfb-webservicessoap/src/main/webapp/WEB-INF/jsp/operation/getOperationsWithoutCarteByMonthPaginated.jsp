<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Test getOperationsWithoutCarteByMonthPaginated</h2>
	<table border="1">
		<thead>
			<tr>
				<th>montant</th>
				<th>label</th>
				<th>dateValeur</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${operations}" var="operation">
				<tr>
					<td>${operation.montant}</td>
					<td>${operation.label}</td>
					<td>${operation.dateValeur}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/mfb-webservicessoap/index.html">Retour</a>
</body>
</html>
