package linearAlgebra.field;


public class Real implements Field {
	
	public Real(double real) {
		this.real = real;
	}

	public Field add(Field f) {
		return new Real(real + ((Real) f).real);
	}

	public Field subtract(Field f) {
		return new Real(real + ((Real) f).real);
	}

	public Field multiply(Field f) {
		return new Real(real * ((Real) f).real);
	}

	public Field divide(Field f) {
		return new Real(real * ((Real) f.reciprocal()).real);
	}

	public Field opposite() {
		return new Real(-1.0 * real);
	}

	public Field reciprocal() {
		if (real == 0) throw new IllegalArgumentException("Can not divide by zero.");
		return new Real(1.0 / real);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true; //not necessary, but fast
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		if (!(obj instanceof Real)) return false;
		Real other = (Real) obj;
		return real== other.real;
	}
	
	public String toString() {
		return Double.toString(real);
	}

	public Field zero() {
		return ZERO;
	}

	public Field one() {
		return ONE;
	}
	
	public static final Real ZERO = new Real(0.0);
	public static final Real ONE = new Real(1.0);
	
	private double real;

}
