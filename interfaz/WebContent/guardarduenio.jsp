<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo dueño</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Nuevo dueño</div>
				<div class="contents">
					<form method="POST" action="DuenioController">
						<p>
							<label for="nombre"> Nombre:</label> <input type="text" name="nombre" />
						</p>
						<p>
							<label for="dni"> DNI:</label> <input type="text" name="dni" />
						</p>
						<p>
							<label for="direccion"> Dirección:</label> <input type="text" name="direccion" />
						</p>
						<p>
							<label for="telefono"> Teléfono:</label> <input type="text" name="telefono" />
						</p>
						<p>
							<label for="email"> E-mail:</label> <input type="text" name="email" />
						</p>
						<p>
							<label for="notificaicones"> Recibe notificaciones:</label> <input type="checkbox" name="notificaciones" />
						</p>

						<p>
							<input class="button" type="submit" name="guardar" value="Guardar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>