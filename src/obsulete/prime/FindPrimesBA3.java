package obsulete.prime;
import java.lang.Math;

public class FindPrimesBA3 {
	/**
	 * 	Sien oprettes som et boolean array (BA).
	 *  Som FindPrimesBA, men med isComposite istedet for isPrime.
	 *  Derved undgåes 'isPrime[i] = true'.
	 *  AND
	 *  Math.sqrt(...) udregnes kun én gang
	 */
	
	private boolean isComposite[];
	private int numberOfPrime = -1, maxNumber;
	
	public FindPrimesBA3(int aMaxNumber) {
		maxNumber = aMaxNumber;
	}
	
	public void findPrimes() {
		isComposite = new boolean[maxNumber];
		isComposite[0] = true;
		isComposite[1] = true;
		
		int sqrt = (int) Math.sqrt(maxNumber + 0.0);
		
		for (int i = 2; i <= sqrt; i++) {
			if (!isComposite[i]) {
				for (int j = i; j <= (int) ((maxNumber - 1.0) / i); j++) {
					isComposite[j * i] = true;
				}
			}
		}
	}
	
	public boolean isComposite(int number)	{
		int sq = (int) Math.round(Math.sqrt((double) number));
		for (int i = 2; i <= sq; i++) {
			if (number % i == 0) return true;
		}
		return false;	
	}
	
	public boolean isPrime(int number) {
		return !isComposite(number);
	}
	
	public void show() {
		System.out.println("Primtallene mindre end " + (maxNumber) + " er:");
		for (int i = 0; i < maxNumber; i++) {
			if (!isComposite[i]) {
				System.out.println(i);
			}
		}
		return;
	}
	
	private void numberOfPrimes() {
		numberOfPrime = 0;
		for (int i = 0; i < maxNumber; i++) {
			if (!isComposite[i]) numberOfPrime++;
		}
		return;
	}
	
	public int getNumberOfPrimes() {
		if (numberOfPrime < 0) numberOfPrimes();
		return numberOfPrime;
	}
	
	private boolean numberOfPrimeisComposite() {
		if (numberOfPrime < 0) numberOfPrimes();
		return isComposite[numberOfPrime];
	}
	
	public void tellIfNumberOfPrimesisComposite() {
		if (numberOfPrimeisComposite()) {
			System.out.println("Antallet af primtal mindre end " + (maxNumber) + " et et primtal.");
		}
		else {
			System.out.println("Antallet af primtal mindre end " + (maxNumber) + " er ikke et primtal.");
		}
	}
	
	public int[] getPrimes() {
		int[] primes = new int[getNumberOfPrimes()];
		primes[0] = 2;
		int n = 1;
		for (int i = 3; i < maxNumber; i = i + 2) {
			if (!isComposite[i]) {
				primes[n] = i;
				n++;
			}
		}
		return primes;
	}
	
	public int leastPrimeGreaterThan(int number) {
		if (number <= 1) return 2;
		do {
			number++;
		} while (isComposite(number));

		return number;
	}
}
