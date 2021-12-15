/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW47 - Guess Again/Using recursion and iteration again/probably building up to binary search
2021-12-14
time spent: 30min

DISCOVERIES:
In this case it doesn't make sense to use recursion because its basically the same thing as iteration but more complicated
You can use Math.random() to create specific ranges

QUESTION:


*/

/***
    DISCO:

    QCC:

 ***/
import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:  
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    //pick random number in range [a,b]
    _target = ((int) (Math.random() * (_hi - _lo + 1))) + _lo;
  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec()
  {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo

    if (guess == _target) {
        System.out.println("OMG U WON! It took " + _guessCtr + " guesses");
        return;
    } else if (guess > _target) {
        _hi = guess - 1;
        _guessCtr++;
        System.out.println("Too high");
        playRec();
    } else if (guess < _target) {
        _lo = guess + 1;
        _guessCtr++;
        System.out.println("Too low");
        playRec();
    }//end cases

  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {

    int guess;

    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();

      //3 cases: we either found it, too hi, too lo

      if (guess == _target) {
        System.out.println("OMG U WON! It took " + _guessCtr + " guesses");
        return;
    } else if (guess > _target) {
        _hi = guess - 1;
        System.out.println("Too high");
    } else if (guess < _target) {
        _lo = guess + 1;
        System.out.println("Too low");
    }//end cases

      _guessCtr++;
    }
  }


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    playRec();
    // playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {
    /*-----------------------------*/
    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);
    //start the game
    g.play();
    /*-----------------------------*/
  }

}//end class GuessNumber