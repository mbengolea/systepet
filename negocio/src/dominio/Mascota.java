package dominio;

import java.util.Calendar;
import java.util.Date;

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
	}

	public int getEdadEnAnios(){
		Calendar dobDate = Calendar.getInstance();
		dobDate.setTime(this.fechaNacimiento);
		Calendar today = Calendar.getInstance();
		int curYear = today.get(Calendar.YEAR);
		int curMonth = today.get(Calendar.MONTH);
		int curDay = today.get(Calendar.DAY_OF_MONTH);

		int year = dobDate.get(Calendar.YEAR);
		int month = dobDate.get(Calendar.MONTH);
		int day = dobDate.get(Calendar.DAY_OF_MONTH);

		int age = curYear - year;
		if (curMonth < month || (month == curMonth && curDay < day)) {
		    age--;
		}
		return age;
	}
}
