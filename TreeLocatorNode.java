
public class TreeLocatorNode<T> {
	public TreeLocatorNode<T> first, second, third, fourth;
	LinkedList<T> data;
	Location l;
	public TreeLocatorNode(LinkedList<T> data, Location l) {
		this.data = data;
		this.l = l;
		first = second = third = fourth = null;
	}
	public TreeLocatorNode(TreeLocatorNode<T> first, TreeLocatorNode<T> second, TreeLocatorNode<T> third,
			TreeLocatorNode<T> fourth, LinkedList<T> data) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.data = data;
	}
}
