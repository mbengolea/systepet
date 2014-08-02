package utilidades;

import java.util.ArrayList;
import java.util.List;

import dominio.Duenio;
import dominio.Vacuna;

public class BaseDeDatos {
	
	private static BaseDeDatos bd;
	
	public static synchronized BaseDeDatos getBaseDeDatos(){
		if (bd == null){
			bd = new BaseDeDatos();
		}
		return bd;
	}
	
	public void guardarDuenio(Duenio duenio) {
	}
	
	public List<Vacuna> buscarVacunas(String nombre){
		
		List<Vacuna> lista = new ArrayList<Vacuna>();
		for (int i = 0; i<10; i++){
			Vacuna vac = new Vacuna();
			vac.setId(i);
			vac.setLaboratorio("Laboratorio " + i);
			vac.setDroga("Droga " + i);
			vac.setNombre("Nombre " + i);
			vac.setActiva(i%2 == 0);
			lista.add(vac);
		}
		return lista ;
	}

	public Vacuna buscarVacuna(int id) {
		Vacuna vac = new Vacuna();
		vac.setId(id);
		vac.setLaboratorio("Laboratorio " + id);
		vac.setDroga("Droga " + id);
		vac.setNombre("Nombre " + id);
		vac.setActiva(id%2 == 0);
		return vac;
	}

	public void guardarVacuna(Vacuna vacuna) {
		// TODO Auto-generated method stub
	}

}
