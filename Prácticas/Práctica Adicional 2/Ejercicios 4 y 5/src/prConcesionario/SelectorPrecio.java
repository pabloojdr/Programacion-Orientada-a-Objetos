package prConcesionario;

public class SelectorPrecio implements SelectorCoche {
	private double minimo;
	private double maximo;

	public SelectorPrecio(double minimo, double maximo) {
		this.minimo = Math.min(minimo, maximo);
		this.maximo = Math.max(minimo, maximo);
	}

	public boolean esSeleccionable(Coche c) {
		boolean seleccionable = false;

		if (minimo <= c.calcPrecioFinal() && c.calcPrecioFinal() <= maximo) {
			seleccionable = true;
		}

		return seleccionable;

	}
}
