<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.samaxes.com/taglib/secure" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error de ingreso</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<div id="contents">
			<div class="container">
				<div class="header"></div>
				<div class="contents">
				<p>El usuario o contraseña no son válidos.</p>
				<p><input type="submit" class="button" onclick="window.history.back();" value="Volver"/></p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>