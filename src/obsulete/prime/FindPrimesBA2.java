package obsulete.prime;
import java.lang.Math;

public class FindPrimesBA2 {
	/**
	 * 	Sien oprettes som et boolean array (BA).
	 *  Som FindPrimesBA, men med isComposite istedet for isComposite.
	 *  Derved undgåes 'isComposite[i] = true'.
	 */
	
	private boolean isComposite[];
	private int numberOfPrime = -1, maxNumber;
	
	public FindPrimesBA2(int aMaxNumber) {
		maxNumber = aMaxNumber;
	}
	
	public void findPrimes() {
		isComposite = new boolean[maxNumber];
		isComposite[0] = true;
		isComposite[1] = true;
		
		/*  // Ej nødvendigt!
		for (int i = 2; i < maxNumber; i++) {
			isComposite[i] = false;
		}
		*/
		for (int i = 0; i <= (int) Math.sqrt(maxNumber + 0.0); i++) {
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
	
	public void show() {
		System.out.println("Primtallene mindre end " + (maxNumber) + " er:");
		for (int i = 0; i < maxNumber; i++) {
			if (isComposite[i]) {
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
	
/*	public int leastPrimeGreaterThan(int number) { // Funktionen skal rettes!
		int prime = 0;
		boolean noPrime = false;
		for (int i = number; noPrime; i++)
		{
			if (isComposite(i))
			{
				noPrime = true;
				prime = i;
			}
		}
		return prime;
	}*/
}
