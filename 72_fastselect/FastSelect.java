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

    public static int fastSelect(int[] arr, int xsmallest) {

        System.out.println(arrToString(arr));

        int midIndex = arr.length/2;
        int partitionEnd = -1;

        while (partitionEnd != xsmallest-1) {
            System.out.println("partitioning the array at pivot: " + arr[midIndex]);
            partitionEnd = partition(arr, 0, arr.length-1, midIndex);
            System.out.println(arrToString(arr));

            if (partitionEnd > xsmallest-1) {  // greater so have to split in half first half
                midIndex = partitionEnd/2;      
            }
            else if (xsmallest-1 > partitionEnd) {
                midIndex = (arr.length + partitionEnd)/2;
                System.out.println(arr.length + " + " + partitionEnd + " / 2 = " + midIndex);
            }

            System.out.println("midIndex " + midIndex);
            System.out.println("partitionEnd " + partitionEnd);
        }
        return arr[partitionEnd];
    }


    public static void main(String[] args) {

        // int[] arr = {7,1,5,12,3};
        // int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int[] arr = {0,1,2,3,10,5,9,8,7,6,4};


        // fastSelect(arr, 1);
        System.out.println(fastSelect(arr, Integer.parseInt(args[0])));
        // System.out.println(fastSelect(arr, 1));

    }
}