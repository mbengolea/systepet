package systepet.interfaz;

import dominio.EspecieDeMascota;

public class Validador {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static boolean esDniValido(String dni) {
		try {
			Long.parseLong(dni);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean esCodigoHistoriaClinicaValido(String codigo) {
		try {
			Long.parseLong(codigo);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean esTelefonoValido(String tel) {
		try {
			Long.parseLong(tel);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean esNombreDuenioValido(String nombre) {
		return nombre != null && (nombre.trim().length() > 0);
	}

	public static boolean esEmailValido(String email) {
		return email.matches(EMAIL_PATTERN);
	}

	public static boolean esNombreMascotaValido(String nombre) {
		return nombre != null && (nombre.trim().length() > 0);
	}
	
	public static boolean esEspecieEspecificaValida(EspecieDeMascota especie, String especieEspecifica){
		if (especie.necesitaEspecieEspecifica()){
			return  especieEspecifica != null && especieEspecifica.trim().length() > 0;
		} else {
			return true;
		}
	}

	public static boolean esNombreUsuarioValido(String nombre) {
		return nombre != null && (nombre.trim().length() > 0);
	}

	public static boolean esNombreRealUsuarioValido(String nombre) {
		return nombre != null && (nombre.trim().length() > 0);
	}
}
