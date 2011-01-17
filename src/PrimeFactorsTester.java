

import algebra.prime.PrimeFactors;

public class PrimeFactorsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main class: PrimeFactorTester");
		int testNumber = 2;
		PrimeFactors factors = new PrimeFactors(testNumber);
		factors.Print();
	}

}
