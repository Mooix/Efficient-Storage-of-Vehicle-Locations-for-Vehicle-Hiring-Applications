
public class TreeLocatorMap<K extends Comparable<K>> implements LocatorMap<K> {
	Map<K, Location> m = new BST<K,Location>();
	Locator<K> lo = new TreeLocator<K>();
	@Override
	public Map<K, Location> getMap() {
		return m;
	}

	@Override
	public Locator<K> getLocator() {
		return lo;
	}

	@Override
	public Pair<Boolean, Integer> add(K k, Location loc) {
		// TODO Auto-generated method stub
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
			Location l = getLoc(k).first; //  Location l = BST.retrieve();
			m.remove(k);                  //  locator.remove(k, l);
			lo.remove(k, l);              //  BST.update(loc);
			m.insert(k, loc);             //  locator.add(k, loc);    
			lo.add(k, loc);
			return new Pair<Boolean, Integer>(flag, x);
		}
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
			lo.remove(k, l);
			return new Pair<Boolean, Integer>(true, x);
			}
	}

	@Override
	public List<K> getAll() {
		List<K> list = new LinkedList<K>();
		list = m.getAll();
		return list;
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
