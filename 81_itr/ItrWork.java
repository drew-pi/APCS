// JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)APCS pd6
// HW81: Thank You, Next
// 2022-03-24
// time spent:  

/***
 *  We chose to use ArrayLists because we understand how to traverse it better, and it seems to be simpler/and faster to get to a 
 * certian index
    DISCO

    QCC

    SUMMARY THE FIRST:

    SUMMARY THE SECOND:

**/




import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for (int i : L) {
        if (i == key) {
            return true;
        }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    Iterator<Integer> i = L.iterator();

    while (i.hasNext()) {
        if (i.next() == key) {
            return true;
        }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> retList = new ArrayList<Integer>();

    for (int i : L) {
        if ((i % 2) == 1) {
            retList.add(i);
        }
    }
    return retList;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    List<Integer> retList = new ArrayList<Integer>();
    int curVal = -1;

    Iterator<Integer> i = L.iterator();

    while (i.hasNext()) {
        curVal = i.next();
        if (( curVal % 2 ) == 1) {
            retList.add(curVal);
        }
    }
    return retList;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator<Integer> i = L.iterator();
    int curVal;

    while (i.hasNext()) {
        curVal = i.next();
        if (( curVal % 2 ) == 0) {
            i.remove();
        }
    }
  }


  public static void main( String [] args )
  {
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~*/

    //var type: List   obj type: ?
    List<Integer> L =  new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ )
      L.add(i);

    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop


    // b) explicitly using an iterator

    /* */
    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);


    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork