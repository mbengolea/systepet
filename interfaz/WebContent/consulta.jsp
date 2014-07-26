<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva consulta</title>
</head>
<body>
	<form method="POST" action="MascotaController">
		<p>
			Detalles: <textarea name="detalles" readonly="readonly"></textarea>
		</p>
		<p>
			Vacunas: <input type="text" name="vacunas" readonly="readonly" />
		</p>
		<p>
			Vacunas a aplicar: <input type="text" name="vacunas_a_aplicar"
				readonly="readonly" />
		</p>
		<p>
			<input type="submit" name="guardar_consulta" value="Guardar" />
		</p>
	</form>
</body>
</html>