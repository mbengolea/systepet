package dominio;

public class Duenio {
	private int id;
	private String dni;
	private String telefono;
	private String direccion;
	private String email;
	private boolean recibeNotificaciones;
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRecibeNotificaciones() {
		return recibeNotificaciones;
	}

	public void setRecibeNotificaciones(boolean recibeNotificaciones) {
		this.recibeNotificaciones = recibeNotificaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
