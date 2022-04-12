import java.util.ArrayList;

public class ALQ<T> implements Queue<T> {

  private int _size;
  private ArrayList<T> _data;

  public ALQ() {
    _size = 0;
    _data = new ArrayList<T>();
  }

  public T dequeue() {
    if (isEmpty()) {
      return null;
    }
    _size -= 1;
    return _data.remove(0);
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
    if (isEmpty()) return null;
    return _data.get(0);
  }

  public String toString() {
    return _data.toString();
  }
}
