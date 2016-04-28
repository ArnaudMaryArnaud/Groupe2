<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Donnees Employe Groupe</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Projet Banque Groupe 2</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="Compte">Compte <span class="sr-only">(current)</span></a></li>
					<li><a href="Employe">Employe</a></li>
					<li><a href="Client">Client</a></li>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>



	<div class="page-header">
		<h1>
			Voici la page concernant les employés et les groupes <small>Made
				by Groupe2</small>
		</h1>
	</div>
	<div>

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#Employe"
				aria-controls="employe" role="tab" data-toggle="tab">Employe</a></li>
			<li role="presentation"><a href="#Groupe" aria-controls="groupe"
				role="tab" data-toggle="tab">Groupe</a></li>
		</ul>
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane fade in active" id="Employe">
				<h2>Création d'un employé</h2>
				<form class="form-inline" action="insereremploye" method="post">
					<div class="form-group">
						<label for="nom">Nom</label> <input type="text"
							class="form-control" id="nom" name="nom" placeholder="SMITH">
					</div>
					<button type="submit" class="btn btn-success">Créer nouvel
						employé</button>
				</form>
				<h2>Liste des employés</h2>
				<table class="table table-striped">
					<th class="success">Code Employe</th>
					<th class="success">Nom Employe</th>
					<c:forEach items="${Employe}" var="e">
						<tr>
							<td>${e.CodeEmploye}</td>
							<td>${e.nomEmploye}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div role="tabpanel" class="tab-pane fade" id="Groupe">
				<div role="tabpanel" class="tab-pane fade in active" id="Employe">
					<h2>Création d'un employé</h2>
					<form class="form-inline" action="inserergroupe" method="post">
						<div class="form-group">
							<label for="nom">Nom du Groupe </label> <input type="text"
								class="form-control" id="nom" name="nom" placeholder="GROUPE 2">
						</div>
						<button type="submit" class="btn btn-info">Créer nouveau
							Groupe</button>
					</form>
					<h2>Liste des groupes</h2>
					<table class="table table-striped">
						<th class="info">Code Groupe</th>
						<th class="info">Nom Groupe</th>
						<c:forEach items="${Groupe}" var="g">
							<tr>
								<td>${g.CodeGroupe}</td>
								<td>${g.nomGroupe}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		<a href="Compte">Go To Compte</a> </br> <a href="Client">Go To Client</a>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>