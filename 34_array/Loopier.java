/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW 34 -- A Pirate's Life for Me/Introduction to arrays/Created methods to alter and interact with arrays using recursion and iteration 
2021-11-2
time spent: 1h30min

DISCOVERIES:
The size of an array cannot be changed, I could not find any substring type method for arrays
Behave very similar to Strings. They have a length value, easy to use with loops. 
Very different from Python lists and much more annoying
Recursion with strings is very difficult

QUESTION:
How do you do the frequency recursion method?
Is there any substring functioning method for arrays too?
Are there any other list like data types? (in python we had tuples and dictionaries)
Do arrays with length zero exits (tried to create it and use my arrayToString method and it didn't work)?
*/




public class Loopier {

	// HELPER METHOD - COPIES AN ARRAY TO ANY DESIRED LENGTH SMALLER THAN THE ORIGINAL
	public static int[] copyOfArray(int[] array, int startIndex) {

		int length = array.length;

		if (startIndex == 0) {
			return array;
		} 

		int[] newArray = new int[length-startIndex];

		if (length-startIndex == 1) {
			newArray[0] = array[startIndex];
		}

		int oldI = startIndex;

		for (int i = 0; oldI <= length-startIndex; i++) {
			newArray[i] = array[oldI];
			oldI += 1;
		}

		return newArray;
	}


	// 1 - FILLS EXISTING ARRAY WITH RANDOM VALUES FROM 0 TO 5
	public static int[] randArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random()*5);
		}

		return array;
	}


	// 2 - RETURNS A STRING REPRESENTATION OF AN ARRAY 
	public static String arrayToString(int[] array) {

		String str = "";

		for (int i = 0; i < array.length; i++) {
			str += array[i] + ",";
		}

		return str.substring(0,str.length()-1);
	}


	// 3A - PERFORMS LINEAR SEARCH USING ITERATION ON AN ARRAY 
	public static int linSearch( int[] array, int target ) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}


	// 3B - PERFORMS LINEAR SEARCH USING RECURSION ON AN ARRAY 
	public static int linSearchR( int[] array, int target ) {

		if (array.length-1 < 0) {
			return -1;
		}
		else if (array[0] == target) {
			return 0;
		} 
		int[] newArray = copyOfArray(array,1);
		return 1 + linSearchR(newArray,target);
	}


	// 4A - USES ITERATION TO FIND FREQUENCY OF SOME INTEGER TARGET
	public static int freq( int[] array, int target ) {

		int freq = 0;

		for (int num : array) {
			if (num == target) {
				freq += 1;
			}
		}
		return freq;
	}

	// 4B - USES RECURSION TO FIND FREQUENCY OF AN INTEGER TARGET
	public static int freqRec( int[] array, int target ) {
		
		int[] newArray = copyOfArray(array,1);

		if (newArray.length == 1) {
			if (newArray[0] == target) {
				return 1;
			}
			return 0;
		}
		if (linSearch(array,target) == -1) {
			return 0;
		}
		if (array[0] == target) {
			return 1 + freqRec(newArray,target);
		}
		return freqRec(newArray,target);
	}




	public static void main(String[] args) {

		int[] testArray = {1,9,2,3,4,5,5,4,9};
		//int[] testArray = {};

		//System.out.println(copyOfArray(testArray,1));
		System.out.println(arrayToString(testArray));
		System.out.println(arrayToString(copyOfArray(testArray,testArray.length-1))); // should return 2,3,4,5,5,4,9}
		
		System.out.println("========================");
		int[] randArray = randArray(new int[5]);
		//System.out.println(randArray); //prints out memory location, useless for now
		System.out.println(arrayToString(randArray)); //prints out random array's values

		System.out.println("========================");
		System.out.println(linSearch(testArray,3)); //returns 3
		System.out.println(linSearch(testArray,1));// returns 0
		System.out.println(linSearch(testArray,9)); //returns 1

		System.out.println("========================");
		System.out.println(linSearchR(testArray,3)); //returns 3
		System.out.println(linSearchR(testArray,1));// returns 0
		System.out.println(linSearchR(testArray,9)); //returns 1

		System.out.println("========================");
		System.out.println(freq(testArray,5)); // returns 2
		System.out.println(freq(testArray,4)); // returns 2
		System.out.println(freq(testArray,1)); // returns 1
		System.out.println(freq(testArray,10)); // returns 0

		System.out.println("========================");
		System.out.println(freqRec(testArray,9)); // returns 2
		System.out.println(freqRec(testArray,4)); // returns 2
		System.out.println(freqRec(testArray,1)); // returns 1
		System.out.println(freqRec(testArray,10)); // returns 0





	} // end main
} // end class Loopier