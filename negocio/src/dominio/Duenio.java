package dominio;

import java.util.ArrayList;
import java.util.List;

public class Duenio {
	private int id;
	private String dni;
	private String telefono;
	private String direccion;
	private String email;
	private boolean recibeNotificaciones;
	private String nombre;
	private List<Mascota> mascotas = new ArrayList<Mascota>();

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

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public void agregarMascota(Mascota mascota) {
		if (this.mascotas != null && !mascotas.contains(mascota)) {
			this.mascotas.add(mascota);
			mascota.setDuenio(this);
		}
	}

	public Mascota getMascotaPorId(int id) {
		for (Mascota mascota : this.mascotas) {
			if (mascota.getId() == id) {
				return mascota;
			}
		}
		return null;
	}
}
