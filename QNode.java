
public class QNode<K extends Comparable<K>, T> {
	public T data;
	public QNode<K, T> next;
	public QNode<K, T> prev;

	public QNode() {
		this.data = null;
		this.next = null;
		this.prev = null;
	}
	
	public QNode (T val) {
		this.data = val;
		this.next = null;
		this.prev = null;
	}

	// Getters and Setters
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public QNode<K, T> getNext() {
		return next;
	}

	public void setNext(QNode<K, T> next) {
		this.next = next;
	}
	
	public QNode<K, T> getPrev() {
		return prev;
	}

	public void setPrev(QNode<K, T> prev) {
		this.prev = prev;
	}
	
}
