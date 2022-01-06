/*
TNPG: Blue Pizza Bagles (Andrew Piatesky, Ben Belotser, Kosta Dubovskiy) and Burnt Peanut
APCS
HW53 - Poker Face/Sorting algos/created a not so memory intensive sorting algorithm called selection sort which partitions array into smaller arrays and organizes them before adding another value (more detail in algo)
2021-1-4
time spent: 1hr
*/

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO: Start with a partition of the first two values (from left), sort them using bubble sort/swapping. Add the next consecutive value to the 
 * partition and sort the entire partition again. Repeat until the partition is the entire array.
 * 
 * DISCO: 
 * Skeleton life saving (also time saving)
 * easier way to test code is to create a bunch of tests that return true or false if work or not
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n, because go from first to index size of array because that encompasses the entire list
 * q1: What do you know after pass p?
 * a1: that the first p+1 elements are sorted relative to each other 
 * q2: How will you know when sorted?
 * a2: When the sorted partition is the entire array
 * q3: What constitues a pass?
 * a3: a pass is just the sorting of the partition after adding a new element to the end of it
 * q4: What must you track?
 * a4: the values of the compared values because lost when swapping (because of ArrList.remove)
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }

  //swaps two items at specified indeces
  public static void swap(ArrayList<Comparable> al, int posLeft, int posRight) {
    // actual values
    Comparable rightItm = al.get(posRight);
    Comparable leftItm = al.get(posLeft);

    // placed previously right item in the place of the left item
    al.add(posLeft, rightItm);
    al.remove(posLeft+1);

    // places previously left item to the right
    al.add(posRight, leftItm); 
    al.remove(posRight+1);
  }

  // checks if an array is sorted
  public static boolean isSorted(ArrayList<Integer> list) {

    for (int i = 1; i < list.size(); i++) {
      if (((int)list.get(i)) < ((int)list.get(i-1))) {
        return false;
      }
    }

    return true;

  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for(int i = 1; i <= data.size(); i++) {
      //partition marks first item in unsorted region
      
      //System.out.println( "\npartition: " + i + "\tdataset:"); //diag
      //System.out.println( data );

      //traverse sorted region from right to left
      for(int z = i-1; z > 0; z--) {

        Comparable rightItm = data.get(z);
        Comparable leftItm = data.get(z-1);
        // "walk" the current item to where it belongs
        // by swapping adjacent items
        // leftItm is greater than rightItm swap them
        if (leftItm.compareTo(rightItm) > 0) {
            
          //System.out.println( "swap indices "+(z-1)+" & "+z+"..." ); //diag

          swap(data,z-1,z);
          
        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort


  public static void main( String [] args )
  {

    // implemented quick reference sheet to see if passed all of the tests
    
    /*===============for VOID methods=============*/
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);

      //System.out.println( "\nArrayList glen before sorting:\n" + glen );
      //System.out.println("\nIs ArrayList glen sorted B4 sorting: " + isSorted(glen));
      // System.out.println("1. false: " + isSorted(glen));
      System.out.println("1." + (isSorted(glen)==false));

      insertionSortV(glen);

      //System.out.println( "\nArrayList glen after sorting:\n" + glen );
      // System.out.println("\nIs ArrayList glen sorted AFTER sorting: " + isSorted(glen));
      // System.out.println("2. true: " + isSorted(glen));
      System.out.println("2." + (isSorted(glen)==true));

      ArrayList coco = populate( 10, 1, 1000 );

      // System.out.println( "\nArrayList coco before sorting:\n" + coco );
      // System.out.println("\nIs ArrayList coco sorted B4 sorting: " + isSorted(coco));
      // System.out.println("3. false: " + isSorted(coco));
      System.out.println("3." + (isSorted(coco)==false));

      insertionSortV(coco);

      // System.out.println( "\nArrayList coco after sorting:\n" + coco );
      // System.out.println("\nIs ArrayList coco sorted AFTER sorting: " + isSorted(coco));
      // System.out.println("4. true: " + isSorted(coco));
      System.out.println("4." + (isSorted(coco)==true));
      /*============================================*/

    /*==========for AL-returning methods==========*/
      System.out.println( "\n*** Testing non-void version... *** " );
      glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);

      // System.out.println( "\nArrayList glen before sorting:\n" + glen );
      // System.out.println("\nIs ArrayList glen sorted B4 sorting: " + isSorted(glen));
      // System.out.println("5. false: " + isSorted(glen));
      System.out.println("5." + (isSorted(glen)==false));

      ArrayList glenSorted = insertionSort( glen );

      //System.out.println( "\nsorted version of ArrayList glen:\n" + glenSorted );
      // System.out.println("\nIs ArrayList glenSorted(copy of the og array) sorted AFTER sorting: " + isSorted(glenSorted));
      // System.out.println("6. true: " + isSorted(glenSorted));
      System.out.println("6." + (isSorted(glenSorted)==true));

      // System.out.println( "\nIs original glen sorted after sorting of copy(should not be sorted): " + isSorted(glen) );
      // System.out.println("7. false: " + isSorted(glen));
      System.out.println("7." + (isSorted(glen)==false));

      coco = populate( 10, 1, 1000 );

      //System.out.println( "\nArrayList coco before sorting:\n" + coco );
      // System.out.println("\nIs ArrayList coco sorted B4 sorting: " + isSorted(coco));
      // System.out.println("8. false: " + isSorted(coco));
      System.out.println("8." + (isSorted(coco)==false));

      ArrayList cocoSorted = insertionSort( coco );

      // System.out.println( "\nsorted version of ArrayList coco:\n" + cocoSorted );
      // System.out.println("\nIs ArrayList cocoSorted(copy of the og array) sorted AFTER sorting: " + isSorted(cocoSorted));
      // System.out.println("9. false: " + isSorted(cocoSorted));
      System.out.println("9." + (isSorted(cocoSorted)==true));

      // System.out.println( "\nOriginal coco after sorting(should not be sorted):\n" + coco );
      // System.out.println( "\nIs original coco sorted after sorting of copy(should not be sorted): " + isSorted(coco) );
      // System.out.println("10. false: " + isSorted(coco));
      System.out.println("10." + (isSorted(coco)==false));

      /*============================================*/

  }//end main

}//end class InsertionSort