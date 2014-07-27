package dominio;

public class ConfiguracionEnvioRecordatorios {
	private String emailOrigen;
	private String passwordEmailOrigen;
	private String plantilla;
	private boolean envioHabilitado;
	private int diasDeAnterioridad;

	public String getEmailOrigen() {
		return emailOrigen;
	}

	public void setEmailOrigen(String emailOrigen) {
		this.emailOrigen = emailOrigen;
	}

	public String getPassword() {
		return passwordEmailOrigen;
	}

	public void setPassword(String passwordEmailOrigen) {
		this.passwordEmailOrigen = passwordEmailOrigen;
	}

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	public boolean isEnvioHabilitado() {
		return envioHabilitado;
	}

	public void setEnvioHabilitado(boolean envioHabilitado) {
		this.envioHabilitado = envioHabilitado;
	}

	public int getDiasDeAnterioridad() {
		return diasDeAnterioridad;
	}

	public void setDiasDeAnterioridad(int diasDeAnterioridad) {
		this.diasDeAnterioridad = diasDeAnterioridad;
	}
}
