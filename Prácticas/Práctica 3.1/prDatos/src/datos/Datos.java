package datos;

import java.util.ArrayList;

public class Datos {
	private ArrayList<Double> datos;
	private ArrayList<String> errores;
	private double min;
	private double max;

	public Datos(String[] s, double mn, double mx) {
		this.min = mn;
		this.max = mx;

		datos = new ArrayList<Double>();
		errores = new ArrayList<String>();

		/*
		 * for (int i = 0; i < s.length; i++) { Double.parseDouble(s[i]); }
		 */

		for (String entrada : s) { // A cada elemento de s lo llamo entrada
			try {
				datos.add(Double.parseDouble(entrada));
			} catch (NumberFormatException e) { // Usamos el e para declararlo, ya que es necesario por sintaxis, aunque
												// despues no lo vamos a usar
				errores.add(entrada);
			} catch (Exception e) { // Usamos Exception para que se active sin necesidad de mirar todos los tipos de
									// errores
			}
		}
	}

	public double calcMedia() {
		int n = 0;
		double sum = 0.0;

		for (double numero : datos) {
			if (numero <= max && numero >= min) {
				n++;
				sum += numero;
			}
		}
		if (n == 0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		/*
		 * for (int i = 0; i < datos.size(); i++) { if (datos.get(i) <= max &&
		 * datos.get(i) >= min) { n++; sum += datos.get(i); } }
		 */

		return sum / n;
	}

	public double calcDesvTipica() { //se tiene que poner throws DatosException
		double sum = 0;
		int n = 0;
		/*
		 * for (int i = 0; i < datos.size(); i++) { if (datos.get(i) <= max &&
		 * datos.get(i) >= min) { sum = Math.pow(datos.get(i) - calcMedia(), 2); }
		 * 
		 * }
		 */
		for (double numero : datos) {
			if (numero <= max && numero >= min) {
				n++;
				sum = Math.pow(numero - calcMedia(), 2);
			}
		}
		if (n == 0) {
			throw new DatosException("No hay datos en el rango especificado");
		}

		return Math.sqrt(sum / n);
	}

	public void setRango(String n) {
		try {
			int i = n.indexOf(';');
			this.min = Double.parseDouble(n.substring(0, i - 1));
			this.max = Double.parseDouble(n.substring(i + 1, n.length()));

		} catch (Exception e) {
			throw new DatosException("Error en los datos al establecer el rango");
		}
	}

	/*
	 * public void setRangoSplit(String rango) { //Aún no hemos trabajado con split
	 * 
	 * try { String[] split = rango.split(";"); min = Double.valueOf(split[0]); max
	 * = Double.valueOf(split[1]); } catch (Exception e) { throw new
	 * DatosException("Error en los datos al establecer el rango"); } }
	 */

	public ArrayList<Double> getDatos() {
		return datos;
	}

	public ArrayList<String> getErrores() {
		return errores;
	}

	@Override
	public String toString() {
		try {
			return "Min: " + this.min + ", Max: " + this.max + ", " + datos.toString() + ", " + errores.toString()
					+ ", Media: " + calcMedia() + ", DesvTipica: " + calcDesvTipica();
		} catch (Exception e) {
			throw new DatosException("Min: " + this.min + ", Max: " + this.max + ", " + datos.toString() + ", "
					+ errores.toString() + ", Media: ERROR, DesvTipica: ERROR");
		}
	}

}
