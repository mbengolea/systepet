<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar vacuna</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Datos de búsqueda de vacunas</div>
				<div class="contents">
					<form method="POST" action="VacunaController">
						<p>
							<label for="nombre">Nombre:</label><input type="text" name="nombre" />
						</p>
						<p>
							<input class="button" type="submit" name="buscar_vacuna" value="Buscar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>