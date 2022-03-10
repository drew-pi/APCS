// public class Partition - contains the original partition method and all necessary helper methods

public class Partition {

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

    public static void main(String[] args) {
        
        // int arr[] = {7,1,5,12,3};
        // int arr[] = {1,3,5,12,7};
        int arr[] = {10,9,2,3,6,7,1,5,8,4};


        for (int i = 2; i < arr.length; i+=2) {
            System.out.println(arrToString(arr));
            partition(arr, i-2, i, i-1);

        }
        System.out.println(arrToString(arr));
    }

}