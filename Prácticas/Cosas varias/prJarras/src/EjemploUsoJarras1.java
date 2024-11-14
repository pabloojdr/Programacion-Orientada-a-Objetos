import jarras.Jarra;

public class EjemploUsoJarras1 {

	public static void main(String[] args) {
		Jarra jarraA = new Jarra(7); // new es el que realmente crea el objeto. Al principio me da error porque no
									 // sabe lo que es "Jarra", para solucionarlo importamos "Jarra" (Pinchando sobre
									 // el error te da opciones para solucionarlo)

		Jarra jarraB = new Jarra(4);

		System.out.println("Contenido jarraA: " + jarraA.contenido());  // Nos muestra el contenido, aunque al principio
																		// nos da
																		// error si no usamos (), ya que sin ellos nos
																		// referimos al
																		// atributo (private) y queremos ver el método
																		// (public)
																		// para eso sirven los getters
		jarraA.llena();
		System.out.println( jarraA + ", " + jarraB); // Aquí nos muestra lo que hemos decidido mostrar en el método
													 // toString
													 // (Funcionaría igual si escribimos j1.toString()

		jarraB.llenaDesde(jarraA);
		System.out.println( jarraA + ", " + jarraB );
		
		jarraB.vacia();
		System.out.println(  jarraA + ", " + jarraB );
		
		jarraB.llenaDesde(jarraA);
		System.out.println( jarraA + ", " + jarraB );
	}

}
