import java.util.LinkedList;


public class LLQ<T> implements Queue<T> {

  private int _size;
  private LinkedList<T> _data;

  public LLQ() {
    _size = 0;
    _data = new LinkedList<T>();
  }


  public T dequeue() {
    if (isEmpty()) return null;

    _size -= 1;
    return _data.removeFirst();
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( T x ) {
    _data.add(x);
    _size += 1;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty() {
    return _data.isEmpty();
  }

  //Returns the first element of the queue without dequeuing it.
  public T peekFront() {
    return _data.getFirst();
  }

  public String toString() {
    return _data.toString();
  }

}
