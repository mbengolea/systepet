package systepet.interfaz;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			forward = Paginas.EDITAR_VACUNA;
		} else if (parameters.containsKey("guardar")) {
			forward = Paginas.VER_VACUNA;
		} else if (parameters.containsKey("buscar_vacuna")) {
			forward = Paginas.BUSCAR_VACUNA;
		} else if (parameters.containsKey("borrar_vacuna")) {
			forward = Paginas.BUSCAR_VACUNA;
		} else if (parameters.containsKey("vacuna")) {
			forward = Paginas.VER_VACUNA;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
