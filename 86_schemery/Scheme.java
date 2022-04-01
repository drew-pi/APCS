import java.util.ArrayList;
/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. This algo runs recursively so it evaluates one peren at a time
 *   3. First it finds the first closed peren and evaluated is through the use of a helper method 
 *   4. It evaluates the expression until there are no more operation signs left (excludes negative signs from that)
 *   5. Profit!
 *
 * STACK OF CHOICE: ArrayList by us? 
 * b/c can access and remove any index in constant time
 **/

public class Scheme
{
  private static final String[] OPERANDS = {"+","*","-","/"};
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] arr = expr.split(" ");

    // System.out.println("expr: " + expr);

    // System.out.println("arr");
    // for (String s : arr) System.out.print(s + " ");
    // System.out.println("arr");

    
    // if (!containsOp(expr)) return expr.substring(2, expr.length()-2);
    if (!containsOp(expr)) {
      if (expr.contains("(")) {
        return arr[1];
        // return expr.substring(2, expr.length()-2);
      }
      return arr[0];
    }
    int i = 0;
    while (!arr[i].equals(")")) {
      // System.out.println(arr[i]);
      i++;
    }

    ALStack<String> stack = new ALStack<String>();

    int j = i-1;
    while (!arr[j].equals("(")) {
      stack.push(arr[j]);
      j--;
    }
    
    String str = "";

    for (int z = 0; z < j; z++) {
      str += arr[z] + " ";
    }

    str += evalStack(stack);

    for (int z = i+1; z < arr.length; z++ ) {
      str += " " + arr[z];
    }

    return evaluate(str);
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    return "hello";
  }//end unload()


  // HELPER METHODS 

  public static int evalStack ( ALStack<String> expr) {

    String operand = expr.pop();
    // System.out.println("operand: " + operand);
    int opIndex = -1; 

    for (int i = 0; i < 4; i++) {
      if (operand.equals(OPERANDS[i])) {
        opIndex = i;
      }
    }

    // System.out.println("index: " + opIndex);

    ArrayList<Integer> evalArr = new ArrayList<Integer>();
    while (!expr.isEmpty()) {
      if (isNumber(expr.peekTop())) {
        evalArr.add(Integer.parseInt(expr.pop()));
      }
      else {
        System.out.println("not a numb for some reason");
      }
    }

    // System.out.println("eavlArr: " + evalArr);

    int retInt = 0;

    if (opIndex == 0) {
      for (int num : evalArr) {
        retInt += num;
      }
    }
    if (opIndex == 1) {
      retInt = 1;
      for (int num : evalArr) {
        retInt *= num;
      }
    }
    if (opIndex == 2) {
      retInt = evalArr.get(0);
      for (int i = 1; i < evalArr.size(); i++) {
        retInt -= evalArr.get(i);
      }
    }
    if (opIndex == 3) {
      retInt = 1;
      for (int num : evalArr) {
        retInt /= num;
      }
    }
    
    return retInt;
  }

  public static boolean containsOp ( String exp ) {
    
    int contains = 0;
    for (String s : OPERANDS) {
      if (exp.contains(s + " ")) {
        contains += 1;
      }
    }

    if (contains > 0) {
      return true;
    }
    return false;
  }
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
    Integer.parseInt(s);
    return true;
    }
    catch( NumberFormatException e ) {
    return false;
    }
  }
  


  //main method for testing
  public static void main( String[] args )
  {

    // System.out.println(evaluate("( + 4 ( * 2 5 ) 3 )"));
    // System.out.println(evaluate("( 5 )"));

    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
    //...7
    
    String zoo2 = "( + 4 ( * 2 5 ) 3 )";
    System.out.println(zoo2);
    System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
    //...17
    
    String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
    System.out.println(zoo3);
    System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
    //...29
    
    String zoo4 = "( - 1 2 3 )";
    System.out.println(zoo4);
    System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
    //...-4
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
