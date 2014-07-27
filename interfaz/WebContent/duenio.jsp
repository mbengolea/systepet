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
	<form method="GET" action="DuenioController">
		<p>
			Nombre: <input type="text" name="nombre" readonly="readonly" />
		</p>
		<p>
			DNI del dueño: <input type="text" name="dni" readonly="readonly" />
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
		<table>
			<tr>
				<th>Historia Clínica</th>
				<th>Nombre</th>
				<th>Fecha nacimiento</th>
				<th></th>
			</tr>
			<c:forEach var="i" begin="1" end="5">
				<tr>
					<td><c:out value="${i}" /></td>
					<td>nombre</td>
					<td>fecha nacimiento</td>
					<td><a href="MascotaController?mascota=<c:out value="${i}" />">
							Ver </a></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<input type="submit" name="nueva_mascota" value="Nueva mascota" />
			<!--  -->
			<input type="submit" name="editar_duenio" value="Modificar" />
		</p>
	</form>
</body>
</html>