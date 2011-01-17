package algebra.linear.vector;

/**
 * 
 * @author Rasmus Ladekjær Pedersen
 * Arbitrary vector spaces
 *
 */

public interface Vector<T> {
	
	/**
	 * Return the inverse element
	 */
	Vector<T> getInverse();
	
	/**
	 * Multiplies a vector with a scalar
	 */
	Vector<T> scale(T s);
	
	/**
	 * Returns the sum of two vectors
	 */
	Vector<T> add(Vector<T> v);
	
	/**
	 * Return the difference of two vectors
	 * 
	 */
	Vector<T> subtract(Vector<T> v);
	
	/**
	 * Return the zero element
	 */
	Vector<T> zero();
	
	/**
	 * Check if two vectors are linear independent
	 */
	boolean isLinearIndependent(Vector<T> v);
	
}
