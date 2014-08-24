<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<c:forEach var="consulta" items="${mascota.getHistoriaClinica().iterator()}">
						<p>
							<label for="fecha">Fecha:</label><input type="text" name="fecha" readonly="readonly"
								value="${consulta.getFechaConsulta()}" />
						</p>
						<p>
							<label for="veterinario">Veterinario:</label><input type="text" name="veterinario"
								value="${consulta.getVeterinario()}" readonly="readonly" />
						</p>
						<p>
							<label for="vacunas">Vacunas:</label><input type="text" name="vacunas" readonly="readonly" />
						</p>
						<p>
							<label for="vacunas_a_aplicar">Vacunas a aplicar:</label><input type="text" name="vacunas_a_aplicar"
								readonly="readonly" />
						</p>
						<p>
							<label for="detalles">Detalles:</label>
							<textarea name="detalles" readonly="readonly">${consulta.getObservaciones()}</textarea>
						</p>
						<hr />
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>