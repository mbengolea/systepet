
<div id="header">SystePet</div>
<div id="menu-bar">
	<ul class="drop_menu">
		<li><a>Dueños</a>
			<ul>
				<li><a href="buscarduenio.jsp">Buscar Dueños</a></li>
				<li><a href="nuevoduenio.jsp">Nuevo Dueño</a></li>
			</ul></li>
		<li><a href="buscarmascota.jsp">Mascotas</a></li>
		<li><a>Vacunas</a>
			<ul>
				<li><a href="buscarvacuna.jsp">Buscar Vacunas</a></li>
				<li><a href="VacunaController?nueva_vacuna">Nueva Vacuna</a></li>
			</ul></li>
		<sec:one roles="administrador">
			<li><a>Usuarios</a>
				<ul>
					<li><a href="UsuarioController?listar">Listar Usuarios</a></li>
					<li><a href="UsuarioController?nuevo_usuario">Nuevo Usuario</a></li>
				</ul></li>
			<li><a href="ConfiguracionController?editar_configuracion_recordatorios">Recordatorios</a></li>
		</sec:one>
		<li><a href="AccesoController?salir">Salir</a>
			<ul>
				<li><a href="UsuarioController?cambiar_mi_contrasena">Cambiar Constraseña</a></li>
			</ul></li>
	</ul>
</div>