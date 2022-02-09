/***
// Team Whatever -- May Qiu and Andrew P.
// APCS pd6
// HW61 -- Instructions so Simple...
// 2022-02-08t
// time spent: 2 hrs
/*


  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  Merge: Created two variables which indicates the new index 0 of the two arrays.
         Used a for loop to add the lesser value of a[aIndex] and b[bIndex] and
         then increased the index of the array that was used. Used to if statements
         to add all the leftover values of the remaining array once one array has already
         had all their values added into answer.
  Sort: Recursive function in which it creates a tree until each node of the tree
        is an array of length 1. After which it goes down each branch merging the
        left and right.
  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int lengthSum = a.length + b.length;
    int[] ans = new int[lengthSum];
    int aIndex = 0;
    int bIndex = 0;
    for(int i = 0; i < lengthSum; i++){
      if(aIndex < a.length && bIndex < b.length){
        if(a[aIndex] > b[bIndex]){
          ans[i] = b[bIndex];
          bIndex++;
        }
        else{
          ans[i] = a[aIndex];
          aIndex++;
      }
    }
  }
  if(aIndex == a.length){
    for(int i = bIndex + aIndex; i < ans.length; i++){
        ans[i] = b[bIndex];
        bIndex++;
    }
  }
  if(bIndex == b.length){
    for(int i = bIndex + aIndex; i < ans.length; i++){
        ans[i] = a[aIndex];
        aIndex++;
    }
  }
    return ans;
  }//end merge()


    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr )
    {
        // initializing split array
        int[] b = new int[1];
        int[] a = new int[arr.length/2];
        if (arr.length % 2 == 0) {
            b = new int[arr.length/2];
        }
        else {
            b = new int[(arr.length/2)+1];
        }


        System.out.println("arr: ");
        printArray(arr);
        if (arr.length == 1) {
          return arr;
        }
        else {

        for (int i = 0; i < a.length; i++) {
            a[i] = arr[i];
        }
        System.out.println("a: ");
        printArray(a);
        for (int i = a.length; i < a.length + b.length; i++) {
            b[i-a.length] = arr[i];
        }
        System.out.println("b: ");
        printArray(b);

        sort(a);
        sort(b);
        System.out.println("After sort; (b and a) ");
        printArray(b);
        printArray(a);
        return merge(a,b);

      }
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
      for( int i = 0 ; i<a.length; i++ )
        a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
      System.out.print("[");
      for( int i : a )
        System.out.print( i + ",");
      System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args )
    {
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~*/

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );
      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) ); // 0,1
      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr1,arr2) ); // 1,1,2
      printArray( merge(arr2,arr3) ); // 1,2,3,4
      printArray( merge(arr0,arr3) ); // 0,3,4


      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
    }//end main()

  }//end class MergeSort
