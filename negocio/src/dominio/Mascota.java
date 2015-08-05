package dominio;

import java.util.Date;

public class Mascota {
	public enum Sexo {
		MACHO, HEMBRA;
	}

	private int id;
	private String nombre;
	private EspecieDeMascota especie;
	private String especieEspecifica;
	private String raza;
	private Date fechaNacimiento;
	private Duenio duenio;
	private boolean vivo = true;
	private HistoriaClinica historiaClinica;
	private Sexo sexo;

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
		if (this.duenio == null) {
			this.duenio = duenio;
			this.duenio.agregarMascota(this);
		}
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public HistoriaClinica getHistoriaClinica() {
		if (this.historiaClinica == null) {
			this.historiaClinica = new HistoriaClinica();
		}
		return this.historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
		this.historiaClinica.setMascota(this);
	}

	public Edad getEdad() {
		return Edad.edadPara(new Date(), this.fechaNacimiento);
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
}
