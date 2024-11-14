import jarras.Mesa;

public class EjemploUsoMesa1 {
	
	public static void main(String[] args) {
		Mesa mesa1 = new Mesa(7, 5);
		
		mesa1.llena(2);
		System.out.println(mesa1);
		
		mesa1.llenaDesde(2);
		System.out.println(mesa1);
		
		mesa1.llena(2);
		System.out.println(mesa1);
		
		mesa1.llenaDesde(2);
		System.out.println(mesa1);
		
		mesa1.vacia(1);
		System.out.println(mesa1);
		
		mesa1.llenaDesde(2);
		System.out.println(mesa1);
		
		mesa1.llena(2);
		System.out.println(mesa1);
		
		mesa1.llenaDesde(2);
		System.out.println(mesa1);
	}
}
