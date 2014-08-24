<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de mascota</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Mascota</div>
				<div class="contents">
					<form method="POST" action="MascotaController">
						<p>
							<label for="nombre_mascota"> Nombre de la mascota:</label> <input type="text" name="nombre_mascota" />
						</p>
						<p>
							<label for="especie"> Especie:</label> <select name="especie">
								<option value="canino">canino</option>
								<option value="felino">felino</option>
								<option value="otro">otro</option>
							</select>
						</p>
						<p>
							<label for="raza"> Raza:</label> <input type="text" name="raza" />
						</p>
						<p>
							<label for="fecha_nacimiento"> Fecha de nacimiento:</label> <input type="text" name="fecha_nacimiento" />
						</p>
						<p>
							<label for="edad"> Edad:</label> <input type="text" name="edad" readonly="readonly" />
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