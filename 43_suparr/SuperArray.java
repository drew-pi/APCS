/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW43 - Array of Steel/Doing more with Arrays/create a wrapper class for arrays so that we can get more functionality like in python
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
  public SuperArray()
  {
    this._data = new int[10];
    this._size = _data.length;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String s = "";
    s = ("[" + this._data[0] + ",");
    for (int i = 1; i < this._data.length-1; i++) {
      s += (this._data[i] + ",");
    }
    s += (this._data[this._data.length-1] + "]");
    return s;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] tempArr = new int[this._data.length*2];
    this._data = tempArr;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return this._data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int oldVal = this._data[index];
    this._data[index] = newVal;
    return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {
    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~*/
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i + 1);
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      System.out.println(curtis._data.length);
      }
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class