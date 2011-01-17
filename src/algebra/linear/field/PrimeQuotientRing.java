package algebra.linear.field;

import algebra.Integers;

public class PrimeQuotientRing implements Field {
	
	public PrimeQuotientRing(long number, long base) {
		if (Integers.isPrime(base))
			throw new IllegalArgumentException("Base must be a prime number.");
		this.number = number%base;
		this.base = base;
	}

	public Field add(Field f) {
		PrimeQuotientRing other = (PrimeQuotientRing) f;
		return new PrimeQuotientRing(number + other.number, base);
	}

	public Field subtract(Field f) {
		PrimeQuotientRing other = (PrimeQuotientRing) f;
		return new PrimeQuotientRing(number - other.number, base);
	}

	public Field multiply(Field f) {
		PrimeQuotientRing other = (PrimeQuotientRing) f;
		return new PrimeQuotientRing(number * other.number, base);
	}

	public Field divide(Field f) {
		return multiply(f.reciprocal());
	}

	public Field opposite() {
		return new PrimeQuotientRing(-1*number, base);
	}

	public Field reciprocal() {
		if (number == 0)
			throw new IllegalArgumentException("Can not divide by zero.");
		for (int i = 0; i < base; i++)
			if (multiply(new PrimeQuotientRing(i, base)).equals(zero()))
				return new PrimeQuotientRing(i, base);
		return null;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true; //not necessary, but fast
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		if (!(obj instanceof PrimeQuotientRing)) return false;
		PrimeQuotientRing other = (PrimeQuotientRing) obj;
		return number == other.number;
	}

	public Field zero() {
		return new PrimeQuotientRing(0, base);
	}

	public Field one() {
		return new PrimeQuotientRing(1, base);
	}

	private long number;
	private long base;
}
