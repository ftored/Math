package linearAlgebra.matrix;


public class DoubleMatrix implements Matrix<Double> {
	
	public DoubleMatrix(double[][] aMatrix) {
		noRow = aMatrix.length;
		noColumn = aMatrix[0].length;
		for (int i = 0; i < aMatrix.length; i++)
			if (aMatrix[i].length != noColumn)
				throw new IllegalArgumentException();
		
		this.matrix = new double[aMatrix.length][aMatrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				this.matrix[i][j] = aMatrix[i][j];
		}
	}

	public String toString() {
		String str;
		str = "";
		for (int i = 0; i < noRow; i++) {
			for (int j = 0; j < noColumn; j++) {
				str += matrix[i][j] + ", ";
			}
			str += "\n";
		}
		return str;
	}

	public Matrix<Double> getTransposed() {
		double[][] transposed = new double[noColumn][noRow];
		for (int i = 0; i < noRow; i++)
			for (int j = 0; j < noColumn; j++)
				transposed[j][i] = matrix[i][j];
		return new DoubleMatrix(transposed);
	}

	public int[] getDimensions() {
		int[] dim = {noRow, noColumn};;
		return dim;
	}

	public Matrix<Double> add(Matrix<Double> m) {
		if (getClass() != m.getClass() || noRow != m.getDimensions()[0] || noColumn != m.getDimensions()[1])
			throw new IllegalArgumentException();
		double[][] sum = new double[matrix.length][matrix.length];
		double[][] other = ((DoubleMatrix) m).matrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				sum[i][j] = matrix[i][j] + other[i][j];
		}
		return new DoubleMatrix(sum);
	}

	public Matrix<Double> scale(Double s) {
		double[][] scaled = new double[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				scaled[i][j] = s * matrix[i][j];
			}
		}
		return new DoubleMatrix(scaled);
	}

	public Matrix<Double> multiply(Matrix<Double> m) {
		if (getClass() != m.getClass() || noColumn != m.getDimensions()[0])
			throw new IllegalArgumentException();
		double[][] product = new double[matrix.length][matrix.length];
		double[][] other = ((DoubleMatrix) m).matrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				double val = 0;
				for (int k = 0; k < matrix.length; k++)
					val += matrix[i][k] * other[k][j];
				product[i][j] = val;
			}
		}
		return new DoubleMatrix(product);
	}
	
	public boolean equals(Object other) {
		if (this == other) return true; //not necessary, but fast
		if (other == null) return false;
		if (getClass() != other.getClass()) return false;
		if (!(other instanceof DoubleMatrix)) return false;
		DoubleMatrix otherMatrix = (DoubleMatrix) other;
		if (noRow != otherMatrix.noRow || noColumn != otherMatrix.noColumn) return false;
		for (int i = 0; i < noRow; i++) {
			for (int j = 0; j < noColumn; j++) {
				if (matrix[i][j] != otherMatrix.matrix[i][j]) return false;
			}
		}
		return true;
	}
	
	public static Matrix<Double> getZero(int row, int column) {
		double[][] zeroMatrix = new double[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				zeroMatrix[i][j] = 0;
		}
		return new CubicDoubleMatrix(zeroMatrix);
	}
	
	public Matrix<Double> getZero() {
		double[][] zeroMatrix = new double[noRow][noColumn];
		for (int i = 0; i < noRow; i++) {
			for (int j = 0; j < noColumn; j++)
				zeroMatrix[i][j] = 0;
		}
		return new CubicDoubleMatrix(zeroMatrix);
	}
	
	public Double getPos(int row, int column) {
		return matrix[row][column];
	}
	
	protected double[][] matrix;
	private int noRow;
	private int noColumn;

}
