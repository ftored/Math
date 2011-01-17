package algebra;

import java.util.ArrayList;
import algebra.prime.FindPrimes;

public class Integers 
{
	
	/**
	 * Checks if an integer is a prime number.
	 * @param number an integer
	 * @return a boolean telling if number is a prime
	 */
	public static boolean isPrime(long number) 
	{
		long sq = (long) Math.round(Math.sqrt((double) number));
		
		for (long i = 2; i <= sq; i++)
		{
			if (number % i == 0) return false;
		}
		return true;
	}
	
	/**
	 * Computes the greatest commen divisor.
	 * @param a an integer
	 * @param b a integer
	 * @return the greatest commen divisor between a and b.
	 */
	public static long gcd(long a, long b)
	{
		if (b > a) return gcd(b, a);
		if (b == 0) return a;	
		return gcd(b, a%b);
	}
	
	/**
	 * Factorize a number into it's prime factorization
	 * @param number an integer of type long
	 * @return the prime factorization
	 */
	public static long[] factorize(int number)
	{
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		FindPrimes primeFinder = new FindPrimes(number);
		primeFinder.findPrimes();
		int[] primes = primeFinder.getPrimes();
		for (int i = 0; i < primes.length; i++) 
		{
			if (number % primes[i] == 0) 
			{
				primeFactors.add(primes[i]);
				int rest = number / primes[i];
				while (rest % primes[i] == 0) 
				{
					primeFactors.add(primes[i]);
					rest = rest / primes[i];
				}
			}
		}
		
		long result[] = new long[primeFactors.size()]; 
		for (int i = 0; i < primeFactors.size(); i++) {
			result[i] = primeFactors.get(i);
		}
		return result;
	}
	
	/**
	 * 
	 * @param number
	 * @return the prime factors of a number
	 */
	public static long[] primeFactors(long number)
	{
		// TODO
		return null;
	}
	
	/**
	 * Gives all the divisors to from number
	 * @param number
	 * @return
	 */
	public static long[] allFactors(long number)
	{
		ArrayList<Long> factors = new ArrayList<Long>();
		factors.add(new Long(1));
		int sqrt = (int) Math.sqrt((double) number);
		for (int i = 2; i <= sqrt; i++)
		{
			if (number % i == 0) 
			{
				factors.add(new Long(i)); 
			}
		}
		int m = factors.size();
		if (factors.get(m - 1) != number / factors.get(m - 1)) factors.add(number / factors.get(m - 1));
		for (int i = m - 2; i >= 0; i--) 
		{
			factors.add(number / factors.get(i));
		}
		m = factors.size();
		long[] result = new long[m];
		for (int i = 0; i < m; i++) 
		{
			result[i] = factors.get(i);
		}
		return result;
	}
	
	/**
	 * Checks if a number is palindrome.
	 * @param number
	 * @return
	 */
	public static boolean isPalindrome(long number)
	{
		// TODO
		return true;
	}
	
	/**
	 * Checks if a number is even.
	 * @param number
	 * @return
	 */
	public static boolean isEven(long number)
	{
		return number%2==0;
	}

}
