package algebra.prime;
import java.util.ArrayList;

public class AllFactors {
/**
 * Find all factors of a given natural number greater than 0.
 */
	
	private int number;
	private ArrayList<Integer> factors = new ArrayList<Integer>();
	
	public AllFactors(int number) {
		this.number = number;
		factors.add(1);
		int sqrt = (int) Math.sqrt((double) number);
		for (int i = 2; i <= sqrt; i++) {
			if (number % i == 0) {
				factors.add(i); 
			}
		}
		int m = factors.size();
		if (factors.get(m - 1) != number / factors.get(m - 1)) factors.add(number / factors.get(m - 1));
		for (int i = m - 2; i >= 0; i--) {
			factors.add(number / factors.get(i));
		}
	}
	
	public void Print() {
		if (factors.size() == 2) System.out.println(number + " is a prime number.");
		else {
			System.out.println(number + " is a composite number.");
			for (int i = 0; i < factors.size(); i++) {
				System.out.print(factors.get(i) + " ");
			}
		}
	}
}
