package obsulete.prime;

import java.util.BitSet;
import java.lang.Math;

	/**
	 * Som FindPrimesBitSet, men med en anden implementering af selve sien 
	 * 
	 *
	 */

public class FindPrimesBitSet2{
	private int upperBound;
	private BitSet isComposite = new BitSet(); // BitSet initialiseres så isComposite[i] = false
	
	public FindPrimesBitSet2(int aUpperBound) {
		upperBound = aUpperBound;
		int sqrtUpperBound = (int) Math.sqrt((double) upperBound);
		isComposite.set(0, true);
		isComposite.set(1, true);
		
		for (int i = 2; i <= sqrtUpperBound; i++) {
			if (!isComposite.get(i)) {
				for (int j = i; j <= (int) ((upperBound - 1.0) / i); j++) {
					isComposite.set(j * i, true);
				}
			}
		}
	}
	
	public void showPrimes() {
		for (int i = 1; i <= upperBound; i++) {
			if (!isComposite.get(i)) System.out.println(i);
		}
	}
	
	public int countPrimes() {
		int j = 0;
		for (int i = 1; i < upperBound; i++) {
			if (!isComposite.get(i)) j++;
		}
		return j;
	}
}
