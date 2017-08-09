<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<meta http-equi="Content-type" content="text/html">
		<link rel="stylesheet" href="resources/login.css" type="text/css"/>
		<title>
			Login Screen
		</title>
	</head>
	<body>
		<div>
			<form action="login" method="POST">
			<h2>Please sign in</h2>
			<c:if test="${error}">
			<label id="erroMessage">Incorrect email or password. Please try again.</label>
			</c:if>
			<label><input type="text" id="loginInput" name="login" placeholder="Username"/></label><br/>
			<label><input type="password" id="passwordInput" name="password" placeholder="Password"/></label><br/>
			<label><input type="submit" id="loginSubmit" value="Sign In"></label><br/>
			</form>

		</div>
	</body>
</html>