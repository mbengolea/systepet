<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de dueño</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Dueño</div>
				<div class="contents">
					<form method="GET" action="DuenioController">
						<input type="hidden" name="duenioId" value="${duenio.getId()}" />
						<p>
							<label for="nombre"> Nombre:</label> <input type="text" name="nombre" value="${duenio.getNombre()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="dni"> DNI del dueño:</label> <input type="text" name="dni" value="${duenio.getDni()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="telefono"> Teléfono:</label> <input type="text" name="telefono" value="${duenio.getTelefono()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="direccion"> Dirección:</label> <input type="text" name="direccion" value="${duenio.getDireccion()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="e_mail"> Correo electrónico:</label> <input type="text" name="e_mail" value="${duenio.getEmail()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="notificaciones"> Recibe notificaciones:</label> <input type="checkbox" name="notificaciones"
								<c:if test="${duenio.isRecibeNotificaciones()}">checked="checked"</c:if> onClick="return false;" />
						</p>
						<p>
							<label class="for-inner-table" for="mascotas">Mascotas:</label>
						</p>
						<table class="tabla inner-table">
							<tr>
								<th>Historia Clínica</th>
								<th>Nombre</th>
								<th>Fecha nacimiento</th>
								<th></th>
							</tr>
							<c:forEach var="mascota" items="${duenio.getMascotas()}">
								<tr>
									<td>${mascota.getId()}</td>
									<td>${mascota.getNombre()}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy" value="${mascota.getFechaNacimiento()}"/></td>
									<td><a class="button" href="MascotaController?mascotaId=${mascota.getId()}"> Ver </a></td>
								</tr>
							</c:forEach>
						</table>
						<p class="buttons">
							<input class="button" type="submit" name="nueva_mascota" value="Nueva mascota" />
							<!--  -->
							<input class="button" type="submit" name="editar_duenio" value="Modificar" />
							<!--  -->
							<c:if test="${!empty con_volver}"><input class="button" type="submit" name="volver_a_lista" value="Volver" /></c:if>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>