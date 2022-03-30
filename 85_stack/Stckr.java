/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    // Stack<Integer> cakes = new ALStack<Integer>();
    Stack<Integer> cakes = new LLStack<Integer>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    for (int i = 0; i < 10; i++) {
        cakes.push(i);
    }

    while (!cakes.isEmpty()) {
        System.out.println(cakes.peekTop());
        System.out.println(cakes.pop());
    }
    //...

  }//end main

}//end class