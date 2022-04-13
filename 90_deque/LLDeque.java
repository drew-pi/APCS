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



import java.util.LinkedList;
import java.util.Iterator;

public class LLDeque<T> implements Deque<T> {

    private LinkedList<T> _data;

    public LLDeque() {
        _data = new LinkedList<T>();
    }


    public T dequeueFront() {
        return _data.removeFirst();
    }

    // remove element from the end of the Queue
    // returns element that was removed
    public T dequeueEnd() {
        return _data.removeLast();
    }


    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueueEnd( T x ) {
        _data.addLast(x);
    }

    // add element onto the beginning of the Queue
    public void enqueueFront(T x) {
        _data.addFirst(x);
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
        return _data.isEmpty();
    }

    //Returns the first element of the queue without dequeuing it.
    public T peekFront() {
        return _data.peekFirst();
    }

    // returns the last element of the Queue
    public T peekEnd() {
        return _data.peekLast();
    }

    // returns an iterator over the deque
    public Iterator<T> iterator() {
      return _data.iterator();
    }

    // returns true if the specified value is in the deque
    public boolean contains (T x) {
      return _data.contains(x);
    }

    public String toString() {
        return _data.toString();
    }

    public static void main(String[] args) {

        LLDeque<String> deck = new LLDeque<String>();


        deck.enqueueEnd("cow");
        deck.enqueueEnd("horse");
        deck.enqueueEnd("goat");
        deck.enqueueEnd("string");

        System.out.println(deck);
        System.out.println("contains cow " + deck.contains("cow"));
        System.out.println("contains goose " + deck.contains("goose"));
        System.out.println("contains goat " + deck.contains("goat"));

        deck.enqueueFront("sea horse");
        deck.enqueueFront("butterfly");

        System.out.println(deck);

        System.out.println(deck.peekFront() + " " + deck.dequeueFront());
        System.out.println(deck.peekFront() + " " + deck.dequeueFront());

        System.out.println(deck);


        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());
        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());
        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());

        System.out.println(deck);

    }
}
