package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HistoriaClinica implements Iterable<Consulta>{
	private List<Consulta> consultas = new LinkedList<Consulta>();
	private Mascota mascota;

	public void agregarConsulta(Consulta consulta) {
		consulta.setHistoriaClinica(this);
		this.consultas.add(consulta);
	}

	@Override
	public Iterator<Consulta> iterator() {
		return consultas.iterator();
	}

	public Consulta getConsultaPorId(int consultaId) {
		for (Consulta cons : this.consultas){
			if (cons.getId() == consultaId){
				return cons;
			}
		}
		return null;
	}
	
	void setMascota(Mascota mascota){
		this.mascota = mascota;
	}
	
	public int getCodigo(){
		return this.mascota.getId();
	}
}
