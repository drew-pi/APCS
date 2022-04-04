// JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
// APCS pd6
// HW87: The English Do Not Wait In Line for Soup
// 2022-04-2
// time spent:  30min


/*
DISCO:

very simplpe data type, don't need to do any complicatd stuff with inserting and removing, just need to change
where _head and _tail point
*/



// class NodeQueue - creates a collection of nodes that follows the FIFO (First in first out) order
public class NodeQueue<QUASAR> implements Queue<QUASAR>{

  SLLNode<QUASAR> _head,_tail;
  int _size;

  public NodeQueue() {
    _head = _tail = null;
    _size = 0;
  }

  public QUASAR dequeue() {
    if (isEmpty()) return null;

    _size = _size - 1;
    SLLNode<QUASAR> retNode = _head;
    _head = _head.getNext();
    return retNode.getCargo();


  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ) {
    if (isEmpty()) {
      _head = _tail = new SLLNode<QUASAR>(x, null);
     _size += 1;
      return;
    }

    _size += 1;
    SLLNode<QUASAR> sl = new SLLNode<QUASAR>(x,null);
    _tail.setNext(sl);
    _tail = sl;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty() {
    return _size == 0;
  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront() {
    return _head.getCargo();
  }


  public String toString() {
    SLLNode<QUASAR> dummy = _head;

    Object[] arr = new Object[_size];

    int i = 0;
    while (dummy != null) {
      arr[i] = dummy.getCargo();
      dummy = dummy.getNext();
      i += 1;
    }

    String retStr = "";
    for (Object o : arr) retStr += (QUASAR) o + " ";

    return retStr;

  }


  public static void main(String[] args) {

    NodeQueue<String> nq = new NodeQueue<String>();

    nq.enqueue("hello");
    nq.enqueue("goat");
    nq.enqueue("cow");
    nq.enqueue("moose");


    System.out.println(nq);

    System.out.println(nq.peekFront());

    System.out.println(nq.dequeue());

    System.out.println(nq);
    // nq.toString();
  }
}
