import libreria.*;

public class MiPruebaLibreria {
	public static void main(String[] args) {
		Libreria l;
		l = new Libreria();

		l.addLibro("george orwell", "1984", 6.20);
		l.addLibro("Philip K. Dick", "?Suenan los androides con ovejas electricas?", 3.50);
		l.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
		l.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		l.addLibro("Alex Huxley", "Un Mundo Feliz", 6.50);
		l.addLibro("Isaac Asimov", "La Fundación", 7.30);
		l.addLibro("William Gibson", "Neuromante", 8.30);
		l.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
		l.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		l.addLibro("George Orwell", "1984", 6.20);
		l.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);


		
//		System.out.println("La Fundacion; Precio: " + l.getPrecioFinal("Isaac Asimov", "La Fundación"));
//		System.out.println("Fake; Precio: " + l.getPrecioFinal("Fake", "Fake"));	
		
		System.out.println();
		System.out.println(l);
		System.out.println();	
	}
}	


