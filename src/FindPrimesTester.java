

import algebra.prime.FindPrimes;

public class FindPrimesTester {

	public static void main(String[] args) {
//		FindPrimes primefinder = new FindPrimes(Integer.parseInt(args[0]));
		FindPrimes primefinder = new FindPrimes(10000000);
		primefinder.findPrimes();
		System.out.println(primefinder.getNumberOfPrimes());
//		primefinder.show();
//		System.out.println(primefinder.leastPrimeGreaterThan(5));
		System.out.println(primefinder.isNumberOfPrimeCompositeString());
		System.out.println("Det er primtal nummer");

	}

}
