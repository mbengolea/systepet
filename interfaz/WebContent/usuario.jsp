<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de usuario</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Usuario</div>
				<div class="contents">
					<form method="POST" action="UsuarioController">
						<p>
							<label for="nombre_usuario"> Nombre de usuario:</label> <input type="text" name="nombre_usuario" value="${usuario.getNombreUsuario()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="nombre_real"> Nombre real:</label> <input type="text" name="nombre_real" value="${usuario.getNombre()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="rol"> Rol:</label> <input type="text" name="rol" value="${usuario.getRol()}"
								readonly="readonly" />
						</p>
						<p>
							<sec:one roles="administrador">
							<input class="button" type="submit" name="borrar_usuario" value="Baja"
								onclick="return confirm('Está seguro de que quiere dar de baja este usuario?')" />
							<!--  -->
							<input class="button" type="submit" name="editar_usuario" value="Modificar" />
							</sec:one>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>