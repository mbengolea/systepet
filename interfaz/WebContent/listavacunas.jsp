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
			<th>Nombre</th>
			<th>Laboratorio</th>
			<th></th>
		</tr>
		<c:forEach var="i" begin="1" end="5">
			<tr>
				<td>nombre</td>
				<td>labo</td>
				<td><a href="VacunaController?vacuna=<c:out value="${i}" />">
						Ver </a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>