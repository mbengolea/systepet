<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos de mascota</title>
</head>
<body>
	<form method="POST" action="MascotaController">
		<p>
			Historia clínica: <input type="text" name="nro_historia_clinica"
				value="${mascota.getId()}" readonly="readonly" />
		</p>
		<p>
			Nombre de la mascota: <input type="text" name="nombre_mascota"
				value="${mascota.getNombre()}" readonly="readonly" />
		</p>
		<p>
			Especie: <input type="text" name="especie"
				value="${mascota.getEspecie()}" readonly="readonly" />
		</p>
		<p>
			Raza: <input type="text" name="raza" value="${mascota.getRaza()}"
				readonly="readonly" />
		</p>
		<p>
			Fecha de nacimiento: <input type="text" name="fecha_nacimiento"
				value="<fmt:formatDate pattern="dd-MM-yyyy" 
            value="${mascota.getFechaNacimiento() }" />"
				readonly="readonly" />
		</p>
		<p>
			Edad: <input type="text" name="edad"
				value="${mascota.getEdadEnAnios()}" readonly="readonly" />
		</p>
		<p>
			Vive: <input type="checkbox" name="vive"
				<c:if test="${mascota.isVivo()}">checked="checked"</c:if>
				onClick="return false;" />
		</p>
		<p>
			Nombre del dueño: <input type="text" name="nombre_duenio"
				value="${mascota.getDuenio().getNombre()}" readonly="readonly" />
		</p>
		<p>
			DNI del dueño: <input type="text" name="dni_duenio"
				value="${mascota.getDuenio().getDni()}" readonly="readonly" />
		</p>
		<p>
			Teléfono: <input type="text" name="telefono" readonly="readonly"
				value="${mascota.getDuenio().getTelefono()}" />
		</p>
		<p>
			Dirección: <input type="text" name="direccion" readonly="readonly"
				value="${mascota.getDuenio().getDireccion()}" />
		</p>
		<p>
			Correo electrónico: <input type="text" name="e_mail"
				value="${mascota.getDuenio().getEmail()}" readonly="readonly" />
		</p>
		<p>
			Recibe notificaciones: <input type="checkbox" name="notificaciones"
				<c:if test="${mascota.getDuenio().isRecibeNotificaciones()}">checked="checked"</c:if>
				onClick="return false;" />
		</p>
		<p>
			<input type="submit" name="historia_clinica" value="Historia clínica" />
			<!--  -->
			<input type="submit" name="editar_mascota" value="Modificar" />
			<!--  -->
			<input type="submit" name="nueva_consulta" value="Nueva consulta" />
		</p>
	</form>
</body>
</html>