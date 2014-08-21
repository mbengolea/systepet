package utilidades;

public class FiltroDuenio {

	private String dni;
	private String nombre;
	private String telefono;
	
	public FiltroDuenio(String dni, String nombre, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}
}
