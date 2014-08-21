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
		<input type="hidden" name="duenioId" value="${duenio.getId()}"/>
		<p>
			Nombre: <input type="text" name="nombre" value="${duenio.getNombre()}" readonly="readonly" />
		</p>
		<p>
			DNI del due�o: <input type="text" name="dni" value="${duenio.getDni()}" readonly="readonly" />
		</p>
		<p>
			Tel�fono: <input type="text" name="telefono" value="${duenio.getTelefono()}" readonly="readonly" />
		</p>
		<p>
			Direcci�n: <input type="text" name="direccion"  value="${duenio.getDireccion()}" readonly="readonly" />
		</p>
		<p>
			Correo electr�nico: <input type="text" name="e_mail" value="${duenio.getEmail()}"
				readonly="readonly" />
		</p>
		<p>
			Recibe notificaciones: <input type="checkbox" name="notificaciones" <c:if test="${duenio.isRecibeNotificaciones()}">checked="checked"</c:if> onClick="return false;" 
				/>
		</p>
		<table>
			<tr>
				<th>Historia Cl�nica</th>
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