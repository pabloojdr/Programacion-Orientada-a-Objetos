package vuelos;

import java.util.Objects;

public class Vuelo implements Comparable<Vuelo> {
	private String aerolinea;
	private String codigo;
	private Hora hora;
	private int duracion;
	private String origen;
	private String destino;

	public Vuelo(String a, String c, Hora h, int d, String o, String des) {
		if (d < 0) {
			throw new VuelosException("La duración no puede ser negativa");
		}

		aerolinea = a;
		codigo = c;
		hora = h;
		duracion = d;
		origen = o;
		destino = des;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public String getCodigo() {
		return codigo;
	}

	public Hora getHoraSalida() {
		return hora;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public Hora getHoraLlegada() {
		return hora.horaTrasMinutos(duracion);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Vuelo && ((Vuelo) o).origen.equalsIgnoreCase(origen)
				&& ((Vuelo) o).destino.equalsIgnoreCase(destino) && ((Vuelo) o).codigo.equalsIgnoreCase(codigo));
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino.toUpperCase(), origen.toUpperCase(), codigo.toUpperCase());
	}
	
	@Override
	public int compareTo(Vuelo v) {
		int result = v.origen.compareToIgnoreCase(origen);
		
		if(result == 0) {
			result = v.destino.compareToIgnoreCase(destino);
			if(result == 0) {
				result = v.codigo.compareToIgnoreCase(codigo);
			}
		}
		
		return result;
	}
	
	
}
