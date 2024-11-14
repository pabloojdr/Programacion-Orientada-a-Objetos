package libreria;

public class LibroOferta extends Libro {
	private double porcDescuento;

	public LibroOferta(String autor, String titulo, double pBase, double porcDescuento) {
		super(autor, titulo, pBase); 	// La llamada al constructor heredado tiene que ser en la primera linea, no
										// podemos ponerlo después. Si no ponemos el super, usaria directamente el
										// constructor sin argumentos super()
		this.porcDescuento = porcDescuento;
	}

	public double getDescuento() {
		return porcDescuento;
	}

	@Override
	protected double getBaseImponible() {
		return super.getBaseImponible() - super.getBaseImponible() * (porcDescuento / 100);
	}

	@Override
	public String toString() {
		return "(" + this.getAutor() + "; " + this.getTitulo() + "; " + this.getPrecioBase() + "; " + this.porcDescuento
				+ "%; " + this.getBaseImponible() + "; " + getIVA() + "%; " + this.getPrecioFinal() + ")";
	}
}
