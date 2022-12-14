
public class TreeLocator<T> implements Locator<T> {
//	private Location L;
	public TreeLocatorNode<T> root, current;
	@Override
	public int add(T e, Location loc) {
		int i=0;
		LinkedList<T> list = new LinkedList<T>();
		list.insert(e);
		TreeLocatorNode <T> a = new TreeLocatorNode<T>(list, loc);
		TreeLocatorNode <T> p =root, q = root;
		
		if(p == null) {
			root = current = a;
			//i++;
			return i;
		}
		while(p!= null /*&& loc.x != p.l.x && loc.y != p.l.y*/) {
			q = p;
			if(loc.x == p.l.x && loc.y == p.l.y) {
				p.data.insert(e);
				i++;
				return i;
			}
			else if(loc.x < p.l.x && loc.y <= p.l.y) {
				p = p.first;
				i++;
			}
			else if(loc.x <= p.l.x && loc.y > p.l.y) {
				p = p.second;
				i++;
			}
			else if(loc.x > p.l.x && loc.y >= p.l.y) {
				p = p.third;
				i++;
			}
			else /*if(loc.x >= p.l.x && loc.y < p.l.y)*/{
				p = p.fourth;
				i++;
			}
				
		}
		if(loc.x < q.l.x && loc.y <= q.l.y) {
			q.first = a;
			return i;
		}
		else if(loc.x <= q.l.x && loc.y > q.l.y) {
			q.second = a;
			return i;
		}
		else if(loc.x > q.l.x && loc.y >= q.l.y) {
			q.third = a;
			return i;
		}
		else {
			q.fourth = a;
			return i;
		}
	
		// TODO Auto-generated method stub
		//return i;
	}
	
