package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HistoriaClinica implements Iterable<Consulta>{
	private List<Consulta> consultas = new LinkedList<Consulta>();

	public void agregarConsulta(Consulta consulta) {
		this.consultas.add(consulta);
	}

	@Override
	public Iterator<Consulta> iterator() {
		return consultas.iterator();
	}
}
