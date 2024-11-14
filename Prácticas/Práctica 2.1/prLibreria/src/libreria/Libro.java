package libreria;

public class Libro {
	private static double porcIVA = 10.0;
	private String autor;
	private String titulo;
	private double precioBase;

	public Libro(String autor, String titulo, double precioBase) { // Este es el constructor, lo mejor es empezar por �l
		this.autor = autor;
		this.titulo = titulo;
		this.precioBase = precioBase;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	protected double getBaseImponible() {
		return precioBase;
	}

	public double getPrecioFinal() {
		return getBaseImponible() + getBaseImponible() * porcIVA / 100; // Se usa el m�todo por si se redefine el m�todo
																		// getBaseImponible.
	}

	@Override

	public String toString() {
		return ("(" + autor + "; " + titulo + "; " + precioBase + "; " + porcIVA + "%; " + getPrecioFinal() + ")");
	}

	public static double getIVA() {
		return porcIVA; // Podr�amos haber puesto Libro.porcIVA, pero como estamos en la propia clase no
						// es necesario
	}

	public static double setIVA(double nuevo_precio) {
		return porcIVA = nuevo_precio;
	}
}
