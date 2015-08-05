package systepet.interfaz;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilidades.BaseDeDatos;
import utilidades.EnviadorDeRecordatorios;
import dominio.ConfiguracionEnvioRecordatorios;

@WebServlet("/ConfiguracionController")
public class ConfiguracionController extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
		if (parameters.containsKey("guardar_configuracion_recordatorios")) {
			forward = guardarConfiguracion(request);
		} else if (parameters
				.containsKey("cancelar_guardar_configuracion_recordatorios")) {
			forward = Paginas.INICIO;
		} else if (parameters.containsKey("editar_configuracion_recordatorios")) {
			forward = verConfiguracionRecordatorios(request);
		} else if (parameters.containsKey("envio_manual_recordatorios")) {
			forward = enviarRecordatorios(request);
		} else if (parameters.containsKey("cerrar_confirmacion")) {
			forward = Paginas.INICIO;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	private String enviarRecordatorios(HttpServletRequest request) {
		new EnviadorDeRecordatorios().enviarRecordatorios();
		return Paginas.CONFIRMACION_ENVIO_RECORDATORIOS;
	}

	private String guardarConfiguracion(HttpServletRequest request) {
		String emailOrigen = request.getParameter("email_origen");
		String usuarioEmailOrigen = request.getParameter("usuario_origen");
		String passwordEmailOrigen = request.getParameter("password");
		String passwordEmailOrigen2 = request.getParameter("password2");
		String asunto = request.getParameter("asunto");
		String plantilla = request.getParameter("plantilla");
		String diasDeAnterioridadString = request
				.getParameter("dias_anterioridad");
		boolean envioHabilitado = request.getParameter("habilitado") != null;
		if (!validarParaGuardar(emailOrigen, usuarioEmailOrigen,
				passwordEmailOrigen, passwordEmailOrigen2, asunto, plantilla,
				diasDeAnterioridadString, request)) {
			request.setAttribute("error_validacion", true);
			return Paginas.EDITAR_CONFIGURACION_RECORDATORIOS;
		}
		ConfiguracionEnvioRecordatorios config = new ConfiguracionEnvioRecordatorios();
		config.setAsunto(asunto);
		int diasDeAnterioridad = Integer.parseInt(diasDeAnterioridadString);
		config.setDiasDeAnterioridad(diasDeAnterioridad);
		config.setEmailOrigen(emailOrigen);
		config.setEnvioHabilitado(envioHabilitado);
		config.setPassword(passwordEmailOrigen);
		config.setPlantilla(plantilla);
		config.setUsuario(usuarioEmailOrigen);
		BaseDeDatos.getBaseDeDatos().guardarConfiguracionEnvioRecordatorios(
				config);
		request.getSession().setAttribute("configuracion", config);
		return Paginas.INICIO;
	}

	private String verConfiguracionRecordatorios(HttpServletRequest request) {
		ConfiguracionEnvioRecordatorios configuracion = BaseDeDatos
				.getBaseDeDatos().buscarConfiguracionEnvioDeRecordatorios();
		request.getSession().setAttribute("configuracion", configuracion);
		return Paginas.EDITAR_CONFIGURACION_RECORDATORIOS;
	}

	private boolean validarParaGuardar(String emailOrigen,
			String usuarioEmailOrigen, String passwordEmailOrigen,
			String passwordEmailOrigen2, String asunto, String plantilla,
			String diasDeAnterioridadString, HttpServletRequest request) {
		boolean valido = true;
		if (!Validador.esEmailValido(emailOrigen)) {
			request.setAttribute("email_origen_invalido", true);
			valido = false;
		}
		if (Validador.esStringVacio(usuarioEmailOrigen)) {
			request.setAttribute("usuario_origen_invalido", true);
			valido = false;
		}
		if (Validador.esStringVacio(passwordEmailOrigen)) {
			request.setAttribute("password_invalido", true);
			valido = false;
		} else if (!passwordEmailOrigen.equals(passwordEmailOrigen2)) {
			// solo me fijo si los passwords son iguales si son validos
			request.setAttribute("contrasenas_distintas", true);
			valido = false;
		}
		if (Validador.esStringVacio(asunto)) {
			request.setAttribute("asunto_invalido", true);
			valido = false;
		}
		if (!Validador.esPlantillaEmailValida(plantilla)) {
			request.setAttribute("plantilla_invalida", true);
			valido = false;
		}
		try {
			int anterioridad = Integer.parseInt(diasDeAnterioridadString);
			if (anterioridad < 0) {
				request.setAttribute("dias_anterioridad_invalido", true);
				valido = false;
			}
		} catch (Exception e) {
			request.setAttribute("dias_anterioridad_invalido", true);
			valido = false;
		}
		return valido;
	}
}
