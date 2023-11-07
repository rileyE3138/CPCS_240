package main;

public class BackpackCommand implements UserInputCommand {
//default constructor no parameters are needed for the backpack
BackpackCommand(){}
/**
 * @param ts The TourStatus for the command to be used on 
 */
	public String carryOut(TourStatus v) {
		//shows all items in the backpack
		return v.listItemsInBackpack();
	}

}
