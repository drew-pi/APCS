/*
contains two versions of quick select

1. O
(n^2) - basically sorts the entire array until the y-1th index
 - worst case is last element is yth smallest
 - best case is first element is yth smallest
2. O(nlogn) - continually makes pivot pos the midpoint of one of the two previous partitions (based on if the current pivot pos is greater or less than y-1)
 - worst case is if yth smallest is some extreme such as last or first element
 - best case is if yth smallest is in the very middle of the array

*/

public class QuickSelect {

    static Partition p = new Partition();

    
    // fast selects

    // O(nlogn)
    public static int fastSelect(int[] arr, int y) {

        // indexs
        int lo = 0;
        int hi = arr.length-1;
        int pivot = -1;

        while (pivot != y-1) {

            pivot = (lo + hi)/2;

            // System.out.println("partitioning the array at pivot: " + arr[pivot]);
            pivot = p.partition(arr, lo, hi, pivot);
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


    // O(n^2)
    public static int slowerFastSelect(int[] arr, int y){
        int a = p.partition(arr, 0, arr.length - 1, 0);
        while (y-1 != a){
            if (y-1 > a) {
            a = p.partition(arr, 0, arr.length - 1, a + 1);
            }
            else {
            a = p.partition(arr, 0, arr.length - 1, a - 1);
            }
        }
        return arr[a];
    }


    public static void main(String[] args) {
        
        int arr[] = {10,9,2,3,6,7,1,5,8,4};

        System.out.println(fastSelect(arr, Integer.parseInt(args[0])));
    }
}



