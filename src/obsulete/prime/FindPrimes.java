package obsulete.prime;
import java.lang.Math;

public class FindPrimes {
	
	/**
	 * Erastosthenes si
	 * Finder samtlige primtal under arg
	 */
	
	private boolean[] isPrime;
	private int numberOfPrimes = -1;
	
	public FindPrimes(int maxNumber)
	{
		isPrime = new boolean[maxNumber + 1];
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i <= isPrime.length - 1; i++)
		{
			isPrime[i] = true;
		}
		
		for (int i = 0; i <= (int) Math.sqrt(isPrime.length + 0.0); i++)
		{
			if (isPrime[i] == true)
			{
				for (int j = 2; j <= (int) ((isPrime.length - 1.0) / i); j++)
				{
					isPrime[j * i] = false;
				}
			}
		}
	}
	
	public void show()
	{
		System.out.println("Primtallene mindre end " + (isPrime.length - 1) + " er:");
		for (int i = 0; i <= isPrime.length - 1; i++)
		{
			if (isPrime[i] == true)
			{
				System.out.println(i);
			}
		}
		return;
	}
	
	private void numberOfPrimes()
	{
		numberOfPrimes = 0;
		for (int i = 0; i <= isPrime.length - 1; i++)
		{
			if (isPrime[i] == true) numberOfPrimes++;
		}
		return;
	}
	
	public int getNumberOfPrimes()
	{
		if (numberOfPrimes < 0) numberOfPrimes();
		return numberOfPrimes;
	}
	
	public int[] getPrimes()
	{
		if (numberOfPrimes < 0) numberOfPrimes();
		int[] primes = new int[numberOfPrimes ];
		int i = 0;
		for (int j = 0; j <= isPrime.length - 1; j++)
		{
			if (isPrime[j] == true) primes[i] = j;
			i++;
		}
		return primes;
	}
	
	private boolean numberOfPrimeIsPrime()
	{
		if (numberOfPrimes < 0) numberOfPrimes();
		return isPrime[numberOfPrimes];
	}
	
	public void tellIfNumberOfPrimesIsPrime()
	{
		if (numberOfPrimeIsPrime())
		{
			System.out.println("Antallet af primtal mindre end " + (isPrime.length - 1) + " et et primtal.");
		}
		else 
		{
			System.out.println("Antallet af primtal mindre end " + (isPrime.length - 1) + " er ikke et primtal.");
		}
	}
}
