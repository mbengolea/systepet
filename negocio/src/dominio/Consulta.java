package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consulta {
	private Date fechaConsulta;
	private String observaciones = "";
	private List<Vacuna> vacunasRealizadas = new ArrayList<Vacuna>();
	private List<AplicacionAgendada> aplicacionesAgendadas = new ArrayList<AplicacionAgendada>();
	private String veterinario;

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

	public void agregarAplicacionAgendada(Date date, Vacuna vacuna) {
		this.aplicacionesAgendadas.add(new AplicacionAgendada(date, vacuna));
	}

	public void agregarAplicacionRealizada(Vacuna vacuna) {
		this.vacunasRealizadas.add(vacuna);
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public List<Vacuna> getVacunasRealizadas() {
		return vacunasRealizadas;
	}

	public List<AplicacionAgendada> getAplicacionesAgendadas() {
		return aplicacionesAgendadas;
	}

	public String getVeterinario() {
		return veterinario;
	}

}
