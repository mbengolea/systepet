
<div id="header">SystePet</div>
<div id="menu-bar">
	<ul class="drop_menu">
		<li><a>Due�os</a>
			<ul>
				<li><a href="buscarduenio.jsp">Buscar Due�os</a></li>
				<li><a href="nuevoduenio.jsp">Nuevo Due�o</a></li>
			</ul>
		<li><a href="buscarmascota.jsp">Mascotas</a></li>
		<li><a href="buscarvacuna.jsp">Vacunas</a></li>
		<sec:one roles="administrador">
			<li><a href="UsuarioController?listar">Usuarios</a>
				<ul>
					<li><a href="nuevousuario.jsp">Nuevo Usuario</a></li>
				</ul>
			</li>
		</sec:one>
	</ul>
	<a href="AccesoController?salir" class="salir">Salir</a>
</div>