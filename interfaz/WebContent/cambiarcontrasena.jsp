<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cambiar Contrase�a</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Cambiar Contrase�a</div>
				<div class="contents">
					<form method="POST" action="UsuarioController">
						<c:if test="${!empty mi_contrasena} }">
							<input type="hidden" name="mi_contrasena" value="mi_contrasena" />
						</c:if>
						<p>
							<label for="password"> Contrase�a:</label> <input type="password" name="password" />
						</p>
						<p>
							<label for="password2"> Confirme Contrase�a:</label> <input type="password" name="password2" />
						</p>
						<p class="error-p <c:if test="${empty contrasena_invalida}">invisible</c:if>">
							<span class="error">La contrase�a es obligatoria</span>
						</p>
						<p class="error-p <c:if test="${empty contrasenas_distintas}">invisible</c:if>">
							<span class="error">Las contrase�as no son iguales</span>
						</p>
						<p>
							<input class="button" type="submit" name="guardar_contrasena" value="Guardar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>