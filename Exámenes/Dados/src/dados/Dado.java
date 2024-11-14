package dados;

import java.util.*;

public class Dado {
	private static Random aleat = new Random();
	private int cara;
	
	public Dado() {
		agita();
	}
	
	public void agita() {
		cara = aleat.nextInt(6)+1;
	}
	
	public int getCara() {
		return cara;
	}
	
	@Override
	public String toString() {
		return "[" + cara + "]";
	}
}
