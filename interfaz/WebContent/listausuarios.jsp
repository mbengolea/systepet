<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios del sistema</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Usuarios del sistema</div>
				<table class="tabla">
					<tr>
						<th>Nombre de Usuario</th>
						<th>Nombre Real</th>
						<th></th>
					</tr>
					<c:forEach var="usuario" items="${usuarios}">
						<tr>
							<td>${usuario.getNombreUsuario()}</td>
							<td>${usuario.getNombre()}</td>
							<td><a class="button" href="UsuarioController?usuario=<c:out value="${usuario.getNombreUsuario()}" />"> Ver </a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>