package prConcesionario;

public class Coche {
	private String m;
	private double p;
	private static int R = 0;
	private int numref = 0;
	private static double IVA = 10.0;
	private static double MATRICULACION = 100.0;

	public Coche(String m, double p) {
		if (m == null || p < 0) {
			throw new RuntimeException("Tienes que introducir un modelo o un precio que no sea negativo");
		}
		this.m = m;
		this.p = p;
		numref = incrementarRef();
	}

	public static int incrementarRef() {
		R++;
		return R;
	}

	public String getModelo() {
		return m;
	}

	public int getRef() {
		return R;
	}

	public double getPrecioBase() {
		return p;
	}

	public void setPrecioBase(double p) {
		if (p < 0)
			throw new RuntimeException("El nuevo precio no puede ser negativo");
		else {
			this.p = p;
		}
	}

	public static double getGastosMatriculacion() {
		return MATRICULACION;
	}

	public static double getIVA() {
		return IVA;
	}

	public static void setIVA(double d) {
		IVA = d;
	}

	public double calcPrecioFinal() {
		return p + MATRICULACION + ((getIVA() / 100) * p);
	}

	@Override
	public String toString() {
		return "(" + numref + ", " + getModelo() + ", " + calcPrecioFinal() + ")";
	}

}
