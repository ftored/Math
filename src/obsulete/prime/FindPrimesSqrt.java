package obsulete.prime;
import java.lang.Math;

public class FindPrimesSqrt {
	private int maxNumber;
	private int[] primes;
	private int sqrtMaxNumber;
	private FindPrimesBA3 sqrtPrimes;
	
	public FindPrimesSqrt(int maxNumber) {
		this.maxNumber = maxNumber;
		System.out.println("Finder samtlige primtal mindre end " + maxNumber);
		sqrtMaxNumber = (int) (Math.sqrt((double) maxNumber));
		System.out.println("Første primtal findes...");
		sqrtPrimes = new FindPrimesBA3(sqrtMaxNumber);
		sqrtPrimes.findPrimes();
		System.out.println("Første primtal fundet.");
//		sqrtPrimes.show();
		getSqrtPrimes();
		System.out.println("Første primtal initialiseret. Resten findes.");
		getOtherPrimes();
//		showPrimes();
	}
	
	private void getOtherPrimes() {
		int n = sqrtPrimes.getNumberOfPrimes();
		int maxSqrtPrime = sqrtPrimes.getNumberOfPrimes() - 1;
		boolean isPrime = true;
		for (int i = sqrtMaxNumber; i < maxNumber; i++) {
			for (int j = 0; j <= maxSqrtPrime; j++) {
				if (i % primes[j] == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes[n] = i;
//				System.out.println(n + " er et primtal.");
				n++;
			}
			isPrime = true;
		}
	}
	
	public void showPrimes() {
		for (int i = 0; primes[i] != 0; i++) {
			System.out.println(primes[i]);
		}
	}
	
	private int maxNumberOfPrimes() {
		return (int) (1.2 * (maxNumber + 0.0) / Math.log(maxNumber));
	}
	
	private void getSqrtPrimes() {
		primes = new int[maxNumberOfPrimes()];
		System.out.println("Maximalt antal primtal: " + maxNumberOfPrimes());
		int[] smallPrimes = sqrtPrimes.getPrimes();
		for (int i = 0; i < smallPrimes.length; i++) {
			primes[i] = smallPrimes[i];
		}
	}
	
	public int getNumberOfPrimes() {
		int numberOfPrimes = 0;
		for (int i = 0; i < maxNumberOfPrimes(); i++) {
			if (primes[i] != 0) numberOfPrimes++;
		}
		return numberOfPrimes;
	}
	
	public int[] getPrimes() {
		return primes;
	}
}
