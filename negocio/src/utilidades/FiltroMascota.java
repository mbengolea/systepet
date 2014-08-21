package utilidades;

public class FiltroMascota {

	private String dni;
	private String nombreDuenio;
	private String telefono;
	private String nombreMascota;
	private int historiaClinica;
	
	public FiltroMascota(String dni, String nombreDuenio, String telefono, String nombreMascota, int historiaClinica) {
		super();
		this.dni = dni;
		this.nombreDuenio = nombreDuenio;
		this.nombreMascota = nombreDuenio;
		this.telefono = telefono;
		this.historiaClinica = historiaClinica;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombreDuenio;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public int getHistoriaClinica() {
		return historiaClinica;
	}
}
