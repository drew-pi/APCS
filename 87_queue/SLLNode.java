/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class SLLNode<T> {

  private T _cargo;    //cargo may only be of type T
  private SLLNode<T> _nextNode; //pointers to next, prev DLLNodes


  // constructor -- initializes instance vars
  public SLLNode( T value, SLLNode<T> next )
{
_cargo = value;
_nextNode = next;
  }


  //--------------v  ASCCESSORS  v--------------
  public T getCargo() { return _cargo; }

  public SLLNode<T> getNext() { return _nextNode; }

  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public T setCargo( T newCargo ) {
T foo = getCargo();
_cargo = newCargo;
return foo;
  }

  public SLLNode<T> setNext( SLLNode<T> newNext ) {
SLLNode<T> foo = getNext();
_nextNode = newNext;
return foo;
  }

  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
{
//Below is an exercise in creating a linked list...

/*********************
//Create a node
DLLNode<String> first = new DLLNode<String>( "cat", null );

//Create a new node after the first
first.setNext( new DLLNode<String>( "dog", null ) );

//Create a third node after the second
first.getNext().setNext( new DLLNode<String>( "cow", null ) );

DLLNode temp = first;
while( temp != null ) {
    System.out.println( temp );
    temp = temp.getNext();
}
***********************/
  }//end main

}//end class DLLNode
