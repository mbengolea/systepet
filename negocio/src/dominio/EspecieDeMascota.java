package dominio;

public enum EspecieDeMascota {
	FELINO(true, false), CANINO(true, false), OTRO(false, true);

	private boolean usaRaza;
	private boolean usaEspecieEspecifica;

	private EspecieDeMascota(boolean usaRaza, boolean usaEspecieEspecifica) {
		this.usaRaza = usaRaza;
		this.usaEspecieEspecifica = usaEspecieEspecifica;
	}

	public boolean tieneRaza() {
		return usaRaza;
	}

	public boolean necesitaEspecieEspecifica() {
		return usaEspecieEspecifica;
	}
}
