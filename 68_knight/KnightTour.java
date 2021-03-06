// Team Blue Pandas (Jacob Ng, PreGuac, Andrew Piatetsky, Burnt Peanut, Emily Ortiz, Applesauce)
// APCS pd6
// HW68: ...and T-, Tr-, Tri-, Tries Again Until It's Done
// 2022-03-1
// time spent: 2.5h 

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO
 *
 * DISCO
 *
 * QCC
 *
 * Mean execution times for boards of size n*n:
 * n=5   0.144s    across 5 executions
 * n=6   0.157s    across 5 executions
 * n=7   0.308s    across 5 executions
 * n=8   0.334s    across 5 executions
 * 
 * // didn't get to this part- will work on this tomorrow 
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;
    int startX = 2;
    int startY = 2;

    try {
      n = Integer.parseInt( args[0] );
      startX = Integer.parseInt(args[1]);
      startY = Integer.parseInt(args[2]);
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    System.out.println(startX + " " + startY);
    TourFinder tf = new TourFinder( n );

    //display board
    // System.out.println( tf );

    //for fixed starting location, use line below:
    tf.findTour( startX, startY, 1 );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    // int startX = 2 + (int) Math.random() * n;
    // int startY = 2 + (int) Math.random() * n;

    // tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    System.out.println( tf );

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[n+4][n+4];
    
    // System.out.println(stringVers(_board));

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
    for (int i = 0; i < _board.length; i++) {
      for (int j = 0; j < _board.length; j++) {
        if ((i < 2) || (i > _board.length-3)) {
          _board[i][j] = -1;
        }
        if ((j < 2) || (j > _board.length-3)) {
          _board[i][j] = -1;
        }
      }
    }
    //---------------------------------------------------------

  }//end constructor
  


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    // String retStr = "[0;0H";
    String retStr = "";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _board.length; i++ ) {
      for( j=0; j < _board.length; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if ( _solved ) System.exit(0); 

    //primary base case: tour completed
    if ( moves > (_sideLength * _sideLength) ) {
      _solved = true;
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
    if ( _board[x][y] != 0 ) {
      return;
    }

    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;

      // System.out.println( this ); //refresh screen

      // delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      
      findTour( x+1, y+2, moves+1 ); // a
      findTour( x+2, y+1, moves+1 ); // b
      findTour( x+2, y-1, moves+1 ); // c
      findTour( x+1, y-2, moves+1 ); // d
      findTour( x-1, y-2, moves+1 ); // e
      findTour( x-2, y-1, moves+1 ); // f
      findTour( x-2, y+1, moves+1 ); // g
      findTour( x-1, y+2, moves+1 ); // h

      _board[x][y] = 0;

      // System.out.println( this ); //refresh screen
    }
  }//end findTour()



  



}//end class TourFinder
