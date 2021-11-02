/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 29 -- Which Way Do You Roll?/Working with loops and recursion/Created two versions of a method that inserts commas into java integers 
2021-11-2
time spent: 1h30min

Discoveries:
That you can input things from the terminal into the program - very cool for testing (almost like the scanner class in java)
Converting from int to String/ String to int is not automatic in java

Questions:
Which method is better (faster in terms of time, more efficient in terms of computer resources) recursion or iteration?
*/


public class Commafier {

	//Iteration method
	public static String commafyF ( int n ) {

		if ( 1000 > n ) {
			return Integer.toString(n);
		}

		String strNum = Integer.toString(n);
		String commaStr = "";

		int remainder = strNum.length() % 3;

		if ( remainder == 0 ) { commaStr += "100"; }
		else { commaStr += strNum.substring(0,remainder); }

		for (int i = strNum.length(); i > 3; i = i-3) {
			commaStr += "," + strNum.substring(i-3,i);
		}

		return commaStr;
	}

	//Recursion method
	public static String commafyR ( int n ) {

		if ( n < 1000 ) {
			return Integer.toString(n);
		}

		String strNum = Integer.toString(n);
		int len = strNum.length();

		return commafyR(Integer.parseInt(strNum.substring(0,len-3))) + "," + strNum.substring(len-3,len);
	}

	//main method
	public static void main( String[] args ) {

		//To make the for loop work change boolean ("i < 0")
		for (int i = 0; i < 0; i = i + 100) {
			System.out.println(i*10000 + ":");
			System.out.println("For loop: " + commafyF(i*10000));
			System.out.println("Recursion: " + commafyR(i*10000));
		}

		int sInt = 0;

		for ( String s : args ) {
			sInt = Integer.parseInt(s);

			if (commafyR(sInt).equals(commafyF(sInt))) {
				System.out.println(commafyR(sInt));
			}
			else {
				System.out.println("Something went wrong");
			}
		}
	} //end main
	
} // end class