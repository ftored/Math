package obsulete.prime;

public class ModuloPrime {
	
	private boolean[] isPrime;
	private int maxNumber;
	
	public ModuloPrime(int number)
	{
		maxNumber = number;
		System.out.println("ModuloPrime");
	}
	
	public void findPrimes()
	{
		isPrime = new boolean[maxNumber + 1];
		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; i <= isPrime.length - 1; i++)
		{
			isPrime[i] = true;
		}
		
		for (int i = 2; i <= maxNumber; i++)
		{
			for (int j = 2; j < Math.sqrt(i + 0.0); j++)
			{
				if (i % j == 0)
				{
					isPrime[i] = false;
					break;
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
}
