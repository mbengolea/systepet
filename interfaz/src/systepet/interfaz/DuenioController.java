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
		String id = request.getParameter("duenioId");
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("e_mail");
		String notificaciones = request.getParameter("notificaciones");
		Duenio duenio;
		if(id != null){
			duenio = BaseDeDatos.getBaseDeDatos().buscarDuenio(Integer.parseInt(id));
		} else {
			duenio = new Duenio();
		}
		duenio.setNombre(nombre);
		duenio.setDni(dni);
		duenio.setTelefono(telefono);
		duenio.setDireccion(direccion);
		duenio.setEmail(email);
		duenio.setRecibeNotificaciones(notificaciones != null);
		BaseDeDatos.getBaseDeDatos().guardarDuenio(duenio);
		request.setAttribute("duenio", duenio);
		return Paginas.VER_DUENIO;
	}

	private String editarDuenio(HttpServletRequest request) {
		String id = request.getParameter("duenioId");
		Duenio duenio = BaseDeDatos.getBaseDeDatos().buscarDuenio(Integer.parseInt(id));
		request.setAttribute("duenio", duenio);
		return Paginas.EDITAR_DUENIO;
	}

	private String verDuenio(HttpServletRequest request) {
		String id = request.getParameter("duenioId");
		Duenio duenio = BaseDeDatos.getBaseDeDatos().buscarDuenio(Integer.parseInt(id));
		request.setAttribute("duenio", duenio);
		return Paginas.VER_DUENIO;
	}

	private String buscarDuenios(HttpServletRequest request) {
		String dni = request.getParameter("dni_duenio");
		String nombre = request.getParameter("nombre_duenio");
		String tel = request.getParameter("telefono");
		FiltroDuenio filtro = new FiltroDuenio(dni, nombre, tel);
		List<DuenioBasico> duenios = BaseDeDatos.getBaseDeDatos().buscarDuenios(filtro);
		request.setAttribute("duenios", duenios);
		return Paginas.LISTAR_DUENIOS;
	}
}
