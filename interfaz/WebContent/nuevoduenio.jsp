<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de mascota</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Mascota</div>
				<div class="contents">
					<form method="POST" action="DuenioController">
						<p>
							<label for="nombre"> Nombre:</label> <input type="text" name="nombre" value="${nombre}"/>
						</p>
						<p class="error-p <c:if test="${empty nombre_invalido}">invisible</c:if>">
							<span class="error">El nombre no puede estar vacío</span>
						</p>							
						<p>
							<label for="dni"> DNI del dueño:</label> <input type="text" name="dni" value="${param.dni}"/>
						</p>
						<p class="error-p <c:if test="${empty dni_invalido}">invisible</c:if>">
							<span class="error">El DNI solo puede contener números</span>
						</p>						
						<p>
							<label for="telefono"> Teléfono:</label> <input type="text" name="telefono" value="${param.telefono}" />
						</p>
						<p class="error-p <c:if test="${empty telefono_invalido}">invisible</c:if>">
							<span class="error">El telefono solo puede contener números</span>
						</p>						
						<p>
							<label for="direccion"> Dirección:</label> <input type="text" name="direccion" value="${param.direccion}" />
						</p>
						<p>
							<label for="e_mail"> Correo electrónico:</label> <input type="text" name="e_mail" value="${param.e_mail}" />
						</p>
						<p class="error-p <c:if test="${empty e_mail_invalido}">invisible</c:if>">
							<span class="error">El correo electrónico no es válido</span>
						</p>							
						<p>
							<label for="notificaciones"> Recibe notificaciones:</label> <input type="checkbox" name="notificaciones" <c:if test="${!empty param.notificaciones}">checked="checked"</c:if> />
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