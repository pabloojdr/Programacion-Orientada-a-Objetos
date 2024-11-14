package prConcesionario;
import prConcesionario.CocheColor;

public class SelectorColor implements SelectorCoche{
	private Color color;
	
	public SelectorColor(String cl) {
		if(Color.valueOf(cl).ordinal() < 0) {
			throw new RuntimeException("ERROR: DATOS INCORRECTOS");
		}
		
		color = Color.valueOf(cl);
	}
	
	public boolean esSeleccionable(Coche c) {
		boolean seleccionable = false;
		
		if((c instanceof CocheColor)) {
			if(((CocheColor) c).getColor().equals(color)) {
				seleccionable = true;
			}
		}
		
		return seleccionable;
	}
}
