package dominio;

public class Recordatorio {
	private String nombreDuenio;
	private String nombreMascota;
	private String email;
	private AplicacionAgendada aplicacion;

	public String getNombreDuenio() {
		return nombreDuenio;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public String getEmail() {
		return email;
	}

	public AplicacionAgendada getAplicacion() {
		return aplicacion;
	}

	public void generarTextoEmail(String texto) {
	}

}
