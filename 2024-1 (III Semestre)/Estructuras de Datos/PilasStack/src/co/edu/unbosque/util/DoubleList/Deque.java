package co.edu.unbosque.util.DoubleList;

public interface Deque<T> {

	public void insertLast(T info);
	
	public T removeLast();
	
	public void insertFirst(T info);
	
	public T removeFirst();
	
	public int size();
	
}
