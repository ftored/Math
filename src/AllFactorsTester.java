

import algebra.prime.AllFactors;

public class AllFactorsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main class: PrimeFactorTester");
//		int testTal = 1991;
		int testTal = 2*2*2*2*2*4;
		AllFactors factor = new AllFactors(testTal);
		factor.Print();
	}
}
