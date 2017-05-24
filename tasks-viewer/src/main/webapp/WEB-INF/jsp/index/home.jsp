<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Tasks Viewer</title>
	<link rel="stylesheet" type="text/css"
		href="<c:url value="/css/materialize.min.css" />" />
</head>
<body>
	<div class="container">
		<h3 class="text-center">Tasks Viewer</h3>
		<div class="card-panel">
			<form method="POST" action="<c:url value="/login" />">
				<div class="input-field">
					<label for="email">E-mail</label>
					<input name="email" id="email" type="email" />
				</div>
				<div class="input-field">
					<label for="password">Senha</label>
					<input name="password" id="password" type="password" />
				</div>
				<input type="submit" value="Login" class="btn btn-lg" />
			</form>
			<a href="<c:url value="/register" />">Crie sua conta agora</a>
		</div>
	</div>
	
	<script src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
	<script src="<c:url value="/js/materialize.min.js" />"></script>
</body>
</html>