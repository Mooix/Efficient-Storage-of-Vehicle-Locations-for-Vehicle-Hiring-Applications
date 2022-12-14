
public class VehicleHiringManager {
	LocatorMap<String> locator;
	public VehicleHiringManager() {
		this.locator = new TreeLocatorMap<String>();
	}

	// Returns the locator map.
	public LocatorMap<String> getLocatorMap() {
		//LocatorMap<String> lo = new TreeLocatorMap<String>();
		locator.getMap();
		return locator;
		//return null;
	}

	// Sets the locator map.
	public void setLocatorMap(LocatorMap<String> locatorMap) {
		this.locator = locatorMap;
	}

	// Inserts the vehicle id at location loc if it does not exist and returns true.
	// If id already exists, the method returns false.
	public boolean addVehicle(String id, Location loc) {
		//LocatorMap<String> lo = new TreeLocatorMap<String>();
		//lo.add(id, loc);
		boolean flag;
		flag = locator.add(id, loc).first;
		return flag;
	}

	// Moves the vehicle id to location loc if id exists and returns true. If id not
	// exist, the method returns false.
	public boolean moveVehicle(String id, Location loc) {
	//	LocatorMap<String> lo = new TreeLocatorMap<String>();
		boolean flag;
		flag = locator.move(id, loc).first;
		return flag;
	}

	// Removes the vehicle id if it exists and returns true. If id does not exist,
	// the method returns false.
	public boolean removeVehicle(String id) {
		//LocatorMap<String> lo = new TreeLocatorMap<String>();
		boolean flag;
		flag = locator.remove(id).first;
		return flag;
	}

	// Returns the location of vehicle id if it exists, null otherwise.
	public Location getVehicleLoc(String id) {
		//LocatorMap<String> lo = new TreeLocatorMap<String>();
		//boolean flag;
		//flag =
		Location l = locator.getLoc(id).first;
		if(l == null)
		return null;
		else
			return l;
	}

	// Returns all vehicles located within a square of side 2*r centered at loc
	// (inclusive of the boundaries).
	public List<String> getVehiclesInRange(Location loc, int r) {
		Location left = new Location(loc.x-r, loc.y-r);
		Location right = new Location(loc.x+r, loc.y+r);
		Pair<List<String>, Integer> p = locator.getInRange(left, right);
		List<String> list = p.first;
		return list;
		//return null;
	}
}