	@Override
	public Pair<List<T>, Integer> get(Location loc) {
		List<T> l = new LinkedList<T>();
		Integer x=0;
		TreeLocatorNode<T> p = root;
		/*if(root == null) {
			return new Pair <List<T>, Integer> (l, x);
		}*/
		while(p != null) {
			if(loc.x == p.l.x && loc.y == p.l.y) {
				x++;
				p.data.findFirst();
				if(p.data.empty())
					return new Pair<List<T>, Integer>(l, x);
			//	p.data.findFirst();
				while(!p.data.last()) {
					l.insert(p.data.retrieve());
					p.data.findNext();
				}
				l.insert(p.data.retrieve());
				return new Pair<List<T>, Integer>(l, x);
			}
			else if(loc.x < p.l.x && loc.y <= p.l.y) {
					p = p.first;
					x++;
				}
				else if(loc.x <= p.l.x && loc.y > p.l.y) {
					p = p.second;
					x++;
				}
				else if(loc.x > p.l.x && loc.y >= p.l.y) {
					p = p.third;
					x++;
				}
				else {
					p = p.fourth;
					x++;
				}
		}
		return new Pair<List<T>, Integer>(l, x);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Pair<Boolean, Integer> remove(T e, Location loc) {
		TreeLocatorNode<T> p = root;// q = null;
		Boolean flag = false;
		Integer x=0;
	//	Pair<Boolean, Integer> p = new Pair<Boolean, Integer>(flag, x);
		/*if(root == null) {
			return new Pair <Boolean, Integer>(found, count);
		}*/
		while(p!= null) {
			//q = p;
			if(loc.x == p.l.x && loc.y == p.l.y) {
				x++;
				p.data.findFirst();
				//if(p.data.retrieve() == null)
				if(p.data.empty())
					return new Pair<Boolean, Integer>(false, x);
				while(!p.data.last()) {
					if(p.data.retrieve().equals(e)) {
						//p.data.update(null);
						p.data.remove();
						//return new Pair<Boolean, Integer>(true, x);
						flag = true;
					}else
						p.data.findNext();
				}
				if(p.data.retrieve().equals(e)) {// last data
					//p.data.update(null);
					p.data.remove();
					flag = true;
					return new Pair<Boolean, Integer>(true, x);
					}
				else if(flag == true)
					return new Pair<Boolean, Integer>(true, x);
				else
					return new Pair<Boolean, Integer>(false, x);
			}
				else if(loc.x < p.l.x && loc.y <= p.l.y) {
					p = p.first;
					x++;
				}
				else if(loc.x <= p.l.x && loc.y > p.l.y) {
					p = p.second;
					x++;
				}
				else if(loc.x > p.l.x && loc.y >= p.l.y) {
					p = p.third;
					x++;
				}
				else {
					p = p.fourth;
					x++;
				}
		}
			return new Pair<Boolean, Integer>(false, x); // because p == null and the location is does not exist
			
		/*while(p != null && loc.x != p.l.x && loc.y != p.l.y) {
			q = p;
			//x++;
			if(loc.x < p.l.x && loc.y <= p.l.y) {
			//	q.first = p;
				p = p.first;
				x++;
			}
			else if(loc.x <= p.l.x && loc.y > p.l.y) {
				//q.second = p;
				p = p.second;
				x++;
			}
			else if(loc.x > p.l.x && loc.y >= p.l.y) {
				//q.third = p;
				p = p.third;
				x++;
			}
			else {
			//	q.fourth = p;
				p = p.fourth;
				x++;
			}
		}
		if(p == null)
			return new Pair<Boolean, Integer>(flag, x);
		flag = true;
		if(loc.x == p.l.x && loc.y == p.l.y) {
			p.data.findFirst();
			while(!p.data.last()) {
				if(p.data.retrieve().equals(e)) {
					p.data = null; // p.data.next = p.data.next.next;
					flag = true;
					return new Pair<Boolean, Integer>(flag, x); // maybe not deleted all occurrences
				}
			//	p.data = null;
				p.data.findNext();
			}
			if(p.data.retrieve().equals(e)) { // last node
				p.data = null; // p.data.next = p.data.next.next;
			//	p.data.update(null);
				flag = true;
				return new Pair<Boolean, Integer>(flag, x);
			}
			else
				return new Pair<Boolean, Integer>(false, x);
		}
		return new Pair<Boolean, Integer>(flag, x);*/
		/*if(p.first != null && p.second != null && p.third != null && p.fourth != null) {
			TreeLocatorNode<T> min = p.first;
			q = p;
			while(min.first != null) {
				q = min;
				min = min.first;
				x++;
			}
			p.data = min.data;
			p = min;
		}
		if(p.first != null)
			p = p.first;
		else if(p.second != null)
			p = p.second;
		else if(p.third != null)
			p = p.third;
		else
			p = p.fourth;
		if ( q == null)
			root = p;
		return new Pair<Boolean, Integer>(flag, x);*/
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public List<Pair<Location, List<T>>> getAll() {
		
		List<Pair<Location, List<T>>> list = new LinkedList<Pair<Location, List<T>>>();
		 getall2(list, root);
		 return list;
		// TODO Auto-generated method stub
	//	return null;
	}
	private void getall2(List<Pair<Location, List<T>>> list, TreeLocatorNode<T> tree) {
		if(tree == null)
			return;
		//List<T> tmp2 = new LinkedList<T>();
		//tmp2 = tree.data;
		// T d = tree.data;
		//List<T> tmp = new LinkedList<T>();
		//tmp.insert(tmp2.retrieve());
		// tmp.insert(d);
		//Pair<U,V> f = new Pair<U,V>(L.x, L.y);
		//Pair<Location, List<T>> p = new Pair<Location, List<T>>(tree.l, tmp);
		Pair<Location, List<T>> p = new Pair<Location, List<T>>(tree.l, tree.data);
		list.insert(p);
		getall2(list, tree.first);
		/*List<T> l = new LinkedList<T>();
		tree.data.findFirst();*/
		//Pair<Location, List<T>> p = new Pair<Location, List<T>>(tree.l, tree.data);
		/*if(tree.data.empty()) {
		//	list.insert(p);
			return;
		}*/
		/*if(!tree.data.empty()) {
			while(!tree.data.last()) {
				l.insert(tree.data.retrieve());
				tree.data.findNext();
			}
			l.insert(tree.data.retrieve());
		}*/
		//Pair<Location, List<T>> p = new Pair<Location, List<T>>(tree.l, tree.data);
		// OR
	/*	Pair<Location, List<T>> p = new Pair<Location, List<T>>(tree.l, tree.data);
		list.insert(p);*/
		getall2(list, tree.second);
		getall2(list, tree.third);
		getall2(list, tree.fourth);
		
	}

	@Override
	public Pair<List<Pair<Location, List<T>>>, Integer> inRange(Location lowerLeft, Location upperRight) {
		// must be recursive method
		/*Integer x = 0;
		List<Pair<Location, List<T>>> l = new LinkedList <Pair<Location, List<T>>>();
		Pair<List<Pair<Location, List<T>>>, Integer> pa = new
				 Pair<List<Pair<Location, List<T>>>, Integer>(l, x);
		recRange(l, root, lowerLeft, upperRight, pa);
		 return pa;*/
		
		Integer x = 0;
		List<Pair<Location, List<T>>> l = new LinkedList <Pair<Location, List<T>>>();
		if(root == null) {
			return new  Pair<List<Pair<Location, List<T>>>, Integer>(l, x);
		}
		
		LinkedQueue<Integer, TreeLocatorNode<T>> q = new LinkedQueue<Integer, TreeLocatorNode<T>>();
		//LinkedQueue <Pair<Integer, TreeLocatorNode<T>>> q = new LinkedQueue <Pair<Integer, TreeLocatorNode<T>>>();
		TreeLocatorNode<T> p = root;
		
		while(p != null) {
			x++;
			if(p.l.x >= lowerLeft.x && p.l.x <= upperRight.x 
					&& p.l.y >= lowerLeft.y && p.l.y <= upperRight.y) {
				Pair<Location, List<T>> pa = new Pair <Location, List<T>>(p.l, p.data);
				l.insert(pa);
			}
			 if(p.fourth != null && p.l.x <= upperRight.x && p.l.y > lowerLeft.y) {
				q.enqueue(p.fourth);
			 }
			 if(p.third != null && p.l.x < upperRight.x && p.l.y <= upperRight.y) {
					q.enqueue(p.third);
			 }
			 if(p.second != null && p.l.x >= lowerLeft.x && p.l.y < upperRight.y) {
					q.enqueue(p.second);
			 }
			 if(p.first != null && p.l.x > lowerLeft.x && p.l.y >= lowerLeft.y) {
					q.enqueue(p.first);
			 }
			if(q != null)
			 p = q.serve();
		}
		return new Pair<List<Pair<Location, List<T>>>, Integer>(l, x);
		// TODO Auto-generated method stub
		//return null;
	}
	
	// extra
	/*	public void displayinorder() {
			if (root == null)
				System.out.println("Empty Locator");
			else
				displaykeyinorder(root);
			System.out.println();
		}
		private void displaykeyinorder(TreeLocatorNode<T> p) {
			if(p == null)
				return;
			
			else {
				displaykeyinorder(p.first);
				System.out.print(" "+p.l);
				p.data.findFirst();
				if(p.data.empty()) {
					System.out.print("");
				}
				else {
					while(!p.data.last()) {
						System.out.print(p.data.retrieve()+", ");
						p.data.findNext();
					}
					System.out.print(p.data.retrieve());
				}
				displaykeyinorder(p.second);
				displaykeyinorder(p.third);
				displaykeyinorder(p.fourth);
			}
		}*/
	
}
