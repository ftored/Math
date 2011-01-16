package obsulete.prime;
import java.lang.Math;

public class FindPrimesBA {
	/**
	 * 	Sien oprettes som et boolean array (BA).
	 */
	
	private boolean isPrime[];
	private int numberOfPrime = -1, maxNumber;
	
	public FindPrimesBA(int aMaxNumber) {
		maxNumber = aMaxNumber;
	}
	
	public void findPrimes() {
		isPrime = new boolean[maxNumber];
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i < maxNumber; i++) {
			isPrime[i] = true;
		}
		
		for (int i = 0; i <= (int) Math.sqrt(maxNumber + 0.0); i++) {
			if (isPrime[i]) {
				for (int j = i; j <= (int) ((maxNumber - 1.0) / i); j++) {
					isPrime[j * i] = false;
				}
			}
		}
	}
	
	public boolean isPrime(int number)	{
	
		int sq = (int) Math.round(Math.sqrt((double) number));
		
		for (int i = 2; i <= sq; i++) {
			if (number % i == 0) return false;
		}
		return true;	
	}
	
	public void show() {
		System.out.println("Primtallene mindre end " + (maxNumber) + " er:");
		for (int i = 0; i < maxNumber; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}
		return;
	}
	
	private void numberOfPrimes() {
		numberOfPrime = 0;
		for (int i = 0; i < maxNumber; i++) {
			if (isPrime[i]) numberOfPrime++;
		}
		return;
	}
	
	public int getNumberOfPrimes() {
		if (numberOfPrime < 0) numberOfPrimes();
		return numberOfPrime;
	}
	
	private boolean numberOfPrimeIsPrime() {
		if (numberOfPrime < 0) numberOfPrimes();
		return isPrime[numberOfPrime];
	}
	
	public void tellIfNumberOfPrimesIsPrime() {
		if (numberOfPrimeIsPrime()) {
			System.out.println("Antallet af primtal mindre end " + (maxNumber) + " et et primtal.");
		}
		else {
			System.out.println("Antallet af primtal mindre end " + (maxNumber) + " er ikke et primtal.");
		}
	}
	
	public int leastPrimeGreaterThan(int number) {
		int prime = 0;
		boolean noPrime = true;
		for (int i = number; noPrime; i++)
		{
			if (isPrime(i))
			{
				noPrime = false;
				prime = i;
			}
		}
		return prime;
	}
}
