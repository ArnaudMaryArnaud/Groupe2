<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Accueil Banque groupe 2</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
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
					<li><a href="Employe">Employe</a></li>
					<li><a href="Client">Client</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="j_spring_security_logout">Déconnexion</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="col-xs-12">
		<div>
			<h2 class="text-center">Bienvenue sur le site de la banque
				Groupe 2</h2>
		</div>
		<p class="text-center">
			<img alt="banque"
				src="http://www.association-de-defense-du-citoyen.fr/images/banque.png">
		</p>
		<div class="row">
			<div class="col-lg-4">
				<h2 class="text-center">Pour consulter les données des comptes
					c'est par là</h2>
				<p class="text-center">
					<a href="Compte"><img alt="compte"
						src="http://www.ins-globalconsulting.fr/sites/default/files/imagecache/fullsize/banque-compte.jpeg"
						height="352" width="420"></a>
				</p>
				</p>
			</div>
			<div class="col-lg-4">
				<h2 class="text-center">Pour consulter les données des employés
					et des groupes c'est par là</h2>
				<p class="text-center">
					<a href="Employe"><img alt="employe"
						src="https://image.freepik.com/icones-gratuites/employe-de-bureau-de-dormir-sur-son-bureau-au-travail_318-63584.jpg"
						height="352" width="420"></a>
				</p>
			</div>
			<div class="col-lg-4">
				<h2 class="text-center">Pour consulter les données des clients
					c'est par là</h2>
				<p class="text-center">
					<a href="Client"><img alt="client"
						src="http://www.colloquium.ca/wp-content/uploads/2015/11/client-est-roi1.jpg"></a>
				</p>
			</div>
		</div>
	</div>
	<!-- Fin div row -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
