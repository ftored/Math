import algebra.linear.vector.DoubleVector;

public class VectorTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		double[] argument0 = {0.0, 0.0, 0.0};
		double[] argument1 = {1.0, 2.0, 3.0};
		double[] argument2 = {3.0, 2.0, 1.0};
		
		DoubleVector v1 = new DoubleVector(argument1);
		DoubleVector v2 = new DoubleVector(argument2);
		
		System.out.println("Vektorerne er: ");
		System.out.println("   " + v1.toString());
		System.out.println("   " + v2.toString());
		
		if (v1.equals(v2)) System.out.println("De er ens.");
		else System.out.println("De er forskellige");
		
		if (v1.isOrthogonal(v2)) System.out.println("De er ortogonale");
		else System.out.println("De er ikke ortogonale");

		System.out.println("Summen er " + v1.add(v2));
		System.out.println("Skalarproduktet er " + v1.getInnerProduct(v2));
		System.out.println("Nulvektoren er: " + v1.zero().toString());
	}
}
