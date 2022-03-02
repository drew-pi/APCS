// Team Blue Pandas (Jacob Ng, PreGuac, Andrew Piatetsky, Burnt Peanut, Emily Ortiz, Applesauce)
// APCS pd6
// HW68: ...and T-, Tr-, Tri-, Tries Again Until It's Done
// 2022-03-1
// time spent: 1.5h

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
 * n=5   __s    across __ executions
 * n=6   __s    across __ executions
 * n=7   __s    across __ executions
 * n=8   __s    across __ executions
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

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    //int startX = //YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    //int startY = //YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    //tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
    // _sideLength = n-4;

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

    // System.out.println(stringVers(_board));
    //---------------------------------------------------------

  }//end constructor


  // public String stringVers(int[][] arr) {
    
  //   String str = "";

  //   for (int i = 0; i < arr.length; i++) {
  //     for (int j = 0; j < arr.length; j++) {
  //       str += arr[i][j] + " ";
  //     }
  //     str += "\n";
  //   }

  //   return str;
  // }


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

    // int i, j;
    // for( i=0; i < _sideLength+4; i++ ) {
    //   for( j=0; j < _sideLength+4; j++ )
    //     retStr = retStr + String.format( "%3d", _board[j][i] );
    //   //"%3d" allots 3 spaces for each number
    //   retStr = retStr + "\n";
    // }
    // return retStr;

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
    if ( moves > (_board.length * _board.length) ) {
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

      System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      
      // a.   _board[x+2][y+1]
      // b.  _board[x+1][y+2]
      // c.  _board[x-1][y+2]
      // d.  _board[x-2][y+1]
      // e.  _board[x-2][y+1]
      // f.  _board[x-1][y-2]
      // g.  _board[x+1][y-2]
      // h.  _board[x+2][y-1]

      for (int i = 0; i < 8; i++) {
        if (i == 0) {
          findTour(x+2,y+1,moves+1);
          if (_board[x+2][y+1] != -1) {
            _board[x+2][y+1] = 0;
          }
          // moves = moves-1;
        }
        if (i == 1) {
          findTour(x+1,y+2,moves+1);
          if (_board[x+1][y+2] != -1) {
            _board[x+1][y+2] = 0;
          }
          // moves = moves-1;          
        }
        if (i == 2) {
          findTour(x-1,y+2,moves+1);
          if (_board[x-1][y+2] != -1) {
            _board[x-1][y+2] = 0;
          }
          // moves = moves-1;
        }
        if (i == 3) {
          findTour(x-2,y+1,moves+1);
          if (_board[x-2][y+1] != -1) {
            _board[x-2][y+1] = 0;
          }
          // moves = moves-1;
        }
        if (i == 4) {
          findTour(x-2,y+1,moves+1);
          if (_board[x-2][y+1] != -1) {
            _board[x-2][y+1] = 0;
          }
          // moves = moves-1;
        }
        if (i == 5) {
          findTour(x-1,y-2,moves+1);
          if (_board[x-1][y-2] != -1) {_board[x-1][y-2] = 0;}
          // moves = moves-1;
          
        }
        if (i == 6) {
          findTour(x+1,y-2,moves+1);
          if (_board[x+1][y-2] != -1) {_board[x+1][y-2] = 0;}
          // moves = moves-1;
        }
        if (i == 7) {
          findTour(x+2,y-1,moves+1);
          if (_board[x+2][y-1] != -1) {_board[x+2][y-1] = 0;}
          // moves = moves-1;
          
        }        
      }// end for loop

      System.out.println( this ); //refresh screen
    }
  }//end findTour()



  



}//end class TourFinder
