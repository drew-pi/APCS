/*
TNPG: Blue Pizza Bagles (Andrew Piatesky, Ben Belotser, Kosta Dubovskiy) and Burnt Peanut
APCS
HW54 - One File to Bring Them All.../compiled all sorting algorithms we had written so far
2022-1-11
time spent: 15min
*/

import java.util.ArrayList;

public class MySorts {

  // ~~~~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  //swaps two items at specified indeces
  public static void swap(ArrayList<Comparable> al, int posLeft, int posRight) {
    // actual values
    Comparable rightItm = al.get(posRight);
    Comparable leftItm = al.get(posLeft);

    // placed previously right item in the place of the left item
    al.set(posLeft, rightItm);
    // al.remove(posLeft+1);

    // places previously left item to the right
    al.set(posRight, leftItm);
    // al.remove(posRight+1);
  }

  // checks if an array is sorted
  public static boolean isSorted(ArrayList<Comparable> list) {

    for (int i = 1; i < list.size(); i++) {
      if (((int)list.get(i)) < ((int)list.get(i-1))) {
        return false;
      }
    }

    return true;
  }


  // populates an array list with numbers either reversed or sorted (1-n, n-1)
  public static ArrayList<Comparable> populate(boolean bestOrWorst, int size){
    ArrayList<Comparable> al = new ArrayList<Comparable>();

    if (bestOrWorst == true) {
      for (int i = 0; i <= size; i++) {
        al.add(i);
      }
    }
    else {
      for (int i = size; i >= 0; i--) {
        al.add(i);
      }
    }
    return al;
  }

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void/*int[]*/ bubbleSortVoid( ArrayList<Comparable> data )
  {
    int comparisonCounter = 0;
    int passCounter = 0;
    int swapCounter = 0;

    boolean noSwap = false;
    int i = 0;

    while ((noSwap == false)) { // while no swap is false and
        noSwap = true;
        passCounter += 1;
        for (int z = data.size()-1; z > i; z--) {

            Comparable val1 = data.get(z);
            Comparable val2 = data.get(z-1);

            comparisonCounter += 1;
            if (val1.compareTo(val2) < 1) {
                swapCounter += 1;
                swap(data,z-1,z);
                noSwap = false;
            }
        }
        i++;
    }

    //System.out.println("Bubblesort compare, pass, swap: " + comparisonCounter + " " + passCounter + " " + swapCounter);
    // int[] a = {comparisonCounter,passCounter,swapCounter};
    // return a;
  }

  // non VOID version of bubble sort
  public static ArrayList<Comparable> bubbleSort(ArrayList<Comparable> data) {

    ArrayList<Comparable> al = new ArrayList<Comparable>();

    for (Comparable c : data) {
        al.add(c);
    }

    bubbleSortVoid(al);
    return al;      
  }






  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void/*int[]*/ selectionSortVoid( ArrayList<Comparable> data )
  {
    //note: this version places smallest value at "rightmost" end
    int comparisonCounter = 0;
    int passCounter = 0;
    int swapCounter = 0;

    Comparable minVal; // smallest value
    Comparable curVal; // current value at position z

    for(int i = 0; i < data.size(); i++) {
      minVal = data.get(i);
      passCounter += 1;

      // nested forloop - looks for smallest value in array and places it at i position
      for(int z = i + 1 ; z < data.size(); z++) {

        curVal = data.get(z);

        comparisonCounter+=1;
        // when at the end of an array
        if (z == data.size()-1) {
          comparisonCounter+=1;
          // ComparisonCounter += 1;
          // when minVal is greater than curVal, minVal takes the value of curVal
          if (minVal.compareTo(curVal) > 0) {
            minVal = curVal;
          }
        } // end last value of list cases
        else {
          comparisonCounter+=1;
          // ComparisonCounter += 1;
          // when minVal is greater than curVal, minVal takes the value of curVal
          if (minVal.compareTo(curVal) > 0) {
            minVal = curVal;
          }
        } // end general cases

      } // end nested forloop

      // not swapping, but places smallest value at the beginning (swap worthy)
      swapCounter += 1;
      data.remove(minVal);
      data.add(i, minVal);
    }

    //System.out.println("Selectionsort compare, pass, swap: " + comparisonCounter + " " + passCounter + " " + swapCounter);
    // int[] a = {comparisonCounter,passCounter,swapCounter};
    // return a;
  }//end selectionSort

    // non VOID version of bubble sort
  public static ArrayList<Comparable> selectionSort(ArrayList<Comparable> data) {

    ArrayList<Comparable> al = new ArrayList<Comparable>();

    for (Comparable c : data) {
        al.add(c);
    }

    selectionSortVoid(al);
    return al;      
  }


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void/*int[]*/ insertionSortVoid ( ArrayList<Comparable> data )
  {
    int comparisonCounter = 0;
    int passCounter = 0;
    int swapCounter = 0;

    for(int i = 1; i <= data.size(); i++) {
      //partition marks first item in unsorted region
      passCounter +=1;
      //traverse sorted region from right to left
      for(int z = i-1; z > 0; z--) {
        // ComparisonCounter += 1;

        Comparable rightItm = data.get(z);
        Comparable leftItm = data.get(z-1);
        // "walk" the current item to where it belongs
        // by swapping adjacent items

        // leftItm is greater than rightItm swap them
        comparisonCounter += 1;
        if (leftItm.compareTo(rightItm) > 0) {
          swap(data,z-1,z);
          swapCounter+=1;
        }
        else {
          comparisonCounter += 1;
          break;
        }

      }
    }

    //System.out.println("Insetionsort compare, pass, swap: " + comparisonCounter + " " + passCounter + " " + swapCounter);
    //int[] a = {comparisonCounter,passCounter,swapCounter};
    //return a;
  }//end insertionSortV

    // non VOID version of bubble sort
  public static ArrayList<Comparable> insertionSort (ArrayList<Comparable> data) {

    ArrayList<Comparable> al = new ArrayList<Comparable>();

    for (Comparable c : data) {
        al.add(c);
    }

    insertionSortVoid(al);
    return al;      
  }


  public static void main(String[] args) {
    ArrayList<Comparable> test = new ArrayList<Comparable>();
  }
}