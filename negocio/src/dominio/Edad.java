package dominio;


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
	
	private final int numero;
	private final Unidad unidad;

	public Edad(int numero, Unidad unidad) {
		super();
		this.numero = numero;
		this.unidad = unidad;
	}

	public int getNumero() {
		return numero;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	@Override
	public String toString() {
		return numero + " " + unidad.getNombre();
	}
}
