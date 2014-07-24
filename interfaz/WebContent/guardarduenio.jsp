<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guardar Dueño</title>
</head>
<body>
	<form method="POST" action="DuenioController">
		<p> 
			Nombre: <input type="text" name="nombre" />
		</p>
		<p>
			Dirección: <input type="text" name="direccion" />
		</p>
		<p>
			E-mail: <input type="text" name="email" />
		</p>
		<p>
			Recibe notificaciones: <input type="checkbox" name="notificaciones" />
		</p>

		<p>
			<input type="submit" name="guardar" value="Guardar" />
		</p>
	</form>

</body>
</html>