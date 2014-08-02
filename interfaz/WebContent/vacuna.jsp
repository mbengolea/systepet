<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de vacuna</title>
</head>
<body>
	<form method="POST" action="VacunaController" >
		<input type="hidden" name="vacunaId" value="${vacuna.getId()}"/>
		<p>
			Nombre: <input type="text" name="nombre_vacuna" value="${vacuna.getNombre()}" readonly="readonly" />
		</p>
		<p>
			Laboratorio: <input type="text" name="laboratorio" value="${vacuna.getLaboratorio()}"
				readonly="readonly" />
		</p>
		<p>
			Composición: <input type="text" name="composicion" value="${vacuna.getDroga()}"
				readonly="readonly" />
		</p>
		<p>
			Notas: <input type="text" name="notas" value="${vacuna.getNotas()}" readonly="readonly" />
		</p>
		<p>
			Activa: <input type="checkbox" name="activa" <c:if test="${vacuna.isActiva()}">checked="checked"</c:if> onClick="return false;" />
		</p>
		<p>
			<input type="submit" name="borrar_vacuna" value="Baja"  onclick="return confirm('Está seguro de que quiere dar de baja esta vacuna?')"/>
			<!--  -->
			<input type="submit" name="editar_vacuna" value="Modificar" />
		</p>
	</form>
</body>
</html>