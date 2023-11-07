package main;
import java.util.*;
/**
 * I hereby declare upon my word of honor that I have neither given nor received unauthorized help on this work
 */
public class Item {
private String name;
private String message;
Item(){}
Item(Scanner S){
name = S.nextLine();
	S.nextLine();
message = S.nextLine();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String toString() {
	return name + "\n("+ message +")";
}
}

