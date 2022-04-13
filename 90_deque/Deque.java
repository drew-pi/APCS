/*
JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
APCS pd6
HW90: Deque the Halls
2022-04-13
time spent:  20min
QCC:
What are Queue's and Deque's used for, stacks are used to control the flow of operations in programming languages for example,
what are Queue's useful for?

What other methods are we missing?
  - like remove or descendingIterator?



DISCO: Using a linked list was so easy. Just use already built in functionality. And I know how LinkedLists work so I know the run
time for everything and understand how everything works.

When we first started using LinkedLists I didn't realize what they could be useful for, but now I sort of understand. Can use them to
create other data types and not actually store information important to use (like an list of needed information like passwords or words)
    - like the conventional list I mean
*/




import java.util.Iterator;
/***
 * interface Deque
 * JAB VERSION OF DEQUE - V2
 * - added iterator() and contains(T x)
 * (Local version, to override built-in Java implementation.)
 **/

public interface Deque<T> {


  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public T dequeueFront();

  // remove element from the end of the Queue
  // returns element that was removed
  public T dequeueEnd();

  // add element onto the beginning of the Queue
  public void enqueueFront(T x);

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueueEnd( T x );

  //Returns the first element of the queue without dequeuing it.
  public T peekFront();

  // returns the last element of the Queue
  public T peekEnd();

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty();

  // returns an iterator over the deque
  public Iterator<T> iterator();

  // returns true if the specified value is in the deque
  public boolean contains( T x );


} // end interface Deque
