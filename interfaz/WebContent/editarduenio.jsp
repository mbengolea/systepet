<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar dueño</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Editar dueño</div>
				<div class="contents">
					<form method="POST" action="DuenioController">
						<input type="hidden" name="duenioId" value="${duenio.getId()}" />
						<p>
							<label for="nombre"> Nombre:</label> <input type="text" name="nombre" value="${duenio.getNombre()}" />
						</p>
						<p>
							<label for="dni"> DNI del dueño:</label> <input type="text" name="dni" value="${duenio.getDni()}" />
						</p>
						<p>
							<label for="telefono"> Teléfono:</label> <input type="text" name="telefono" value="${duenio.getTelefono()}" />
						</p>
						<p>
							<label for="direccion"> Dirección:</label> <input type="text" name="direccion" value="${duenio.getDireccion()}" />
						</p>
						<p>
							<label for="e_mail"> Correo electrónico:</label> <input type="text" name="e_mail" value="${duenio.getEmail()}" />
						</p>
						<p>
							<label for="notificaciones"> Recibe notificaciones:</label> <input type="checkbox" name="notificaciones" />
						</p>
						<p>
							<input class="button" type="submit" name="guardar_duenio" value="Guardar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>