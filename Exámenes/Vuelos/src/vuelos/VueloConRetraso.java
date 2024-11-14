package vuelos;

import java.util.*;

public class VueloConRetraso extends Vuelo{
	private Random rnd = new Random();
	private int retraso;
	
	public VueloConRetraso(String a, String c, Hora h, int d, String o, String des) {
		super(a, c, h, d, o, des);
		retraso = rnd.nextInt(3*d);
	}
	
	public Hora getHoraSalida() {
		return super.getHoraSalida().horaTrasMinutos(super.getDuracion() + retraso);
	}
}
