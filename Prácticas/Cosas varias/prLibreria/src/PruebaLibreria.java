import libreria.Libreria;

public class PruebaLibreria {
	public static void main(String[] arg) {
		Libreria li = new Libreria();

		li.addLibro("George Orwell", "1984", 8.20);
		li.addLibro("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?", 3.50);
		li.addLibro("Isaac Asimov", "Fundaci�n e Imperio", 9.40);
		li.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		li.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		li.addLibro("Isaac Asimov", "La Fundaci�n", 7.30);
		li.addLibro("William Gibson", "Neuromante", 8.30);
		li.addLibro("Isaac Asimov", "Segunda Fundaci�n", 8.10);
		li.addLibro("Isaac Newton", "Arithmetica Universalis", 7.50);
		li.addLibro("George Orwell", "1984", 6.20);
		li.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
		System.out.println(li);
		li.remLibro("George Orwell", "1984");
		li.remLibro("Aldous Huxley", "Un Mundo Feliz");
		li.remLibro("Isaac Newton", "Arithmetica Universalis");
		// li.remLibro("James Gosling", "The Java Language Specification");
		System.out.println(li);
		// System.out.println("getPrecioFinal(\"George Orwell\", \"1984\"): " +
		// li.getPrecioFinal("George Orwell", "1984"));
		System.out.println("getPrecioFinal(\"Philip K. Dick\", \"�Sue�an los androides con ovejas el�ctricas?\")): "
				+ li.getPrecioFinal("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?"));
		System.out.println("getPrecioFinal(\"Isaac Asimov\", \"Fundaci�n e Imperio\")): "
				+ li.getPrecioFinal("Isaac Asimov", "Fundaci�n e Imperio"));
		System.out.println("getPrecioFinal(\"Ray Bradbury\", \"Fahrenheit 451\")): "
				+ li.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
		// System.out.println("getPrecioFinal(\"Aldous Huxley\", \"Un Mundo Feliz\")): "
		// + li.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"));
		System.out.println("getPrecioFinal(\"Isaac Asimov\", \"La Fundaci�n\")): "
				+ li.getPrecioFinal("Isaac Asimov", "La Fundaci�n"));
		System.out.println("getPrecioFinal(\"William Gibson\", \"Neuromante\")): "
				+ li.getPrecioFinal("William Gibson", "Neuromante"));
		System.out.println("getPrecioFinal(\"Isaac Asimov\", \"Segunda Fundaci�n\")): "
				+ li.getPrecioFinal("Isaac Asimov", "Segunda Fundaci�n"));
		// System.out.println("getPrecioFinal(\"Isaac Newton\", \"Arithmetica
		// Universalis\")): " + li.getPrecioFinal("Isaac Newton", "Arithmetica
		// Universalis"));
	}
}
