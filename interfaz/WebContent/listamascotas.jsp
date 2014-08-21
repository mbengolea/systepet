<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado de b�squeda</title>
</head>
<body>
	<table>
		<tr>
			<th>Historia Cl�nica</th>
			<th>Nombre</th>
			<th>Especie</th>
			<th>Due�o</th>
			<th></th>
		</tr>
		<c:forEach  var="mascota" items="${mascotas}">
			<tr>
				<td>${mascota.getId()}</td>
				<td>${mascota.getNombre()}</td>
				<td>${mascota.getEspecie()}</td>
				<td>${mascota.getNombreDuenio()}</td>
				<td><a href="MascotaController?mascotaId=<c:out value="${mascota.getId()}" />">
						Ver </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>