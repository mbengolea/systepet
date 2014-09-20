package systepet.interfaz;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilidades.BaseDeDatos;
import utilidades.DuenioBasico;
import utilidades.FiltroDuenio;
import dominio.Duenio;
import dominio.Rol;
import dominio.Usuario;

/**
 * Servlet implementation class DuenioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ejecutar(request, response);
	}

	private void ejecutar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		Map<String, String[]> parameters = request.getParameterMap();
		if (parameters.containsKey("listar")) {
			forward = buscarUsuarios(request);
		} else if (parameters.containsKey("guardar_usuario")) {
			forward = guardarUsuario(request);
		} else if (parameters.containsKey("cambiar_contrasena")) {
			forward = cambiarContrasena(request);
		} else if (parameters.containsKey("cambiar_mi_contrasena")) {
			forward = cambiarMiContrasena(request);
		} else if (parameters.containsKey("guardar_nuevo_usuario")) {
			// no es lo mismo guardar un usuario nuevo que uno existente por el
			// password
			forward = guardarNuevoUsuario(request);
		} else if (parameters.containsKey("guardar_contrasena")) {
			forward = guardarContrasena(request);
		} else if (parameters.containsKey("editar_usuario")) {
			forward = editarUsuario(request);
		} else if (parameters.containsKey("borrar_usuario")) {
			forward = borrarUsuario(request);
		} else if (parameters.containsKey("usuario")) {
			forward = verUsuario(request);
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	private String guardarUsuario(HttpServletRequest request) {
		String nombre = request.getParameter("nombre_real");
		String nombreUsuario = request.getParameter("nombre_usuario");
		String rol = request.getParameter("rol");
		Usuario usuario = (Usuario) request.getSession()
				.getAttribute("usuario");
		if (!validarParaGuardar(nombre, nombreUsuario, rol, request)) {
			request.setAttribute("error_validacion", true);
			return Paginas.EDITAR_USUARIO;
		}
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setRol(Rol.valueOf(rol));
		BaseDeDatos.getBaseDeDatos().guardarUsuario(usuario);
		request.getSession().setAttribute("usuario", usuario);
		return Paginas.VER_USUARIO;
	}

	private String guardarNuevoUsuario(HttpServletRequest request) {
		String nombre = request.getParameter("nombre_real");
		String nombreUsuario = request.getParameter("nombre_usuario");
		String rol = request.getParameter("rol");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (!validarParaGuardarNuevo(nombre, nombreUsuario, rol, password,
				password2, request)) {
			return Paginas.NUEVO_USUARIO;
		}
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setPassword(password.trim());
		usuario.setRol(Rol.valueOf(rol));
		BaseDeDatos.getBaseDeDatos().guardarUsuario(usuario);
		request.getSession().setAttribute("usuario", usuario);
		return Paginas.VER_USUARIO;
	}

	private String guardarContrasena(HttpServletRequest request) {
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (!validarParaGuardarContrasena(password, password2, request)) {
			return Paginas.CAMBIAR_CONTRASENA;
		}
		Usuario usuario = (Usuario) request.getSession()
				.getAttribute("usuario");
		usuario.setPassword(password.trim());
		BaseDeDatos.getBaseDeDatos().guardarUsuario(usuario);
		request.getSession().setAttribute("usuario", usuario);
		if (request.getParameter("mi_contrasena") != null) {
			return Paginas.INICIO;
		} else {
			return Paginas.VER_USUARIO;
		}
	}

	private String cambiarContrasena(HttpServletRequest request) {
		return Paginas.CAMBIAR_CONTRASENA;
	}

	private String cambiarMiContrasena(HttpServletRequest request) {
		String nombreUsuario = request.getUserPrincipal().getName();
		Usuario usuario = BaseDeDatos.getBaseDeDatos().buscarUsuario(nombreUsuario);
		request.getSession().setAttribute("usuario", usuario);
		request.setAttribute("mi_contrasena", "mi_contrasena");
		return Paginas.CAMBIAR_CONTRASENA;
	}

	private String borrarUsuario(HttpServletRequest request) {
		String nombreUsuario = request.getParameter("nombre_usuario");
		BaseDeDatos.getBaseDeDatos().borrarUsuario(nombreUsuario);
		request.getSession().removeAttribute("usuario");
		return Paginas.LISTAR_USUARIOS;
	}

	private String editarUsuario(HttpServletRequest request) {
		request.setAttribute("roles", Rol.values());
		return Paginas.EDITAR_USUARIO;
	}

	private String verUsuario(HttpServletRequest request) {
		String nombreUsuario = request.getParameter("usuario");
		Usuario usuario = BaseDeDatos.getBaseDeDatos().buscarUsuario(
				nombreUsuario);
		request.getSession().setAttribute("usuario", usuario);
		return Paginas.VER_USUARIO;
	}

	private String buscarUsuarios(HttpServletRequest request) {
		List<Usuario> usuarios = BaseDeDatos.getBaseDeDatos().buscarUsuarios();
		request.setAttribute("usuarios", usuarios);
		return Paginas.LISTAR_USUARIOS;
	}

	private boolean validarParaGuardarNuevo(String nombre,
			String nombreUsuario, String rol, String password,
			String password2, HttpServletRequest request) {
		boolean valido = true;
		if (!Validador.esNombreUsuarioValido(nombreUsuario)) {
			request.setAttribute("nombre_invalido", true);
			valido = false;
		}
		if (!Validador.esNombreRealUsuarioValido(nombre)) {
			request.setAttribute("nombre_real_invalido", true);
			valido = false;
		}
		if (!Validador.esPasswordValido(password)) {
			request.setAttribute("contrasena_invalida", true);
			valido = false;
		} else if (!password.equals(password2)) {
			// solo me fijo si los passwords son iguales si son validos
			request.setAttribute("contrasenas_distintas", true);
			valido = false;
		}
		try {
			Rol.valueOf(rol);
		} catch (Exception e) {
			request.setAttribute("rol_invalido", true);
			valido = false;
		}
		return valido;
	}

	private boolean validarParaGuardarContrasena(String password,
			String password2, HttpServletRequest request) {
		boolean valido = true;
		if (!Validador.esPasswordValido(password)) {
			request.setAttribute("contrasena_invalida", true);
			valido = false;
		} else if (!password.equals(password2)) {
			// solo me fijo si los passwords son iguales si son validos
			request.setAttribute("contrasenas_distintas", true);
			valido = false;
		}
		return valido;
	}

	private boolean validarParaGuardar(String nombre, String nombreUsuario,
			String rol, HttpServletRequest request) {
		boolean valido = true;
		if (!Validador.esNombreUsuarioValido(nombreUsuario)) {
			request.setAttribute("nombre_invalido", true);
			valido = false;
		}
		if (!Validador.esNombreRealUsuarioValido(nombre)) {
			request.setAttribute("nombre_real_invalido", true);
			valido = false;
		}
		try {
			Rol.valueOf(rol);
		} catch (Exception e) {
			request.setAttribute("rol_invalido", true);
			valido = false;
		}
		return valido;
	}
}
