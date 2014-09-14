<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<div id="header">SystePet</div>
		<div id="contents">
			<div class="container">
				<div class="header">Ingreso a SystePet</div>
				<div class="contents">
					<form method="POST" action="j_security_check">
						<p>
							<label for="j_username"> Usuario:</label> <input type="text" name="j_username">
						</p>
						<p>
							<label for="j_password"> Contraseña:</label> <input type="password" name="j_password">
						</p>
						<input class="button" type="submit" value="Ingresar">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>