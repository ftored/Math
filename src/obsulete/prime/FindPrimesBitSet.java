package obsulete.prime;

import java.util.BitSet;
import java.lang.Math;

public class FindPrimesBitSet{
	private int upperBound;
	private BitSet isComposite = new BitSet();
	
	public FindPrimesBitSet(int aUpperBound) {
		upperBound = aUpperBound;
		int sqrtUpperBound = (int) Math.sqrt((double) upperBound);
		int j;
		isComposite.set(0, true);
		isComposite.set(1, true);
		
		/*// Ej nødvendigt, da BitSet som standard er false
		for (int i = 2; i <= upperBound; i++){
			isComposite.set(i, false);
		}*/
		
		for (int i = 2; i <= sqrtUpperBound; i++) {
			j = i*i;
			while (j <= upperBound) {
				isComposite.set(j, true);
				j = j + i;
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
