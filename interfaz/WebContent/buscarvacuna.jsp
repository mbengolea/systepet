<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar vacuna</title>
</head>
<body>
	<form method="POST" action="VacunaController">
		<p>
			Nombre: <input type="text" name="nombre" />
		</p>
		<p>
			<input type="submit" name="buscar_vacuna" value="Buscar" />
		</p>
	</form>
</body>
</html>