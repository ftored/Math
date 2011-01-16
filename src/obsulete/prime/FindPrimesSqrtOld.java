package obsulete.prime;
import java.lang.Math;

public class FindPrimesSqrtOld {
	private int maxNumber;
	private int[] firstPrimes;
	private int[] primes;
	private FindPrimesBA3 findFirstPrimes;
	
	public FindPrimesSqrtOld(int maxNumber) {
		this.maxNumber = maxNumber;
		System.out.println("Første primtal findes...");
		findFirstPrimes = new FindPrimesBA3((int) (Math.sqrt((double) maxNumber)));
		findFirstPrimes.findPrimes();
		firstPrimes = new int[findFirstPrimes.getNumberOfPrimes()];
		firstPrimes = findFirstPrimes.getPrimes();
		System.out.println("Første primtal fundet. Primtal initialiseres.");
		primes = new int[maxNumberOfPrimes()];
		for (int i = 0; i <= firstPrimes.length - 1; i++) {
			primes[i] = firstPrimes[i];
		}
		System.out.println("Første primtal initialiseret.");
		System.out.println("Finder øvrige primtal.");
	}
	
	private int maxNumberOfPrimes() {
		return (int) (1.1 * (maxNumber + 0.0) / Math.log(maxNumber));
	}
	
	public int getNumberOfPrimes() {
		int numberOfPrimes = 0;
		for (int i = 0; i < primes.length; i++) {
			if (primes[i] != 0) numberOfPrimes++;
		}
		return numberOfPrimes;
	}
}
