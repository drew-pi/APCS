/*
JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
APCS pd6
HW90: Swabbing the Deque
2022-04-12
time spent:  20min
QCC:
What are Queue's and Deque's used for, stacks are used to control the flow of operations in programming languages for example, 
what are Queue's useful for?



DISCO: Using a linked list was so easy. Just use already built in functionality. And I know how LinkedLists work so I know the run
time for everything and understand how everything works.

When we first started using LinkedLists I didn't realize what they could be useful for, but now I sort of understand. Can use them to
create other data types and not actually store information important to use (like an list of needed information like passwords or words)
    - like the conventional list I mean
*/



import java.util.LinkedList;

public class LLDeque<T> implements Deque<T> {
    
    private LinkedList<T> _data;

    public LLDeque() {
        _data = new LinkedList<T>();
    }


    public T dequeue() {
        return _data.removeFirst();
    }

    // remove element from the end of the Queue
    // returns element that was removed
    public T dequeueEnd() {
        return _data.removeLast();
    }


    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( T x ) {
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

    public String toString() {
        return _data.toString();
    }

    public static void main(String[] args) {
        
        LLDeque<String> deck = new LLDeque<String>();


        deck.enqueue("cow");
        deck.enqueue("horse");
        deck.enqueue("goat");
        deck.enqueue("string");

        System.out.println(deck);

        deck.enqueueFront("sea horse");
        deck.enqueueFront("butterfly");

        System.out.println(deck);

        System.out.println(deck.peekFront() + " " + deck.dequeue());
        System.out.println(deck.peekFront() + " " + deck.dequeue());

        System.out.println(deck);


        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());
        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());
        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());

        System.out.println(deck);

    }
}
