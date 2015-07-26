<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
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
							<label for="nombre"> Nombre:</label> <input type="text" name="nombre" value="${empty error_validacion ? duenio.getNombre() : param.nombre}" />
						</p>
						<p class="error-p <c:if test="${empty nombre_invalido}">invisible</c:if>">
							<span class="error">El nombre no puede estar vacío</span>
						</p>							
						<p>
							<label for="dni"> DNI del dueño:</label> <input type="text" name="dni" value="${empty error_validacion ? duenio.getDni() : param.dni}" />
						</p>
						<p class="error-p <c:if test="${empty dni_invalido}">invisible</c:if>">
							<span class="error">El DNI solo puede contener números</span>
						</p>						
						<p>
							<label for="telefono"> Teléfono:</label> <input type="text" name="telefono" value="${empty error_validacion ? duenio.getTelefono() : param.telefono}" />
						</p>
						<p class="error-p <c:if test="${empty telefono_invalido}">invisible</c:if>">
							<span class="error">El telefono solo puede contener números</span>
						</p>						
						<p>
							<label for="direccion"> Dirección:</label> <input type="text" name="direccion" value="${empty error_validacion ? duenio.getDireccion() : param.direccion}" />
						</p>
						<p>
							<label for="e_mail"> Correo electrónico:</label> <input type="text" name="e_mail" value="${empty error_validacion ? duenio.getEmail() : param.e_mail}" />
						</p>
						<p class="error-p <c:if test="${empty e_mail_invalido}">invisible</c:if>">
							<span class="error">El correo electrónico no es válido</span>
						</p>						
						<p>
							<label for="notificaciones"> Recibe notificaciones:</label> 
							<input type="checkbox" name="notificaciones" <c:if test="${empty error_validacion ? duenio.isRecibeNotificaciones() : (param.notificaciones != null)}">checked="checked"</c:if> />
						</p>
						<p>
							<input class="button" type="submit" name="cancelar_guardar_duenio" value="Cancelar" />
							<input class="button" type="submit" name="guardar_duenio" value="Guardar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>