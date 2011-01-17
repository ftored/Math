package algebra.linear.field;

import algebra.Integers;


public class Rational implements Field {
	
	public Rational(long num, long den) {
		if (den == 0) throw new IllegalArgumentException("Denominator can not be zero.");
		this.num = num;
		this.den = den;
		reduce();
	}

	public Field add(Field f) {
		Rational other = (Rational) f;
		long a = num; long b = den;
		long c = other.num; long d = other.den;
		long numsum = a * d + c * d;
		long densum = b * d;
		return new Rational(numsum, densum);
	}

	public Field subtract(Field f) {
		Rational other = (Rational) f;
		long a = num; long b = den;
		long c = other.num; long d = other.den;
		long numdif = a * d - c * d;
		long dendif = b * d;
		return new Rational(numdif, dendif);
	}

	public Field multiply(Field f) {
		Rational frac = (Rational) f;
		return new Rational(num * frac.num, den * frac.den);
	}

	public Field divide(Field f) {
		Rational frac = (Rational) f;
		if (frac.equals(ZERO))
			throw new IllegalArgumentException("Can not divide by zero.");
		return multiply(frac.reciprocal());
	}

	public Field opposite() {
		return new Rational(-1 * num, den);
	}

	public Field reciprocal() {
		if (this.equals(ZERO))
			throw new IllegalArgumentException("Zero has no multiplicative inverse.");
		return new Rational(den, num);
	}

	public Field zero() {
		return ZERO;
	}

	public Field one() {
		return ONE;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true; //not necessary, but fast
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		if (!(obj instanceof Rational)) return false;
		Rational other = (Rational) obj;
		return (num == other.num && den == other.den);
	}
	
	public String toString() {
		return "(" + Double.toString(num) + "/" + Double.toString(den) + ")";
	}
	
	private void reduce() {
		if (num == 0) den = 1;
		num /= Integers.gcd(num, den);
		den /= Integers.gcd(num, den);
	}
	
	public static final Rational ZERO = new Rational(0, 1);
	public static final Rational ONE = new Rational(1, 1);
	
	private long num;
	private long den;

}
