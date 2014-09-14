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
@WebServlet("/AccesoController")
public class AccesoController extends HttpServlet {

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
		if (parameters.containsKey("salir")) {
			request.getSession().invalidate();
			forward = Paginas.SALIDA;
		} 
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
