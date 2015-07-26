
<div id="header">SystePet</div>
<div id="menu-bar">
	<ul class="drop_menu">
		<li><a>Due�os</a>
			<ul>
				<li><a href="buscarduenio.jsp">Buscar Due�os</a></li>
				<li><a href="DuenioController?nuevo_duenio">Nuevo Due�o</a></li>
			</ul></li>
		<li><a>Mascotas</a>
			<ul>
				<li><a href="buscarmascota.jsp">Buscar Mascotas</a></li>

			</ul></li>
		<li><a>Vacunas</a>
			<ul>
				<li><a href="buscarvacuna.jsp">Buscar Vacunas</a></li>
				<sec:one roles="jefe_veterinario">
				<li><a href="VacunaController?nueva_vacuna">Nueva Vacuna</a></li>
			    </sec:one>
			</ul></li>
		<sec:one roles="administrador">
			<li><a>Usuarios</a>
				<ul>
					<li><a href="UsuarioController?listar">Listar Usuarios</a></li>
					<li><a href="UsuarioController?nuevo_usuario">Nuevo
							Usuario</a></li>
				</ul></li>
			<li><a>Recordatorios</a>
				<ul>
					<li><a
						href="ConfiguracionController?envio_manual_recordatorios">Enviar
							Recordatorios</a></li>
					<li><a
						href="ConfiguracionController?editar_configuracion_recordatorios">Configurar
							Recordatorios</a></li>
				</ul></li>
		</sec:one>
		<li><a>Mi cuenta</a>
			<ul>
				<li><a href="UsuarioController?cambiar_mi_contrasena">Cambiar
						Constrase�a</a></li>
				<li><a href="AccesoController?salir">Salir</a></li>

			</ul></li>
	</ul>
</div>