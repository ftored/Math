package greatestCommonDivisor;


public class EuclidTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Euclid tester");
		Euclid euklid = new Euclid(30, 21);
		euklid.getGCD();
		euklid.getAll();
		System.out.println("\n");
		
		System.out.println("GCD tester");
		GCD gcd = new GCD(30, 21);
		System.out.println("GCD er " + gcd.getGCD());
		System.out.println("\n");
		
		System.out.println("ExtendedEuclid tester");
		ExtendedEuclid extendedEuclid = new ExtendedEuclid(36163, 21199);
		extendedEuclid.printResult();
		System.out.println("\n");
	}
}
