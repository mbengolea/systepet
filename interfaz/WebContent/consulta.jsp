<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva consulta</title>
<%@ include file="dependencies.html"%>
</head>
<body>
	<div id="wrapper">
		<%@ include file="menu.jsp"%>
		<div id="contents">
			<div class="container">
				<div class="header">Nueva consulta</div>
				<div class="contents">
					<form method="POST" action="MascotaController">
						<p>
							<label for="detalles">Detalles:</label>
							<textarea name="detalles"></textarea>
						</p>
						<p>
							<label for="vacunas">Vacunas:</label> <input type="text" name="vacunas" />
						</p>
						<p>
							<label for="vacunas_a_aplicar">Vacunas a aplicar:</label> <input type="text" name="vacunas_a_aplicar" />
						</p>
						<p>
							<input class="button" type="submit" name="guardar_consulta" value="Guardar" />
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>