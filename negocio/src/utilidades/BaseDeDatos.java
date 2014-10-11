package utilidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.AplicacionAgendada;
import dominio.ConfiguracionEnvioRecordatorios;
import dominio.Consulta;
import dominio.Duenio;
import dominio.EspecieDeMascota;
import dominio.HistoriaClinica;
import dominio.Mascota;
import dominio.Recordatorio;
import dominio.Rol;
import dominio.Usuario;
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
		agregarMascotas(duenio);
		return duenio;
	}

	private void agregarMascotas(Duenio duenio) {
		for (int i = duenio.getId(); i < duenio.getId() + 3; i++) {
			Mascota mascota = new Mascota();
			mascota.setId(i);
			mascota.setNombre("nombre" + i);
			mascota.setFechaNacimiento(new Date());
			mascota.setRaza("raza" + i);
			mascota.setVivo(i % 2 == 0);
			mascota.setEspecie(EspecieDeMascota.FELINO);
			mascota.setDuenio(duenio);
			duenio.getMascotas().add(mascota);
			agregarHistoriaClinica(mascota);
		}
	}

	private void agregarHistoriaClinica(Mascota mascota) {
		HistoriaClinica hist = new HistoriaClinica();
		for (int i = 0; i < mascota.getId(); i++) {
			Consulta consulta = new Consulta();
			consulta.setFechaConsulta(new Date());
			consulta.setVeterinario("Nombre Vete" + i);
			consulta.setObservaciones("Observaciones muy laaargas");
			Vacuna vacuna = new Vacuna();
			vacuna.setNombre("vacuna1 de " + i);
			consulta.agregarAplicacionRealizada(vacuna);
			vacuna = new Vacuna();
			vacuna.setNombre("vacuna2 de " + i);
			consulta.agregarAplicacionRealizada(vacuna);
			consulta.agregarAplicacionAgendada(new Date(), vacuna);
			consulta.agregarAplicacionAgendada(new Date(), vacuna);
			hist.agregarConsulta(consulta);
		}
		mascota.setHistoriaClinica(hist);
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
		int duenioId = this.buscarDuenioIdDeMascota(id);
		Duenio duenio = this.buscarDuenio(duenioId);
		return duenio.getMascotaPorId(id);
	}

	private int buscarDuenioIdDeMascota(int id) {
		return id;
	}

	public Mascota guardarMascota(Mascota mascota) {
		if (mascota.getId() <= 0) {
			mascota.setId(1);
		}
		return mascota;
	}

	public void guardarConsulta(Consulta consulta) {

	}

	public List<Usuario> buscarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (int i = 1; i <= 3; i++) {
			Usuario u = new Usuario();
			u.setNombre("nombre " + i);
			u.setPassword("password" + i);
			u.setNombreUsuario("username" + i);
			u.setRol(Rol.values()[i % 3]);
			usuarios.add(u);
		}
		return usuarios;
	}

	public Usuario buscarUsuario(String nombreUsuario) {
		Usuario u = new Usuario();
		u.setNombre("nombre de " + nombreUsuario);
		u.setPassword("passwordDe" + nombreUsuario);
		u.setNombreUsuario(nombreUsuario);
		u.setRol(Rol.JEFE_VETERINARIO);
		return u;
	}

	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	public void borrarUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub

	}

	public ConfiguracionEnvioRecordatorios buscarConfiguracionEnvioDeRecordatorios() {
		ConfiguracionEnvioRecordatorios config = new ConfiguracionEnvioRecordatorios();
		config.setDiasDeAnterioridad(1);
		config.setEmailOrigen("systepet@gmail.com");
		config.setEnvioHabilitado(true);
		config.setUsuario("systepet");
		config.setPassword("systepet1");
		config.setPlantilla("Hola, ${nombre_dueño}!\nRecuerde que debe aplicarle la vacuna ${nombre_vacuna} a ${nombre_mascota} el día ${fecha_agendada}.\nVeterinaria PetyPet");
		config.setAsunto("Prueba de envio de mail");
		return config;
	}

	public List<Recordatorio> buscarAplicacionesAgendadas() {
		Vacuna vacuna = new Vacuna();
		vacuna.setNombre("antirrábica");
		AplicacionAgendada apli = new AplicacionAgendada(new Date(), vacuna);
		Recordatorio recordatorio = new Recordatorio("Matilde Bengolea", "Chou-Chou",
				"tilly314@gmail.com", apli);
		List<Recordatorio> recordatorios = new ArrayList<Recordatorio>();
		recordatorios.add(recordatorio);
		return recordatorios;
	}

	public void actualizarAplicacionAgendada(AplicacionAgendada aplicacion) {
	}
}
