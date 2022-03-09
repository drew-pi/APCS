// JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
// APCS pd6
// HW72 -- FastSelect
// 2022-03-08
// time spent:  2hrs

/*
ALGO:
Working -
start at the first index and then just go through the entire array until we find the yth smallest value

not working -
find the middle array and then either check the middle one on the left or right depending on if pivot is lower or higher than y. Ends when pivot is at index y-1


BEST CASE SCENARIO: (Describe best-case scenario and justify its Big-O classification.)
when yth smallest is in the y+1 index, and in the middle of the array
o(1) because doesn't even have to run loop

WORST CASE SCENARIO:
When its not in its correct spot and its an extreme such as the largest element or smallest element

DISCO
The previous pivot values don't change position when partitioned again

QCC
How can we make a O(logn) algo using a O(n) algo


Include test cases in main() method illustrating each best- and worst-case scenario.

*/

public class FastSelect {


    // partition and all of its helper methods
    public static int partition (int[] arr, int a, int b, int c) {

        int midVal = arr[c];

        swap(arr, c, b);
        int start = a;

        for (int i = a; i < b; i++) {
            if (midVal > arr[i]) {
                swap(arr,start,i);
                start+=1;
            }
        }
        swap(arr, b, start);

        return start;
    }

    public static void swap(int[] arr, int a, int b) { // a and b are indexes
        int oldA = arr[a];

        arr[a] = arr[b];

        arr[b] = oldA;

    }


    public static String arrToString(int[] arr) {
        String str = "{";
        for (int i : arr) {
            str += i + ",";
        }
        str = str.substring(0, str.length()-1);
        str += "}";
        return str;
    }



    // fast select
    // O(nlogn)
    public static int fastSelect(int[] arr, int y) { // not working for specific cases (in the case of arr in main method when the 7th largest number is requested)

        // indexs
        int lo = 0;
        int hi = arr.length-1;
        int pivot = -1;

        while (pivot != y-1) {

            pivot = (lo + hi)/2;

            // System.out.println("partitioning the array at pivot: " + arr[pivot]);
            pivot = partition(arr, lo, hi, pivot);
            // System.out.println(arrToString(arr));

            if (pivot > y-1) {  // greater so have to split in half first half
                hi = pivot;
            }
            else if (pivot < y-1) {
                lo = pivot;
                // System.out.println(arr.length + " + " + partitionEnd + " / 2 = " + midIndex);
            }

            // System.out.println("lo " + lo);
            // System.out.println("hi " + hi);
        }
        return arr[pivot];
    }


    // groups method - working O(n)

    public static int GroupFastSelect(int[] arr, int y){
        int a = partition(arr, 0, arr.length - 1, 0);
        while (y-1 != a){
            if (y-1 > a) {
            a = partition(arr, 0, arr.length - 1, a + 1);
            }
            else {
            a = partition(arr, 0, arr.length - 1, a - 1);
            }
        }
        return arr[a];
    }


    public static void main(String[] args) {

        // int[] arr = {7,1,5,12,3};
        // int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int[] arr = {4,1,2,3,10,5,9,8,7,6};


        // fastSelect(arr, 1);
        System.out.println(fastSelect(arr, Integer.parseInt(args[0])));
        // System.out.println(fastSelect(arr, 1));

    }
}
