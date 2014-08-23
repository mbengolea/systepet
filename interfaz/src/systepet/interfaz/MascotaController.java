package systepet.interfaz;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilidades.BaseDeDatos;
import utilidades.FiltroMascota;
import utilidades.MascotaBasica;
import dominio.Consulta;
import dominio.EspecieDeMascota;
import dominio.Mascota;

/**
 * Servlet implementation class MascotaController
 */
@WebServlet("/MascotaController")
public class MascotaController extends HttpServlet {

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
			forward = Paginas.NUEVA_MASCOTA;
		} else if (parameters.containsKey("editar_mascota")) {
			// ya deber�a estar la mascota en la sesi�n
			forward = Paginas.EDITAR_MASCOTA;
		} else if (parameters.containsKey("buscar_mascota")) {
			forward = this.buscarMascotas(request);
		} else if (parameters.containsKey("guardar")) {
			forward = guardarMascota(request);
		} else if (parameters.containsKey("historia_clinica")) {
			forward = Paginas.HISTORIA_CLINICA;
		} else if (parameters.containsKey("nueva_consulta")) {
			forward = Paginas.CONSULTA;
		} else if (parameters.containsKey("guardar_consulta")) {
			forward = guardarConsulta(request);
		} else if (parameters.containsKey("mascotaId")) {
			forward = buscarMascota(request);
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	private String buscarMascotas(HttpServletRequest request) {
		String dni = request.getParameter("dni_duenio");
		String nombre = request.getParameter("nombre_duenio");
		String tel = request.getParameter("telefono");
		String nombreMascota = request.getParameter("nombre_mascota");
		String historiaClinicaStr = request.getParameter("historia_clinica");
		Integer historiaClinicaInt = null;
		try {
			historiaClinicaInt = Integer.parseInt(historiaClinicaStr);
		} catch (Exception e) {
			// no es un numero, no hago nada
		}
		FiltroMascota filtro = new FiltroMascota(dni, nombre, tel,
				nombreMascota, historiaClinicaInt);
		List<MascotaBasica> mascotas = BaseDeDatos.getBaseDeDatos()
				.buscarMascotas(filtro);
		request.setAttribute("mascotas", mascotas);
		return Paginas.LISTAR_MASCOTAS;
	}

	private String buscarMascota(HttpServletRequest request) {
		String id = request.getParameter("mascotaId");
		Mascota mascota = BaseDeDatos.getBaseDeDatos().buscarMascota(
				Integer.parseInt(id));
		request.getSession().setAttribute("mascota", mascota);
		return Paginas.VER_MASCOTA;
	}

	private String guardarMascota(HttpServletRequest request) {
		String nombre = request.getParameter("nombre_mascota");
		String especie = request.getParameter("especie");
		String raza = request.getParameter("raza");
		Mascota mascota = (Mascota) request.getSession()
				.getAttribute("mascota");
		mascota.setNombre(nombre);
		mascota.setRaza(raza);
		mascota.setEspecie(EspecieDeMascota.valueOf(especie));
		BaseDeDatos.getBaseDeDatos().guardarMascota(mascota);
		request.getSession().setAttribute("mascota", mascota);
		return Paginas.VER_MASCOTA;
	}
	
	private String guardarConsulta(HttpServletRequest request) {
		String detalles = request.getParameter("detalles");
		Mascota mascota = (Mascota) request.getSession()
				.getAttribute("mascota");
		Consulta consulta = new Consulta(new Date(), "nombre Vete", detalles);
		mascota.getHistoriaClinica().agregarConsulta(consulta);
		BaseDeDatos.getBaseDeDatos().guardarConsulta(consulta);
		return Paginas.VER_MASCOTA;
	}
}
