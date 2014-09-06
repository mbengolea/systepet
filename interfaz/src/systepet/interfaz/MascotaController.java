package systepet.interfaz;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import dominio.Vacuna;

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
			// ya debería estar la mascota en la sesión
			forward = Paginas.EDITAR_MASCOTA;
		} else if (parameters.containsKey("buscar_mascota")) {
			forward = this.buscarMascotas(request);
		} else if (parameters.containsKey("guardar")) {
			forward = guardarMascota(request);
		} else if (parameters.containsKey("agregar_vacuna")) {
			forward = agregarVacuna(request);
		} else if (parameters.containsKey("agregar_aplicacion_agendada")) {
			forward = agregarAplicacionAgendada(request);
		} else if (parameters.containsKey("historia_clinica")) {
			forward = Paginas.HISTORIA_CLINICA;
		} else if (parameters.containsKey("volver_mascota")) {
			forward = Paginas.VER_MASCOTA;
		} else if (parameters.containsKey("nueva_consulta")) {
			forward = nuevaConsulta(request);
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
	
	private String nuevaConsulta(HttpServletRequest request) {
		List<Vacuna> vacunas = BaseDeDatos.getBaseDeDatos().buscarVacunas(null);
		request.getSession().setAttribute("vacunas", vacunas);
		request.getSession().setAttribute("consulta", new Consulta());
		return Paginas.CONSULTA;
	}
	
	private String agregarVacuna(HttpServletRequest request) {
		String idString = request.getParameter("vacunaId");
		if (idString != null){
			int id = Integer.parseInt(idString);
			Consulta consulta = (Consulta) request.getSession().getAttribute("consulta");
			List<Vacuna> vacunas = (List<Vacuna>) request.getSession().getAttribute("vacunas");
			for (Vacuna vacuna : vacunas){
				if (vacuna.getId() == id){
					consulta.agregarAplicacionRealizada(vacuna);
				}
			}
		}
		return Paginas.CONSULTA;
	}
	
	private String agregarAplicacionAgendada(HttpServletRequest request) {
		String idString = request.getParameter("vacunaAAplicarId");
		String fechaAplicacionString = request.getParameter("fecha_aplicacion");
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaAplicacion = null;
		try {
			fechaAplicacion = formato.parse(fechaAplicacionString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (idString != null){
			int id = Integer.parseInt(idString);
			Consulta consulta = (Consulta) request.getSession().getAttribute("consulta");
			List<Vacuna> vacunas = (List<Vacuna>) request.getSession().getAttribute("vacunas");
			for (Vacuna vacuna : vacunas){
				if (vacuna.getId() == id){
					consulta.agregarAplicacionAgendada(fechaAplicacion, vacuna);
				}
			}
		}
		return Paginas.CONSULTA;
	}

	private String guardarMascota(HttpServletRequest request) {
		String nombre = request.getParameter("nombre_mascota");
		String especieString = request.getParameter("especie");
		String raza = request.getParameter("raza");
		String especieEspecifica = request.getParameter("especie_especifica");
		String fechaNacimientoString = request.getParameter("fecha_nacimiento");
		System.out.println("Fecha de nacimiento recibida: "
				+ fechaNacimientoString);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = formato.parse(fechaNacimientoString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Mascota mascota = (Mascota) request.getSession()
				.getAttribute("mascota");
		if (mascota == null) {
			mascota = new Mascota();
		}
		mascota.setNombre(nombre);
		EspecieDeMascota especie = EspecieDeMascota.valueOf(especieString);
		mascota.setEspecie(especie);
		if (especie.tieneRaza()) {
			mascota.setRaza(raza);
		}
		if (especie.necesitaEspecieEspecifica()) {
			mascota.setEspecieEspecifica(especieEspecifica);
		}
		mascota.setFechaNacimiento(fechaNacimiento);
		Mascota mascotaGuardada = BaseDeDatos.getBaseDeDatos().guardarMascota(mascota);
		request.getSession().setAttribute("mascota", mascotaGuardada);
		return Paginas.VER_MASCOTA;
	}

	private String guardarConsulta(HttpServletRequest request) {
		String detalles = request.getParameter("detalles");
		Mascota mascota = (Mascota) request.getSession()
				.getAttribute("mascota");
		Consulta consulta = (Consulta) request.getSession().getAttribute("consulta");
		consulta.setFechaConsulta(new Date());
		consulta.setVeterinario("nombre Vete");
		consulta.setObservaciones(detalles);
		mascota.getHistoriaClinica().agregarConsulta(consulta);
		BaseDeDatos.getBaseDeDatos().guardarConsulta(consulta);
		return Paginas.VER_MASCOTA;
	}
}
