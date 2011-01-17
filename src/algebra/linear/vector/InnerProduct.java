package algebra.linear.vector;


public interface InnerProduct<T> extends NormedVector<T> {
	
	T getInnerProduct(InnerProduct<T> v);

}
