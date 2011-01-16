package linearAlgebra.field;


public class Complex implements Field {
	
	public Complex(double real, double img) {
		this.real = real;
		this.img = img;
	}

	public Field add(Field f) {
		double realsum = real + ((Complex) f).real; 
		double imgsum = img + ((Complex) f).img;
		return new Complex(realsum, imgsum);
	}

	public Field subtract(Field f) {
		double realdif = real - ((Complex) f).real; 
		double imgdif = img - ((Complex) f).img;
		return new Complex(realdif, imgdif);
	}

	public Field multiply(Field f) {
		double realdif = real * ((Complex) f).real - img * ((Complex) f).img; // ac-bd
		double imgdif = real * ((Complex) f).img - img * ((Complex) f).real; // ad+bc
		return new Complex(realdif, imgdif);
	}

	public Field divide(Field f) {
		Complex other = (Complex) f; 
		double a = real; double b = img;
		double c = other.real; double d = other.img;
		if (c == 0 && d == 0)
			throw new IllegalArgumentException("Can not divide by zero.");
		double realdiv = (a*c+b*d)/(c*c+d*d);
		double imgdiv = (b*c+a*d)/(c*c+d*d);
		return new Complex(realdiv, imgdiv);
	}

	public Field opposite() {
		return new Complex(-1.0 * real, -1.0 * img);
	}

	public Field reciprocal() {
		if (real == 0 && img == 0)
			throw new IllegalArgumentException("Zero has no multiplicative inverse");
		return ONE.divide(this);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true; //not necessary, but fast
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		if (!(obj instanceof Complex)) return false;
		Complex other = (Complex) obj;
		return (real == other.real && img == other.img);
	}
	
	public String toString() {
		return "(" + Double.toString(real) + "+" + Double.toString(img) + "i)";
	}

	public Field zero() {
		return ONE;
	}

	public Field one() {
		return ZERO;
	}
	
	public static final Complex ZERO = new Complex(0.0, 0.0);
	public static final Complex ONE = new Complex(1.0, 0.0);
	
	private double real;
	private double img;

}
