/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW44 - Array of Grade 316/Doing more with Arrays/create a wrapper class for arrays so that we can get more functionality like in python
2021-12-6
time spent: 25min

DISCOVERIES:
There is no easy way to extend an array, you have to create a new one and then fill it up
Anyone can make any wrapper class with whatever extra functionality


QUESTION:
How do you get the nice formatting for methods in a class i.e 'superArray[1] = something' like in python instead of 'set(1,something)''

*/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray() {
    _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  { 
    if (_size == 0) {
      return "[]";
    }
    if (_size == 1) {
      return "[" + _data[0] + "]";
    }
    String s = "";
    s = ("[" + _data[0] + ",");
    for (int i = 1; i < _size-1; i++) {
      s += (_data[i] + ",");
    }
    s += (_data[_size-1] + "]");
    return s;
  }

  // HELPER METHOD - fill an empty Array with values from _data
  private void fill(int[] emptyArr) {
    if (emptyArr.length >= _data.length) {
      for (int i = 0; i < _size; i++) {
        emptyArr[i] = _data[i];
      }
    }
  }

  // HELPER METHOD - returns true if there is at least one extra space in data array
  private boolean isOneSpace() {
    return (_size + 1 < _data.length);
  }


  //double capacity of SuperArray
  private void expand() {
    int[] tempArr = new int[_data.length*2];
    this.fill(tempArr);
    _data = tempArr;
  }


  //accessor -- return value at specified index
  public int get( int index ) {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal ) {
    int oldVal = _data[index];
    _data[index] = newVal;
    return oldVal;
  }



  public void add (int newVal) {
    if (!isOneSpace()) {
      this.expand();
    }
    this.set(_size,newVal);
    _size += 1;
  }


  public void insert(int index, int newVal) {
    if (!isOneSpace()) {
      this.expand();
    }
  
    int oldVal;
    for (int i = _size; i >= index + 1; i--) {
      oldVal = _data[i-1];
      _data[i] = oldVal;
    }

    _data[index] = newVal;
    _size += 1;
  }


  public void remove(int index) {
    int oldVal;
    for (int i = index+1; i < _size; i++) {
      oldVal = _data[i];
      _data[i-1] = oldVal;
    }

    _size -= 1;
  } 





  //main method for testing
  public static void main( String[] args )
  {
    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~*/
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < 10; i++ ) {
        curtis.add(i + 1);
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      int indx = 5;
      curtis.insert(indx,100);
      System.out.println("Printing curtis with insert at " + indx);
      System.out.println(curtis);

      curtis.remove(indx);
      System.out.println("Printing curtis with remove at " + indx);
      System.out.println(curtis);          

      // for( int i = 0; i < 3; i++ ) {
      //   curtis.expand();
      // System.out.println("Printing expanded SuperArray curtis...");
      // System.out.println(curtis);
      // System.out.println(curtis._data.length);
      //}
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class