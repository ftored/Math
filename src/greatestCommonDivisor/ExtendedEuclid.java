package greatestCommonDivisor;

public class ExtendedEuclid {
	private int m, n;
	private int[] result;
	
	public ExtendedEuclid (int a, int b) {
		this.m = Math.max(a, b);
		this.n = Math.min(a, b);
		result = calcExtendedEuclid(m, n);
	}
	
	private int[] calcExtendedEuclid(int m, int n) {
		if (n == 0) return new int[] {m, 1, 0};
		int[] result = calcExtendedEuclid(n, m%n);
		
		int r = result[0];
		int a = result[2];
		int b = result[1] - (m / n) * result[2];

		return new int[] {r, a, b};
	}
	
	public int[] getResult () {
		return result;
	}
	
	public void printResult () {
		System.out.println("(" + result[1] + ")(" + m + ") + (" + result[2] + ")" +
				"(" + n + ") = " + result[0]);
	}
}
