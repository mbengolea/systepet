package dominio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Recordatorio {
	
	public enum Claves {
		nombre_mascota, nombre_dueño, fecha_agendada, nombre_vacuna;
	}
	
	private static final String FORMATO_FECHA = "dd-MM-yyyy";
	private String nombreDuenio;
	private String nombreMascota;
	private String email;
	private AplicacionAgendada aplicacion;

	public Recordatorio(String nombreDuenio, String nombreMascota,
			String email, AplicacionAgendada aplicacion) {
		super();
		this.nombreDuenio = nombreDuenio;
		this.nombreMascota = nombreMascota;
		this.email = email;
		this.aplicacion = aplicacion;
	}

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

	public String generarTextoEmail(String texto) {
		String resultado = reemplazar(texto, Claves.nombre_dueño, this.nombreDuenio);
		DateFormat formatter = new SimpleDateFormat(FORMATO_FECHA);
		resultado = reemplazar(resultado, Claves.fecha_agendada, formatter.format(this.aplicacion.getFechaAplicacion()));
		resultado = reemplazar(resultado, Claves.nombre_mascota, this.nombreMascota);
		resultado = reemplazar(resultado, Claves.nombre_vacuna, this.aplicacion.getVacuna().getNombre());
		return resultado;
	}

	private String reemplazar(String texto, Claves clave,
			String valor) {
		return texto.replace("${" + clave + "}", valor);
	}

}
