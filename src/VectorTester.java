import linearAlgebra.vector.Rn;

public class VectorTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		double[] argument0 = {0.0, 0.0, 0.0};
		double[] argument1 = {1.0, 2.0, 3.0};
		double[] argument2 = {3.0, 2.0, 1.0};
		
		Rn v1 = new Rn(argument1);
		Rn v2 = new Rn(argument2);
		Rn noVector = new Rn(3);
		
		System.out.println("Vektorerne er: ");
		System.out.println("   " + v1.toString());
		System.out.println("   " + v2.toString());
		
		if (v1.equals(v2)) System.out.println("De er ens.");
		else System.out.println("De er forskellige");
		
		if (v1.isOrthogonal(v2)) System.out.println("De er ortogonale");
		else System.out.println("De er ikke ortogonale");

		System.out.println("Summen er " + v1.getSum(v2));
		System.out.println("Skalarproduktet er " + v1.getScalarProduct(v2));
		System.out.println("Nulvektoren er: " + v1.getZero().toString());
		System.out.println("Nulvektoren er: " + noVector.getZero().toString());
	}
}
