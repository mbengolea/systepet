<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de búsqueda</title>
</head>
<body>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Laboratorio</th>
			<th></th>
		</tr>
		<c:forEach var="vacuna" items="${vacunas}">
			<tr>
				<td>${vacuna.getNombre()}</td>
				<td>labo</td>
				<td><a href="VacunaController?vacunaId=${vacuna.getId()}">
						Ver </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>