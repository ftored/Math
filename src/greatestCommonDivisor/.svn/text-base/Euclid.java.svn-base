package greatestCommonDivisor;
import java.lang.Math;

public class Euclid {
	/**
	 * Euklids udvidede Algoritme
	 * Bestemmer største fælles divisor samt en linearkombination der giver denne 
	 */

	private int[] q;
	private int[] r;
	private int[] x;
	private int[] y;
	private int i;
	
	public Euclid(int a, int b) {
		int m = a;

		r = new int[m];
		x = new int[m];
		y = new int[m];
		q = new int[m];
		
		r[0] = Math.max(a, b);
		r[1] = Math.min(a, b);
		
		x[0] = 1;
		x[1] = 0;
		y[0] = 0;
		y[1] = 1;
		q[1] = calcQ(1);
		
		for (i = 2; calcR(i+1) > 0; i++) {
			r[i] = calcR(i);
			q[i] = calcQ(i);
			x[i] = calcX(i);
			y[i] = calcY(i);
		}
		i = i - 2;
	}

	private int calcQ(int i)
	{
		return (int) Math.floor((double) r[i - 1] / r[i]);
	}
	
	private int calcR(int i)
	{
		return (int) r[i - 2] - q[i - 1] * r[i - 1];
	}
	
	private int calcX(int i)
	{
		return (int) x[i - 2] - q[i - 1] * x[i - 1];
	}
	
	private int calcY(int i)
	{
		return (int) y[i - 2] - q[i - 1] * y[i - 1];
	}

	public void getGCD()
	{
		System.out.println("gcd(" + r[0] + "," + r[1] + ") = " + r[i]);
	}
	
	public void getAll()
	{
		for (int k = 0;  k <= i; k++)
		{
			System.out.println(k + "   " + q[k] + "   " + r[k] + "   " + x[k] + "   " + y[k]);
		}
		System.out.println((i + 1)  + "   " + "-" + "   " + r[i + 1] + "   " + "-" + "   " + "-");
	}

}


