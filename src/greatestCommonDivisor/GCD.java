package greatestCommonDivisor;

public class GCD {
	private int gcd;
	
	public GCD (int a, int b) {
		gcd = calcGCD(Math.max(a, b), Math.min(a, b));
	}
	
	private int calcGCD (int a, int b) {
		if (b == 0) return a;	
		return calcGCD(b, a%b);
	}
	
	public int getGCD () {
		return gcd;
	}
}
