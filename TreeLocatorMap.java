
public class TreeLocatorMap<K extends Comparable<K>> implements LocatorMap<K> {
	Map<K, Location> m = new BST<K,Location>();
	Locator<K> lo = new TreeLocator<K>();
	 // data is unique
	 // Location is also unique 51.00
	@Override
	public Map<K, Location> getMap() {
		//Map<K, Location> m = new BST<K,Location>();
		return m;
		/*List<K> l = m.getAll(); // missed of location
		//Locator<K> lo = new TreeLocator<K>();
		l.findFirst();
		while(!l.last()) {
			m.insert(l.retrieve(), lo.getAll().retrieve().first);
			l.findNext();
			lo.getAll().findNext();
		}
		m.insert(l.retrieve(), lo.getAll().retrieve().first);
		return m;*/
		
		// m = (Map<K, Location>) new TreeLocatorMapNode<K>(root, l);
		/*BST<K,K> b = new BST<K,K>();
		K f = (K) b.getAll();
		TreeLocator<K> t = new TreeLocator<K>();
		Location loc = (Location) t.getAll();
		return new Map<K, Location>(f,loc);*
		
		//return m;
		/* Map<K, Location> m;
		 m = (Map<K, Location>) new TreeLocatorMap<K>();
		 K key;
		 Pair<Integer, Integer> p = new Pair <Integer, Integer>(l.x, l.y);
		 BSTNode<K,K> ke;
		 TreeLocatorNode<Location> t = root;*/
		 
		// m.insert(key, l);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Locator<K> getLocator() {
		//Map<K, Location> m = new BST<K,Location>();
		return lo;
		/*List<K> l = m.getAll();
		//Locator<K> lo = new TreeLocator<K>();
		//lo.getAll();
		l.findFirst();
		while(!l.last()) { // Extra location here
			lo.add(l.retrieve(), lo.getAll().retrieve().first);
			l.findNext();
			lo.getAll().findNext();
		}
		lo.add(l.retrieve(), lo.getAll().retrieve().first);
		return lo;*/
		
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Pair<Boolean, Integer> add(K k, Location loc) {
		// TODO Auto-generated method stub
		//Boolean flag = false;
		//Integer x = 0;
		Pair<Boolean, Integer> p = m.find(k);
		Boolean flag = p.first;
		Integer x = p.second;
		if(flag == true) { // key is found
			return new Pair<Boolean, Integer>(false, x);
		}
		else {
			lo.add(k, loc);
			m.insert(k, loc);
			return new Pair<Boolean, Integer>(true, x);
			}
		/*if (lo == null) {
			return new Pair<Boolean, Integer>(flag, x);
			if(lo.get(loc).equals(false))
				return new Pair<Boolean, Integer>(flag, x);
		}*/
		//Pair<K, Integer> p = new Pair<K, Integer>(lo.get(loc).first, lo.get(loc).second);
		//x= lo.get(loc).second; // error
		 //if(lo.get(loc).first.equals(null)) {
			//return new Pair<Boolean, Integer>(flag, x);
		//}
		/*else {
		lo.add(k, loc);
		flag = true;
		}*/
		
	//	return null;
	}

	@Override
	public Pair<Boolean, Integer> move(K k, Location loc) {
		Pair<Boolean, Integer> p = m.find(k);
		Boolean flag = p.first;
		Integer x = p.second;
		if(flag == false) {
			return new Pair<Boolean, Integer>(flag, x);
		}
		else {
			//Map<K, Location> data = m.
			Location l = getLoc(k).first; //  Location l = BST.retrieve();
			m.remove(k);                  //  locator.remove(k, l);
			lo.remove(k, l);              //  BST.update(loc);
			m.insert(k, loc);             //  locator.add(k, loc);    
			lo.add(k, loc);
			return new Pair<Boolean, Integer>(flag, x);
		}
		
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Pair<Location, Integer> getLoc(K k) {
		Pair<Boolean, Integer> p = m.find(k);
		Boolean flag = p.first;
		Integer x = p.second;
		Pair<Location, Integer> pp = new Pair<Location, Integer>(m.retrieve(), x);
		if(flag == true)
				return pp;
		else
			 return new Pair<Location, Integer>(null, x);
		
		/*Boolean flag = false;
		Integer x = 0;
		//Locator<K> lo = new TreeLocator<K>();
		//lo.get(loc);
		//Map<K, K> m = new BST<K,K>();
		m.find(k);
		flag = m.find(k).first;
		x = m.find(k).second;
		if(flag == false) {
			return new Pair<Location, Integer>(null, x);
		}
		else {
			lo.getAll();
			List<Pair<Location, List<K>>> j = (LinkedList<Pair<Location, List<K>>>) lo.getAll();
			j.findFirst();
			while(!j.last()) {
				x++;
				if(j.retrieve().second.equals(k)) {
					return new Pair<Location, Integer>(j.retrieve().first, x);
				}
				j.findNext();
			}
		}*/
		
		/*Pair<Integer, Integer> o = new Pair<Integer, Integer>(l.x, l.y);
		Integer x = 0;
		BST<K,K> b = new BST<K,K>();
		//List<Pair<Location, List<T>>> li = b.getAll().;
		Boolean flag = b.find(k).first;
		BSTNode<K, K> p = b.root, q = b.root;
		if(flag.equals(false)) // error 
			return null;
		while(p!= null && k.compareTo(p.data) != 0) {
			q = p;
			if(k.compareTo(p.data) == -1)
				p = p.left;
			else
				p = p.right;
		}*/
		
		//return new Pair<Location, Integer> ((l.x, l.y), x);
		//Locator<K> lo = new TreeLocator<K>();
		
		//Pair<Location, Integer> p = new Pair<Location, Integer>(o,x);
	//	return new Pair<Location, Integer>(null, x);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Pair<Boolean, Integer> remove(K k) { // Delete from BST And TreeLocator
		Pair<Boolean, Integer> p = m.find(k);
		Boolean flag = p.first;
		Integer x = p.second;
		if(flag == false) {
			return new Pair<Boolean, Integer>(false, x);
		}
		else {
			Location l = getLoc(k).first;
			m.remove(k);
			//Location l = getLoc(k).first;
			lo.remove(k, l);
			return new Pair<Boolean, Integer>(true, x);
			}
		
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public List<K> getAll() {
	//	Map<K, K> m = new BST<K,K>();
		List<K> list = new LinkedList<K>();
		list = m.getAll();
		return list;
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Pair<List<K>, Integer> getInRange(Location lowerLeft, Location upperRight) {
		List<K> l = new LinkedList<K>();
		Pair<List<Pair<Location, List<K>>>, Integer> p = lo.inRange(lowerLeft, upperRight);
		List<Pair<Location, List<K>>> list = p.first;
		Integer x = p.second;
		list.findFirst();
		if(!list.empty()) {
			while(!list.last()) {
				list.retrieve().second.findFirst();
				if(!list.retrieve().second.empty()) {
					while(!list.retrieve().second.last()) {
						l.insert(list.retrieve().second.retrieve());
						list.retrieve().second.findNext();
					}
					l.insert(list.retrieve().second.retrieve());
				}
				list.findNext();
			}
			list.retrieve().second.findFirst();
			if(!list.retrieve().second.empty()) {
				while(!list.retrieve().second.last()) {
					l.insert(list.retrieve().second.retrieve());
					list.retrieve().second.findNext();
				}
				l.insert(list.retrieve().second.retrieve());
			}
		}
		return new Pair<List<K>, Integer> (l, x);
		// TODO Auto-generated method stub
		//return null;
	}
	
	// extra
	/*public void BSTdisplayinorder() {
		m.displayinorder();
	}
	public void Treedisplayinorder() {
		lo.displayinorder();
	}
///////////// add helpping methods to TreeLocatorMap //////////////
	public void display()
	{
	System.out.println("---------all bst in order------");
	m.displayinorder();
 	System.out.println("---------all locations in order------");
	lo.displayinorder();
	}*/
}
