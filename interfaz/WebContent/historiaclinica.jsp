<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historia clínica</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="5">
		<p>
			Fecha: <input type="text" name="fecha" readonly="readonly"
				value="<c:out value="${i}" />" />
		</p>
		<p>
			Veterinario: <input type="text" name="veterinario"
				readonly="readonly" />
		</p>
		<p>
			Vacunas: <input type="text" name="vacunas" readonly="readonly" />
		</p>
		<p>
			Vacunas a aplicar: <input type="text" name="vacunas_a_aplicar"
				readonly="readonly" />
		</p>
		<p>
			Detalles: <textarea name="detalles" readonly="readonly"></textarea>
		</p>
		<hr/>
	</c:forEach>
</body>
</html>