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
		} else if (parameters.containsKey("usuario")) {
			forward = verUsuario(request);
		} 
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	private String guardarUsuario(HttpServletRequest request) {
		String nombre = request.getParameter("nombre_real");
		String nombreUsuario = request.getParameter("nombre_usuario");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		if (!validarParaGuardar(nombre, nombreUsuario, request)){
			if(usuario == null){
				return Paginas.NUEVO_USUARIO;
			} else {
				request.setAttribute("error_validacion", true);
				return Paginas.EDITAR_USUARIO;
			}
		}
		if(usuario == null){
			usuario = new Usuario();
		}
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		BaseDeDatos.getBaseDeDatos().guardarUsuario(usuario);
		request.getSession().setAttribute("duenio", usuario);
		return Paginas.VER_USUARIO;
	}

	private String editarDuenio(HttpServletRequest request) {
		return Paginas.EDITAR_DUENIO;
	}

	private String verUsuario(HttpServletRequest request) {
		String nombreUsuario = request.getParameter("usuario");
		Usuario usuario = BaseDeDatos.getBaseDeDatos().buscarUsuario(nombreUsuario);
		request.getSession().setAttribute("usuario", usuario);
		return Paginas.VER_USUARIO;
	}

	private String buscarUsuarios(HttpServletRequest request) {
		List<Usuario> usuarios = BaseDeDatos.getBaseDeDatos().buscarUsuarios();
		request.setAttribute("usuarios", usuarios);
		return Paginas.LISTAR_USUARIOS;
	}
	
	private boolean validarParaGuardar(String nombre, String nombreUsuario, HttpServletRequest request) {
		boolean valido = true;
		if (!Validador.esNombreUsuarioValido(nombreUsuario)){
			request.setAttribute("nombre_invalido", true);
			valido = false;
		}
		if (!Validador.esNombreRealUsuarioValido(nombre)){
			request.setAttribute("nombre_real_invalido", true);
			valido = false;
		}
		return valido;
	}
}
