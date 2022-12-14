
public class TreeLocator<T> implements Locator<T> {
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
		while(p!= null) {
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
			else{
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
	}
	
	@Override
	public Pair<List<T>, Integer> get(Location loc) {
		List<T> l = new LinkedList<T>();
		Integer x=0;
		TreeLocatorNode<T> p = root;
		while(p != null) {
			if(loc.x == p.l.x && loc.y == p.l.y) {
				x++;
				p.data.findFirst();
				if(p.data.empty())
					return new Pair<List<T>, Integer>(l, x);
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
	}

	@Override
	public Pair<Boolean, Integer> remove(T e, Location loc) {
		TreeLocatorNode<T> p = root;// q = null;
		Boolean flag = false;
		Integer x=0;
		while(p!= null) {
			//q = p;
			if(loc.x == p.l.x && loc.y == p.l.y) {
				x++;
				p.data.findFirst();
				if(p.data.empty())
					return new Pair<Boolean, Integer>(false, x);
				while(!p.data.last()) {
					if(p.data.retrieve().equals(e)) {
						p.data.remove();
						flag = true;
					}else
						p.data.findNext();
				}
				if(p.data.retrieve().equals(e)) {// last data
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
	}

	@Override
	public List<Pair<Location, List<T>>> getAll() {
		
		List<Pair<Location, List<T>>> list = new LinkedList<Pair<Location, List<T>>>();
		 getall2(list, root);
		 return list;
	}
	private void getall2(List<Pair<Location, List<T>>> list, TreeLocatorNode<T> tree) {
		if(tree == null)
			return;
		Pair<Location, List<T>> p = new Pair<Location, List<T>>(tree.l, tree.data);
		list.insert(p);
		getall2(list, tree.first);
		getall2(list, tree.second);
		getall2(list, tree.third);
		getall2(list, tree.fourth);
		
	}

	@Override
	public Pair<List<Pair<Location, List<T>>>, Integer> inRange(Location lowerLeft, Location upperRight) {
		// must be recursive method
		Integer x = 0;
		List<Pair<Location, List<T>>> l = new LinkedList <Pair<Location, List<T>>>();
		if(root == null) {
			return new  Pair<List<Pair<Location, List<T>>>, Integer>(l, x);
		}
		
		LinkedQueue<Integer, TreeLocatorNode<T>> q = new LinkedQueue<Integer, TreeLocatorNode<T>>();
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
	}
}
