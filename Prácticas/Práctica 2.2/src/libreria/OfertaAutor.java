package libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
	private double porcDescuento;
	private String[] autoresOferta;

	public OfertaAutor(double porcDescuento, String[] autoresOferta) {
		this.porcDescuento = porcDescuento;
		this.autoresOferta = autoresOferta;
	}

	@Override
	public double getDescuento(Libro l) {
		double desc = 0;
		for (int i = 0; i < autoresOferta.length; i++) {
			if (autoresOferta[i].equalsIgnoreCase(l.getAutor())) {
				desc = porcDescuento;
			}
		}
		return desc;
	}

	private int buscarAutorOferta(String autor) {
		// Version con for
		int res = -1;
		for (int i = 0; i < autoresOferta.length; i++) {
			if (autoresOferta[i].equalsIgnoreCase(autor)) {
				res = i;
			} else {
				res = -1;
			}
		}

		return res;
	}

	@Override
	public String toString() {
		return porcDescuento + "%" + Arrays.toString(autoresOferta);
	}

}
