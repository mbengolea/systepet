<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmación de envío</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header"></div>
				<div class="contents">
				<form method="POST" action="ConfiguracionController">
					<p>Los recordatorios han sido enviados.</p>
					<p>
						<input class="button" type="submit"
							name="cerrar_confirmacion" value="Inicio" />
					</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>