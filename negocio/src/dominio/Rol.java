package dominio;

public enum Rol {

	VETERINARIO("veterinario"), JEFE_VETERINARIO("jefe_veterinario", VETERINARIO), ADMINISTRADOR("administrador", JEFE_VETERINARIO);
	
	private String nombreRol;
	private Rol rolPadre;
	
	private Rol(String nombreRol) {
		this(nombreRol, null);
	}

	private Rol(String nombreRol, Rol rolPadre) {
		this.nombreRol = nombreRol;
		this.rolPadre = rolPadre;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public Rol getRolPadre() {
		return rolPadre;
	}
}
