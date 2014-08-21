package utilidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.Duenio;
import dominio.EspecieDeMascota;
import dominio.Mascota;
import dominio.Vacuna;

public class BaseDeDatos {

	private static BaseDeDatos bd;

	public static synchronized BaseDeDatos getBaseDeDatos() {
		if (bd == null) {
			bd = new BaseDeDatos();
		}
		return bd;
	}

	public Duenio guardarDuenio(Duenio duenio) {
		return duenio;
	}

	public List<Vacuna> buscarVacunas(String nombre) {

		List<Vacuna> lista = new ArrayList<Vacuna>();
		for (int i = 0; i < 10; i++) {
			Vacuna vac = new Vacuna();
			vac.setId(i);
			vac.setLaboratorio("Laboratorio " + i);
			vac.setDroga("Droga " + i);
			vac.setNombre("Nombre " + i);
			vac.setActiva(i % 2 == 0);
			lista.add(vac);
		}
		return lista;
	}

	public Vacuna buscarVacuna(int id) {
		Vacuna vac = new Vacuna();
		vac.setId(id);
		vac.setLaboratorio("Laboratorio " + id);
		vac.setDroga("Droga " + id);
		vac.setNombre("Nombre " + id);
		vac.setActiva(id % 2 == 0);
		return vac;
	}

	public void guardarVacuna(Vacuna vacuna) {
		// TODO Auto-generated method stub
	}

	public List<DuenioBasico> buscarDuenios(FiltroDuenio filtro) {
		List<DuenioBasico> lista = new ArrayList<DuenioBasico>();
		for (int i = 0; i < 10; i++) {
			DuenioBasico duenio = new DuenioBasico();
			duenio.setId(i);
			duenio.setNombre("Nombre " + i);
			duenio.setDni("" + i);
			duenio.setEmail("email " + i);
			duenio.setTelefono(i + " - " + i);
			lista.add(duenio);
		}
		return lista;
	}

	public Duenio buscarDuenio(int id) {
		Duenio duenio = new Duenio();
		duenio.setId(id);
		duenio.setNombre("Nombre " + id);
		duenio.setDni("" + id);
		duenio.setDireccion("Direccion " + id);
		duenio.setRecibeNotificaciones(id % 2 == 0);
		duenio.setEmail("email " + id);
		duenio.setTelefono(id + " - " + id);
		return duenio;
	}

	public List<MascotaBasica> buscarMascotas(FiltroMascota filtro) {
		List<MascotaBasica> lista = new ArrayList<MascotaBasica>();
		for (int i = 0; i < 10; i++) {
			lista.add(new MascotaBasica(i, "nombre" + i, "nombreDuenio" + i,
					"especie" + i));
		}
		return lista;
	}

	public Mascota buscarMascota(int id) {
		Mascota mascota = new Mascota();
		mascota.setId(id);
		mascota.setNombre("nombre" + id);
		mascota.setFechaNacimiento(new Date());
		mascota.setRaza("raza" + id);
		mascota.setVivo(id % 2 == 0);
		mascota.setEspecie(EspecieDeMascota.FELINO);
		return mascota;
	}
}
