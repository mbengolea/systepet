<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de vacuna</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Vacuna</div>
				<div class="contents">
					<form method="POST" action="VacunaController">
						<input type="hidden" name="vacunaId" value="${vacuna.getId()}" />
						<p>
							<label for="nombre_vacuna"> Nombre:</label> <input type="text" name="nombre_vacuna" value="${vacuna.getNombre()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="laboratorio"> Laboratorio:</label> <input type="text" name="laboratorio"
								value="${vacuna.getLaboratorio()}" readonly="readonly" />
						</p>
						<p>
							<label for="composicion"> Composición:</label> <input type="text" name="composicion" value="${vacuna.getDroga()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="notas"> Notas:</label> <input type="text" name="notas" value="${vacuna.getNotas()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="activa"> Activa:</label> <input type="checkbox" name="activa"
								<c:if test="${vacuna.isActiva()}">checked="checked"</c:if> onClick="return false;" />
						</p>
						<p>
							<sec:one roles="jefe_veterinario">
							<input class="button" type="submit" name="borrar_vacuna" value="Baja"
								onclick="return confirm('Está seguro de que quiere dar de baja esta vacuna?')" />
							<!--  -->
							<input class="button" type="submit" name="editar_vacuna" value="Modificar" />
							</sec:one>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>