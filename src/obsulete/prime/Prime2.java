package obsulete.prime;

public class Prime2 {

	private boolean[] notPrime;
	
	public Prime2(int maxNumber)
	{
		notPrime = new boolean[maxNumber - 1]; // Set to false initially
	}
	
	public void find()
	{
		for (int i = 0; i <= notPrime.length - 1; i++) /** Change to Math.sqrt(maxNumber) */
		{
			if (notPrime[i] == false)
			{
				for (int j = 2; j <= (int) (notPrime.length + 1.0) / (i + 2); j++)
				{
					notPrime[j * (i + 2) - 2] = true;
				}
			}
		}
		
		System.out.println("Primtallene mindre end " + (notPrime.length + 1) + " er:");
		for (int i = 0; i <= notPrime.length - 1; i++)
		{
			if (notPrime[i] == false)
			{
				System.out.println(i + 2);
			}
		}
		
		return;
	}
}
