// JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
// APCS pd6
// HW83: Stacks on Stacks
// 2022-03-28
// time spent:  20 minutes


/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
    DISCO:
    Stacks have a fixed capacity, or do they? thus the O(n)

    QCC:
    why do we need a size, aren't the stacks recursively defined (also since we can't access values without removing the val infront of them)

 **/


public class Latkes
{
  private String [] _stack;
  private int _stackSize;


  //constructor
  public Latkes( int initCapacity )
  {
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(1)


  //means of insertion
  public void push( String s )
  {
    _stack[_stack.length - _stackSize - 1] = s;
    _stackSize +=1;
  }// O(1)


  //means of removal
  public String pop( )
  { 
    if (isEmpty()) {
        return null;
    }
    String retVal = _stack[_stack.length - _stackSize];
    _stack[_stack.length - _stackSize] = null;

    _stackSize -= 1;

    return retVal;

  }// O(1)


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }// O(1)


  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == _stack.length;
  }// O(1)


  //main method for testing
  public static void main( String[] args )
  {
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v*/

    Latkes tastyStack = new Latkes(12);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");  
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
      /*^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes