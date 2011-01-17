package algebra.prime;
import java.lang.Math;

public class IsPrime {

	/**
	 * Deter if a number is a prime number or not
	 */
	
	private boolean isPrime;
	private long number;
	
	public IsPrime(long aNumber)
	{
		System.out.println("Class: IsPrime");
		number = aNumber;
		isPrime = testIfPrime(number);
	}
	
	public boolean isPrime()
	{
		return isPrime;
	}
	
	public boolean testIfPrime(long number)
	{
		long sq = (long) Math.round(Math.sqrt((double) number));
		
		for (long i = 2; i <= sq; i++)
		{
			if (number % i == 0) return false;
		}
		return true;
	}
	
	public void tellIfNumberIsPrime()
	{
		if (isPrime)
		{
			System.out.println("Tallet " + number + " er et primtal."); 
		}
		else 
		{
			System.out.println("Tallet " + number + " er ikke et primtal.");
		}
	}
}
