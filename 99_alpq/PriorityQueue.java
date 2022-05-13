/*
Team PinkLemonade:  Jacob Ng, Andrew Piatetsky, Emily Ortiz
APCS pd6
HW99: Some Are More Equal Than Others, Codified
2022-05-13
time spent: _ hrs
*/


public interface PriorityQueue {

  // adds an element to the end of a PriorityQueue
  public void add(int value);

  // returns true if the PriorityQueue is empty
  public boolean isEmpty();

  // removes and returns the smallest/priorty value of the Priority Queue
  public int removeMin();

  // returns but does not return the smallest/priority val of the PriorityQueue
  public int peekMin();
}
