// Team Blue Pandas (Jacob Ng, PreGuac, Andrew Piatetsky, Burnt Peanut, Emily Ortiz, Applesauce)
// APCS pd6
// HW71: Whut Dis.
// 2022-03-07

/*
DISCO:

Never be so confident in class again. We thought that we solved it but after running some cases our hypothesises got thrown in the bin.
Next time we will be more humble and less sure, because after you hard code it and test it a bit more everthing you believed is destroyed.

Disregard last one. 

Take aways - be more confident in your self and your findings. Sometimes one typo in your code can make you rethink your life. Just be confident and full of hubris
and everything shall come next.

QCC

Why would you want to have greater numbers on one side and smaller numbers on the other side. Why would you care if the array is still not sorted?


q0: What does it do?

Creates two zones. One to the left of arr[c] and the other to the right of arr[c]. Then on the left it places all of the numbers smaller than arr[c], and on the left it places all the number
greater than arr[c]


q1: What is its Big-Oh runtime?

O(n) because runs a for loop that touches every element of the array

*/



public class Mysterion {


    public static int func (int[] arr, int a, int b, int c) {

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

    public static void main(String[] args) {
        
        // int[] arr1 = {7,1,5,12,3};
        // int[] arr2 = {1,3,5,12,7};
        int[] arr2 = {21,1,3,6,9,15,11,2,10}; 
        int[] arr3 = {1,3,6,2,9,15,11,21,10}; // after partition at pivot 4
        int[] arr4 = {1,3,2,6,9,15,11,21,10};// after partition at pivot 2


        // int[] arr3 = {7,1,5,2,3};
        // int[] arr4 = {10,9,8,7,6,5,4,3,2,1,0};
        // int[] arr5 = {0,4,3,2,1,5,9,8,7,6,10};
        // int[] arr6 = {0,2,1,3,10,5,9,8,7,6,4};
        // int[] arr7 = {0,1,2,3,10,5,9,8,7,6,4};

        int[] arr = arr4;
        int a = 0;
        int b = arr.length-1;
        int c = 4;

        // System.out.println(arrToString(arr));

        // System.out.println(arr[c]);
        // int x = func ( arr, 0, b, c);

        // System.out.println(arrToString(arr));
        // System.out.println("x: " + x);

        for (int i = 0; i < arr2.length; i ++) {
            System.out.println(arrToString(arr2));
            func(arr2,0,arr2.length-1,i);
        }

        System.out.println(arrToString(arr2));





    }
}