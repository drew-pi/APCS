/*
Team PinkLemonade:  Jacob Ng, Andrew Piatetsky, Emily Ortiz
APCS pd6
HW96: BSTs is the Perfect Place for Shade
2022-05-09
time spent: _ hrs
*/

/*
QCC: Does the first insert create the root or should the root be a fixed value?
What to do if the value already exists in tree?

*/


/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    _root = new TreeNode(0);
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    /*** YOUR IMPLEMENTATION HERE ***/
    insert(_root, newNode);

  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/


      if(stRoot.getValue() > newNode.getValue()){
          if(stRoot.getLeft() == null){
              stRoot.setLeft(newNode);
          }else{
              insert(stRoot.getLeft(), newNode);
          }
      }else if (stRoot.getValue() < newNode.getValue()){
          if(stRoot.getRight() == null){
              stRoot.setRight(newNode);
          }else{
              insert(stRoot.getRight(), newNode);
          }
      }

  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    if(currNode == null) return;
    System.out.println(currNode.getValue());
    preOrderTrav(currNode.getLeft());
    preOrderTrav(currNode.getRight());
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    inOrderTrav(_root);
  }
  public void inOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    if(currNode == null) return;
    inOrderTrav(currNode.getLeft());
    System.out.println(currNode.getValue());
    inOrderTrav(currNode.getRight());

  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    postOrderTrav(_root);
  }
  public void postOrderTrav( TreeNode currNode )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    if(currNode == null) return;
    postOrderTrav(currNode.getLeft());
    postOrderTrav(currNode.getRight());
    System.out.println(currNode.getValue());
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // HW 96 implementations

    // our algo - use insert method, but instead of inserting we compare when the cargo equals our int. Then we create a pointer and point it to the node.
    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
      return search(target,_root);
    }


    // helper method for search
    TreeNode search (int target, TreeNode curNode) {

      if (curNode == null) return null;

      // System.out.println(curNode.getValue());

      if (curNode.getValue() == target) return curNode;
      
      if (curNode.getValue() > target) {
        return search(target,curNode.getLeft());
      }

      if (curNode.getValue() < target) {
        return search(target, curNode.getRight());
      }

      return null;
    } // end helper method


    // our algo - ask child how tall you are
    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
      return height(_root);
    }

    // helper method for finding hight
    public int height(TreeNode curNode) {

      if (curNode == null) return 0;

      System.out.println(curNode.getValue());

      int maxLeft = 1 + height(curNode.getLeft());
      int maxRight = 1 + height(curNode.getRight());

      if (maxLeft > maxRight) {
        return maxLeft;
      }
      return maxRight;
    }



    // our algo - Use a traversal because but instead of going all the way until the current node is null, just check that left and right == null, then counter++
    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
      return numLeaves(_root);
      
    }


    public int numLeaves(TreeNode curNode) {

      if (curNode == null) return 0;
      // System.out.println(curNode.getValue());

      if (curNode.getLeft() == null && curNode.getRight() == null) return 1;

      return numLeaves(curNode.getLeft()) + numLeaves(curNode.getRight());
    }




  //main method for testing
  public static void main( String[] args )
  {

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );

      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
      
      System.out.println( "Search for 5: " + arbol.search(5));
      
      System.out.println( "Search for 10: " + arbol.search(10));
      
      System.out.println( "\n-----------------------------");
      System.out.println( "Number of Leaves: " + arbol.numLeaves());
      System.out.println( "Should be 3");
      
      System.out.println( "\n-----------------------------");
      System.out.println( "Height: " + arbol.height());
      System.out.println( "Should be 4");
      
      //  System.out.println( "Height: " + arbol1.height());
      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class