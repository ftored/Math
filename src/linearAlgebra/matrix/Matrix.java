package linearAlgebra.matrix;

public interface Matrix<T> {
	
//	<ArrayList>linearAlgebra.vector.Vector getColumnVectors();
//	<ArrayList>linearAlgebra.vector.Vector getRowVectors();
	Matrix<T> getTransposed();
	int[] getDimensions();
	T getPos(int row, int column);
	
	// Operations
	Matrix<T> add(Matrix<T> m);
	Matrix<T> scale(T s);
	Matrix<T> multiply(Matrix<T> m);
}
