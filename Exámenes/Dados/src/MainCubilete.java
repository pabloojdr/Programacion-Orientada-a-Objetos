import java.util.*;

import dados.*;

public class MainCubilete {
	public static void main(String[] args) {
		Cubilete c = new Cubilete(5);
		
		Set<Dado> c1 = c.tira();
		System.out.println(c1);
		
		int n = 0;
		for(Dado d : c1) {
			if(d.getCara() == 6) {
				n  = 6;
			}
		}
		
		if(n == 6) {
			System.out.println("Ha salido al menos un 6");
		}
		
		if(n == 0) {
			System.out.println("No ha salido ningún 6");
		}
	}
}
