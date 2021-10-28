/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 26 -- GCD Three Ways/Working with loops and recursion/Created 3 version of a method that finds the gcd of two numbers
2021-10-27
time spent: 40min

Discoveries:
Recursion is much cleaner and cooler than while loops.
Recursion usually doesn't fare so well with zeros (last hw 0s made it throw errors/fits)

Questions:
Is there a right way to do it (recursion or looping)
*/


public class Stats {

	public static void main( String[] args ) {

		//Testing out brute force loop method
		System.out.println("========= LOOP METHOD ========");
		System.out.println("6: " + gcd(18,24));
		System.out.println("5: " + gcd(100,245));
		System.out.println("4: " + gcd(12,16));
		System.out.println("3: " + gcd(6,15));
		System.out.println("3: " + gcd(15,9));
		System.out.println("5: " + gcd(5,0));

		//Testing out recursive method
		System.out.println("========= RECURSIVE METHOD ========");
		System.out.println("6: " + gcdER(18,24));
		System.out.println("5: " + gcdER(100,245));
		System.out.println("4: " + gcdER(12,16));
		System.out.println("3: " + gcdER(6,15));
		System.out.println("3: " + gcdER(15,9));
		System.out.println("5: " + gcdER(5,0)); //Stack overflow error if one of inputs is zero

		//Testing out Iterative method that doesn't brute force
		System.out.println("========= BETTER LOOP METHOD ========");
		System.out.println("6: " + gcdEW(18,24));
		System.out.println("5: " + gcdEW(100,245));
		System.out.println("4: " + gcdEW(12,16));
		System.out.println("3: " + gcdEW(6,15));
		System.out.println("3: " + gcdEW(15,9));
		System.out.println("5: " + gcdEW(5,0));
	}

	//Brute force using loops and starting with 1 
	public static int gcd( int a, int b ) {
		int i = 1,greater,gcd = 0;

		if ( a == b ) {
			return a;
		}

		if ( a > b ) {
			greater = a;
		}
		else {
			greater = b;
		}

		while (greater >= i) {
			if (( (a % i) == 0 ) && (( (b % i) == 0 ))) {
				gcd = i;
			}
			i ++;
		}
		
		return gcd;
	}



	//Recursive version
	public static int gcdER( int a, int b ) {
		//Base Case
		if (a == b) {
			return a;
		}
		//Checking to see if any inputs are zero
		else if ((a == 0) || (b == 0)) {
			return a - b;
		}
		//Recursion
		else {
			if (a > b) {
				return gcdER( a-b,b );
			}
			else {
				return gcdER( a,b-a );
			}
		}
	}



	//Iterative one that doesn't brute force
	public static int gcdEW( int a, int b ) {
		//Check to see if equal first
		if ( a == b ) {
			return a;
		}

		int i,difference,greater;

		//Finding difference to GCD law on, and also finding which one is greater/smaller
		if ( a > b ) {
			greater = a;
			difference = a - b; 
		}
		else {
			greater = b;
			difference = b - a;
		}

		i = difference;

		//Loops through until both can be divided by counter (i), starts from difference and subtracts down
		while ( i >= 1) {
			if (( (difference % i) == 0 ) && (( (greater % i) == 0 ))) {
				return i;
			}
			i --;
		}

		//Return statement never gets called, just allows method to run because thinks missing return statement
		return 0;
	}
}