

import prime.IsPrime;


public class IsPrimeTester {

	public static void main(String[] args) {
		
		System.out.println("Main class: IsPrimeTester");
		long testTal = 100663296000000001L;
		IsPrime primtalTester = new IsPrime(testTal);
		primtalTester.tellIfNumberIsPrime();
	}
}
