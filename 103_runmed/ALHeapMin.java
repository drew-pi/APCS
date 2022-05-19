/*
Team PinkLemonade:  Jacob Ng, Andrew Piatetsky, Emily Ortiz
APCS pd6
HW103: Erica's Friends, Hugo, and The One in the Middle
2022-05-18
*/

/*
DISCO
Trace everything out
errors so stupid and so easy to find when you print info out 


QCC
everything is log base 2 something, because of the binary nature. If a tree has between 4-7 elements, the maximum number of swaps
that has to be done to resort the tree is 2 (corresponds to log base 2 of elements between 4-7)

*/


/**
 * class ALHeapMin
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeapMin
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeapMin()
  {
      _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
      // level-order traversal of the tree
      String retString = "";
      for (Integer i : _heap) {
          retString += i + ",";
      }
      return retString;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
      return _heap.isEmpty();
  }//O(1)



  public int size() {
      return _heap.size();
  }


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
      if (isEmpty()) return null;
      return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * add as leaf, then "float" it up
   */
  public void add( Integer addVal )
  {
    int posVal = _heap.size();
    int posParent = findParent(posVal);
    _heap.add(addVal);

    while (_heap.get(posParent) > _heap.get(posVal)) {
      swap(posVal, posParent);
      posVal = posParent;
      posParent = findParent(posVal);
    }

    // if ( minOf(findParent(_heap.size()-1),addVal) == addVal)
  }//O(logn)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * <swap smallest and last added elements, then resort by >
   */
  public Integer removeMin()
  {
    if (isEmpty()) return null;


    int posLast = _heap.size()-1;
    int curPos = 0;
    int minPos = -1;


    int smallest = _heap.get(curPos);

    // swap and remove
    swap(posLast, curPos);
    _heap.remove(posLast);

    if (_heap.size() == 1) return smallest;


    // re-sort and maintain invariant
    while (_heap.size() > (curPos * 2) + 2) {

      // System.out.println("heap: " + _heap);
      // System.out.println("curPos: " + curPos);
      // System.out.println("minPos: " + minPos);
      minPos = minChildPos(curPos);
      if (_heap.get(minPos) > _heap.get(curPos)) {
        break;
      }
      swap(curPos, minPos);
      curPos = minPos;
    }


    return smallest;

      
  }//O(logn)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
      int indxChildLeft = (pos * 2) + 1;
      int indxChildRight = (pos * 2) + 2;

      if (minOf(_heap.get(indxChildLeft), _heap.get(indxChildRight)) == _heap.get(indxChildLeft)) {
        return indxChildLeft;
      }
      else {
          return indxChildRight;
      }
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  private Integer findParent(int childIndex) {
      return (childIndex-1) / 2;
  }



  //main method for testing
  public static void main( String[] args )
  {
    ALHeapMin pile = new ALHeapMin();
    
    pile.add(2);
    System.out.println(pile);
    pile.add(4);
    System.out.println(pile);
    pile.add(6);
    System.out.println(pile);
    pile.add(8);
    System.out.println(pile);
    pile.add(10);
    System.out.println(pile);
    pile.add(1);
    System.out.println(pile);
    pile.add(3);
    System.out.println(pile);
    pile.add(5);
    System.out.println(pile);
    pile.add(7);
    System.out.println(pile);
    pile.add(9);
    System.out.println(pile);
    
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap