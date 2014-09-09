<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar dueño</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Datos de búsqueda de dueños</div>
				<div class="contents">
					<form method="POST" action="DuenioController">
						<p>
							<label for="dni_duenio">DNI del dueño:</label><input type="text" name="dni_duenio" value="${param.dni_duenio}"/>
						</p>
						<p class="error-p <c:if test="${empty dni_invalido}">invisible</c:if>">
							<span class="error">El DNI solo puede contener números</span>
						</p>
						<p>
							<label for="nombre_duenio">Nombre del dueño:</label><input type="text" name="nombre_duenio" value="${param.nombre_duenio}"/>
						</p>
						<p>
							<label for="telefono">Teléfono:</label><input type="text" name="telefono" value="${param.telefono}"/>
						</p>
						<p class="error-p <c:if test="${empty telefono_invalido}">invisible</c:if>">
							<span class="error">El telefono solo puede contener números</span>
						</p>						
						<p>
							<input class="button" type="submit" name="buscar_duenio" value="Buscar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>