/*
Team PinkLemonade:  Jacob Ng, Andrew Piatetsky, Emily Ortiz
APCS pd6
HW99: Some Are More Equal Than Others, Codified
2022-05-13
time spent: _ hrs
*/



import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

  // array list will in decreasing order
  private ArrayList<Integer> _data;

  public ArrayPriorityQueue() {
    _data = new ArrayList<Integer>();
  }

  // adds an element to the end of a PriorityQueue
  // Min: O(1) Max: O(n)
  public void add(int value) {
    if (isEmpty()) {
      _data.add(value);
      return;
    }

    for (int i = 0;i < _data.size();i++) {
      if (_data.get(i) < value) {
        _data.add(i,value);
        return;
      }
    }
    _data.add(value);
  }

  // returns true if the PriorityQueue is empty
  // O(1)
  public boolean isEmpty() {
    return _data.size() == 0;
  }

  // removes and returns the smallest/priorty value of the Priority Queue
  // O(1)
  public int removeMin() {
    return _data.remove(_data.size()-1);
  }

  // returns but does not return the smallest/priority val of the PriorityQueue
  // O(1)
  public int peekMin() {
    return _data.get(_data.size()-1);
  }

  public String toString() {
    return _data.toString();
  }


  public static void main(String[] args) {

    ArrayPriorityQueue apq = new ArrayPriorityQueue();

    System.out.println(apq);
    for (int i = 0; i < 10; i++) {
      apq.add( (int) (Math.random() * 100) +1 );
    }

    System.out.println(apq);
  }


}
