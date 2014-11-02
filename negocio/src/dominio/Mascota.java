package dominio;

import java.util.Date;

import dominio.Edad.Unidad;

public class Mascota {
	private int id;
	private String nombre;
	private EspecieDeMascota especie;
	private String especieEspecifica;
	private String raza;
	private Date fechaNacimiento;
	private Duenio duenio;
	private boolean vivo;
	private HistoriaClinica historiaClinica;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EspecieDeMascota getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieDeMascota especie) {
		this.especie = especie;
	}

	public String getEspecieEspecifica() {
		return especieEspecifica;
	}

	public void setEspecieEspecifica(String especieEspecifica) {
		this.especieEspecifica = especieEspecifica;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Duenio getDuenio() {
		return duenio;
	}

	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public HistoriaClinica getHistoriaClinica() {
		return this.historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
		this.historiaClinica.setMascota(this);
	}

	public Edad getEdad(){
		long diff = new Date().getTime() - this.fechaNacimiento.getTime();
		int dias = (int) (diff / (24 * 60 * 60 * 1000));
		if (dias > 90) {
			int meses = dias / 30;
			if (meses > 12) {
				int anios = dias / 365;
				return new Edad(anios, Unidad.ANIO);
			} else {
				return new Edad(meses, Unidad.MES);
			}
		} else {
			return new Edad(dias, Unidad.DIA);
		}
	}
}
