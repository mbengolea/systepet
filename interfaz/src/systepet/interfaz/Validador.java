package systepet.interfaz;

public class Validador {

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

	public static boolean esNombreDuenioValido(String dni) {
		return true;
	}

	public static boolean esEmailValido(String dni) {
		return true;
	}

	public static boolean esNombreMascotaValido(String dni) {
		return true;
	}
}
