<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historia clínica</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Historia Clínica</div>
				<div class="contents">
				<form method="POST" action="MascotaController">
					<div>
						<input class="button" type="submit" name="volver_mascota" value="Volver" />
						<!--  -->
						<input class="button" type="submit" name="nueva_consulta" value="Nueva consulta" />
					</div>
					<div class="below-buttons">
					<c:forEach var="consulta" items="${mascota.getHistoriaClinica().iterator()}">
						<p>
							<label for="fecha">Fecha:</label><input type="text" name="fecha" readonly="readonly"
								value="${consulta.getFechaConsulta()}" />
						</p>
						<p>
							<label for="veterinario">Veterinario:</label><input type="text" name="veterinario"
								value="${consulta.getVeterinario()}" readonly="readonly" />
						</p>
						<c:if test="${consulta.getVacunasRealizadas().size() > 0}">
							<p>
								<label for="vacunas">Vacunas:</label>
								<c:forEach var="vacuna" items="${consulta.getVacunasRealizadas()}">
									<input type="text" readonly="readonly" value="${vacuna.getNombre()}" />
									</p>
									<p class="no-label-p">
								</c:forEach>
							</p>
						</c:if>
					<c:if test="${consulta.getAplicacionesAgendadas().size() > 0}">
						<p>
							<label for="vacunas_a_aplicar">Vacunas a aplicar:</label>
							<c:forEach var="aplicacionAgregada" items="${consulta.getAplicacionesAgendadas()}">
								<input type="text" readonly="readonly"
									value="${aplicacionAgregada.getVacuna().getNombre()}, <fmt:formatDate pattern="dd-MM-yyyy" value="${aplicacionAgregada.getFechaAplicacion() }" />" />
						</p>
						<p class="no-label-p">
							</c:forEach>
						</p>
					</c:if>
					<p>
						<label for="detalles">Detalles:</label>
						<textarea name="detalles" readonly="readonly">${consulta.getObservaciones()}</textarea>
					</p>
					<hr />
					</c:forEach>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>