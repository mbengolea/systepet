<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de búsqueda</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Lista de dueños</div>
				<table class="tabla">
					<tr>
						<th>Nombre</th>
						<th>DNI</th>
						<th>Teléfono</th>
						<th>E-mail</th>
						<th></th>
					</tr>
					<c:forEach var="duenio" items="${duenios}">
						<tr>
							<td>${duenio.getNombre()}</td>
							<td>${duenio.getDni()}</td>
							<td>${duenio.getTelefono()}</td>
							<td>${duenio.getEmail()}</td>
							<td><a class="button" href="DuenioController?duenioId=${duenio.getId()}"> Ver </a></td>
						</tr>
					</c:forEach>
				</table>
				<p><a class="button belowtable" href="DuenioController?cancelar_lista_duenio"> Volver </a></p>
			</div>
		</div>
	</div>
</body>
</html>