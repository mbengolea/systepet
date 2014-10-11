<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec"%>
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
							<label for="nombre_usuario"> Nombre de usuario:</label> <input type="text" name="nombre_usuario"
								value="${empty error_validacion ? usuario.getNombreUsuario() : param.nombre_usuario}" readonly="readonly" />
						</p>
						<p class="error-p <c:if test="${empty nombre_invalido}">invisible</c:if>">
							<span class="error">El nombre de usuario es obligatorio</span>
						</p>
						<p>
							<label for="nombre_real"> Nombre real:</label> <input type="text" name="nombre_real"
								value="${empty error_validacion ? usuario.getNombre() : param.nombre_real}" />
						</p>
						<p class="error-p <c:if test="${empty nombre_real_invalido}">invisible</c:if>">
							<span class="error">El nombre real es obligatorio</span>
						</p>
						<p>
							<label for="rol"> Rol:</label> <select id="rol" name="rol">
								<c:forEach var="rol" items="${roles}">
									<option value="${rol.name()}"
										${rol.name().equals(empty error_validacion ? usuario.getRol().name() : param.rol) ? 'selected' : ''}>${rol.getNombreRol()}</option>
								</c:forEach>
							</select>
						</p>
						<p class="error-p <c:if test="${empty rol_invalido}">invisible</c:if>">
							<span class="error">Se debe seleccionar un rol de la lista</span>
						</p>
						<p>
							<sec:one roles="administrador">
								<input class="button" type="submit" name="guardar_usuario" value="Guardar" />
							</sec:one>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>