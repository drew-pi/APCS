/*
TNPG: Blue Pizza Bagles (Andrew Piatesky, Ben Belotser, Kosta Dubovskiy) and Burnt Peanut
APCS
HW55 - One File to Bring Them All.../Never Fear, Big Oh Is Here!/ learning about time complexity and big o notation/ wrote comments on each method in the class and showed its time complexity
2022-1-11
time spent: 2h
*/


import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;

  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
    _data = new ArrayList<Integer>(); // empty constructor means inital capacity of 10
  }

  // O(n) because cycles through the entire array and adds each value into a string
  public String toString()
  {
    return _data.toString();
  }

  // O(p), for position p of desired value to be removed. Runs linear search to find value
  public Integer remove( int i )
  {
    Integer oldVal = _data.get(i);
    _data.remove(i);
    return oldVal;
  }

  // O(1), just prints out size attribute
  public int size()
  {
    return _data.size();
  }

  // O(1) because just returns value at some index
  public Integer get( int i )
  {
    return _data.get(i);
  }

  // time complexity - O(p) for correct position p. Goes through each value and finds the right value
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  public void addLinear(Integer newVal)
  {
    boolean skip = false;
    int N = _data.size();
    for (int i = 0; i < N; i++) {
        if (_data.get(i) >= newVal) {
            _data.add(i, newVal);
            skip = true;
            break;
        }
    }
    if (skip == false) {
        _data.add(newVal);
    }
  }

  // time complexity - O(log base 2 of n, for size of array n. Halves the searching partition each run, so ends up finishing in logarithmic time complexity)
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  public void addBinary(Integer newVal)
  {
    int lo = 0;
    int hi = _data.size()-1;
    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while(lo <= hi) { // run until lo & hi cross

      //update mid pos var
      m = (lo + hi) / 2;

      // target found
      if (newVal > _data.get(_data.size()-1)) {
        tPos = -1;
        break;
      } 
      if (_data.get(0) > newVal) {
          tPos = 0;
          break;
      }
      if ((_data.get(m) > newVal) && (_data.get(m-1) < newVal)) {
          tPos = m;
          break;
      }
      if (_data.get(m) == newVal) {
          tPos = m;
          break;
      }
      // value at mid index higher than target
      if ((_data.get(m)).compareTo(newVal) > 0) {
        hi = m-1;
      } 
      // value at mid index lower than target
      if ((_data.get(m)).compareTo(newVal) < 0) {
        lo = m+1;
      }
    }
    
    if (tPos != -1) {
        _data.add(tPos,newVal);
    }
    else {
        _data.add(newVal);
    }
  }

  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    /*-----v-------move-me-down-----------------v--------*/

    // testing binary search
    Franz = new OrderedArrayList();
    int a = 0;
    for( int i = 0; i < 15; i++ ) {
      a =  (int) (50 * Math.random());
    //   System.out.println("a: " + a);      
      Franz.addBinary((int)( a ) );
    }
    Franz.addLinear(5);
    Franz.addLinear(7);
    Franz.addLinear(9);
    Franz.addLinear(520);
    Franz.addBinary(6);
    Franz.addBinary(500);
    Franz.addBinary(10);
    Franz.addBinary(1);

    System.out.println( Franz );
      /*=====^====================================^=========*/

  }//end main()

}//end class OrderedArrayList