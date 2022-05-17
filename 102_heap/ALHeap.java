/*
Team PinkLemonade:  Jacob Ng, Andrew Piatetsky, Emily Ortiz
APCS pd6
HW101: Heap o'Trouble
2022-05-16
*/


/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
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
  }//O(?)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
      return _heap.size() == 0;
  }//O(?)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
      if (isEmpty()) return null;
      return _heap.get(0);
  }//O(?)


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
  }//O(?)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * <swap smallest and last added elements, then resort by >
   */
  public Integer removeMin()
  {
    int posLast = _heap.size()-1;
    int curVal = _heap.get(0);

    int smallest = _heap.get(posLast);

    // swap and remove
    swap(posLast, curVal);
    _heap.remove(posLast);

    // re-sort and maintain invariant
    if (_heap.get((curVal * 2) + 1) > _heap.get((curVal * 2) + 2)) {
      swap(curVal, (curVal * 2) + 2);
      curVal = (curVal * 2) + 2;
    }
    else {
      swap(curVal, (curVal * 2) + 1);
      curVal = (curVal * 2) + 1;
    }


    return smallest;

      
  }//O(?)


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
  }//O(?)


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
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ALHeap pile = new ALHeap();

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
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap