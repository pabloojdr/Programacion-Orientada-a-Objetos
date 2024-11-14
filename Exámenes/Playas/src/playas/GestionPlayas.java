package playas;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GestionPlayas {
	private ArrayList<Playa> playas;
	private String provincia;

	public GestionPlayas(String provincia) {
		this.playas = new ArrayList<Playa>();
		this.provincia = provincia;
	}

	public GestionPlayas(String p, String[] datos) {
		this.provincia = p;
		this.playas = new ArrayList<Playa>();

		for (String d : datos) {
			try (Scanner sc = new Scanner(d)) {
				sc.useDelimiter("[;]");
				String nombre = sc.next();
				String localidad = sc.next();
				sc.useLocale(Locale.ENGLISH);
				double latitud = sc.nextDouble();
				double longitud = sc.nextDouble();
				int aforoMax = sc.nextInt();

				playas.add(new Playa(nombre, localidad, latitud, longitud, aforoMax));
			} catch (IllegalArgumentException e) {
				throw new PlayaException("ERROR. Valor no numérico");
			} catch (ArrayIndexOutOfBoundsException ee) {
				throw new PlayaException("ERROR. Faltan datos");
			}catch(PlayaException eee) {
				throw new PlayaException("ERROR. Aforo negativo");
			}
		}
	}

	private int posicion(Playa p) {
		int pos = -1;
		for (int i = 0; i < playas.size(); i++) {
			if (p.equals(playas.get(i))) {
				pos = i;
			}
		}
		return pos;
	}

	public void incluye(Playa p) {
		
		if (posicion(p) >= 0) {
			playas.set(posicion(p), p);
			
		} else if (posicion(p) == -1) {
			playas.add(p);
		}

	}

}
