package algebra.linear.field;

public interface Field {
	
	/**
	 * Adds a number to this
	 * @param f	a Field
	 * @return the sum of this element and f
	 */
	Field add(Field f);
	
	/**
	 * Subtract a number from this
	 * @param f
	 * @return the difference this minus f
	 */
	Field subtract(Field f);
	Field multiply(Field f);
	Field divide(Field f);
//	Field power(Field f);
//	Field root(Field f);

	// Inverses
	Field opposite();
	Field reciprocal();

	// Neutralelements
	/**
	 * 
	 * @return the additive neutral element
	 */
	Field zero();
	
	/**
	 * 
	 * @return the multiplicative neutral element
	 */
	Field one();
}
