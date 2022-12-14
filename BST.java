
public class BST <K extends Comparable<K>, T> implements Map<K, T> {
	BSTNode<K,T> root, current;
	
	public BST() {
		root = current = null;
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return root == null;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T retrieve() {
		// TODO Auto-generated method stub
		return current.data;
	}

	@Override
	public void update(T e) {
		// TODO Auto-generated method stub
		current.data = e;
	}

	@Override
	public Pair<Boolean, Integer> find(K key) {
		BSTNode<K,T> p = root;
		Boolean flag = false;
		Integer x = 0;
		if(empty())
			return new Pair<Boolean, Integer>(flag,x);
			while(p!= null) {
				if(p.key.compareTo(key) == 0) {
					flag = true;
					x++;
					current = p;
					return new Pair<Boolean, Integer>(flag,x);
				}
				else if(key.compareTo(p.key) < 0) {
					p = p.left;
					x++;
				}
				else {
					p = p.right;
					x++;
				}
			}
			return new Pair<Boolean, Integer>(flag,x);
	}

	@Override
	public Pair<Boolean, Integer> insert(K key, T data) {
		BSTNode<K,T> p = root, q = root;
		Boolean flag = false;
		Integer x = 0;
		BSTNode<K,T> a = new BSTNode<K,T>(key, data);
		if(p == null) {
			root = current = a;
			flag = true;
			return new Pair<Boolean, Integer>(flag,x);
		}	
			while(p!= null && (key.compareTo(p.key))!=0) {
				q = p;
				if(key.compareTo(p.key) < 0) {
				p = p.left;
				x++;
	        	}
			else {
				p = p.right;
				x++;
			}
				
			}
			if(p != null) {
				x++;
				return new Pair<Boolean, Integer>(flag,x);
			}
			if(key.compareTo(q.key) < 0) {
				q.left = a;
				flag = true;
				current = a;
				return new Pair<Boolean, Integer>(flag,x);
	        	}
			else {
				q.right = a;
				flag = true;
				current = a;
				return new Pair<Boolean, Integer>(flag,x);
			}
	}

	@Override
	public Pair<Boolean, Integer> remove(K key) {
		BSTNode<K,T> p = root, q = null;
		Boolean flag = false;
		Integer x = 0;
		K k = key;
		while(p != null && (key.compareTo(p.key) != 0)) {
			q = p;
			x++;
		if(key.compareTo(p.key) < 0) 
			p = p.left;
		else
			p = p.right;
		}
		if (p == null)
			return new Pair<Boolean, Integer>(flag,x);
		
			x++; 
			if((p.left != null) && (p.right != null)) {
				BSTNode<K,T> min = p.right;
				q = p;
				while(min.left != null) {
					q = min;
					min = min.left;
				}
				p.key = min.key;
				p.data = min.data;
				k = min.key;
				p = min;
			}
			if(p.left != null)
				p = p.left;
			else
				p = p.right;
			if(q == null)
				root = p;
			else {
				if(k.compareTo(q.key) < 0)
					q.left = p;
				else
					q.right = p;
			}
			current = root;
			return new Pair<Boolean, Integer>(true,x);
	}

	@Override
	public List<K> getAll() {
		List<K> keys = new LinkedList<K>();
		reckey(keys, root);
		return keys;
	}
	private void reckey(List<K>list, BSTNode<K,T> tmp) {
		if(tmp == null)
			return;
		reckey(list, tmp.left);
		list.insert(tmp.key);
		reckey(list, tmp.right);
	}
	
	
	// extra
	public void displayinorder() {
		if (root == null)
			System.out.println("Empty BST");
		else
			displaykeyinorder(root);
		System.out.println();
	}
	private void displaykeyinorder(BSTNode<K,T> p) {
		if(p == null)
			return;
		
		else {
			displaykeyinorder(p.left);
			System.out.print(p.key+" "+p.data+",  ");
			displaykeyinorder(p.right);
		}
	}

}


