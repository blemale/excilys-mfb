<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Test findPersonByUsername</h2>
	<table border="1">
		<thead>
			<tr>
				<th>username</th>
				<th>firstname</th>
				<th>lastname</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${person.username}</td>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
			</tr>
		</tbody>
	</table>
	<a href="/mfb-webservicessoap/index.html">Retour</a>
</body>
</html>