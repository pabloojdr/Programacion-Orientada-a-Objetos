package libreria;

public class LibreriaOferta extends Libreria {
	private double porcDescuento;
	String[] autoresOferta;

	public LibreriaOferta(double porcDescuento, String[] autoresOferta) {
		super();
		this.autoresOferta = new String[autoresOferta.length];
		this.porcDescuento = porcDescuento;

		for (int i = 0; i < autoresOferta.length; ++i) {
			this.autoresOferta[i] = autoresOferta[i];
		}
	}

	public void setOferta(double descuento, String[] autoresOferta) {
		porcDescuento = descuento;
		for (int i = 0; i < autoresOferta.length; ++i) {
			this.autoresOferta[i] = autoresOferta[i];
		}
	}

	public String[] getOferta() {
		return autoresOferta;
	}

	public double getDescuento() {
		return porcDescuento;
	}

	
	private int buscarLibroOferta(String autor) {
		int pos = -1;
		for
	}
	
	
	@Override
	public void addLibro(String autor, String titulo, double pBase) {
		for (int i = 0; i < autoresOferta.length; i++) {
			if (autoresOferta[i].equalsIgnoreCase(autor)) {
				LibroOferta lo = new LibroOferta(autor, titulo, pBase, this.porcDescuento);
				anyadirLibro(lo);
			}

			else {
				anyadirLibro(new Libro(autor, titulo, pBase));
			}
		}
	}
	
	@Override
	public String toString() {
		return getDescuento() + autoresOferta.toString(); + super.toString();
	}

}
