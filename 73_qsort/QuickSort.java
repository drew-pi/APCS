/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 * Find the yth smallest element of each index of an array
 *
 * 2a. Worst pivot choice and associated run time:
 * no worst case, pivot is always the middle index at first until narrows into the correctn position - O(n^2 logn)
 *
 * 2b. Best pivot choice and associated run time:
 * no worst case, pivot is always the middle index at first until narrows into the correctn position - O(n^2 logn)
 * 
 *
 * 3. Approach to handling duplicate values in array:
 * pray - too focused on figuring out what the best index is
 *
 **/

// Achieve consensus as a team as to how to best automagically pick a pivot for partitioning, with an eye toward
// reliability
// simplicity
// minimized time complexity
// Refactor your partition method by removing its pivot parameter and implementing your mechanism from previous step.
// Refactor FastSelect implementation as necessary. Rename as QuickSelect, stored in current hw folder.


public class QuickSort {

    static QuickSelect q = new QuickSelect();

    // partitions the array based on pivot pos c
    public static int partition (int[] arr, int lo, int hi, int pivot) {

        int midVal = arr[pivot];

        swap(arr, pivot, hi);
        int start = lo;

        for (int i = lo; i < hi; i++) {
            if (midVal > arr[i]) {
                swap(arr,start,i);
                start+=1;
            }
        }
        swap(arr, hi, start);

        return start;
    }

    // swaps two array values at index a and b
    public static void swap(int[] arr, int a, int b) { // a and b are indexes
        int oldA = arr[a];

        arr[a] = arr[b];

        arr[b] = oldA;
    }


    // returns a string representation of an array
    public static String arrToString(int[] arr) {
        String str = "{";
        for (int i : arr) {
            str += i + ",";
        }
        str = str.substring(0, str.length()-1);
        str += "}";
        return str;
    }
    

    // O(n^2 logn) - couldn't figure out how to find a better pivot position (worked for around 50min tryint to figure it out)
    public static void qsort (int[] arr) {

        System.out.println(arrToString(arr));

        for (int i = 1; i < arr.length; i++) {
            q.fastSelect(arr, i);
        }
        System.out.println(arrToString(arr));

    }


    public static void main(String[] args) {

        int arr[] = {10,9,2,3,6,7,1,5,8,4};

        qsort(arr);
    }
}