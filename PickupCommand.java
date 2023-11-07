package main;

public class PickupCommand implements UserInputCommand {
String ItemName;
/**
 * 
 * @param ItemName sets the name of the Item
 */
PickupCommand(String ItemName){
 this.ItemName = ItemName;	
}
/**
 * @param ts The TourStatus for the command to be used on 
 */
public String carryOut(TourStatus ts){
	//ensures the item exists before trying to pick it up
	if(ts.getCurLocation().getItemNamed(ItemName) != null) {
		//picks up the item
		ts.addToBackpack(ts.getCurLocation().getItemNamed(ItemName));
		//shows the current list of items in the backpack
		return ts.listItemsInBackpack();
	}
	//returns a error msg
	return "failed to pick up the Item named " + ItemName + " at " + ts.getCurLocation().getName();
}
}
