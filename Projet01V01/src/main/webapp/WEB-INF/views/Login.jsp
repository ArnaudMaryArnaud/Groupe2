<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Page de connexion Banque Groupe 2</title>
</head>
<body>
<html style="background: url(http://znn.fr/wp-content/uploads/2014/11/pluie-billets.jpg)";/>

	<div class="col-xs-12">
		<h1>Bienvenue sur la page de connexion à la banque groupe 2</h1>
		<p class="text-center">
			<img alt="banque"
				src="http://www.association-de-defense-du-citoyen.fr/images/banque.png">
		</p>
		<form class="form-inline" action="j_spring_security_check"
			method="post">

			<div class="form-group">
				<label for="exampleInputEmail3">Identifiant</label> <input
					type="text" class="form-control" id="text" name="j_username"
					placeholder="Smith">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword3">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword3"
					name="j_password" placeholder="Password">
			</div>

			<button type="submit" class="btn btn-primary">Sign in</button>
			<div class="checkbox">
				<label> <input type="checkbox"> Remember me
				</label>
			</div>

			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
				<p>Votre mot de passe est incorrect</p>
			</c:if>
		</form>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>