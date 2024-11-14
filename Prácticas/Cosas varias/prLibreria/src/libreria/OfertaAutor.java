package libreria;

public class OfertaAutor implements OfertaFlex {
	private double porcDescuento;
	private String[] autoresOferta;

	public OfertaAutor(double porcDescuento, String[] autoresOferta) {
		this.porcDescuento = porcDescuento;
		this.autoresOferta = autoresOferta;
	}

	public double getDescuento(Libro l) {
		for (int i = 0; i < autoresOferta.length(); i++) {
			if (autoresOferta[i] == l.getAutor()) {

			}
		}
	}

	private int buscarAutorOferta(String autor) {
		//Version con for
		for(int i = 0, i < autoresOferta.length(); i++) {
			if(autoresOferta[i].equalsIgnoreCase(autor)) {
				return i;
			}else {
				return -1;
			}
		}
		
		/*Version con while
		 * private int buscarAutorOferta(String autorBuscado){
		 * int
		 */
	}
}
