package dominio;

import java.util.Date;

public class Edad {

	public enum Unidad {
		DIA("días"), MES("meses"), ANIO("años");

		private String nombre;

		private Unidad(String nombre) {
			this.nombre = nombre;
		}

		public String getNombre() {
			return nombre;
		}
	}

	private String edadString;

	private Edad(int cantidad, Unidad unidad) {
		this.edadString = cantidad + " " + unidad.nombre;
	}

	private Edad(String edadString) {
		this.edadString = edadString;
	}

	@Override
	public String toString() {
		return this.edadString;
	}

	public static Edad edadPara(Date fechaEn, Date fechaNacimiento) {
		long diff = fechaEn.getTime() - fechaNacimiento.getTime();
		int dias = (int) (diff / (24 * 60 * 60 * 1000));
		if (dias > 90) {
			int meses = dias / 30;
			if (meses > 12) {
				int anios = dias / 365;
				String edad = anios + " " + Unidad.ANIO.nombre;
				if (meses % 12 != 0) {
					edad += ", " + (meses % 12) + " meses";
				}
				return new Edad(edad);
			} else {
				return new Edad(meses, Unidad.MES);
			}
		} else {
			return new Edad(dias, Unidad.DIA);
		}
	}
}
