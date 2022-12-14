
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
	
	/*public BSTNode(K k, T val, BSTNode<K,T> l, BSTNode<K,T> r, Location loc) {
		this.key = k;
		this.data = val;
		this.left = l;
		this.right = r;
		this.l = loc;
	}*/
}
