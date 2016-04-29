<!-- Auteur : Valérian THOMAS
nom : Projet01V01
date : 28/04/2016
dossier : Deployed ressources/webapp/WEB-INF/views
Fichier : Client.jsp
Version : 1
sprint : 1
ref-userstory : 6
association : HomeController -->



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Les clients</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="home">Projet Banque Groupe 2</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="Compte">Compte </a></li>
				<li><a href="Employe">Employe</a></li>
				<li class=active><a href="Client">Client<span
						class="sr-only">(current)</span></a></li>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="page-header">
		<div class="col-xs-12">
			<!-- Mise en place d'une marge -->
			<h1>
				Voici la page concernant les clients <small>Made by Groupe2</small>
			</h1>


			<h2>Ajout d'un client</h2>

			<!-- Champ d'insertion d'un nouveau client -->
			<form action="ajouter.do" method="get">

				<table>
					<!-- Nom des champs -->
					<tr>
						<td class="text-center"><label for="nomClient">Nom</label></td>
						<td class="text-center"><label for="prenomClient">Prénom</label></td>
						<td class="text-center"><label for="dateNaissance">Date
								de Naissance</label></td>
						<td class="text-center"><label for="codePostal">Code
								Postal</label></td>
					</tr>

					<!-- Champs à remplir par l'utilisateur -->
					<tr>
						<td><input class="form-control" id="nomClient"
							name="nomClient" type="text" placeholder="Nom"></td>
						<td><input class="form-control" id="prenomClient"
							name="prenomClient" type="text" placeholder="Prénom"></td>
						<td><input class="form-control" id="dateNaissance"
							name="dateNaissance" type="text" placeholder="Date de naissance"></td>
						<td><input class="form-control" id="codePostal"
							name="codePostal" type="text" placeholder="Code Postal"></td>
						<td><button type="submit" class="btn btn-success">Enregistrer
								client</button></td>
					</tr>
				</table>

			</form>

			<!-- Recherche d'un client -->
			<h2>Rechercher un client</h2>

			<form class="form-inline" action="rechercher.do" method="get">

				<label for="mc">Mot Clé</label> <input type="text"
					class="form-control" id="mc" name="mc" placeholder="mot-clé">

				<button type="submit" class="btn btn-success">Rechercher</button>

			</form>

			</br>
			<!-- Nom des champs de la table -->

			<h2>Liste des clients</h2>

			<div class="table table-striped, container-fluid">

				<table class="table">

					<th class="success">Code client</th>
					<th class="success">Nom</th>
					<th class="success">Prénom</th>
					<th class="success">Date de naissance</th>
					<th class="success">Code postal</th>

					<!-- contenu de la table Clients -->

					<c:forEach items="${Client}" var="cl">
						<tr>
							<td>${cl.codeClient}</td>
							<td>${cl.nomClient}</td>
							<td>${cl.prenomClient}</td>
							<td>${cl.dateNaissance}</td>
							<td>${cl.codePostal}</td>
						</tr>
					</c:forEach>
				</table>

			</div>

			<!-- Pour afficher les comptes par client-->

			<h2>Afficher les comptes pour un client</h2>

			<div class="table table-striped, container-fluid">

				<form action="affichercompteCli.do" method="">

					<label for="codeClient">Nom Client</label> <select id="select"
						name="codeClient">
						<c:forEach items="${Client}" var="cl">
							<option value="${cl.codeClient}">${cl.nomClient}</option>
						</c:forEach>
					</select> <input type="submit" value="affichercomptes" />

				</form>
				<table class="table table-striped">
					<tr class="success">
						<th>Numéro de compte</th>
						<th>Date de création</th>
						<th>Solde</th>
					</tr>
					<!-- Pour consulter les données comptes -->
					<c:forEach items="${Comptes}" var="co">
						<tr>
							<td>${co.numCompte}</td>
							<td>${co.dateCreation}</td>
							<td>${co.solde}</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>