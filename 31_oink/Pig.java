/***
 * TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay/String manipulation and iteration and recursion/Created a pig latin translator.
 * 2021-11-03
 * time spent: 20min
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) {
    
    for (int index = 0; index < w.length(); index ++) {
      if (w.substring(index,index+1).equals(letter)) {
        return true;
      }
    }
    return false;

  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) {
    
    if (hasA(VOWELS,letter)) {
      return true;
    }
    return false;

  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) {

    int numVowels = 0;

    for (int index = 0; index < w.length(); index ++) {
      if (isAVowel(w.substring(index,index+1))) {
        numVowels += 1;
      }
    }

    return numVowels;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) {

    if (countVowels(w) > 0) {
      return true;
    }
    return false;

  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) {
    
    String strVowels = "";

    for (int index = 0; index < w.length(); index ++) {
      if (isAVowel(w.substring(index,index+1))) {
        strVowels += w.substring(index,index+1);
      } 
    }

    return strVowels;

  }


  public static void main( String[] args ) {

    for (String s : args ) {
      //System.out.println(hasA("cat","s"));
      //System.out.println(isAVowel(s));
      //System.out.println(countVowels(s));
      //System.out.println(hasAVowel(s));
      System.out.println(allVowels(s));
    }
  
  }//end main()




}//end class Pig