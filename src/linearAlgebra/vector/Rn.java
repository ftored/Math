package linearAlgebra.vector;


public class Rn implements InnerProduct {
	private double[] vector;

	public Rn(double[] coordinates) {
		vector = coordinates;
	}

	/**
	 * Contructor without vector.
	 */
	public Rn(int dim) {
		vector = new double[dim];
	}
	
	/**
	 * Makes an exact copy of the variable vector.
	 * 
	 * @return
	 */
	private double[] cloneVector() {
		double[] clone = new double[vector.length];
		for (int i = 0; i < vector.length; i++) {
			clone[i] = vector[i];
		}
		return clone;
	}

	public boolean equals(Vector v) {
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] != ((Rn) v).getCoordinates()[i])
				return false;
		}
		return true;
	}

	public double[] getCoordinates() {
		return cloneVector();
	}

	public double getInnerProduct(InnerProduct v) {
		double[] newVector = cloneVector();
		double innerProduct = 0;
		for (int i = 0; i < vector.length; i++) {
			innerProduct += newVector[i] * ((Rn) v).getCoordinates()[i];
		}
		return innerProduct;
	}

	public Rn getInverse() {
		double[] newVector = cloneVector();
		for (int i = 0; i < vector.length; i++) {
			newVector[i] = -vector[i];
		}
		return new Rn(newVector);
	}

	public double getNorm() {
		return Math.sqrt(getInnerProduct(this));
	}

	public double getScalarProduct(InnerProduct v) {
		return getInnerProduct(v);
	}

	public Rn getScale(double s) {
		double[] newVector = cloneVector();
		for (int i = 0; i < vector.length; i++) {
			newVector[i] *= s;
		}
		return new Rn(newVector);
	}

	public Rn getSum(Vector v) {
		double[] newVector = cloneVector();
		for (int i = 0; i < vector.length; i++) {
			newVector[i] += ((Rn) v).getCoordinates()[i];
		}
		return new Rn(newVector);
	}

	public Rn getZero() {
		double[] zeroVector = new double[vector.length] ;
		for (int i = 0; i < vector.length; i++) {
			zeroVector[i] = 0;
		}
		return new Rn(zeroVector);
	}

	public boolean isLinearIndependent(Vector v) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Check if two vectors are orthogonal
	 */
	public boolean isOrthogonal(InnerProduct v) {
		if (getInnerProduct(v) == getScalarProduct(getZero()))
			return true;
		return false;
	}
	
	public String toString() {
		String str;
		str = "{";
		for (int i = 0; i < vector.length - 1; i++) {
			str += vector[i] + ", ";
		}
		str += vector[vector.length - 1] + "}";
		
		return str;
	}
}
