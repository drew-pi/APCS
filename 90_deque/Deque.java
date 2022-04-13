/***
 * interface Deque
 * Own version - names are our own as well
 * (Local version, to override built-in Java implementation.)
 **/

public interface Deque<T> extends Queue<T> {

    // add element onto the beginning of the Queue
    public void enqueueFront(T x);

    // remove element from the end of the Queue
    // returns element that was removed
    public T dequeueEnd();

    // returns the last element of the Queue
    public T peekEnd();

} // end interface Deque