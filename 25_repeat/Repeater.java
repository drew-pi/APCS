/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 19 -- Do I repeat myself?/Working with loops and recursion/Created two versions of a method that builds a fence, one recursive the other one looping using while loop
2021-10-26
time spent: 30-40min

Discoveries:
Recursion is much cleaner and cooler than while loops.
If you input zero into the recusion method without a non recursive return statement (line 66), then it will throw an error and repeat forever.

Questions:
How can I write my recursive method without a string input?
*/


public class Repeater {

	//Main method
	public static void main( String[] args ) {

		//Loop to test fence loop with different numbers for (int i = 0; i < 5; i++) {
		System.out.println("==============================");
		System.out.println("Testing while loop fence method\n");

		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " + fenceW(i));
		}

		//Testing out recusion method
		System.out.println("\n==============================");
		System.out.println("Testing recusive fence method\n");

		for (int i = 0; i < 10; i++) {
			//resets string after everytime
			String s = "";
			System.out.println(i + ": " + fenceR(i,s));
		}		
	}


	//Creates fence using while loop
	private static String fenceW( int numPosts ) {
		String str = "|";
		int i = 1;

		while (numPosts > i) {
			str = str + "--|";
			i++;
		}

		return str;
	}

	//Creates fences using recursion
	private static String fenceR ( int numPosts, String str ) {
		
		if ( numPosts == 1 ) {
			return str + "|";
		} 
		else if ( numPosts > 1 ) {
			str = str + "|--";
			return fenceR(numPosts-1,str);
		}
		else {
			return str;
		}
	}	
}