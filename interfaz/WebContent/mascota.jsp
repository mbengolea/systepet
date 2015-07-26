<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec"%>
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
							<label for="nro_historia_clinica"> Historia cl�nica:</label> <input
								type="text" name="nro_historia_clinica"
								value="${mascota.getId()}" readonly="readonly" />
						</p>
						<p>
							<label for="nombre_mascota"> Nombre de la mascota:</label> <input
								type="text" name="nombre_mascota" value="${mascota.getNombre()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="especie"> Especie:</label> <input type="text"
								name="especie" value="${mascota.getEspecie()}"
								readonly="readonly" />
						</p>
						<p>
							<label for="raza"> Raza:</label> <input type="text" name="raza"
								value="${mascota.getRaza()}" readonly="readonly" />
						</p>
						<p>
							<label for="sexo"> Sexo:</label> <input type="text" name="sexo"
								value="${mascota.getSexo()}" readonly="readonly" />
						</p>
						<p>
							<label for="fecha_nacimiento"> Fecha de nacimiento:</label> <input
								type="text" name="fecha_nacimiento"
								value="<fmt:formatDate pattern="dd-MM-yyyy" 
            value="${mascota.getFechaNacimiento() }" />"
								readonly="readonly" />
						</p>
						<p>
							<label for="edad"> Edad:</label> <input type="text" name="edad"
								value="${mascota.getEdad()}" readonly="readonly" />
						</p>
						<p>
							<label for="vive"> Vive:</label> <input type="checkbox"
								name="vive"
								<c:if test="${mascota.isVivo()}">checked="checked"</c:if>
								onClick="return false;" />
						</p>
						<p>
							<label for="nombre_duenio"> Nombre del due�o:</label> <input
								type="text" name="nombre_duenio"
								value="${mascota.getDuenio().getNombre()}" readonly="readonly" />
						</p>
						<p>
							<label for="dni_duenio"> DNI del due�o:</label> <input
								type="text" name="dni_duenio"
								value="${mascota.getDuenio().getDni()}" readonly="readonly" />
						</p>
						<p>
							<label for="telefono"> Tel�fono:</label> <input type="text"
								name="telefono" readonly="readonly"
								value="${mascota.getDuenio().getTelefono()}" />
						</p>
						<p>
							<label for="direccion"> Direcci�n:</label> <input type="text"
								name="direccion" readonly="readonly"
								value="${mascota.getDuenio().getDireccion()}" />
						</p>
						<p>
							<label for="e_mail"> Correo electr�nico:</label> <input
								type="text" name="e_mail"
								value="${mascota.getDuenio().getEmail()}" readonly="readonly" />
						</p>
						<p>
							<label for="notificaciones"> Recibe notificaciones:</label> <input
								type="checkbox" name="notificaciones"
								<c:if test="${mascota.getDuenio().isRecibeNotificaciones()}">checked="checked"</c:if>
								onClick="return false;" />
						</p>
						<p>
							<c:if test="${!empty con_volver}">
								<input class="button" type="submit" name="volver_a_lista"
									value="Volver" />
							</c:if>
							<!--  -->
							<input class="button" type="submit" name="ver_duenio"
								value="Ver due�o" />
							<!--  -->
							<input class="button" type="submit" name="historia_clinica"
								value="Historia cl�nica" />
							<!--  -->
							<input class="button" type="submit" name="editar_mascota"
								value="Modificar" />
							<!--  -->
							<input class="button" type="submit" name="nueva_consulta"
								value="Nueva consulta" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>