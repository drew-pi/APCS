/*
TNPG: Blue Pizza Bagles (Andrew Piatesky, Ben Belotser, Kosta Dubovskiy) and Burnt Peanut
APCS
HW52 - Selection, Natch/Sorting algos/created a not so memory intensive sorting algorithm called selection sort which searches array for smallest item, places it at the beginning and then repeats for next smallest item.
2021-1-4
time spent: 1hr
*/

/******************************
 *   class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO: Our algorithm searches the entire array by comparing a smallest value to current value
 *       Then it places smallest value at the beginning and starts looking for next smallest value
 *
 * DISCO:
 *  I know we had an entire unit on this but I forgot that doing Array a = another array doesn't make a copy of another array, it points to it instead and changes it too
 *  There are a lot of if statements and variables involved
 *  In this case not much faster than bubble sort because does maximum amount of loops anyways
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: (n-1)! / n - 1 factorial
 * q1: What do you know after pass p?
 * a1: that the first p elements are sorted
 * q2: How do you know if sorted?
 * a2: Nothing is smaller than the last value in the array
 * q3: What does a pass boil down to? (don't exactly understand the question)
 * a3: a pass goes through the entire array scanning it, ends at the end of the array
 ******************************/


import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places smallest value at "rightmost" end

    Comparable minVal; // smallest value 
    Comparable curVal; // current value at position z

    for(int i = 0; i < data.size(); i++) {
      //System.out.println( "\nbegin pass " + (i) );//diag
      //System.out.println(data);

      minVal = data.get(i);

      // nested forloop
      for(int z = i + 1 ; z < data.size(); z++) {

        curVal = data.get(z);

        // System.out.println( "minPos: " + minPos + " minVal: " + minVal );//diag
        // System.out.println( data );//diag

        // when at the end of an array
        if (z == data.size()-1) {
          // System.out.println("End?" + z);
          // when minVal is greater than curVal, minVal takes the value of curVal
          if (minVal.compareTo(curVal) > 0) {
            minVal = curVal;
          }
        } // end last value of list cases
        else {
          // when minVal is greater than curVal, minVal takes the value of curVal 
          if (minVal.compareTo(curVal) > 0) {
            minVal = curVal;
          }
        } // end general cases

      } // end nested forloop

      data.remove(minVal);
      data.add(i, minVal);

      // System.out.println( "after swap: " +  data );//diag
    }
  }//end selectionSort


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort


  public static void main( String [] args )
  {

    /*===============for VOID methods=============*/
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );
      /*============================================*/

    /*==========for AL-returning methods==========*/
      glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen ); // shouldn't be sorted because manually copied arraylist

      coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      /*============================================*/

  }//end main

}//end class SelectionSort
