import java.util.Arrays;
import datos.Datos;
import datos.DatosException;

public class PruebaDatos {

	public static void main(String[] args) {
		//try {
			double min = Double.parseDouble(args[0]);
			double max = Double.parseDouble(args [1]);
			Datos datos = new Datos(Arrays.copyOfRange(args, 2, args.length), min, max);
			System.out.println();
			System.out.println(datos.getDatos());
			System.out.println();
		//}
		
		String entrada[] = { "5", "9.5", "-Pepe", "Pepe", "10,5", "Maria", "12", "13", "Paco", "17", "20"};
		//double min = 5.0;
		//double max = 10.0;
		
		//Datos datos = new Datos(entrada, min, max);
		
		System.out.println(entrada.length + " " + datos.getDatos() + ": " + datos.getErrores());
	}
}
