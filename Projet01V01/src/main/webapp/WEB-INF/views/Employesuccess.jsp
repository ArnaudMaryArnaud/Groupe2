<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Auteur : Arnaud MARY -->
<!-- Date creation : 29/04/2016 -->
<!-- Sprint : 1 | User story : 5-->
<!-- Page employe et groupe -->
<title>Donnees Employe Groupe</title>
</head>
<body>
	<!-- Barre de navigation -->
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
					<li><a href="Compte">Compte</a></li>
					<li class=active><a href="Employe">Employe <span
							class="sr-only">(current)</span></a></li>
					<li><a href="Client">Client</a></li>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- Debut du contenu de la page -->
	<div class="col-xs-12">
		<div class="page-header">

			<h1>
				Vous avez ajouté avec succès un nouvel employé<small>Bravo</small>
			</h1>
			<a href="Employe">Retour vers la page Employé</a>

		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>