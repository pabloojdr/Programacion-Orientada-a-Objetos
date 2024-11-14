import jarras.Jarra;

public class EjemploUsoJarras1 {

	public static void main(String[] args) {
		Jarra j1 = new Jarra(-4); 	// new es el que realmente crea el objeto. Al principio me da error porque no
									// sabe lo que es "Jarra", para solucionarlo importamos "Jarra" (Pinchando sobre
									// el error te da opciones para solucionarlo)

		System.out.println("Contenido: " + j1.contenido()); // Nos muestra el contenido, aunque al principio nos da
															// error si no usamos (), ya que sin ellos nos referimos al
															// atributo (private) y queremos ver el método (public)
															// para eso sirven los getters

		System.out.println(j1); 							// Aquí nos muestra lo que hemos decidido mostrar en el método toString
															// (Funcionaría igual si escribimos j1.toString()
	}

}
