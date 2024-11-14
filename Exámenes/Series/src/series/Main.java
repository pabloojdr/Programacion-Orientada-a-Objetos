package series;

public class Main {

	public static void main(String[] args) {
		Episodio ep = new Episodio("Linterena azul", 58, 4);
		System.out.println(ep);
		Trailer tr= new Trailer("Amarillo", 4);
		System.out.println(tr);
		String[] st= {"4:Juana de Arco:50" , "7:NotreDame:80"};
		Serie serie= new Serie("Santa Teresa", st);
		System.out.println(serie);
		System.out.println(serie.duracionTotal());
		System.out.println(serie.obtenerEpisodio(4));

	}

}
