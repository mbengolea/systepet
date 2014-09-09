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

/**
 * Servlet implementation class DuenioController
 */
@WebServlet("/DuenioController")
public class DuenioController extends HttpServlet {

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
		if (parameters.containsKey("nueva_mascota")) {
			forward = Paginas.MASCOTA_CONTROLLER;
		} else if (parameters.containsKey("buscar_duenio")) {
			forward = buscarDuenios(request);
		} else if (parameters.containsKey("guardar_duenio")) {
			forward = guardarDuenio(request);
		} else if (parameters.containsKey("editar_duenio")) {
			forward = editarDuenio(request);
		} else if (parameters.containsKey("duenioId")) {
			forward = verDuenio(request);
		} 
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	private String guardarDuenio(HttpServletRequest request) {
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("e_mail");
		String notificaciones = request.getParameter("notificaciones");
		Duenio duenio = (Duenio) request.getSession().getAttribute("duenio");
		if (!validarParaGuardar(dni, telefono, nombre, email, request)){
			if(duenio == null){
				return Paginas.NUEVO_DUENIO;
			} else {
				request.setAttribute("error_validacion", true);
				return Paginas.EDITAR_DUENIO;
			}
		}
		if(duenio == null){
			duenio = new Duenio();
		}
		duenio.setNombre(nombre);
		duenio.setDni(dni);
		duenio.setTelefono(telefono);
		duenio.setDireccion(direccion);
		duenio.setEmail(email);
		duenio.setRecibeNotificaciones(notificaciones != null);
		BaseDeDatos.getBaseDeDatos().guardarDuenio(duenio);
		request.getSession().setAttribute("duenio", duenio);
		return Paginas.VER_DUENIO;
	}

	private String editarDuenio(HttpServletRequest request) {
		return Paginas.EDITAR_DUENIO;
	}

	private String verDuenio(HttpServletRequest request) {
		String id = request.getParameter("duenioId");
		Duenio duenio = BaseDeDatos.getBaseDeDatos().buscarDuenio(Integer.parseInt(id));
		request.getSession().setAttribute("duenio", duenio);
		return Paginas.VER_DUENIO;
	}

	private String buscarDuenios(HttpServletRequest request) {
		String dni = request.getParameter("dni_duenio");
		String nombre = request.getParameter("nombre_duenio");
		String tel = request.getParameter("telefono");
		if (!validarParaBusqueda(dni, tel, request)){
			return Paginas.BUSCAR_DUENIO;
		}
		FiltroDuenio filtro = new FiltroDuenio(dni, nombre, tel);
		List<DuenioBasico> duenios = BaseDeDatos.getBaseDeDatos().buscarDuenios(filtro);
		request.setAttribute("duenios", duenios);
		request.getSession().removeAttribute("duenio");
		request.getSession().removeAttribute("mascota");
		return Paginas.LISTAR_DUENIOS;
	}
	
	private boolean validarParaBusqueda(String dni, String tel, HttpServletRequest request) {
		boolean valido = true;
		if (dni != null && dni.length() > 0){
			if (!Validador.esDniValido(dni)){
				request.setAttribute("dni_invalido", true);
				valido = false;
			}
		}
		if (tel != null && tel.length() > 0){
			if (!Validador.esTelefonoValido(tel)){
				request.setAttribute("telefono_invalido", true);
				valido = false;
			}
		}
		return valido;
	}
	
	private boolean validarParaGuardar(String dni, String tel, String nombre, String email, HttpServletRequest request) {
		boolean valido = true;
		if (!Validador.esNombreDuenioValido(nombre)){
			request.setAttribute("nombre_invalido", true);
			valido = false;
		}
		if (dni != null && dni.length() > 0){
			if (!Validador.esDniValido(dni)){
				request.setAttribute("dni_invalido", true);
				valido = false;
			}
		}
		if (tel != null && tel.length() > 0){
			if (!Validador.esTelefonoValido(tel)){
				request.setAttribute("telefono_invalido", true);
				valido = false;
			}
		}
		if (email != null && email.length() > 0){
			if (!Validador.esEmailValido(email)){
				request.setAttribute("e_mail_invalido", true);
				valido = false;
			}
		}
		return valido;
	}
}
