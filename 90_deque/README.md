todo list

0. Create the interface to know which methods to add
1. First add all instance variables (use a linked list called data)
2. then add all necessary/fundamental methods
  - enqueueFront(), enqueueEnd(), dequeueFront(), dequeueEnd()
3. then add other methods that we used in Queue peekFront() and peekEnd()
4. then add other methods inherited from the collection interface such as isEmpty() and size()


At the end decided not to implement size(), but created an isEmpty() method because just extended our old Queue interface. 

Also renamed enqueueFront() and dequeueEnd() to just enqueue() and dequeue() because already defined in our old Queue interface

Will use a LinkedList to hold the deque
