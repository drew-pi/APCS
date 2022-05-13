import java.util.Currency;

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



    // remove a node based on value

    public TreeNode remove(int target) {
      TreeNode remNode = search(target);
      TreeNode prevNode = searchPre(target,_root);

      // System.out.println("remNode " + remNode.getValue());
      // if (prevNode != null) System.out.println("prevNode " + prevNode.getValue());
      // else System.out.println("null");

      // if no children
      if (remNode.getLeft() == null && remNode.getRight()==null) {
        if (prevNode.getRight().getValue() == target) {
          prevNode.setRight(null);
        }
        else {
          prevNode.setLeft(null);
        }
      }

      // if only one child

      // if that child is the right node
      else if (remNode.getLeft() == null) {
        // if rem node is the root
        if (prevNode == null) {
          _root = (_root.getRight());
        }
        // if the rem node is the left child of prevNode
        else if (prevNode.getLeft().getValue() == target) {
          prevNode.setLeft(remNode.getRight());
        }
        // if the rem node is the right child of prevNode
        else {
          prevNode.setRight(remNode.getRight());
        }
      }

      // if that child is the left node
      else if (remNode.getRight() == null) {
        // if rem node is the root
        if (prevNode == null) {
          _root = (_root.getLeft());
        }
        // if the rem node is the left child of prevNode
        else if (prevNode.getLeft().getValue() == target) {
          prevNode.setLeft(remNode.getLeft());
        }
        // if the rem node is the right child of prevNode
        else {
          prevNode.setRight(remNode.getLeft());
        }
      }


      // if node has two children 
      else {

        TreeNode maxLeft;
        TreeNode tempLeft, tempRight;

        maxLeft = subTreeGreatest(remNode.getLeft());

        // System.out.println("maxLeft " + maxLeft.getValue());

        // System.out.println("serch pre " + searchPre(maxLeft.getValue(), _root).getValue());
        // System.out.println("");

        tempLeft = remNode.getLeft();
        tempRight = remNode.getRight();

        searchPre(maxLeft.getValue(), _root).setRight(null);

        // System.out.println("tempRight " + tempRight.getValue());

        // checking to see if maxLeft is tempLeft or tempRight
        if (maxLeft.equals(tempLeft)) tempLeft = null;
        if (maxLeft.equals(tempRight)) tempRight = null;
        
        // if the node being removed is the root
        if (prevNode == null) {

          _root = maxLeft;
          _root.setLeft(tempLeft);
          _root.setRight(tempRight);
        }
        // if the remNode is on the left of prevNode
        else if (remNode.equals(prevNode.getLeft())) {
          prevNode.setLeft(maxLeft);
          maxLeft.setRight(tempRight);
          maxLeft.setLeft(tempLeft);
        }
        else { // if the remoNode is on the right
          prevNode.setRight(maxLeft);
          maxLeft.setRight(tempRight);
          maxLeft.setLeft(tempLeft);

          // tests just in case of any future errors

          // System.out.println("root" + _root.getValue());
          // System.out.println("right of root" + _root.getRight().getValue());
          // System.out.println("left of root" + _root.getLeft());
          // System.out.println("");

          // System.out.println("left of right of root" + _root.getRight().getLeft().getValue());
          // System.out.println("right of right of root" + _root.getRight().getRight().getValue());
          // System.out.println("");

          // System.out.println("right of left of right of root" + _root.getRight().getLeft().getRight().getValue());
          // System.out.println("left of left of right of root" + _root.getRight().getLeft().getLeft());
          // System.out.println("");

          // System.out.println("right of right of right of root" + _root.getRight().getRight().getRight());
          // System.out.println("left of right of right of root" + _root.getRight().getRight().getLeft().getValue());
          // System.out.println("");


          // System.out.println("the new subroot" + prevNode.getRight().getValue() + " " + maxLeft.getValue());
          // System.out.println("tempLeft or maxLeft.getLeft()" + prevNode.getRight().getLeft().getValue() + " " + maxLeft.getLeft().getValue() + " " + tempLeft.getValue());
          // System.out.println("tempRight or maxLeft.getRight()" + prevNode.getRight().getRight().getValue() + " " + maxLeft.getRight().getValue() + " " + tempRight.getValue());
          // System.out.println(prevNode.getRight().getRight().getRight().getValue());
          // System.out.println(prevNode.getRight().getRight().getLeft().getValue());
        }
      } // end 

      return remNode;
      // return remove(target, _root);
    }


    // failings of a helper method
    // public void remove(TreeNode remNode, TreeNode prevNode, TreeNode rootNode) {
    //   int targetVal = prevNode.getValue();
    //   TreeNode remLeft;

    //   if (remNode == null) return;
      
    //   if (prevNode.getRight().equals(remNode)){
    //     remLeft = remNode.getLeft();
    //     prevNode.setRight(remNode.getRight());

    //     prevNode.getRight().setLeft(remLeft);

    //   }

    //   if (prevNode.getLeft().equals(remNode)) {
    //     prevNode.setLeft(remNode.getRight());
    //     remove(prevNode.get)
    //   }

    //   // return new TreeNode(5);
    // }


    


    // search for parent of desired node
    TreeNode searchPre (int target, TreeNode curNode) {

      // System.out.println(curNode.getValue());

      if (curNode == null) return null;

      if (curNode.getLeft() != null) {
      if (curNode.getLeft().getValue() == target) return curNode; 
      }

      if (curNode.getRight() != null) {
      if (curNode.getRight().getValue() == target) return curNode;
      }
      
      if (curNode.getValue() > target) {
        return searchPre(target,curNode.getLeft());
      }

      if (curNode.getValue() < target) {
        return searchPre(target, curNode.getRight());
      }

      return null;
    } // end helper method


    // get greatest value in subtree
    public TreeNode subTreeGreatest(TreeNode curNode) {

      if (curNode.getRight() == null) return curNode;

      return subTreeGreatest(curNode.getRight());
    }




  //main method for testing
  public static void main( String[] args )
  {

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.

    System.out.println( "tree init'd: " + arbol );

    //inserting in this order will build a perfect tree
    arbol.insert( 3 );
    arbol.insert( 1 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 4 );
    arbol.insert( 6 );
    /*
    */

    arbol.preOrderTrav();
    System.out.println("");
    arbol.inOrderTrav();
    // for (int i = 1; i < 7; i++) {
    //   TreeNode s = arbol.searchPre(i, arbol._root);
    //   System.out.println(s.getValue() + " " + i);
    // }

    // System.out.println("");
    // System.out.println(arbol.searchPre(0, arbol._root));
    System.out.println("");
    // System.out.println(arbol.subTreeGreatest(arbol.search(5)).getValue());
    


    //insering in this order will build a linked list to left
    /*
    arbol.insert( 6 );
    arbol.insert( 5 );
    arbol.insert( 3 );
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 1 );
    arbol.insert( 0 );
    */

    // System.out.println( "tree after insertions:\n" + arbol );
    // System.out.println();

    // System.out.println();
    // for( int i=-1; i<8; i++ ) {
    //     System.out.println(" searching for "+i+": " + arbol.search(i) );    
    // }

    // System.out.println();
    // System.out.println( arbol );

    System.out.println("");
    System.out.println(arbol.remove(6).getValue());
    System.out.println();

    arbol.preOrderTrav();
    System.out.println("");
    arbol.inOrderTrav();

    // arbol.remove(5);
    // System.out.println();
    // System.out.println( arbol );

    // arbol.remove(4);
    // System.out.println();
    // System.out.println( arbol );

    // arbol.remove(3);
    // System.out.println();
    // System.out.println( arbol );

    // arbol.remove(2);
    // System.out.println();
    // System.out.println( arbol );

    // arbol.remove(1);
    // System.out.println();
    // System.out.println( arbol );

    // arbol.remove(0);
    // System.out.println();
    // System.out.println( arbol );
  } // end main

}//end class