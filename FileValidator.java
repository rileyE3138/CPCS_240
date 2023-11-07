/**
 * @deprecated  Is now handled while setting up the campus with setUpCampus in TourUMW 
 * instead of a separate System just for ensuring the text file has the correct formatting
 */
package main;
/**
 * I hereby declare upon my word of honor that I have neither given nor received unauthorized help on this work
 */
import java.util.Scanner;

@Deprecated
public class FileValidator {
/**
 * 
 * @param CampusReader the Scanner containing the data file
 * @return returns true for proper formating for false if something is wrong with the data file
 */
@Deprecated
public static Boolean validateFile(Scanner CampusReader) {
	//if we hit the end of the file before we finish processing it, it means the formatting is wrong
	try {
	//used to help with the parsing of the file
	Boolean FirstTime = false;
	/*
	 * before continuing checks if a name is located in the first line
	 *  the first like should not equal ***** since that means the name is missing from the file
	 */
    String i = CampusReader.nextLine();
    if(i == null || i == "*****") { return false; }
    
    //checking if there is ***** separating the name from the locations 
    i = CampusReader.nextLine();
    if(!i.equals("*****")){ return false; }
    
    //checks if the identity line is there
    i = CampusReader.nextLine();
    if (!i.equals("Locations:")) { return false; }
    
   /* 
    * we will now go through and check if each location has the minimum of 2 lines 1 for name, and at least 1 for the description
    * we want to continue through till ***** is found since ***** dictates the end of the locations
    * it is also okay if it exits if the end of the file is found, since that means the file has an error, and we do not
    * want to be stuck in the while loop
    */
   while (!i.equals("*****")){
	/* 
	 * we only want to run it the first time, 
	 * since after that we also want to  also check if it is the end of the location list
	 * we only care if there is at least 1 location
	 */ 
	   if(FirstTime) {
		   i = CampusReader.nextLine();
	      //no longer the first time, meaning we no longer want to progress to the next line here
	       FirstTime = false;
	   }
	   /*
	    * checks if the name line is either of the reserved phrases,
		*  if thats the case we want to return false
		*/
        if(i.equals("*****") || i.equals("+++")) {System.out.println(i + "1"); return false; }
       
        //checks if there is at least 1 line for the description
        i = CampusReader.nextLine();
        if(i.equals("*****") || i.equals("+++")) {System.out.println(i + "2"); return false;}
        
        //goes through the description till the end phrase +++ is found.
        while(!i.equals("+++")) {

        	//goes to the next line before checking the condition for the while loop
        	i = CampusReader.nextLine();
        	
        	//prevent us from being stuck in a infinite loop
        	if(!CampusReader.hasNextLine()) {return false;}
        }
        
        /*
         *  goes to the next line before checking the condition for the while loop
         *  if the while loop exits because i is = to ***** it means the end of locations have 
         *  been found
         */
        i = CampusReader.nextLine();
        
        //prevents us from being stuck in a infinite loop
        if(!CampusReader.hasNextLine()) {return false;}
        }
   
  //now we check if the Door tag phrase is  there.
  i = CampusReader.nextLine();
  if(!i.equals("Doors:")) { return false; }
 
  //the data for each door should be exactly 3 lines separated by a +++
  FirstTime = false;
  //we now want to read through the file till the end, since
  //doors is the last piece of information inside it
  while(CampusReader.hasNextLine()) {
		 i = CampusReader.nextLine();
	   /*
	    * if we arrived at the end of the file without returning false, that means the file is acceptable
	    * we are also okay if this triggers before the door check, since a campus with 1 location 
	    * and 0 doors is still acceptable.
	    */
	  if(i.equals("*****")) {return true;}
	  
	  /*
	   * reads through direction, and the arrival location
	   * the departing location would be the line that may be the end of file indicator 
	   */
	  for(int x = 0 ;x < 2; x++ ) {
		  i = CampusReader.nextLine();
		 if(x == 0) {
			 //checks that the directional is correct
			 if(!(i.equals("n") || i.equals("e") || i.equals("s") || i.equals("w"))) {
				return false; 
			 }
		 }
	  }
	  
	  //checks if the +++ separating locations is there.
	  i = CampusReader.nextLine();
	  if(!i.equals("+++")) {return false;}
	  }
	}
	catch(Exception e) {
		//if an exception occurs, it means the file was not in the correct formatting
		return false;
	}
//if it does not hit true, before the file ends, that means the formatting is false
return false;
} 


}