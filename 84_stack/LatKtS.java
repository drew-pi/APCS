import java.util.Stack;
// JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
// APCS pd6
// HW84: Stack: What Is It Good For?
// 2022-03-29
// time spent:  50 minutes


/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

 /* 
 Q: How do we do allMatched, can't do it. Recursively doesn't make sense because have to get to center first, not end or some other extremity

 allMatched:
 doesn't work for ones where even number, but intertwined "{[}]" would return true
issue with recursion is because no clear base case, like with a base case where two ones next to each other are opposite returns true would not work either because
this would return true "()[)(]" since the first two are next to each other and close each other
 
 */

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes stack = new Latkes(s.length());
    String retStr = "";

    for (int i = 0; i < s.length(); i++) {
        stack.push(s.substring(i, i+1));
    }

    while (!stack.isEmpty()) {
        retStr += stack.pop();
    }

    return retStr;
  }

  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s ) 
  {
    for (int i = 0; i < s.length(); i++) {
      // System.out.println(s.substring(i, i+1));
      // System.out.println(hasMatch(s,s.substring(i, i+1)));
      if (!hasMatch(s,s.substring(i, i+1))) {
        return false;
      }
    }
    return true;

  }

  public static boolean hasMatch (String s, String car) {
    // System.out.println("opp: " + getOpposite(car));
    return (s.indexOf(getOpposite(car)) >= 0);
  } 


  public static String getOpposite( String s) {
    if (s.equals("{")) {
      return "}";
    }
    if (s.equals("}")) {
      return "{";
    }
    if (s.equals("]")) {
      return "[";
    }
    if (s.equals("[")) {
      return "]";
    }
    if (s.equals(")")) {
      return  "(";
    }
    if (s.equals("(")) {
      return ")";
    }
    return "not what expected";
  }


  //main method to test
  public static void main( String[] args )
  {

      
      System.out.println(flip("racecar"));
      System.out.println(allMatched( "({}[()])" )); //true
      System.out.println(allMatched( "([)]" ) ); //false
      System.out.println(allMatched( "(){([])}" ) ); //true
      System.out.println(allMatched( "](){([])}" ) ); //false
      System.out.println(allMatched( "(){([])}(" ) ); //false
      System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class