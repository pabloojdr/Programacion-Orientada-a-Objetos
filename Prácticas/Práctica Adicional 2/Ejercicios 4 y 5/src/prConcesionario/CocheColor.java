package prConcesionario;
import prConcesionario.Color;
import java.util.Arrays;

public class CocheColor extends Coche {
	private Color color;

	public CocheColor(String m, double p, String cn) {
		super(m, p);
		
		if(m.equalsIgnoreCase(null) || Color.valueOf(cn).ordinal()<0 || p<0) {
			throw new RuntimeException ("ERROR: DATOS INCORRECTOS");
		}
		
		color = Color.valueOf(cn);
		
	}

	public CocheColor(String m, double p, Color col) {
		super(m, p);
		if(m.equalsIgnoreCase(null) || col.ordinal()<0 || p<0) {
			throw new RuntimeException ("ERROR: DATOS INCORRECTOS");
		}
		color = col;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		color = c;
	}

	public void setColor(String col) {
		color = Color.valueOf(col);
	}

	@Override
	public String getModelo() {
		return super.getModelo();
	}

	@Override
	public double getPrecioBase() {
		return super.getPrecioBase()+color.ordinal()*10;
	}
	
	@Override
	public String toString() {
		return "(" + super.getRef() + ", " + getModelo() + ", "+ color.name() + ", " + this.calcPrecioFinal() + ")";
	}
	
	/*static public String[] coloresDisponibles(){
		String[] colores = new String[color.];
		for(int i=0; i<colores.length; ++i) {
			colores[i]=color.toString();
		}
	*/
	//}
	
}