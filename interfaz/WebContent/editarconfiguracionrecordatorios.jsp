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
					<form method="POST" action="ConfiguracionController">
						<p>
							<label for="email_origen">E-mail:</label> <input type="text" name="email_origen"
								value="${empty error_validacion ? configuracion.getEmailOrigen() : param.email_origen}" />
						</p>
						<p class="error-p <c:if test="${empty email_origen_invalido}">invisible</c:if>">
							<span class="error">La dirección de e-mail es obligatoria</span>
						</p>
						<p>
							<label for="usuario_origen">Nombre de usuario:</label> <input type="text" name="usuario_origen"
								value="${empty error_validacion ? configuracion.getUsuario() : param.usuario_origen}" />
						</p>
						<p class="error-p <c:if test="${empty usuario_origen_invalido}">invisible</c:if>">
							<span class="error">El nombre de usuario es obligatorio</span>
						</p>
						<p>
							<label for="password">Contraseña:</label> <input type="password" name="password"
								value="${empty error_validacion ? configuracion.getPassword() : param.password}" />
						</p>
						<p>
							<label for="password2">Confirme Contraseña:</label> <input type="password" name="password2"
								value="${empty error_validacion ? configuracion.getPassword() : param.password2}" />
						</p>
						<p class="error-p <c:if test="${empty password_invalido}">invisible</c:if>">
							<span class="error">La contraseña es obligatoria</span>
						</p>
						<p class="error-p <c:if test="${empty contrasenas_distintas}">invisible</c:if>">
							<span class="error">Las contraseñas no son iguales</span>
						</p>
						<p>
							<label for="asunto">Asunto del recordatorio:</label> <input type="text" name="asunto"
								value="${empty error_validacion ? configuracion.getAsunto() : param.asunto}" />
						</p>
						<p class="error-p <c:if test="${empty asunto_invalido}">invisible</c:if>">
							<span class="error">El asunto del recordatorio es obligatorio</span>
						</p>
						<p>
							<label for="plantilla">Plantilla del mensaje:</label> <textarea name="plantilla">${empty error_validacion ? configuracion.getPlantilla() : param.plantilla}</textarea>
						</p>
						<p class="error-p <c:if test="${empty plantilla_invalida}">invisible</c:if>">
							<span class="error">La plantilla del mensaje no es válida</span>
						</p>
						<p>
							<label for="dias_anterioridad">Días de preaviso:</label> <input type="text" name="dias_anterioridad"
								value="${empty error_validacion ? configuracion.getDiasDeAnterioridad() : param.dias_anterioridad}" />
						</p>
						<p class="error-p <c:if test="${empty dias_anterioridad_invalido}">invisible</c:if>">
							<span class="error">El valor de días de preaviso debe ser un número</span>
						</p>
						<p>
							<label for="habilitado">Recordatorios habilitados:</label> 
							<input type="checkbox" name="habilitado" <c:if test="${empty error_validacion ? configuracion.isEnvioHabilitado() : (param.habilitado != null)}">checked="checked"</c:if> />
						</p>						
						<p>
							<sec:one roles="administrador">
								<input class="button" type="submit" name="guardar_configuracion_recordatorios" value="Guardar" />
							</sec:one>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>