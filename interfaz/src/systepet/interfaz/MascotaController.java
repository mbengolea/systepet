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
			forward = Paginas.EDITAR_MASCOTA;
		} else if (parameters.containsKey("guardar")) {
			forward = Paginas.VER_MASCOTA;
		} else if (parameters.containsKey("historia_clinica")) {
			forward = Paginas.HISTORIA_CLINICA;
		} else if (parameters.containsKey("nueva_consulta")) {
			forward = Paginas.CONSULTA;
		} else if (parameters.containsKey("guardar_consulta")) {
			forward = Paginas.VER_MASCOTA;
		} else if (parameters.containsKey("mascota")) {
			forward = Paginas.VER_MASCOTA;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
