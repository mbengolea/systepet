<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar mascota</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Datos de búsqueda de dueños</div>
				<div class="contents">
					<form method="POST" action="DuenioController">
						<p>
							<label for="dni_duenio">DNI del dueño:</label><input type="text" name="dni_duenio" />
						</p>
						<p>
							<label for="nombre_duenio">Nombre del dueño:</label><input type="text" name="nombre_duenio" />
						</p>
						<p>
							<label for="telefono">Teléfono:</label><input type="text" name="telefono" />
						</p>
						<p>
							<input class="button" type="submit" name="buscar_duenio" value="Buscar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>