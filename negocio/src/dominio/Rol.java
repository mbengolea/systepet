package dominio;

public enum Rol {

	VETERINARIO("veterinario", 0), JEFE_VETERINARIO("jefe_veterinario", 100), ADMINISTRADOR("administrador", 200);
	
	private String nombreRol;
	private int nivel;
	
	private Rol(String nombreRol, int nivel) {
		this.nombreRol = nombreRol;
		this.nivel = nivel;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public int getNivel() {
		return nivel;
	}
}
