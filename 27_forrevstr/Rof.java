/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 27 -- FOR the Love of Strings/Working with loops and recursion/Created fence for loop, and then attempted to create recursive and itterative version
of a reverse method which reverses the order of letters.
2021-10-28
time spent: 50min

Discoveries:
Recursion makes no sense
for loop are a lot cleaner than while loops because counters are built in

Questions:
How do you do reverseR just in general?
*/


public class Rof {
	
	public static String fenceF(int posts) {
		
		String fence = "|";

		for (int i = 1; i < posts; i++) {
			fence += "--|";
		}
		
		return fence;
	}


	public static String reverseF(String s) {

		String newStr = "";

		for (int i = (s.length()); i > 0; i--) {
			newStr += s.substring(i-1,i);
		}

		return newStr;
	}


	public static String reverseR(String s) {

		if (s=="") {
                    return("Please enter non-empty string");
            }

        int len = s.length();

        if (len == 1) { 
        	return s; 
        }

        //System.out.println("1 " + s.substring(len - 1, len));
        //System.out.println("2 " + s.substring(0, len - 1));
        //System.out.println("3 " + s);
        return s.substring(len - 1, len) + reverseR(s.substring(0, len - 1));
	}
	
	
	
	public static void main(String[] args) {

		//Testing fenceF method
		System.out.println(fenceF(1));
		System.out.println(fenceF(2));
		System.out.println(fenceF(3));

		//Testing reverseF method
		System.out.println(reverseF("stressed"));

		//Testing reverseR method
		System.out.println(reverseR("stressed"));
	}
}
