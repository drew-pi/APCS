/*
JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
APCS pd6
HW88: BPC Kiddies Do Not Wait in Line Either
2022-04-4
time spent:  1h 30min

QCC:
How do we shuffle-
decided to swap elements because pretty easy in standard lists, very difficult with singly linked lists
What other ways to shuffle (without swap) and or how do we implement a swap

Other methods are easy when the shuffle method is finished, just how do we do shuffle

Could do a remove sort of swap, but would take much longer and also what if want to swap 0th element

Maybe not meant for shuffling?



DISCO: Singly linked lists are annyoing to manipulate in any complex way (like swapping nodes)
*/



/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/
public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;

  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    _size += 1;
    if (isEmpty()) { _front = _end = new LLNode<SWASHBUCKLE>(enQVal, null); return; }
    
    LLNode<SWASHBUCKLE> n = new LLNode<SWASHBUCKLE>(enQVal, null);
    _end.setNext(n);
    _end = n;

    // determines what the random node to be removed is
    // int whereQ = (int)(Math.random() * (_size-1));

    // _randNode = _front;
    // for (int i = 0; i < whereQ; i++) {
    //     _randNode = _randNode.getNext();
    // }
  }//O(1)


  // remove and return random thing
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    if (isEmpty()) return null;

    SWASHBUCKLE retVal = peekFront();
    _front = _front.getNext();

    return retVal;
    

  }//O(?)


  public SWASHBUCKLE peekFront()
  {
    for (int i = 0; i < 6; i++) {
      sample();
    }

    return _front.getCargo();

  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   < YOUR SUCCINCT SUMMARY HERE >
   **/
  public void sample ()
  { 
    // int lim = _size;
    LLNode<SWASHBUCKLE> tmp1 = null;
    LLNode<SWASHBUCKLE> front1 = null;
    LLNode<SWASHBUCKLE> tmp2 = null;
    LLNode<SWASHBUCKLE> front2 = null;

    LLNode<SWASHBUCKLE> dummy = _front;


    for (int i = 0; i < _size; i++) {

      if ( (i % 2) == 0) {
        if (tmp1 == null) {
          tmp1 = dummy;
          front1 = tmp1;
        } else {
          tmp1.setNext(dummy);
          tmp1 = tmp1.getNext();
        }

      } else if ((i % 2) == 1) {
        if (tmp2 == null) {
          tmp2 = dummy;
          front2 = tmp2;
        } else {
          tmp2.setNext(dummy);
          tmp2 = tmp2.getNext();
        }
      }

      dummy = dummy.getNext();
    }

    tmp1.setNext(null);
    tmp2.setNext(null);

    _front = null;

    // for testing purposes
    // while (front1 != null ) {
    //   System.out.print(front1 + " ");
    //   front1 = front1.getNext();
    // }
    // System.out.println("");
    
    // while (front2 != null ) {
    //   System.out.print(front2 + " ");
    //   front2 = front2.getNext();
    // }
    // System.out.println("");

    // System.out.println(this.toString());

    dummy = null;

    int decider = (int) (Math.random() * 2);

    if (decider == 0) {
      System.out.println(decider);
      _front = front1;
      dummy = _front;
      front1 = front1.getNext();

      while (front1 != null) {
        dummy.setNext(front1);
        front1 = front1.getNext();
        dummy = dummy.getNext();
      }

      while (front2 != null) {
        dummy.setNext(front2);
        front2 = front2.getNext();
        dummy = dummy.getNext();
      }
    }
    else {
      System.out.println(decider);
      _front = front2;
      dummy = _front;
      front2 = front2.getNext();

      while (front2 != null) {
        dummy.setNext(front2);
        front2 = front2.getNext();
        dummy = dummy.getNext();
      }

      while (front1 != null) {
        dummy.setNext(front1);
        front1 = front1.getNext();
        dummy = dummy.getNext();
      }
    }

    _end = dummy;

    // System.out.println(this.toString());
    // System.out.println(_end);

  }//O(n^2)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    LLNode<SWASHBUCKLE> dummy = _front;

    String retStr = "";

    while (dummy != null) {
        retStr += dummy.getCargo() + " "; 
        dummy = dummy.getNext();
    }

    return retStr;

  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

      
      RQueue<String> PirateQueue = new RQueue<String>();
      
      System.out.println("\nnow enqueuing..."); 
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Roberts");
      PirateQueue.enqueue("Blackbeard");
    //   PirateQueue.enqueue("Peter");
    //   PirateQueue.enqueue("Stuyvesant");
      
      System.out.println("\nnow testing toString()..."); 
      System.out.println( PirateQueue ); //for testing toString()...
      
      System.out.println("\nnow dequeuing..."); 
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      
      System.out.println(PirateQueue);
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    System.out.println("\nnow dequeuing fr empty queue...\n" +
    "(expect NPE)\n"); 
    System.out.println( PirateQueue.dequeue() );
    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    // PirateQueue.sample();


  }//end main

}//end class RQueue



// if (_randNode.equals(_end)) {
//     System.out.println("will this happen");
// }

// if (!_randNode.equals(_front)) {
//     SWASHBUCKLE retVal = _randNode.getNext().getCargo();
//     _randNode.setNext(_randNode.getNext().getNext());
// }




// _size -= 1;

// // System.out.println("will this happen?");
// _front = _randNode.getNext();
// retVal = _randNode.getCargo();

// // get new random location
// int whereQ = (int)(Math.random() * (_size-1));

// _randNode = _front;
// for (int i = 0; i < whereQ; i++) {
//     _randNode = _randNode.getNext();
// }

// return retVal;