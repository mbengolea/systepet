<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva consulta</title>
<%@ include file="dependencies.html"%>
<script>
	$(function() {
		$("#fecha_aplicacion").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					dateFormat : "dd/mm/yy"
				});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Nueva consulta</div>
				<div class="contents">
					<form method="POST" action="MascotaController">
						<p>
							<label for="detalles">Detalles:</label>
							<textarea name="detalles"></textarea>
						</p>
						<div id="vacunas">
							<p>
								<label for="vacuna">Vacunas:</label>
								<c:forEach var="vacunaAgregada" items="${consulta.getVacunasRealizadas()}">
									<input type="text" readonly="readonly" value="${vacunaAgregada.getNombre()}" />
							</p>
							<p class="no-label-p">
								</c:forEach>
								<select name="vacunaId">
									<c:forEach var="vacuna" items="${vacunas}">
										<option value="${vacuna.getId()}">${vacuna.getNombre()}</option>
									</c:forEach>
								</select> <input class="small-button" type="submit" name="agregar_vacuna" value="+" />
							</p>
						</div>
						<div id="vacunas_a_aplicar">
							<p>
								<label for="vacunas_a_aplicar">Vacunas a aplicar:</label>
								<c:forEach var="aplicacionAgregada" items="${consulta.getAplicacionesAgendadas()}">
									<input type="text" readonly="readonly" value="${aplicacionAgregada.getVacuna().getNombre()}, <fmt:formatDate pattern="dd-MM-yyyy" value="${aplicacionAgregada.getFechaAplicacion() }" />" />
							</p>
							<p class="no-label-p">
								</c:forEach>
								<select name="vacunaAAplicarId">
									<c:forEach var="vacuna" items="${vacunas}">
										<option value="${vacuna.getId()}">${vacuna.getNombre()}</option>
									</c:forEach>
								</select> 
								<p class="no-label-p">
								<input type="text" id="fecha_aplicacion" name="fecha_aplicacion" />
								<input class="small-button" type="submit" name="agregar_aplicacion_agendada" value="+" />
							</p>
							</p>
						</div>
						<p>
							<input class="button" type="submit" name="guardar_consulta" value="Guardar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>