<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Auteur: Sabrina HENRIETTE
Date: 28/04/2106 -->


<!-- Onglet -->

<title>Comptes</title>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluname">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="home">Projet Banque Groupe 2</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			name="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class=active><a href="Compte">Compte <span
						class="sr-only">(current)</span></a></li>
				<li><a href="Employe">Employe</a></li>
				<li><a href="Client">Client</a></li>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluname --> </nav>

	<!-- Titre de la page -->

	<h1>
		<p class="text-center">Consultation des comptes
		<p>
	</h1>

	</br>


	<!-- Table -->

	<div class="table-responsive, container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<table class="table table-striped">
					<tr class="warning">
						<th>Numéro de compte</th>
						<th>Date de création</th>
						<th>Solde</th>
					</tr>


					<!-- Pour consulter les données -->

					<c:forEach items="${comptes}" var="co">
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

	</br>
	</br>

	<!-- Formulaire pour ajouter un nouveau compte -->


	<form action="addCompte" method="get">

		<h2>
			<p class="text-center">Ajout d'un compte
			<p>
		</h2>

		</br>



		<p class="text-center">
			<label for="date">Date de création</label> <input type="text"
				name="dateCreation" />
		</p>



		<p class="text-center">
			<label for="solde">Solde</label> <input type="text" name="solde" />
		</p>


		<p class="text-center">
			<label for="client">Client</label> <input type="text"
				name="codeClient" />
		</p>

		<p class="text-center">
			<label for="employe">Employé</label> <input type="text"
				name="codeEmploye" />
		</p>

		</br>

		<p class="text-center">
			<button type="submit" class="btn btn-warning">Ajouter
				nouveau compte</button>
		</p>
		
		</form>

		</br> </br>
		
		<div class = "row">


		<h1>
			<p class="text-center">Opérations sur les comptes
			<p>
		</h1>

		</br>


		<!-- Formulaire pour effectuer un retrait -->
		
		<form action="effectuerRetrait" method="get">
		
        <div class= "col-lg-6">

		<h2>

			<p class="text-center">Effectuer un retrait
			<p>
		</h2>

		</br>

		<p class="text-center">
			<label for="montant">Montant à retirer</label> <input type="text"
				name="montant" />
		</p>



		<p class="text-center">
			<label for="compte">Compte</label> <input type="text" name="numCompte" />
		</p>


		<p class="text-center">
			<label for="employe">Employé</label> <input type="text"
				name="codeEmploye" />
		</p>

		</br>


		<p class="text-center">
			<button type="submit" class="btn btn-danger">Faire le
				retrait</button>
		</p>
		
		</div>
		
		</form>



		<!-- Formulaire pour effectuer un versement -->
		
		<form action="effectuerVersement" method="get">
		
		<div class= "col-lg-6">

		<h2>

			<p class="text-center">Effectuer un versement
			<p>
		</h2>

		</br>

		<p class="text-center">
			<label for="montant">Montant à verser</label> <input type="text"
				name="montant" />
		</p>



		<p class="text-center">
			<label for="compte">Compte</label> <input type="text" name="numCompte" />
		</p>


		<p class="text-center">
			<label for="employe">Employé</label> <input type="text"
				name="codeEmploye" />
		</p>

		</br>


		<p class="text-center">
			<button type="submit" class="btn btn-danger">Faire le
				versement</button>
		</p>
		
		</div>
		
		</form>
		
		</div>

		</br> </br>
		
		
		<!-- Formulaire pour effectuer un virement -->
		
		<form action="effectuerVirement" method="get">
		
		<h2>

			<p class="text-center">Effectuer un virement
			<p>
		</h2>

		</br>

		<p class="text-center">
			<label for="montant">Montant</label> <input type="text"
				name="montant" />
		</p>



		<p class="text-center">
			<label for="compte1">Compte à débiter</label> <input type="text" name="compteRetrait" />
		</p>


		<p class="text-center">
			<label for="compte2">Compte à créditer</label> <input type="text"
				name="compteVersement" />
		</p>
		
		<p class="text-center">
			<label for="employe">Employé</label> <input type="text"
				name="codeEmploye" />
		</p>

		</br>


		<p class="text-center">
			<button type="submit" class="btn btn-danger">Faire le
				virement</button>
		</p>
		
		</form>
		
		</br>
		</br>


		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


	</form>

</body>
</html>