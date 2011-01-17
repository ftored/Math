package algebra.linear.vector;

public class DoubleVector implements InnerProduct<Double> {
	
	public DoubleVector(double[] vector)
	{
		this.vector = new double[vector.length];
		for (int i = 0; i < vector.length; i++)
			this.vector[i] = vector[i];
	}

	public Vector<Double> getInverse() 
	{
		double[] inv = new double[vector.length];
		for (int i = 0; i < vector.length; i++)
			inv[i] = -1.0 * vector[i];
		return new DoubleVector(inv);
	}

	public Vector<Double> scale(Double s) 
	{
		double[] scaled = new double[vector.length];
		for (int i = 0; i < vector.length; i++)
			scaled[i] = scaled[i] * s;
		return new DoubleVector(scaled);
	}

	public Vector<Double> add(Vector<Double> v) 
	{
		if (v == null || getClass() != v.getClass())
			throw new IllegalArgumentException();
		double[] other = ((DoubleVector) v).vector;
		if (other.length != vector.length)
			throw new IllegalArgumentException();
		double[] sum = new double[vector.length];
		for (int i = 0; i < vector.length; i++)
			sum[i] = vector[i] + other[i];
		return new DoubleVector(sum);
	}
	
	public Vector<Double> subtract(Vector<Double> v) {
		if (v == null || getClass() != v.getClass())
			throw new IllegalArgumentException();
		DoubleVector other = (DoubleVector) v;
		if (other.vector.length != vector.length)
			throw new IllegalArgumentException();
		return add(other.getInverse());
	}

	public Vector<Double> zero() 
	{
		double[] zero = new double[vector.length];
		for (int i = 0; i < vector.length; i++)
			zero[i] = 0;
		return new DoubleVector(zero);
	}

	public boolean isLinearIndependent(Vector<Double> v) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public Double getNorm() 
	{
		return Math.sqrt(getInnerProduct(this));
	}

	/**
	 * Gives the inner product between two vectors. Also called scalar product.
	 * 
	 */
	public Double getInnerProduct(InnerProduct<Double> v) 
	{
		if (!icompatibel(v))
			throw new IllegalArgumentException();
		DoubleVector other = (DoubleVector) v;
		double result = 0;
		for (int i = 0; i < vector.length; i++)
			result += vector[i] * other.vector[i];
		return result;
	}
	
	/**
	 * Check whether two vectors are orthogonal
	 */
	public boolean isOrthogonal(InnerProduct v) {
		if (!icompatibel(v))
			throw new IllegalArgumentException();
		DoubleVector other = (DoubleVector) v;
		if (getInnerProduct(other).equals(getInnerProduct((DoubleVector) zero())))
			return true;
		return false;
	}
	
	public String toString() 
	{
		String str;
		str = "{";
		for (int i = 0; i < vector.length - 1; i++) 
		{
			str += vector[i] + ", ";
		}
		str += vector[vector.length - 1] + "}";
		
		return str;
	}
	
	public static DoubleVector zero(int dim)
	{
		double[] vec = new double[dim];
		for (int i = 0; i < dim; i++)
			vec[i] = 0;
		return new DoubleVector(vec);
	}
	
	private boolean icompatibel(Vector<Double> v)
	{
		if (v == null || getClass() != v.getClass())
			return false;
		DoubleVector other = (DoubleVector) v;
		if (other.vector.length != vector.length)
			return false;
		return true;
	}
	
	private double[] vector;

}
