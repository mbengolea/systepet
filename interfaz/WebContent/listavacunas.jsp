<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de b�squeda</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Resultado de b�squeda de vacunas</div>
				<table class="tabla">
					<tr>
						<th>Nombre</th>
						<th>Laboratorio</th>
						<th></th>
					</tr>
					<c:forEach var="vacuna" items="${vacunas}">
						<tr>
							<td>${vacuna.getNombre()}</td>
							<td>${vacuna.getLaboratorio()}</td>
							<td><a class="button" href="VacunaController?vacunaId=${vacuna.getId()}"> Ver </a></td>
						</tr>
					</c:forEach>
				</table>
				<p><a class="button belowtable" href="VacunaController?cancelar_lista_vacuna"> Volver </a></p>
			</div>
		</div>
	</div>
</body>
</html>