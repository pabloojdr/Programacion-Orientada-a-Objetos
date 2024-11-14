package libreria;

public class LibreriaOfertaFlex extends Libreria {
	private OfertaFlex oferta;

	public LibreriaOfertaFlex(OfertaFlex oferta) {
		this.oferta = oferta;
	}

	public OfertaFlex getOferta() {
		return oferta;
	}

	public void setOferta(OfertaFlex oferta) {
		this.oferta = oferta;
	}

	@Override
	public void addLibro(String autor, String titulo, double precioBase) {
		Libro l = new Libro(autor, titulo, precioBase);
		double desc = oferta.getDescuento(l);
		if (desc != 0) {
			anyadirLibro(new LibroOferta(autor, titulo, precioBase, desc));
		} else {
			anyadirLibro(l);
		}
	}

	@Override
	public String toString() {
		return oferta.toString() + "/n" + super.toString();
	}
}
