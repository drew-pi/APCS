/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW51 - Dat Bubbly Tho/Sorting algos/created a not so memory intensive sorting algorithm called bubble sort which swaps adjacent terms if one is larger than the other.
2021-1-3
time spent: 1hr
*/

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO: Check consecutive pairs and swap if the one on the left is greater than the one on the right. 
 * Continue the pass until the end of the array and rinse and repeat until ordered (no more swaps occur during an entire pass)
 * 
 * DISCOVERIES:
 * using logical operators in while loops is a bit confusing because its opposite of what you would think
 * the program is extremely simple to write and implement
 *
 * QUESTION:
 * Why bubble sort it takes so long. It takes n^2 loops to guarantee a sorted array.
 * The second version that doesn't return void also uses twice the memory which is very inefficient what's the point?
 * 
 *  
 * q0: If a pass requires no swaps, what do you know?
 * a0: It is sorted
 * q1: After pass p, what do you know?
 * a1: That up to index p-1, all items are sorted (the first p items are sorted)
 * q2: How many passes are necessary to completely sort?
 * a2: let n be the size of the array, n passes to guarantee that all items up to index n-1 (or all n items) are sorted
 * 
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
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
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    boolean noSwap = false;
    int i = 0;

    while ((noSwap == false) && (data.size() > i)) { // while no swap is false and 
        noSwap = true;
        for (int z = data.size()-1; z > i; z--) {
            Comparable val1 = data.get(z);
            Comparable val2 = data.get(z-1);

            if (val1.compareTo(val2) < 1) {
                noSwap = false;
                data.set(z, val2);
                data.set(z-1, val1);
            }
        }
        i ++;
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> copyList = input;
    bubbleSortV(copyList);
    return copyList;
  }


  public static void whileLoopTest () {

    // idea of the test: can you use logical operators in while loops? and if you can how?
    
    int i = 0;
    int z = 1;

    // while i is 0 and z is 10 run loop
    /**
     * The following are the possibilities:
     * 
     * 
     */
    // if i is 0 and z is 10 loop continues
    // if one changes loop ends because both need to be true
    // if both change loop ends because both need to be true
    
    while ((i == 0) && (z == 1)) { 
        System.out.println("z: " + z);
        System.out.println("i: " + i);
        i += 1;
        z += 1;          
    }
  }



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
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      /*============================================*/

    /*==========for AL-returning methods==========*/
      //ArrayList<Integer> glen = new ArrayList<Integer>();
      glen = new ArrayList<Integer>(); 
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      /*============================================*/

  }//end main

}//end class BubbleSort