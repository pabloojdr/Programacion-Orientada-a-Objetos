package libreria;

public class OfertaPrecio implements OfertaFlex {
	private double porcDescuento;
	private double umbralDescuento;

	public OfertaPrecio(double porcDescuento, double umbralDescuento) {
		this.porcDescuento = porcDescuento;
		this.umbralDescuento = umbralDescuento;
	}

	@Override
	public double getDescuento(Libro l) {
		return (l.getPrecioBase() >= umbralDescuento) ? porcDescuento : 0;
		
		/*
		 * if (l.getPrecioBase() >= umbralDescuento){
		 * 		return porcDescuento;
		 * } else {
		 * 		return 0;
		 * 	}
		 */
	}
	
	@Override
	public String toString() {
		return porcDescuento + "% (" + umbralDescuento + ")";
	}
}
