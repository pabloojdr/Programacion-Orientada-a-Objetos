package rutas;

public class RutaDesdeETSIInf extends Ruta {
	public RutaDesdeETSIInf(String n) {
		super(n);
	}

	public void agregar(Lugar l) {
		super.agregar(l);
		lugares.sort(new OrdenETSIInfUMA());
	}

}
