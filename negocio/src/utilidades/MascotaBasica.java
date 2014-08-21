package utilidades;

public class MascotaBasica {

	private int id;
	private String nombre;
	private String nombreDuenio;
	private String especie;

	public MascotaBasica(int id, String nombre, String nombreDuenio,
			String especie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreDuenio = nombreDuenio;
		this.especie = especie;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreDuenio() {
		return nombreDuenio;
	}

	public String getEspecie() {
		return especie;
	}

	
}
