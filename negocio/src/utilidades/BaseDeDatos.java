package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

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
	private DataSource ds;

	private BaseDeDatos() {
		PGSimpleDataSource source = new PGSimpleDataSource();
		source.setServerName("localhost");
		source.setPortNumber(5432);
		source.setDatabaseName("systepet");
		source.setUser("systepet");
		source.setPassword("systepet");
		this.ds = source;
	}

	public static synchronized BaseDeDatos getBaseDeDatos() {
		if (bd == null) {
			bd = new BaseDeDatos();
		}
		return bd;
	}

	public List<Vacuna> buscarVacunas(String nombre) {
		List<Vacuna> lista = new ArrayList<Vacuna>();
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT id, nombre, droga, laboratorio, notas, activa FROM vacuna WHERE nombre LIKE ? ORDER BY nombre;");
			st.setString(1, "%" + nombre + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Vacuna vacuna = new Vacuna();
				vacuna.setId(rs.getInt(1));
				vacuna.setNombre(rs.getString(2));
				vacuna.setDroga(rs.getString(3));
				vacuna.setLaboratorio(rs.getString(4));
				vacuna.setNotas(rs.getString(5));
				vacuna.setActiva(rs.getBoolean(6));
				lista.add(vacuna);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar vacuna", e);
		}
		return lista;
	}
	
	public List<Vacuna> buscarVacunasActivas() {
		List<Vacuna> lista = new ArrayList<Vacuna>();
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT id, nombre, droga, laboratorio, notas, activa FROM vacuna WHERE activa = ? ORDER BY nombre;");
			st.setBoolean(1, true);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Vacuna vacuna = new Vacuna();
				vacuna.setId(rs.getInt(1));
				vacuna.setNombre(rs.getString(2));
				vacuna.setDroga(rs.getString(3));
				vacuna.setLaboratorio(rs.getString(4));
				vacuna.setNotas(rs.getString(5));
				vacuna.setActiva(rs.getBoolean(6));
				lista.add(vacuna);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar vacuna", e);
		}
		return lista;
	}

	public Vacuna buscarVacuna(int id) {
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT id, nombre, droga, laboratorio, notas, activa FROM vacuna WHERE id = ?;");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Vacuna vacuna = new Vacuna();
				vacuna.setId(rs.getInt(1));
				vacuna.setNombre(rs.getString(2));
				vacuna.setDroga(rs.getString(3));
				vacuna.setLaboratorio(rs.getString(4));
				vacuna.setNotas(rs.getString(5));
				vacuna.setActiva(rs.getBoolean(6));
				return vacuna;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar vacuna", e);
		}
	}

	public Vacuna guardarVacuna(Vacuna vacuna) {
		try (Connection conn = this.ds.getConnection()) {
			if (vacuna.getId() > 0) {
				PreparedStatement st = conn
						.prepareStatement("UPDATE vacuna SET nombre=?, droga=?, laboratorio=?, notas=?, activa=? WHERE id = ?;");
				st.setString(1, vacuna.getNombre());
				st.setString(2, vacuna.getDroga());
				st.setString(3, vacuna.getLaboratorio());
				st.setString(4, vacuna.getNotas());
				st.setBoolean(5, vacuna.isActiva());
				st.setInt(6, vacuna.getId());
				st.execute();
				return vacuna;
			} else {
				// es una vacuna nueva
				PreparedStatement st = conn
						.prepareStatement("INSERT INTO vacuna(nombre, droga, laboratorio, notas, activa) VALUES (?, ?, ?, ?, ?) RETURNING id;");
				st.setString(1, vacuna.getNombre());
				st.setString(2, vacuna.getDroga());
				st.setString(3, vacuna.getLaboratorio());
				st.setString(4, vacuna.getNotas());
				st.setBoolean(5, vacuna.isActiva());
				st.execute();
				ResultSet rs = st.getResultSet();
				if (rs.next()) {
					vacuna.setId(rs.getInt(1));
				}
				return vacuna;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar vacuna", e);
		}
	}

	public List<DuenioBasico> buscarDuenios(FiltroDuenio filtro) {
		List<DuenioBasico> lista = new ArrayList<DuenioBasico>();
		try (Connection conn = this.ds.getConnection()) {
			String sql = "SELECT id, dni, nombre, telefono, email FROM duenio ";
			// armo la consulta con los filtros
			boolean primerFiltro = true;
			if (filtro.getDni() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " dni = ? ";
				primerFiltro = false;
			}
			if (filtro.getNombre() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " nombre LIKE ? ";
				primerFiltro = false;
			}
			if (filtro.getTelefono() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " telefono LIKE ? ";
				primerFiltro = false;
			}
			PreparedStatement st = conn.prepareStatement(sql);
			// pongo los valores en los filtros
			int contadorDeFiltros = 1;
			if (filtro.getDni() != null) {
				st.setString(contadorDeFiltros++, filtro.getDni());
			}
			if (filtro.getNombre() != null) {
				st.setString(contadorDeFiltros++, "%" + filtro.getNombre()
						+ "%");
			}
			if (filtro.getTelefono() != null) {
				st.setString(contadorDeFiltros++, "%" + filtro.getTelefono()
						+ "%");
			}
			// ejecuto la consulta
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				DuenioBasico duenio = new DuenioBasico();
				duenio.setId(rs.getInt(1));
				duenio.setDni(rs.getString(2));
				duenio.setNombre(rs.getString(3));
				duenio.setTelefono(rs.getString(4));
				duenio.setEmail(rs.getString(5));
				lista.add(duenio);
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar los duenios", e);
		}
	}

	public Duenio guardarDuenio(Duenio duenio) {
		try (Connection conn = this.ds.getConnection()) {
			if (duenio.getId() > 0) {
				PreparedStatement st = conn
						.prepareStatement("UPDATE duenio SET nombre=?, dni=?, telefono=?, direccion=?, email=?, notificaciones=? WHERE id = ?;");
				st.setString(1, duenio.getNombre());
				st.setString(2, duenio.getDni());
				st.setString(3, duenio.getTelefono());
				st.setString(4, duenio.getDireccion());
				st.setString(5, duenio.getEmail());
				st.setBoolean(6, duenio.isRecibeNotificaciones());
				st.setInt(7, duenio.getId());
				st.execute();
				return duenio;
			} else {
				// es un nuevo dueño
				PreparedStatement st = conn
						.prepareStatement("INSERT INTO duenio(nombre, dni, telefono, direccion, email, notificaciones) VALUES (?, ?, ?, ?, ?, ?) RETURNING id;");
				st.setString(1, duenio.getNombre());
				st.setString(2, duenio.getDni());
				st.setString(3, duenio.getTelefono());
				st.setString(4, duenio.getDireccion());
				st.setString(5, duenio.getEmail());
				st.setBoolean(6, duenio.isRecibeNotificaciones());
				st.execute();
				ResultSet rs = st.getResultSet();
				if (rs.next()) {
					duenio.setId(rs.getInt(1));
				}
				return duenio;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar duenio", e);
		}
	}

	public Duenio buscarDuenio(int id) {
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT id, dni, nombre, telefono, direccion, email, notificacines FROM duenio WHERE id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Duenio duenio = new Duenio();
				duenio.setId(rs.getInt(1));
				duenio.setDni(rs.getString(2));
				duenio.setNombre(rs.getString(3));
				duenio.setTelefono(rs.getString(4));
				duenio.setDireccion(rs.getString(5));
				duenio.setEmail(rs.getString(6));
				duenio.setRecibeNotificaciones(rs.getBoolean(7));
				agregarMascotas(duenio);
				return duenio;
			} else {
				throw new RuntimeException(
						"Error al buscar el dueño, no existe dueño con id = "
								+ id);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar el dueño", e);
		}
	}

	private void agregarMascotas(Duenio duenio) {
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT id, nombre, especie, especieespecifica, raza, fechanacimiento, vivo FROM mascota WHERE duenioid = ?");
			st.setInt(1, duenio.getId());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Mascota mascota = new Mascota();
				mascota.setId(rs.getInt(1));
				mascota.setNombre(rs.getString(2));
				mascota.setEspecie(EspecieDeMascota.valueOf(rs.getString(3)));
				mascota.setEspecieEspecifica(rs.getString(4));
				mascota.setRaza(rs.getString(5));
				mascota.setFechaNacimiento(rs.getDate(6));
				mascota.setVivo(rs.getBoolean(7));
				mascota.setDuenio(duenio);
				duenio.getMascotas().add(mascota);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar las mascotas", e);
		}
		for (Mascota mascota : duenio.getMascotas()) {
			agregarHistoriaClinica(mascota);
		}
	}

	private void agregarHistoriaClinica(Mascota mascota) {
		HistoriaClinica hist = new HistoriaClinica();
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT c.id, c.fechaconsulta, c.veterinario, c.observaciones "
							+ " FROM consulta c "
							+ " WHERE c.mascotaid = ? ORDER BY c.id");
			st.setInt(1, mascota.getId());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setId(rs.getInt(1));
				consulta.setFechaConsulta(rs.getDate(2));
				consulta.setVeterinario(rs.getString(3));
				consulta.setObservaciones(rs.getString(4));
				hist.agregarConsulta(consulta);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar las consultas", e);
		}
		mascota.setHistoriaClinica(hist);

		// ahora agrego las aplicaciones
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT c.id, v.id, v.nombre, v.droga, v.laboratorio "
							+ " FROM consulta c "
							+ " LEFT JOIN aplicacion ap ON c.id = ap.consultaid "
							+ " LEFT JOIN vacuna v ON ap.vacunaid = v.id "
							+ " WHERE c.mascotaid = ? ORDER BY c.id");
			st.setInt(1, mascota.getId());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int consultaId = rs.getInt(1);
				Vacuna vacuna = new Vacuna();
				vacuna.setId(rs.getInt(2));
				vacuna.setNombre(rs.getString(3));
				vacuna.setDroga(rs.getString(4));
				vacuna.setLaboratorio(rs.getString(5));
				Consulta cons = hist.getConsultaPorId(consultaId);
				cons.agregarAplicacionRealizada(vacuna);
			}
		} catch (SQLException e) {
			throw new RuntimeException(
					"Error al buscar aplicaciones realizadas", e);
		}

		// ahora agrego las aplicaciones agendadas
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT c.id, v.id, v.nombre, v.droga, v.laboratorio, ap.fechaaplicacion "
							+ " FROM consulta c "
							+ " LEFT JOIN aplicacionagendada ap ON c.id = ap.consultaid "
							+ " LEFT JOIN vacuna v ON ap.vacunaid = v.id "
							+ " WHERE c.mascotaid = ? ORDER BY c.id");
			st.setInt(1, mascota.getId());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int consultaId = rs.getInt(1);
				Vacuna vacuna = new Vacuna();
				vacuna.setId(rs.getInt(2));
				vacuna.setNombre(rs.getString(3));
				vacuna.setDroga(rs.getString(4));
				vacuna.setLaboratorio(rs.getString(5));
				Consulta cons = hist.getConsultaPorId(consultaId);
				cons.agregarAplicacionAgendada(rs.getDate(6), vacuna);
			}
		} catch (SQLException e) {
			throw new RuntimeException(
					"Error al buscar aplicaciones agendadas", e);
		}
	}

	public List<MascotaBasica> buscarMascotas(FiltroMascota filtro) {
		List<MascotaBasica> lista = new ArrayList<MascotaBasica>();
		try (Connection conn = this.ds.getConnection()) {
			String sql = "SELECT m.id, m.nombre, d.nombre, m.especie FROM mascota m INNER JOIN duenio d ON m.duenioid = d.id ";
			// armo la consulta con los filtros
			boolean primerFiltro = true;
			if (filtro.getDni() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " d.dni = ? ";
				primerFiltro = false;
			}
			if (filtro.getNombre() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " d.nombred LIKE ? ";
				primerFiltro = false;
			}
			if (filtro.getTelefono() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " d.telefono LIKE ? ";
				primerFiltro = false;
			}
			if (filtro.getNombreMascota() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " m.nombre LIKE ? ";
				primerFiltro = false;
			}
			if (filtro.getHistoriaClinica() != null) {
				if (!primerFiltro) {
					sql += " AND ";
				} else {
					sql += " WHERE ";
				}
				sql += " m.id = ? ";
				primerFiltro = false;
			}
			PreparedStatement st = conn.prepareStatement(sql);
			// pongo los valores en los filtros
			int contadorDeFiltros = 1;
			if (filtro.getDni() != null) {
				st.setString(contadorDeFiltros++, filtro.getDni());
			}
			if (filtro.getNombre() != null) {
				st.setString(contadorDeFiltros++, "%" + filtro.getNombre()
						+ "%");
			}
			if (filtro.getTelefono() != null) {
				st.setString(contadorDeFiltros++, "%" + filtro.getTelefono()
						+ "%");
			}
			if (filtro.getNombreMascota() != null) {
				st.setString(contadorDeFiltros++,
						"%" + filtro.getNombreMascota() + "%");
			}
			if (filtro.getHistoriaClinica() != null) {
				st.setInt(contadorDeFiltros++, filtro.getHistoriaClinica());
			}
			// ejecuto la consulta
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				MascotaBasica mascota = new MascotaBasica(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4));
				lista.add(mascota);
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar las mascotas", e);
		}
	}

	public Mascota buscarMascota(int id) {
		int duenioId = this.buscarDuenioIdDeMascota(id);
		Duenio duenio = this.buscarDuenio(duenioId);
		return duenio.getMascotaPorId(id);
	}

	private int buscarDuenioIdDeMascota(int id) {
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement("SELECT duenioid FROM mascota WHERE id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new RuntimeException(
						"No se encontró el dueño para la mascota de id " + id);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar las mascotas", e);
		}
	}

	public Mascota guardarMascota(Mascota mascota) {
		try (Connection conn = this.ds.getConnection()) {
			if (mascota.getId() > 0) {
				PreparedStatement st = conn
						.prepareStatement("UPDATE mascota SET nombre=?, especie=?, especieespecifica=?, raza=?, fechanacimiento=?, vivo=? WHERE id = ?;");
				st.setString(1, mascota.getNombre());
				st.setString(2, mascota.getEspecie().name());
				st.setString(3, mascota.getEspecieEspecifica());
				st.setString(4, mascota.getRaza());
				st.setDate(5, new java.sql.Date(mascota.getFechaNacimiento()
						.getTime()));
				st.setBoolean(6, mascota.isVivo());
				st.setInt(7, mascota.getId());
				st.execute();
				return mascota;
			} else {
				// es una nueva mascota
				PreparedStatement st = conn
						.prepareStatement("INSERT INTO mascota(nombre, especie, especieespecifica, raza, fechanacimiento, vivo, duenioid) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id;");
				st.setString(1, mascota.getNombre());
				st.setString(2, mascota.getEspecie().name());
				st.setString(3, mascota.getEspecieEspecifica());
				st.setString(4, mascota.getRaza());
				st.setDate(5, new java.sql.Date(mascota.getFechaNacimiento()
						.getTime()));
				st.setBoolean(6, mascota.isVivo());
				st.setInt(7, mascota.getDuenio().getId());
				st.execute();
				ResultSet rs = st.getResultSet();
				if (rs.next()) {
					mascota.setId(rs.getInt(1));
				}
				return mascota;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar la mascota", e);
		}
	}

	public void guardarConsulta(Consulta consulta) {
		try (Connection conn = this.ds.getConnection()) {
			// siempre es una consulta nueva, las consultas no se pueden
			// modificar
			PreparedStatement st = conn
					.prepareStatement("INSERT INTO consulta(fechaconsulta, veterinario, observaciones, mascotaid) VALUES (?, ?, ?, ?) RETURNING id;");
			st.setDate(1, new java.sql.Date(consulta.getFechaConsulta()
					.getTime()));
			st.setString(2, consulta.getVeterinario());
			st.setString(3, consulta.getObservaciones());
			st.setInt(4, consulta.getHistoriaClinica().getCodigo());
			st.execute();
			ResultSet rs = st.getResultSet();
			if (rs.next()) {
				consulta.setId(rs.getInt(1));
			}
			// ahora guardo las aplicaciones realizadas
			for (Vacuna vac : consulta.getVacunasRealizadas()) {
				st = conn
						.prepareStatement("INSERT INTO aplicacion(vacunaid, consultaid) VALUES (?, ?);");
				st.setInt(1, vac.getId());
				st.setInt(2, consulta.getId());
				st.execute();
			}
			for (AplicacionAgendada aplic : consulta.getAplicacionesAgendadas()) {
				st = conn
						.prepareStatement("INSERT INTO aplicacionagendada(vacunaid, consultaid, fechaaplicacion) VALUES (?, ?, ?);");
				st.setInt(1, aplic.getVacuna().getId());
				st.setInt(2, consulta.getId());
				st.setDate(3, new java.sql.Date(aplic.getFechaAplicacion()
						.getTime()));
				st.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar la consulta", e);
		}
	}

	public List<Usuario> buscarUsuarios() {
		List<Usuario> lista = new ArrayList<Usuario>();
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement(""
							+ " SELECT u.user_name, u.user_pass, u.nombre, r.nombre "
							+ " FROM usuarios u INNER JOIN usuariosroles ur ON u.user_name = ur.user_name "
							+ " INNER JOIN roles r ON ur.role_name = r.nombre "
							+ " INNER JOIN ("
							+ "      SELECT ur2.user_name as user2, max(r2.nivel) as nivel2 "
							+ "      FROM usuariosroles ur2 INNER JOIN roles r2 ON ur2.role_name = r2.nombre "
							+ "      GROUP BY ur2.user_name) n ON u.user_name = n.user2 AND r.nivel = n.nivel2");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombreUsuario(rs.getString(1));
				usuario.setPassword(rs.getString(2));
				usuario.setNombre(rs.getString(3));
				usuario.setRol(Rol.valueOf(rs.getString(4).toUpperCase()));
				lista.add(usuario);
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar los usuarios", e);
		}
	}

	public Usuario buscarUsuario(String nombreUsuario) {
		try (Connection conn = this.ds.getConnection()) {
			PreparedStatement st = conn
					.prepareStatement(""
							+ " SELECT u.user_name, u.user_pass, u.nombre, r.nombre "
							+ " FROM usuarios u INNER JOIN usuariosroles ur ON u.user_name = ur.user_name "
							+ " INNER JOIN roles r ON ur.role_name = r.nombre "
							+ " INNER JOIN ("
							+ "      SELECT ur2.user_name as user2, max(r2.nivel) as nivel2 "
							+ "      FROM usuariosroles ur2 INNER JOIN roles r2 ON ur2.role_name = r2.nombre "
							+ "      GROUP BY ur2.user_name) n ON u.user_name = n.user2 AND r.nivel = n.nivel2 "
							+ " WHERE u.user_name = ?");
			st.setString(1, nombreUsuario);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombreUsuario(rs.getString(1));
				usuario.setPassword(rs.getString(2));
				usuario.setNombre(rs.getString(3));
				usuario.setRol(Rol.valueOf(rs.getString(4).toUpperCase()));
				return usuario;
			} else {
				throw new RuntimeException("Error al buscar el usuario "
						+ nombreUsuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al buscar los usuarios", e);
		}
	}

	public void guardarUsuario(Usuario usuario) {
		try (Connection conn = this.ds.getConnection()) {
			// me fijo si es un usuario nuevo
			PreparedStatement st = conn
					.prepareStatement("SELECT 1 FROM usuarios WHERE user_name = ?;");
			st.setString(1, usuario.getNombreUsuario());
			ResultSet rs = st.executeQuery();
			boolean esNuevo = true;
			if (rs.next()) {
				esNuevo = false;
			}
			rs.close();
			st.close();
			if (!esNuevo) {
				// si ya existe
				st = conn
						.prepareStatement("UPDATE usuarios SET user_pass = ?, nombre=? WHERE user_name = ?;");
				st.setString(1, usuario.getPassword());
				st.setString(2, usuario.getNombre());
				st.setString(3, usuario.getNombreUsuario());
				st.execute();
				st.close();
			} else {
				// si es un usuario nuevo
				st = conn
						.prepareStatement("INSERT INTO usuarios (user_name, user_pass, nombre) VALUES (?, ?, ?);");
				st.setString(1, usuario.getNombreUsuario());
				st.setString(2, usuario.getPassword());
				st.setString(3, usuario.getNombre());
				st.execute();
				st.close();
			}
			// ajusto los roles
			// borro los roles mas altos si es necesario
			st = conn.prepareStatement("" //
					+ " DELETE FROM usuariosroles " //
					+ " WHERE user_name = ? " //
					+ " AND role_name NOT IN (" //
					+ "       SELECT nombre " //
					+ "       FROM roles " //
					+ "       WHERE nivel <= (" //
					+ "            SELECT nivel " //
					+ "            FROM roles " //
					+ "            WHERE nombre = ?" //
					+ "       )" //
					+ " );");
			st.setString(1, usuario.getNombreUsuario());
			st.setString(2, usuario.getRol().getNombreRol());
			st.execute();
			st.close();
			// agrego los roles menores si es necesario
			st = conn
					.prepareStatement("" //
							+ " INSERT INTO usuariosroles (user_name, role_name) "
							+ "       SELECT ?, r.nombre " //
							+ "       FROM roles r" //
							+ "       WHERE nivel <= (" //
							+ "            SELECT nivel " //
							+ "            FROM roles " //
							+ "            WHERE nombre = ?" //
							+ "       ) " //
							+ "       AND NOT EXISTS (" //
							+ "            SELECT 1 " //
							+ "            FROM usuariosroles ur " //
							+ "            WHERE ur.user_name = ? AND ur.role_name = r.nombre" //
							+ "       );");
			st.setString(1, usuario.getNombreUsuario());
			st.setString(2, usuario.getRol().getNombreRol());
			st.setString(3, usuario.getNombreUsuario());
			st.execute();
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar el usuario", e);
		}
	}

	public void borrarUsuario(String nombreUsuario) {
		try (Connection conn = this.ds.getConnection()) {
			// borro los roles del usuario
			PreparedStatement st = conn
					.prepareStatement("DELETE FROM usuariosroles WHERE user_name = ? ");
			st.setString(1, nombreUsuario);
			st.execute();
			st.close();
			// borro el usuario
			st = conn
					.prepareStatement("DELETE FROM usuarios WHERE user_name = ?;");
			st.setString(1, nombreUsuario);
			st.execute();
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error al borrar el usuario", e);
		}
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
		Recordatorio recordatorio = new Recordatorio("Matilde Bengolea",
				"Chou-Chou", "tilly314@gmail.com", apli);
		List<Recordatorio> recordatorios = new ArrayList<Recordatorio>();
		recordatorios.add(recordatorio);
		return recordatorios;
	}

	public void actualizarAplicacionAgendada(AplicacionAgendada aplicacion) {
	}

	public void guardarConfiguracionEnvioRecordatorios(
			ConfiguracionEnvioRecordatorios config) {
	}
}
