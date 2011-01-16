package linearAlgebra.vector;

/**
 * 
 * @author Rasmus Ladekjær Pedersen
 * Arbitrary vector spaces
 *
 */

public interface Vector {
	
	/**
	 * Check if two vectors are identical.
	 */
	boolean equals(Vector v);
	
	/**
	 * Return the inverse element
	 */
	Vector getInverse();
	
	/**
	 * Multiplies a vector with a scalar
	 */
	Vector getScale(double s);
	
	/**
	 * Returns the sum of two vectors
	 */
	Vector getSum(Vector v);
	
	/**
	 * Return the zero element
	 */
	Vector getZero();
	
	/**
	 * Check if two vectors are linear independent
	 */
	boolean isLinearIndependent(Vector v);
	
	String toString();
	
	
}
