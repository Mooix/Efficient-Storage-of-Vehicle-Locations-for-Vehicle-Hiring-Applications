
public class BSTNode<K extends Comparable<K>, T>{ // <K extends Comparable<K>, T>
	public K key;
	public T data;
	public BSTNode<K,T> left, right;
	Location l;
	public BSTNode(K k, T val) {
		key = k;
		data = val;
		left = right = null;
	}
}
