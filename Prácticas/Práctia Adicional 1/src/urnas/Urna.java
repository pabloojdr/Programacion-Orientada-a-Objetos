package urnas;

public class Urna {
	private int afirmativos, negativos;
	private boolean resultado = true;

	public Urna() {
		this.afirmativos = 0;
		this.negativos = 0;
	}

	public void votar(boolean voto) {
		if (voto == true)
			afirmativos += 1;

		if (voto == false)
			negativos += 1;
	}

	public boolean resultado() {
		if (afirmativos > negativos)
			resultado = true;

		else if (afirmativos < negativos)
			resultado = false;

		else if(afirmativos == negativos)
			System.out.println("El numero de votos positivos y negativos es el mismo");
		return resultado;
	}

	@Override
	public String toString() {
		if (resultado == true)
			System.out.println("La votación ha salido positiva con " + afirmativos + " votos a favor y " + negativos
					+ " en contra");

		if (resultado == false)
			System.out.println("La votación ha salido negativa con " + negativos + " votos en contra y " + afirmativos
					+ " a favor");
		return null;
	}
}
