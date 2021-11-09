/***
 * TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay/String manipulation and iteration and recursion/Created a pig latin translator.
 * 2021-11-03
 * time spent: 20min
 *
 *
 * Discoveries:
 * Taking a problem step by step is easier than solving everything at once.
 * Creating methods to traverse a string becomes easier with practice
 * Substring kind of allows us to turn each string into a list of letters
 *
 * Questions:
 *
 * class Pig
 * a Pig Latin translator
 ***/

public class Pig
{
  private static final String VOWELS = "aeiou";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
  private static final String PUNC = "!.?;:";



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


  public static boolean beginsWithV ( String w ) {

    return isAVowel(w.substring(0,1));

  }


  public static int indexOfV ( String w ) {

    if ( hasAVowel(w) ) {
      for (int index = 0; index < w.length(); index ++) {
        if (isAVowel(w.substring(index,index+1))) {
          return index;
        }
      }
    }
    return -1;
  }




  //Capital letter improvements
  public static boolean isACap( String letter ) {

    if (hasA(CAPS,letter)) {
      return true;
    }
    return false;

  }


  public static boolean hasACap ( String w ) {

    if ( indexOfCap(w) != -1 ) {
      return true;
    }
    return false;
  }


  public static int indexOfCap ( String w ) {

    for (int index = 0; index < w.length(); index ++) {
        if (isACap(w.substring(index,index+1))) {
          return index;
        }
    }

    return -1;
  }

  public static int indexOflower ( String letter , String allLower ) {

    for (int index = 0; index < allLower.length(); index ++) {
        if ((allLower.substring(index,index+1).equals(letter))) {
          return index;
        }
    }
    return -1;
  }

  public static String findUpper (int capIndex, String allUpper) {

    for (int index = 0; index < allUpper.length(); index ++) {
        if (capIndex == index) {
          return allUpper.substring(index,index+1);
        }
    }
    return null;
  }


  public static boolean isALetter ( String chara ) {

    if (hasA(CAPS,chara) || hasA(LOWER,chara)) {
      return true;
    }
    return false;
  }

  public static int indexOfPunc ( String w ) {

    for (int index = 0; index < w.length(); index ++) {
        if (!(isALetter(w.substring(index,index+1)))) {
          return index;
        }
    }
    return -1;
  }

  //Translator
  public static String engToPig( String w ) {

    String pig = "";

    if ( beginsWithV(w) ) {
      pig = w + "way";
    }

    int vPos = indexOfV(w);
    if (vPos != -1) { pig = w.substring(vPos) + w.substring(0,vPos) + "ay"; }
    else {pig = w + "ay"; }

    if (hasACap(w)) {
      String capLetter = findUpper(indexOflower((pig.substring(0,1)),LOWER),CAPS);
      pig = capLetter + (pig.substring(1)).toLowerCase();
    }

    if ( hasPunc(w) ) {
      String punc = w.substring(indexOfPunc);
      pig = 
    }

    return pig;



  }


  public static void main( String[] args ) {

    for (String s : args ) {
      //System.out.println(hasA("cat","s"));
      //System.out.println(isAVowel(s));
      //System.out.println(countVowels(s));
      //System.out.println(hasAVowel(s));
      //System.out.println(indexOfV(s));
      System.out.println(engToPig(s));
      //System.out.println(hasACap(s));
    }



  }//end main()




}//end class Pig
