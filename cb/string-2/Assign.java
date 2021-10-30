public class Assign {

	//doubleChar
	public static String doubleChar(String str) {
  
  		String newStr = "";
  
  		for (int i = 0; str.length() > i; i ++) {
  	  
    			String letter = str.substring(i,i+1);
    			newStr +=  letter + letter;
    		}	
  
  		return newStr;
	}
	
	
	//countHi - Return the number of times that the string "hi" appears anywhere in the given string.
	public static int countHi(String str) {
  
  	int numHi = 0;
  
  	for (int i = 1; str.length() > i; i++) {
    	
    	//System.out.println(str.substring(i-1,i+1));

   		if (str.substring(i-1,i+1).equals ("hi")) {
      			numHi += 1;
    		} 
  	}
  
  	return numHi;
	}


	//catDog - Return true if the string "cat" and "dog" appear the same number of times in the given string.
	public static boolean catDog(String str) {
  
  		int numCats = 0;
  		int numDogs = 0;
  
  		for (int i = 3; str.length() >= i; i++) {

  			//System.out.println(str.substring(0,str.length()));
  			//System.out.println(str.length()-1);
  			//System.out.println(str.substring(i-3,i));
    
    		if (str.substring(i-3,i).equals("cat")) {
      		numCats ++;
    		}
    		else if (str.substring(i-3,i).equals("dog")) {
      			numDogs ++;
    		}
  		}
  
 		if (numCats == numDogs) {
    		return true;
  		}
  		else {
    		return false;
  		}
  	}



  	//countCode - Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
  	public static int countCode(String str) {
  
  		int numCode = 0;
  
  		for (int i = 4; str.length() >= i; i++) {
    
    		String subStr = str.substring(i-4,i);
    		//System.out.println(subStr);
    
    		String letter1 = subStr.substring(0,1);
    		String letter2 = subStr.substring(1,2);
    		String letter4 = subStr.substring(3,4);
    		//System.out.println(letter1 + letter2 + " " + letter4);
    
    		if ( (letter1.equals("c")) && (letter2.equals("o")) && (letter4.equals("e")) ) {
      			numCode ++;
    		}
  		}
  
  		return numCode;
	}



	//endOther - Given two strings, return true if either of the strings appears at the very end of the other string
	//ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
	public static boolean endOther(String a, String b) {
  
  		String longer;
  		String shorter;
  
  		if ( a.length() > b.length() ) {
    		longer = a.toLowerCase();
    		shorter = b.toLowerCase();
  		}
  		else {
    		longer = b.toLowerCase();
    		shorter = a.toLowerCase();
  		}
  	
  		String longEnd = longer.substring(longer.length()-shorter.length(),longer.length());
  		//System.out.println(longEnd);
  
  		if (longEnd.equals(shorter)) {
    		return true;
  		}
  		else {
    		return false;
  		}
	}


	//xyzThere - Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
	public static boolean xyzThere(String str) {

		if ((str.length() >=3) && ((str.substring(0,3)).equals("xyz"))) {
			return true;
		}
	    
	  	for (int i = 4; str.length() >= i; i++) {
	    
	    	String subStr = str.substring(i-4,i);
	    	//System.out.println(subStr);
	    
	    	String letter1 = subStr.substring(0,1);
	    	String letter2 = subStr.substring(1,2);
	    	String letter3 = subStr.substring(2,3);
	    	String letter4 = subStr.substring(3,4);
	    	//System.out.println(letter1 + letter2 + letter3 + letter4);
	    
	    	if (((letter2+letter3+letter4).equals("xyz"))) {
	      		if (letter1.equals(".")) {
	      		}
	      		else {
	      		  return true;
	      		}
	    	}
	    	// else if ((letter1+letter2+letter3).equals("xyz")) {
	    	// 	return true;
	    	// }
	  	}
	  	return false;
	}

	
	public static void main (String[] args) {
		//Testing countHi
		System.out.println(countHi("abc hi ho"));

		//Testing catDog
		catDog("catcat");
		/*catDog("catxxdogxxxdog");
		catDog("catxdogxdogxca");
		catDog("dogdogcat");
		catDog("dog");*/

		//Testing countCode
		//System.out.println(countCode("aaacodebbb"));

		//Testing endOther
		//System.out.println(endOther("AbC", "HiaBc"));
		//System.out.println(endOther("Z", "12xz"));

		//Testing xyzThere
		System.out.println(xyzThere("xyz"));
		System.out.println(xyzThere("xyz.abc"));
		System.out.println(xyzThere("1.xyz.xyz2.xyz"));

	}
	
}	
	
	
	
