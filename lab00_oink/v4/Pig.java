/***
 * TNPG: Pigs Can Fly (Perry Huang, Salaj Rijal, Faiyaz Rafee, Andrew Piatetsky) and Burnt Peanut
 * APCS
 * Lab00 -- Etterbay Odingcay Oughthray Ollaborationcay/String manipulation and iteration and recursion/Create a pig latin translator.
 * 2021-11-09
 * time spent: 40min
 *
 *
 * Discoveries:
 * Taking a problem step by step is easier than solving everything at once.
 * Creating methods to traverse a string becomes easier with practice
 * Substring kind of allows us to turn each string into a list of letters
 *
 * Questions:
 * 
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




  /** ==================================
   * 
   * Methods that resolve vowel related issues
   * 
   ================================== **/ 

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

  //Returns true if the sentence begins with a vowel
  public static boolean beginsWithV ( String w ) {

    return isAVowel(w.substring(0,1));

  }

  //Finds index of first vowel (Linear search)
  public static int indexOfV ( String w ) {

    for (int index = 0; index < w.length(); index ++) {
      if (isAVowel(w.substring(index,index+1))) {
        return index;
      }
    }

    return -1;
  }




  /** ==================================
   * 
   * Functions which provide functionality when working with capital letters in translator
   *
    ==================================**/

  //Checks to see if the letter is a capital letter by using CAPS string initialized at the top of code
  public static boolean isACap( String letter ) { 

    if (hasA(CAPS,letter)) {
      return true;
    }
    return false;

  }


  // Checks to see if first letter is capital and returns true if it is
  public static boolean firstCap ( String w ) {

    if ( indexOfCap(w) == 0 ) {
      return true;
    }
    return false;
  }


  //Returns index of capital letter, if none then returns -1
  public static int indexOfCap ( String w ) {

    for (int index = 0; index < w.length(); index ++) {
        if (isACap(w.substring(index,index+1))) {
          return index;
        }
    }

    return -1;
  }

  //Finds the index of the letter based on the alphabet at the top of code (LOWER String variable)
  public static int indexOflower ( String letter ) {

    for (int index = 0; index < LOWER.length(); index ++) {
        if ((LOWER.substring(index,index+1).equals(letter))) {
          return index;
        }
    }
    return -1;
  }

  //Finds the index of the uppercase letter based on the alphabeta at the top of code (CAPS String variable)
  public static String findUpper ( int capIndex ) {

    for (int index = 0; index < CAPS.length(); index ++) {
        if (capIndex == index) {
          return CAPS.substring(index,index+1);
        }
    }
    return null;
  }


  /** ==================================
   * 
   * Methods useful in translating phrases with punctuation
   * 
   * ==================================**/

  //Returns true if the String inputed is a letter (capital or lowercase)
  public static boolean isALetter ( String chara ) {

    if (hasA(CAPS,chara) || hasA(LOWER,chara)) {
      return true;
    }
    return false;
  }

  //Returns index of Punctuation mark, -1 means that it doesn't exist
  public static int indexOfPunc ( String w ) {

    for (int index = 0; index < w.length(); index ++) {
        if (!(isALetter(w.substring(index,index+1)))) {
          return index;
        }
    }
    return -1;
  }

  /** ==================================
   * 
   * Methods for identifying and modifying strings based on spaces
   * 
     ==================================**/

  //returns true is the string inputed (letter) is a space
  public static boolean isASpace ( String space ) {

     if (space.equals(" ")) {
      return true;
     }
     return false;
  }

  //Returns index of the next space and -1 if no more spaces
  public static int indexOfSpace ( String w ) {

    for (int index = 0; index < w.length(); index ++) {
        if (isASpace(w.substring(index,index+1))) {
          return index;
        }
    }
    return -1;

  }







  /** ==================================
   * 
   * Translator methods for actually going from English to Pig Latin
   * 
   * ==================================**/

  public static String wordToPig( String w ) {

    String pig = "";
    String punct = "";
  

    if ( indexOfPunc(w) != -1 ) {
      punct = w.substring(w.length()-1);
      w = w.substring(0,w.length()-1);
    }

    if ( beginsWithV(w) ) {
      pig = w + "way";
    }

    int vPos = indexOfV(w);
    if (vPos != -1) { pig = w.substring(vPos) + w.substring(0,vPos) + "ay"; }
    else {pig = w + "ay"; }



    if (firstCap(w)) {
      String capLetter = findUpper(indexOflower((pig.substring(0,1)))); //Turns first letter of pig string into an uppercase letter and stores in variable
      pig = capLetter + (pig.substring(1)).toLowerCase(); //Adds capital first letter to 
    }

    return pig + punct;
  } //end wordToPig



  // Can be used to translate sentences, wordToPig does actual singular words
  public static String engToPig( String w ) {

    if (indexOfSpace(w) == -1) { //If no space means a one word so can miss the loop
      return wordToPig(w);
    }

    String pig = "";
    int spaceIndex = 0;

    while (indexOfSpace(w) != -1) {
      spaceIndex = indexOfSpace(w); //Index of the next space
      pig += wordToPig(w.substring(0,spaceIndex)) + " ";
      w = w.substring(spaceIndex+1); //Cuts original string everytime
    }

    pig += wordToPig(w);//Adds the ending because no more spaces (last word added at the end)

    return pig;
  } //ehnd engToPig


  public static void main( String[] args ) {

    String sentence = "";

    for (String s : args ) {
      //System.out.println(engToPig(s));
      sentence += " " + s;
    }

    sentence = sentence.substring(1);
    System.out.println(sentence);
    System.out.println(engToPig(sentence));



  }//end main()

}//end class Pig
