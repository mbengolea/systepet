<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar mascota</title>
</head>
<body>
	<form method="POST" action="MascotaController">
		<p>
			Nombre de la mascota: <input type="text" name="nombre_mascota" value="${mascota.getNombre()}" />
		</p>
		<p>
			Especie: <select name="especie">
				<option value="CANINO">canino</option>
				<option value="FELINO">felino</option>
				<option value="OTRO">otro</option>
			</select>
		</p>
		<p>
			Raza: <input type="text" name="raza" value="${mascota.getRaza()}"/>
		</p>
		<p>
			Fecha de nacimiento: <input type="text" name="fecha_nacimiento" />
		</p>
		<p>
			Edad: <input type="text" name="edad" readonly="readonly" />
		</p>
		<p>
			<input type="submit" name="guardar" value="Guardar" />
		</p>
	</form>
</body>
</html>