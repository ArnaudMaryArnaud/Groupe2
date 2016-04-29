<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<a class="navbar-brand" href="#">Projet Banque Groupe 2</a>
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
	<div class="page-header">
		<h1>
			Voici la page concernant les employés et les groupes <small>Made
				by Groupe2</small>
		</h1>
	</div>
	<!-- Utilisation d'onglets -->
	<div>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#Employe"
				aria-controls="employe" role="tab" data-toggle="tab">Employe</a></li>
			<li role="presentation"><a href="#Groupe" aria-controls="groupe"
				role="tab" data-toggle="tab">Groupe</a></li>
		</ul>
		<!-- Onglet Employé -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane fade in active" id="Employe">
				<div class="row">
					<div class="col-lg-6">
						<!-- Formulaire d'ajout d'un employé -->
						<h2>Création d'un employé</h2>
						<form class="form-inline" action="insereremploye" method="get">
							<div class="form-group">
								<label for="nom">Nom</label> <input type="text"
									class="form-control" id="nom" name="nomEmploye"
									placeholder="SMITH">
							</div>
							<button type="submit" class="btn btn-success">Créer
								nouvel employé</button>
						</form>
					</div>
					<!-- Formulaire d'ajout d'un employé à un groupe -->
					<div class="col-lg-6">
							<h2>Ajout d'un employé à un groupe</h2>
							<form class="form-inline" action="addemployegroupe" method="">
								<div class="form-group">
									<label for="nom">Code Employé</label> 
									 <select id="select"
										name="codeEmploye">
										<c:forEach items="${Employe}" var="em">
											<option value="${em.codeEmploye}">${em.nomEmploye}</option>
										</c:forEach>
									</select>
									<label for="nom">Code Groupe</label> 
									<select id="select"
										name="codeGroupe">
										<c:forEach items="${Groupe}" var="gp">
											<option value="${gp.codeGroupe}">${gp.nomGroupe}</option>
										</c:forEach>
									</select>
								</div>
								<button type="submit" class="btn btn-success">Ajouter
									Employé à groupe</button>
							</form>
						</div>
				</div>
				<h2>Liste des employés</h2>
				<table class="table table-striped, table-responsive">
					<th class="success">Code Employe</th>
					<th class="success">Nom Employe</th>
					<c:forEach items="${Employe}" var="e">
						<tr>
							<td>${e.codeEmploye}</td>
							<td>${e.nomEmploye}</td>
						</tr>
					</c:forEach>
				</table>
				<!-- Pour afficher les comptes créés par un employé-->
				<h2>Afficher les comptes créés par un employé</h2>
				<form action="affichercompteEmp.do" method="">
					<label for="codeEmploye">Nom Employé</label> <select id="select"
						name="codeEmploye">
						<c:forEach items="${Employe}" var="em">
							<option value="${em.codeEmploye}">${em.nomEmploye}</option>
						</c:forEach>
					</select> <input type="submit" value="rechercher" />
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
			<!-- Onglet Groupe -->
			<div role="tabpanel" class="tab-pane fade" id="Groupe">
				<div role="tabpanel" class="tab-pane fade in active" id="Employe">
					<div class="row">
						<div class="col-lg-6">
							<h2>Création d'un employé</h2>
							<form class="form-inline" action="inserergroupe" method="">
								<div class="form-group">
									<label for="nom">Nom du Groupe </label> <input type="text"
										class="form-control" id="nom" name="nomGroupe"
										placeholder="GROUPE 2">
								</div>
								<button type="submit" class="btn btn-info">Créer
									nouveau Groupe</button>
							</form>
						</div>
						<div class="col-lg-6">
							<h2>Ajout d'un employé à un groupe</h2>
							<form class="form-inline" action="addemployegroupe" method="">
								<div class="form-group">
									<label for="nom">Code Employé</label> 
									 <select id="select"
										name="codeEmploye">
										<c:forEach items="${Employe}" var="em">
											<option value="${em.codeEmploye}">${em.nomEmploye}</option>
										</c:forEach>
									</select>
									<label for="nom">Code Groupe</label> 
									<select id="select"
										name="codeGroupe">
										<c:forEach items="${Groupe}" var="gp">
											<option value="${gp.codeGroupe}">${gp.nomGroupe}</option>
										</c:forEach>
									</select>
								</div>
								<button type="submit" class="btn btn-info">Ajouter
									Employé à groupe</button>
							</form>
						</div>
					</div>
					<h2>Liste des groupes</h2>
					<table class="table table-striped">
						<th class="info">Code Groupe</th>
						<th class="info">Nom Groupe</th>
						<c:forEach items="${Groupe}" var="g">
							<tr>
								<td>${g.codeGroupe}</td>
								<td>${g.nomGroupe}</td>
							</tr>
						</c:forEach>
					</table>
					<h2>Afficher les employés d'un groupe</h2>
					<form class="form-inline" action="employedugroupe" method="">
						<label for="codeEmploye">Nom groupe</label> <select id="select"
							name="codeGroupe">
							<c:forEach items="${Groupe}" var="g">
								<option value="${g.codeGroupe}">${g.nomGroupe}</option>
							</c:forEach>
						</select> <input type="submit" value="rechercher" />
					</form>
					<table class="table table-striped">
						<th class="info">Code employe</th>
						<th class="info">Nom employe</th>
						<c:forEach items="${EmployeGroupe}" var="eg">
							<tr>
								<td>${eg.codeEmploye}</td>
								<td>${eg.nomEmploye}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>