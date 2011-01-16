package linearAlgebra.matrix;

public class CubicDoubleMatrix extends DoubleMatrix implements Matrix<Double> {

	public CubicDoubleMatrix(double[][] aMatrix) {
		super(aMatrix);
		for (int i = 0; i < aMatrix.length; i++)
			if (aMatrix.length != aMatrix[i].length)
				throw new IllegalArgumentException();
	}

	public static CubicDoubleMatrix getIdentity(int dim) {
		double[][] identity = new double[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				if (i == j) identity[i][j] = 1;
				else identity[i][j] = 0;
			}
		}
		return new CubicDoubleMatrix(identity);
	}

	public boolean isSingular() {
		return !isInvertible();
	}

	public boolean isInvertible() {
		return (getDeterminant() != 0.0);
	}

	public double getDeterminant() {
		return calcDet(matrix);
	}

	private double calcDet(double[][] aMatrix) {
		if (aMatrix.length == 1) return aMatrix[0][0];
		double result = 0.0;
		for (int i = 0; i < aMatrix.length; i++) 
			result += Math.pow(-1, i + 0.0) * aMatrix[0][i]
			          * calcDet(getMatrixPart(aMatrix, 0, i));
		return result;
	}

	private double[][] getMatrixPart(double[][] aMatrix, int row, int column) {
		double[][] matrixPart = new double[aMatrix.length-1][aMatrix.length-1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				matrixPart[i][j] = aMatrix[i][j];
			for (int j = column+1; j < aMatrix.length; j++)
				matrixPart[i][j-1] = aMatrix[i][j];
		}
		for (int i = row+1; i < aMatrix.length; i++) {
			for (int j = 0; j < column; j++)
				matrixPart[i-1][j] = aMatrix[i][j];
			for (int j = column+1; j < aMatrix.length; j++)
				matrixPart[i-1][j-1] = aMatrix[i][j];
		}
		return matrixPart;
	}

	public boolean isSymmetric() {
		return equals(getTransposed());
	}

	public boolean commute(Matrix<Double> M) {
		if (multiply(M).equals(M.multiply(this))) return true;
		return false;
	}

	public CubicDoubleMatrix getInversion() {
		return null;
	}

	public static Matrix<Double> getZero(int dim) {
		double[][] zeroMatrix = new double[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++)
				zeroMatrix[i][j] = 0;
		}
		return new CubicDoubleMatrix(zeroMatrix);
	}
	
	public Matrix<Double> getZero() {
		double[][] zeroMatrix = new double[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				zeroMatrix[i][j] = 0;
		}
		return new CubicDoubleMatrix(zeroMatrix);
	}

	public String toString() {
		String str;
		str = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				str += matrix[i][j] + ", ";
			}
			str += "\n";
		}

		return str;
	}

	public boolean equals(Object other) {
		if (this == other) return true; //not necessary, but fast
		if (other == null) return false;
		if (getClass() != other.getClass()) return false;
		if (!(other instanceof CubicDoubleMatrix)) return false;
		CubicDoubleMatrix otherMatrix = (CubicDoubleMatrix) other;
		if (matrix.length != otherMatrix.matrix.length) return false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != otherMatrix.matrix[i][j]) return false;
			}
		}
		return true;
	}
	
	public int getDimension() {
		return matrix.length;
	}
}
