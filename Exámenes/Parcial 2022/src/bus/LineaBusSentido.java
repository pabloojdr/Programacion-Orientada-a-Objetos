package bus;

public class LineaBusSentido extends LineaBus {
	private boolean sentidoInvertido;

	public LineaBusSentido(String n) {
		super(n);
		this.sentidoInvertido = false;
	}

	public void cambiarSentido() {
		if (this.sentidoInvertido == true) {
			this.sentidoInvertido = false;
		} else if (this.sentidoInvertido == false) {
			this.sentidoInvertido = true;
		}
	}

	public Parada inicio() {
		int pos = -1;
		if (linea == null) {
			throw new RuntimeException("La linea no contiene ninguna parada");
		} else if (this.sentidoInvertido == false) {
			pos = 0;
		} else if (this.sentidoInvertido == true) {
			pos = linea.size() - 1;
		}

		return linea.get(pos);
	}

	public Parada fin() {
		int pos = -1;
		if (linea == null) {
			throw new RuntimeException("La linea no contiene ninguna parada");
		} else if (this.sentidoInvertido == false) {
			pos = linea.size() - 1;
		} else if (this.sentidoInvertido == true) {
			pos = 0;
		}

		return linea.get(pos);
	}
}
