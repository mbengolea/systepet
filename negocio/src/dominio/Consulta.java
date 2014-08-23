package dominio;

import java.util.Date;
import java.util.List;

public class Consulta {
	private Date fechaConsulta;
	private String observaciones;
	private List<Vacuna> vacunasRealizadas;
	private List<AplicacionAgendada> aplicacionesAgendadas;
	private String veterinario;

	public Consulta(Date date, String veterinario, String observaciones) {
		this.fechaConsulta = date;
		this.veterinario = veterinario;
		this.observaciones = observaciones;
	}

	public void agregarAplicacionAgendada(Date date, Vacuna vacuna) {
	}

	public void agregarAplicacionRealizada(Vacuna vacuna) {
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
