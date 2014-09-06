<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar mascota</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Datos de búsqueda de mascotas</div>
				<div class="contents">
					<form method="POST" action="MascotaController">
						<p>
							<label for="dni_duenio">DNI del dueño:</label> <input type="text" name="dni_duenio" value="${param.dni_duenio}"/>
						</p>
						<p class="error-p <c:if test="${empty dni_invalido}">invisible</c:if>">
							<span class="error">El DNI solo puede contener números</span>
						</p>
						<p>
							<label for="nombre_duenio">Nombre del dueño:</label> <input type="text" name="nombre_duenio" value="${param.nombre_duenio}"/>
						</p>
						<p>
							<label for="telefono">Teléfono:</label> <input type="text" name="telefono" value="${param.telefono}"/>
						</p>
						<p class="error-p <c:if test="${empty telefono_invalido}">invisible</c:if>">
							<span class="error">El telefono solo puede contener números</span>
						</p>						
						<p>
							<label for="nombre_mascota">Nombre de la mascota:</label> <input type="text" name="nombre_mascota" value="${param.nombre_mascota}"/>
						</p>
						<p>
							<label for="historia_clinica">Historia clínica:</label> <input type="text" name="historia_clinica" value="${param.historia_clinica}"/>
						</p>
						<p class="error-p <c:if test="${empty historia_clinica_invalido}">invisible</c:if>">
							<span class="error">El código de historia clínica solo puede contener números</span>
						</p>						
						<p>
							<input class="button" type="submit" name="buscar_mascota" value="Buscar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>