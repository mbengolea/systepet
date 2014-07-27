package dominio;

import java.util.Date;

public class AplicacionAgendada {
	private Date fechaAplicacion;
	private Vacuna vacuna;
	private boolean recordatorioEnviado;

	public AplicacionAgendada(Date date, Vacuna vacuna) {
		this.fechaAplicacion = date;
		this.vacuna = vacuna;
	}

	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setRecordatorioEnviado(boolean recordatorioEnviado) {
		this.recordatorioEnviado = recordatorioEnviado;
	}

}
