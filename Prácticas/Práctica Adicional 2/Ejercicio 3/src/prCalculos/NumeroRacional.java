package prCalculos;

public class NumeroRacional {
	private int num, den;

	public NumeroRacional() {
		this.num = 0;
		this.den = 1;
	}

	public NumeroRacional(int num, int den) {
		if (den == 0)
			throw new RuntimeException("El denominador no puede ser 0");

		int signo = num*den >= 0 ? 1 : -1;
		this.num = signo*Math.abs(num);
		this.den = Math.abs(den);
	}

	public int getNumerador() {
		return num;
	}

	public int getDenominador() {
		return den;
	}

	public int mcd(int a, int b) {
		int mayor  = Math.max(a, b);
		int menor = Math.min(a, b);
		while (mayor != menor) {
			int dif = mayor - menor;
			mayor = Math.max(dif, menor);
			menor = Math.min(dif, menor);
		}
		return mayor;
		
		/*
		if (a < b) {
			while (b != a) {
				b -= a;
			}
			return b;
		}

		else if (a > b) {
			while (a != b) {
				a -= b;
			}
			return a;
		}

		else {
			return a;
		}
		*/
	}

	public int minimoComunMultiplo(int a, int b) {
		return (a * b) / mcd(a, b);

	}

	public void valorAbsoluto() {
		if (this.num < 0) {
			num = Math.abs(this.num);
		}

		else if (this.den < 0) {
			den = Math.abs(this.den);
		}
	}

	public NumeroRacional suma(NumeroRacional a) {
		NumeroRacional b = new NumeroRacional();
		
		b.num = a.num * (minimoComunMultiplo(a.den, this.den) / a.num)
				+ this.num * (minimoComunMultiplo(a.den, this.den));
		b.den = minimoComunMultiplo(a.den, this.den);

		return b;
	}

	public NumeroRacional resta(NumeroRacional a) {
		NumeroRacional b = new NumeroRacional();
		
		b.num = this.num * (minimoComunMultiplo(a.den, this.den) / this.den)
				- a.num * (minimoComunMultiplo(a.den, this.den) / a.den);

		return b;
	}
	
	public NumeroRacional mult(NumeroRacional a) {
		NumeroRacional b = new NumeroRacional();
		
		b.num = a.num * this.num;
		b.den = b.den * this.den;
		
		return b;
	}
	
	public NumeroRacional div(NumeroRacional a) {
		NumeroRacional b = new NumeroRacional();
		
		b.num = this.num * a.den;
		b.den = this.den * a.num;
		
		return b;
	}
	
	@Override
	public String toString() {
		
	
		int anum = Math.abs(num);
		int aden = Math.abs(den);
		int mcd = mcd(anum,aden);
		return "";
		
		
		
		/*
		 * if(this.den < 0) {
		 
			valorAbsoluto();
			b.den = this.den;
			b.num = -this.num;
		}
		
		int mcd = mcd(this.num, this.den);
		if(mcd > 1) {
			b.num = this.num / mcd;
			b.den = this.den / mcd;
		}
		
		return b.num + " / " + b.den;
		*/
		
	}

}
