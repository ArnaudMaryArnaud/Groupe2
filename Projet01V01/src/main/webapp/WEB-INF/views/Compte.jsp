<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Les comptes</title>
</head>
<body>

	<p>
	Consultation des comptes.
	<p>
	
	<table>
		<tr>
			<td>Numéro de compte</td>
			<td>Date de création</td>
			<td>Solde</td>
			<td>Decouvert</td>
			<td>Code du client</td>
			<td>Code de l'empoyé</td>
		</tr>
	</table>


	<table>
		<c:forEach items="${comptes}" var="co">
			<tr>
				<td>${co.numCompte}</td>
				<td>${co.dateCreation}</td>
				<td>${co.solde}</td>
				<td>${co.decouvert}</td>
				<td>${co.client}</td>
				<td>${co.employe}</td>
			</tr>
		</c:forEach>
	</table>


	<a href="Employe">Go To Employes</a>

</body>
</html>