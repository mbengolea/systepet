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
	<form method="POST" action="MascotaController">
		<p>
			Historia clínica: <input type="text" name="nro_historia_clinica"
				readonly="readonly" />
		</p>
		<p>
			Nombre de la mascota: <input type="text" name="nombre_mascota"
				readonly="readonly" />
		</p>
		<p>
			Especie: <input type="text" name="especie" readonly="readonly" />
		</p>
		<p>
			Raza: <input type="text" name="raza" readonly="readonly" />
		</p>
		<p>
			Fecha de nacimiento: <input type="text" name="fecha_nacimiento"
				readonly="readonly" />
		</p>
		<p>
			Edad: <input type="text" name="edad" readonly="readonly" />
		</p>
		<p>
			Vive: <input type="text" name="vive" readonly="readonly" />
		</p>
		<p>
			Nombre del dueño: <input type="text" name="nombre_duenio"
				readonly="readonly" />
		</p>
		<p>
			DNI del dueño: <input type="text" name="dni_duenio"
				readonly="readonly" />
		</p>
		<p>
			Teléfono: <input type="text" name="telefono" readonly="readonly" />
		</p>
		<p>
			Dirección: <input type="text" name="direccion" readonly="readonly" />
		</p>
		<p>
			Correo electrónico: <input type="text" name="e_mail"
				readonly="readonly" />
		</p>
		<p>
			Recibe notificaciones: <input type="text" name="notificaciones"
				readonly="readonly" />
		</p>
		<p>
			<input type="submit" name="historia_clinica" value="Historio clínica" />
			<!--  -->
			<input type="submit" name="editar_mascota" value="Modificar" />
			<!--  -->
			<input type="submit" name="nueva_consulta" value="Nueva consulta" />
		</p>
	</form>
</body>
</html>