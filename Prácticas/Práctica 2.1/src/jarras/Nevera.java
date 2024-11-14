
package neveras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

public class Nevera {
	private double ocupacion;
	private final double capacidad;
	protected Map<Producto, Double> productos;

	public Nevera(double c) {
		capacidad = c;
		productos = new HashMap<>();
	}

	public Nevera(double c, String file) {
		this(c);
		procesaProductos(file);
	}

	public Set<Producto> getProductos() {
		return productos.keySet();
	}

	public double getCapacidad() {
		return capacidad;
	}

	public double getDisponible() {
		return capacidad - ocupacion;
	}

	public double getPeso(String c, Fecha f) {
		double weight = 0;
		for (Producto p : productos.keySet())
			if (p.getCodigo().equalsIgnoreCase(c) && p.getFecha().compareTo(f) < 0)
				weight += productos.get(p);
		return weight;
	}

	public void mete(String c, String n, Fecha f, double p) {
		if (p <= 0)
			throw new IllegalArgumentException();
		if (getDisponible() == 0)
			return;
		p = Math.min(p, getDisponible());
		Producto product = new Producto(c, n, f);
		double weight = productos.getOrDefault(product, Double.valueOf(0));
		productos.put(product, weight + p);
		ocupacion += p;
	}

	public void saca(String c, Fecha f, double p) {
		Producto product = new Producto(c, "dummy", f);
		double weight = productos.getOrDefault(product, Double.valueOf(0));
		if (p <= 0 || weight < p)
			throw new IllegalArgumentException();
		if (weight - p == 0)
			productos.remove(product);
		else
			productos.put(product, weight - p);
		ocupacion -= p;
	}

	protected void procesaProductos(String file) {
		try (Scanner sc = new Scanner(new File(file))) {
			procesaProductos(sc);
		} catch (FileNotFoundException e) {
			// dejamos la nevera vacía
		}
	}

	protected void procesaProductos(Scanner sc) {
		sc.useDelimiter("\\s*[;]\\s*");
		while (sc.hasNext()) {
			try (Scanner sc2 = new Scanner(sc.next())) {
				sc2.useDelimiter("\\s*[:/]\\s*");
				sc2.useLocale(Locale.ENGLISH);
				String c = sc2.next();
				String n = sc2.next();
				double p = sc2.nextDouble();
				int d = sc2.nextInt();
				int m = sc2.nextInt();
				int a = sc2.nextInt();
				Fecha f = new Fecha(d, m, a);
				mete(c, n, f, p);
			} catch (NoSuchElementException | IllegalArgumentException e) {
				// descartamos el producto
			}
		}
	}

	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for (Entry<Producto, Double> entry : productos.entrySet())
			sj.add("[" + entry.getKey() + " (" + entry.getValue() + ")]");
		return ocupacion + " / " + capacidad + ": " + sj.toString();
	}
}
