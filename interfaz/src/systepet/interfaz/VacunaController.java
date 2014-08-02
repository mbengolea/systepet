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

import dominio.Vacuna;

import utilidades.BaseDeDatos;

/**
 * Servlet implementation class MascotaController
 */
@WebServlet("/VacunaController")
public class VacunaController extends HttpServlet {

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
		if (parameters.containsKey("nueva_vacuna")) {
			forward = Paginas.NUEVA_VACUNA;
		} else if (parameters.containsKey("editar_vacuna")) {
			forward = editarVacuna(request);
		} else if (parameters.containsKey("guardar")) {
			forward = guardarVacuna(request);
		} else if (parameters.containsKey("buscar_vacuna")) {
			forward = buscarVacunas(request);
		} else if (parameters.containsKey("borrar_vacuna")) {
			forward = darDeBajaVacuna(request);
		} else if (parameters.containsKey("vacunaId")) {
			forward = verVacuna(request);
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	private String darDeBajaVacuna(HttpServletRequest request) {
		String id = request.getParameter("vacunaId");
		Vacuna vacuna = BaseDeDatos.getBaseDeDatos().buscarVacuna(Integer.parseInt(id));
		vacuna.setActiva(false);
		BaseDeDatos.getBaseDeDatos().guardarVacuna(vacuna);
		return Paginas.BUSCAR_VACUNA;
	}

	private String editarVacuna(HttpServletRequest request) {
		String id = request.getParameter("vacunaId");
		Vacuna vacuna = BaseDeDatos.getBaseDeDatos().buscarVacuna(Integer.parseInt(id));
		request.setAttribute("vacuna", vacuna);
		return Paginas.VER_VACUNA;
	}

	private String guardarVacuna(HttpServletRequest request) {
		String id = request.getParameter("vacunaId");
		String nombre = request.getParameter("nombre_vacuna");
		String labo = request.getParameter("laboratorio");
		String comp = request.getParameter("composicion");
		String notas = request.getParameter("notas");
		Vacuna vacuna = BaseDeDatos.getBaseDeDatos().buscarVacuna(Integer.parseInt(id));
		vacuna.setNombre(nombre);
		vacuna.setLaboratorio(labo);
		vacuna.setNotas(notas);
		vacuna.setDroga(comp);
		BaseDeDatos.getBaseDeDatos().guardarVacuna(vacuna);
		request.setAttribute("vacuna", vacuna);
		return Paginas.VER_VACUNA;
	}

	private String verVacuna(HttpServletRequest request) {
		String id = request.getParameter("vacunaId");
		Vacuna vacuna = BaseDeDatos.getBaseDeDatos().buscarVacuna(Integer.parseInt(id));
		request.setAttribute("vacuna", vacuna);
		return Paginas.VER_VACUNA;
	}

	private String buscarVacunas(HttpServletRequest request) {
		String nombre = request.getParameter("nombre");
		List<Vacuna> vacunas = BaseDeDatos.getBaseDeDatos().buscarVacunas(nombre);
		request.setAttribute("vacunas", vacunas);
		return Paginas.LISTAR_VACUNAS;
	}
}
