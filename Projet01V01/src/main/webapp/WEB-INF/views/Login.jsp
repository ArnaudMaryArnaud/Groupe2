<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="j_spring_security_check" method="post">
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
			<p>Votre mot de passe est incorrect</p>
		</c:if>
		<input type="text" name="j_username" /> <input type="password"
			name="j_password" /> <input type="submit">
	</form>
</body>
</html>