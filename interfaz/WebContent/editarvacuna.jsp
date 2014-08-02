<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar vacuna</title>
</head>
<body>
	<form method="POST" action="VacunaController">
		<input type="hidden" name="vacunaId" value="${vacuna.getId()}"/>
		<p>
			Nombre: <input type="text" name="nombre_vacuna" value="${vacuna.getNombre()}" />
		</p>
		<p>
			Laboratorio: <input type="text" name="laboratorio" value="${vacuna.getLaboratorio()}"
				 />
		</p>
		<p>
			Composición: <input type="text" name="composicion" value="${vacuna.getDroga()}"
				 />
		</p>
		<p>
			Notas: <input type="text" name="notas" value="${vacuna.getNotas()}" />
		</p>
		<p>
			<input type="submit" name="guardar" value="Guardar" />
		</p>
	</form>
</body>
</html>