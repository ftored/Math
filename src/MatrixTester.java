import algebra.linear.matrix.*;


public class MatrixTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] arg1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
		double[][] arg2 = {{9.0, 8.0, 7.0}, {6.0, 5.0, 4.0}, {3.0, 2.0, 1.0}};
		double[][] argSmall = {{1.0, 2.0}, {3.0, 4.0}};
		double[][] argDet24 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 1.0}};
		
		CubicDoubleMatrix m1 = new CubicDoubleMatrix(arg1);
		CubicDoubleMatrix m2 = new CubicDoubleMatrix(arg2);
		CubicDoubleMatrix small = new CubicDoubleMatrix(argSmall);
		CubicDoubleMatrix m24 = new CubicDoubleMatrix(argDet24);

		System.out.println(m1.toString() + " +\n" + m2.toString() + " =\n" + m1.add(m2).toString());
		System.out.println(m1.toString() + " +\n" + m2.toString());
		System.out.println(small.toString());
		System.out.println(small.getDeterminant());
		System.out.println(m1.getDeterminant());
		System.out.println(m24.getDeterminant());
	}

}
