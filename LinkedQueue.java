
public class LinkedQueue <K extends Comparable<K>, T>{
	private QNode<K, T> head;
	private QNode<K, T> tail;
	private int size;
	
	public LinkedQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean full() {
		return false;
	}
	
	public int length() {
		return size;
	}
	
	public void enqueue(T e) {
		QNode<K, T> newElem = new QNode<K, T>(e);
		if(tail == null) 
			head = tail = newElem;
		else {
			newElem.prev = tail;
			tail.next = newElem;
			tail = tail.next;
		}
		size++;
	}
	
	public T serve () {
		if(size == 0)
			return null;
		T x = tail.data;
		if(tail.prev != null) {
		tail.prev.next = null;
		}
		tail = tail.prev;
		size--;
		if(size == 0)
			tail = null;
		return x;
	}
	
}
