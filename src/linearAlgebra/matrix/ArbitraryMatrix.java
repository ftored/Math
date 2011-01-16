package linearAlgebra.matrix;

import linearAlgebra.field.Field;

public class ArbitraryMatrix implements Matrix<Field> {

	public ArbitraryMatrix(Field[][] aMatrix) {
		noRow = aMatrix.length;
		noColumn = aMatrix[0].length;
		for (int i = 0; i < aMatrix.length; i++)
			if (aMatrix[i].length != noColumn)
				throw new IllegalArgumentException();
		
		this.matrix = new Field[noRow][noColumn];
		for (int i = 0; i < noRow; i++) {
			for (int j = 0; j < noColumn; j++)
				this.matrix[i][j] = aMatrix[i][j];
		}	
	}

	public boolean equals(Matrix<Field> m) {
		if (this == m) return true; //not necessary, but fast
		if (m == null) return false;
		if (getClass() != m.getClass()) return false;
		if (!(m instanceof ArbitraryMatrix)) return false;
		ArbitraryMatrix otherMatrix = (ArbitraryMatrix) m;
		if (noRow != otherMatrix.noRow || noColumn != otherMatrix.noColumn) return false;
		for (int i = 0; i < noRow; i++) {
			for (int j = 0; j < noColumn; j++) {
				if (matrix[i][j] != otherMatrix.matrix[i][j]) return false;
			}
		}
		return true;
	}

	public String toString() {
		String str;
		str = "";
		for (int i = 0; i < noRow; i++) {
			for (int j = 0; j < noColumn; j++) {
				str += matrix[i][j].toString();
			}
			str += "\n";
		}
		return str;
	}

	public Matrix<Field> getTransposed() {
		Field[][] transposed = new Field[noColumn][noRow];
		for (int i = 0; i < noRow; i++)
			for (int j = 0; j < noColumn; j++)
				transposed[j][i] = matrix[i][j];
		return new ArbitraryMatrix(transposed);
	}

	public Matrix<Field> add(Matrix<Field> m) {
		if (getClass() != m.getClass() || noRow != m.getDimensions()[0] || noColumn != m.getDimensions()[1])
			throw new IllegalArgumentException();
		Field[][] sum = new Field[matrix.length][matrix.length];
		Field[][] other = ((ArbitraryMatrix) m).matrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				sum[i][j] = matrix[i][j].add(other[i][j]);
		}
		return new ArbitraryMatrix(sum);
	}

	public Matrix<Field> scale(Field s) {
		Field[][] scaled = new Field[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				scaled[i][j] = matrix[i][j].multiply(s);
			}
		}
		return new ArbitraryMatrix(scaled);
	}

	public Matrix<Field> multiply(Matrix<Field> m) {
		if (getClass() != m.getClass() || noColumn != m.getDimensions()[0])
			throw new IllegalArgumentException();
		Field[][] product = new Field[noColumn][m.getDimensions()[0]];
		Field[][] other = ((ArbitraryMatrix) m).matrix;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				product[i][j] = matrix[0][0].zero();
				for (int k = 0; k < matrix.length; k++)
					product[i][j].add(matrix[i][k].multiply(other[k][j]));
			}
		}
		return new ArbitraryMatrix(product);
	}

	public int[] getDimensions() {
		int[] dim = {matrix.length, matrix[0].length};
		return dim;
	}
	
	public ArbitraryMatrix getZero() {
		Field[][] aMatrix = new Field[noRow][noColumn];
		for (int i = 0; i < noRow; i++) {
			for (int j = 0; j < noColumn; j++)
				aMatrix[i][j] = matrix[0][0].zero();
		}
		return new ArbitraryMatrix(aMatrix);
	}
	
	public static ArbitraryMatrix getZero(Field f, int row, int column) {
		Field[][] aMatrix = new Field[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				aMatrix[i][j] = f.zero();
		}
		return new ArbitraryMatrix(aMatrix);
	}
	
	public Field getPos(int row, int column) {
		return matrix[row][column];
	}

	
	private Field[][] matrix;
	private int noRow;
	private int noColumn;
}
