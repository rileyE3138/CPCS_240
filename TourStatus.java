package main;

import java.util.ArrayList;

public class TourStatus {
	private Campus campus;
	//used for holding the current location of the tour
	private Location CurLocation = new Location();
	//default constructor
	private ArrayList<Item> backpack = new ArrayList<Item>();
	public TourStatus() {}
	/**
	 * 
	 * @param campus the campus for the tour
	 */
	public TourStatus(Campus campus) {
		this.campus = campus;	
		CurLocation = campus.getStartingLoc();
	}
	/**
	 * @param campus sets the campus data up
	 */
	public void setCampus(Campus campus) {
			this.campus = campus;
	}
	/**
	 * @returns returns the current version of the campus
	 */
	public Campus getCampus() {
		return campus;
	}
	/**
	 * @param Curlocation sets the current location
	 */
	public void setCurLocation(Location CurLocation) {
		this.CurLocation = CurLocation;
	}
	/**
	 * @return returns the current location
	 */
	public Location getCurLocation() {
		return CurLocation;
	}
	/**
	 * @param CurLocation selects which location you want information about
	 * @return returns the information for that location, that is needed for the tour.
	 */
	public String getInfo(Location CurLocation) {
		String info = "";
		info += CurLocation.getName();
		//only shows description if the first time it's been visited
		if(CurLocation.getFirstTime()) {
			info += CurLocation.getDesc();
			CurLocation.setFirstTime(false);
		}
		//shows doors and then the Items
		info += CurLocation.getDoors();
		info += CurLocation.getItemsInLocation();
		return info;
	}
	/**
	 * 
	 * @param item the item you would like to add to the backpack
	 */
	public void addToBackpack(Item item) {
		backpack.add(item);
	}
	/**
	 * 
	 * @param item used to tell which item to removed 
	 */
	public void removeFromBackpack(Item item) {
		//scans through backpack
		for(int x = 0; x < backpack.size(); x++) {
			//checks if the item is the one we want removed
			if(item.getName().equals(backpack.get(x).getName())) {
				//remove the desired item
				backpack.remove(x);
				//forces for loop to close
				x = backpack.size();
			}
		}
	}
	/** 
	 * @param moves the the first item found with that name in the CurLocation to the backpack
	 */
	public Item pickUpItemFromLocation(String name) {
		return CurLocation.getItemNamed(name);
	}
	/** 
	 * @param moves the the first item found with that name in the CurLocation to the backpack
	 */
	public Item DropItemFromBackpack(String name) {
		//looks through backpack
		for(int x = 0; x < backpack.size(); x++) {
			//checks if it exists
			if(backpack.get(x).getName().equals(name)) {
				return backpack.get(x);
			}
		}
		//returns null if no item by that name exists in the backpack
		return null;
	}
	/**
	 * @return returns a String containing all items in the backpack
	 */
	public String listItemsInBackpack() {
		String toString = "BackPackItems are";
		//gathers all items in the backpack into one string
		for(int x = 0; x < backpack.size(); x++) {
			toString += "\n" + backpack.get(x).toString();
		}
		return toString;		
	}
	/**
	 * @param direction changes the current location based off of what direction is given
	 */
	public void UpdateTourLocation(char dir) { 
			//if bad dir, or bad file is given, then we want to alert the user to the problem
		if(!(CurLocation.getArrivalLocation("" + dir) == null))
			CurLocation = CurLocation.getArrivalLocation("" + dir);	
	}
}
