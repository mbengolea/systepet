<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de mascota</title>
</head>
<body>
	<form method="POST" action="DuenioController">
		<p>
			Nombre: <input type="text" name="nombre" />
		</p>
		<p>
			DNI del due�o: <input type="text" name="dni" />
		</p>
		<p>
			Tel�fono: <input type="text" name="telefono" />
		</p>
		<p>
			Direcci�n: <input type="text" name="direccion" />
		</p>
		<p>
			Correo electr�nico: <input type="text" name="e_mail" />
		</p>
		<p>
			Recibe notificaciones: <input type="checkbox" name="notificaciones" />
		</p>
		<p>
			<input type="submit" name="guardar_duenio" value="Guardar" />
		</p>
	</form>
</body>
</html>