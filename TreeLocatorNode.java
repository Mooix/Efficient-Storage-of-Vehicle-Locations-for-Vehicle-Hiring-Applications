
public class TreeLocatorNode<T> {
	public TreeLocatorNode<T> first, second, third, fourth;
	//List<T> data = new LinkedList<T>();
	LinkedList<T> data;
	Location l;
	//public T locx;
	//public T locy;
	public TreeLocatorNode(LinkedList<T> data, Location l) {
		this.data = data;
		this.l = l;
		first = second = third = fourth = null;
	}
	public TreeLocatorNode(TreeLocatorNode<T> first, TreeLocatorNode<T> second, TreeLocatorNode<T> third,
			TreeLocatorNode<T> fourth, LinkedList<T> data/*, T locx, T locy*/) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.data = data;
		//this.locx = locx;
		//this.locy = locy;
	}
}
