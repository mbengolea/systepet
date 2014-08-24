<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva vacuna</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Mascota</div>
				<div class="contents">
					<form method="POST" action="VacunaController">
						<p>
							<label for="nombre_vacuna"> Nombre:</label> <input type="text" name="nombre_vacuna" />
						</p>
						<p>
							<label for="laboratorio"> Laboratorio:</label> <input type="text" name="laboratorio" />
						</p>
						<p>
							<label for="composicion"> Composición:</label> <input type="text" name="composicion" />
						</p>
						<p>
							<label for="notas"> Notas:</label> <input type="text" name="notas" />
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