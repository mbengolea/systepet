<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar mascota</title>
</head>
<body>
	<form method="POST" action="DuenioController">
		<p>
			DNI del due�o: <input type="text" name="dni_duenio" />
		</p>
		<p>
			Nombre del due�o: <input type="text" name="nombre_duenio" />
		</p>
		<p>
			Tel�fono: <input type="text" name="telefono" />
		</p>
		<p>
			<input type="submit" name="buscar_duenio" value="Buscar" />
		</p>
	</form>
</body>
</html>