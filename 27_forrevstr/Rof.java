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


	public static String reverseR(String s, String newStr) {

		String lastChar = s.substring((s.length())-1,(s.length()));

		if (newStr.length() == s.length()) {
			return newStr;
		}
		else {
			System.out.println(newStr);
			System.out.println(s);
			newStr += lastChar;
			s = s.substring(0,(s.length()-1));
			return reverseR(s,newStr);
		}
	}
	
	
	
	public static void main(String[] args) {

		//Testing fenceF method
		System.out.println(fenceF(1));
		System.out.println(fenceF(2));
		System.out.println(fenceF(3));

		//Testing reverseF method
		System.out.println(reverseF("stressed"));

		//Testing reverseR method
		System.out.println(reverseR("stressed",""));
	}
}
