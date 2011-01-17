package algebra.prime;

import java.util.ArrayList;

public class PrimeFactors {

	private int number;
	private int primes[];
	private ArrayList<Integer> primeFactors = new ArrayList<Integer>();
	
	public PrimeFactors(int number) {
		this.number = number;
		FindPrimes primeFinder = new FindPrimes(number);
		primeFinder.findPrimes();
		primes = primeFinder.getPrimes();
		for (int i = 0; i < primes.length; i++) {
			if (number % primes[i] == 0) {
				primeFactors.add(primes[i]);
				int rest = number / primes[i];
				while (rest % primes[i] == 0) {
					primeFactors.add(primes[i]);
					rest = rest / primes[i];
				}
			}
		}
	}
	
	public int[] getPrimes() {
		int result[] = new int[primeFactors.size()]; 
		for (int i = 0; i < primeFactors.size(); i++) {
			result[i] = primeFactors.get(i);
		}
		return result;
	}
	
	public void Print() {
		if (primeFactors.size() == 0) System.out.println(number + " is a prime number.");
		else {
			System.out.println(number + " is a composite number with the prime factorization");
			System.out.print(primeFactors.get(0));
			for (int i = 1; i < primeFactors.size(); i++) {
				System.out.print("*" + primeFactors.get(i));
			}
		}
	}
}
