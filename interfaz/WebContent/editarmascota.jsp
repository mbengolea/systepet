<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar mascota</title>
<%@ include file="dependencies.html"%>
<%@ include file="para_mascota.html"%>
<script>
	$(function() {
		$("#fecha_nacimiento").datepicker("setDate", "<c:if test="${empty error_validacion}"><fmt:formatDate pattern="dd/MM/yyyy" 
	            value="${mascota.getFechaNacimiento()}"/></c:if><c:if test="${!empty error_validacion}">${param.fecha_nacimiento}</c:if>");
		actualizarEdad();
	});
</script>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Editar mascota</div>
				<div class="contents">
					<form method="POST" action="MascotaController">
						<p>
							<label for="nombre_mascota"> Nombre de la mascota:</label> <input type="text" name="nombre_mascota"
								value="${empty error_validacion ? mascota.getNombre() : param.nombre}" />
						</p>
						<p class="error-p <c:if test="${empty nombre_invalido}">invisible</c:if>">
							<span class="error">El nombre es obligatorio</span>
						</p>
						<p>
							<label for="especie"> Especie:</label> <select id="especie" name="especie">
								<option value="CANINO" ${'CANINO'.equals(empty error_validacion ? mascota.getEspecie().name() : param.raza) ? 'selected' : ''}>canino</option>
								<option value="FELINO" ${'FELINO'.equals(empty error_validacion ? mascota.getEspecie().name() : param.raza) ? 'selected' : ''}>felino</option>
								<option value="OTRO" ${'OTRO'.equals(empty error_validacion ? mascota.getEspecie().name() : param.raza) ? 'selected' : ''}>otro</option>
							</select>
						</p>
						<p id="raza_p">
							<label for="raza"> Raza:</label> <input type="text" id="raza" name="raza" value="${empty error_validacion ? mascota.getRaza() : param.raza}" />
						</p>
						<p id="especie_especifica_p">
							<label for="especie_especifica"> Especifica:</label> <input type="text" id="especie_especifica" 
							name="especie_especifica" value="${empty error_validacion ? mascota.getEspecieEspecifica() : param.especie_especifica}" />
						</p>
						<p class="error-p <c:if test="${empty especie_especifica_invalida}">invisible</c:if>">
							<span class="error">La especie específica es obligatoria</span>
						</p>
						<p>
							<label for="fecha_nacimiento"> Fecha de nacimiento:</label> <input type="text"  id="fecha_nacimiento" name="fecha_nacimiento" />
						</p>
						<p class="error-p <c:if test="${empty fecha_nacimiento_invalida}">invisible</c:if>">
							<span class="error">La fecha de nacimiento debe estar en formato día/mes/año</span>
						</p>					
						<p class="error-p <c:if test="${empty fecha_nacimiento_futuro}">invisible</c:if>">
							<span class="error">La fecha de nacimiento no puede ser posterior al día de hoy</span>
						</p>					
						<p>
							<label for="edad"> Edad:</label> <input type="text" id="edad" name="edad" readonly="readonly" />
						</p>
						<p>
							<input class="button" type="submit" name="guardar" value="Guardar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>