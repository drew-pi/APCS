## Tuesday 2022-2-15 :: 8 Queens Puzzle :: by Andrew Piatetsky

**Interesting Tech News:** [Cool stuff on Windows soon](https://www.cnet.com/tech/services-and-software/windows-11-finally-adds-android-apps-heres-how-to-download-them/)

#### Do Now
 - Standard Trio Config
 - Converse with all neighbors about Queens puzzle with K+S


#### On Board
  - Q0: C'est possible? (Is this possible?)
      - a) How do you know
      - b) Prove otherwise
  - Q1: 8x8...7x7...9x9...NxN?
  - Q2: How to make machine droit (useful)? 

#### The Big Question: how do we solve?
  - Brute force
    - Student/Mr. Mykolyk's suggestions:
      - Use a similar problem (8 Rook Puzzle) and eliminate all working possiblities that don't work for queens.
      - Traveling salesman problem (more info [here](https://en.wikipedia.org/wiki/Travelling_salesman_problem)) - Can either use brute force or start going through down a certian possiblity until there is some sort of dead end, then try a different path (much faster and efficient)

#### Class Work:
  - Mr. Mykolyk passed out a worksheet to do with our trio.
  - Instructions:
    - 0 . Read for understanding.
    - 1 . Summarize what each method does.
    - 2 . List pre-/post conditions for each.
    - 3 . Generate a more descriptive name for each.
    - 4 . When entire team is confident in responses, send liason to lisadesk.
  - Also here is the classwork (don't worry I didn't type it all out, I scanned the words with my phone). 
 ```
private int[][]board;
public QueenBoard( int size ) {_board = new int[size][size]; }

private boolean foo(int row, int col)
{
  if (_board[row][col] != 0){
    return false;
   }
  _board[row][col] = 1;
  int offset = 1;
  while(col+offset < _board[row].length){
    _board[row][col+offset]--;
    if(row - offset >= 0){
      _board[row-offset][col+offset]--;
     }
    if (row + offset < _board. length){
      _board[row+offset][col+offset]--;
    }
    offset++;
   }
 return true
}



private boolean whutItDo0(int row, int col) 
{
  if (_board[row][col] != 1 ) {
    return false;
   }
  _board[row][col]=0:
  int offset = 1;
  
  while( col+offset < _board[row].length ) {
    _board[row][col+offset]++;
    if row - offset >= 0 ) {
      _board[row-offset][col+offset]++;
    }
    if( row + offset < _board.length ) {
      _board[row+offset][col+offset]++:
    }
    offset++;
   }
  return true;
}
```


#### HW!!
 - It isn't on the Assignments page, but the assignment was to continue working on the worksheet with our group (Piazza thread about it [here](https://piazza.com/class/kue5pmk0w7n70n?cid=543))


#### Next LCT:

Emily Ortiz (eortiz30@stuy.edu)



## Tuesday 2022-1-11 :: LAB04 REVIEW AND BIG O :: by Andrew Piatetsky

**Interesting Tech News:** [Oopsie on Mars](https://www.cnet.com/news/pesky-pebbles-are-clogging-nasa-perseverance-mars-rovers-rock-sample-system/)

#### Do Now
  - Mr. Mykolyk asked us how confident we were with our Readme file's for the lab, most people were not entirely confident

#### On Board

|| Vanilla Bub | Optimized/Exit Early Bub | Selection | Insertion |
|:---:|:------------:|:------------------------:|:--------:|:---------:|
|Worst Case (List is in descending order)   | O(n<sup>2</sup>)        | O(n<sup>2</sup>)                 | O(n<sup>2</sup>)  |     O(n<sup>2</sup>)      |
|Best Case(List is already sorted)     | O(n<sup>2</sup>)       | O(n)                  | O(n<sup>2</sup>)  |    O(n)       |

**Big O - notation used to show how many times the program repeats itself**
##### Why: 
  - Worst case is List in descending order (backwards list) because for each of the sorting algorithms the program must do the maximum amount of loops to take a value from one extreme to another. I recommend creating a flow chart or drawing it out one of the algos with a 5 item list to better understand.
  - Best case is an already sorted list. This is because if the list is already sorted no swaps need to be performed and so no extra loops in each pass. 

---
##### Why is it O(n<sup>2</sup>), and not something else:
  - Vanilla Bubble Sort: It's O(n<sup>2</sup>) for the Vanilla version of Bubble Sort because in each pass through array of size n, the program makes n loops to compare all of the values and then it makes n passes. So n * n is <sup>2</sup>. For both worst and best because nothing changes, still has to compare n values each pass and still has to make n passes to check to see if sorted.
  - Vanilla Bubble Sort: This version doesn't differ from regular bubble sort when the array is backwards (worst case) because still has to make the same number of passes and swaps, but when the list is sorted (best case) it only has to make 1 pass of n loops (1 * n = n) to check to see if the array is sorted since it has an exit feature - if there were no swaps during a pass it exits the sorting algorithm. 
  - Selection Sort: It's O(n<sup>2</sup>) because in the worst and best case it does the same thing. Each pass it searches the entire array (n items) for the smallest value and then places that item at the beginning (or at position p for how many passes it has done) and then repeats that until the next smallest value is the last value in the array. 
  - Insertion Sort: 
    - Best Case: O(n) because no swaps need to be done each pass. Instead of adding the next value to the partition and then resorting the partition, the algorithm adds the next value to the partition and does not do any additional sorting. So it does only n loops because it adds n values to the partition to make sure the array is sorted.  
    - Worst Case: This case is still O(n<sup>2</sup>) because instead of adding a value to the partition each pass and just moving on, the algorithm has to move that value to the left most side of the partition taking an additional p loops (for p items in the partition). It does n passes and n loops to add all the items in the array to the partition and therefore n<sup>2</sup> loops in total 


##### New Term:
  - "data-insensitive": describes, in this case a sorting algorithm, that has the same Big O notation regardless if the array is sorted or not
    - includes Vanilla Bubble Sort and Selection Sort.

#### Class Work:
Mr. Mykolyk asked us if we have the Big O (mathimatical) notation in our notebooks. When we all said no, he cried a little.
  - When we finally did copy it down, he gave us sheets where we were supposed to figure out Big O notation for Array List methods.

"Amortized" - Sometimes things will differ from the norm, but most of the time things are standard, so averaged out the actual measurement would actually be very close to the norm. Usually in relation to mortgages, but here in relation to Big O notation for add(Object o), where usually its very standard, but when the array is full, it has to create a new bigger one and then fill that one up too. 

#### HW!!
  - There are two assignments due tomorrow:
     - [HW54: One File to Bring Them All...](https://www.stuycs.org/apcs-mykolyk/1970/01/12/hw54.html)
     - [HW55: Never Fear, Big Oh Is Here!](https://www.stuycs.org/apcs-mykolyk/1970/01/12/hw55.html)
  - Also I would recommend studying for the next test

#### Next LCT:
mqiu30@stuy.edu





## Thursday 2021-11-04 :: REVIEW FOR TEST01 :: by Andrew Piatetsky (Filling in for Anjini Katari)
If there are any issues feel free to let me know (apiatetsky30@stuy.edu)

**Interesting Tech News:** [Elon Musk Doing Elon Musk Things](https://www.cnet.com/news/blue-origin-loses-legal-challenge-over-nasas-choice-of-spacex-and-starship/)

#### Do Now
 - Take out hardcopy of HW 31
 - Greatest number Thinker, login
#### On Board
 - ```$ git clone <SSH CLONE URL>```
 - ```$ cd repository``` (into what you just cloned)
 - ```$ git pull``` (whenever you need refresh)
#### Questions at the beginning of class
 - *Analog Feedback*
    - How did you feel about HW#31?
       - Most people seemed happy with it
 - *Binary Feedback*
    - Who saw Jayleen's QAF post?
#### On HW grades ([Piazza Post](https://piazza.com/class/kue5pmk0w7n70n?cid=215))
 - Sadly Brook's HW server was disbanded
 - Pupil path sucks
 - *Can post HW on Piazza after it was due*
    - Make sure to check with your group first though!
    - **Note**
      - When looking at the solutions posted (by Students or Mr. Mykolyk), don't think that the solution posted is the only way to do it
      - Make sure to read and understand the code because that is a very important skill

#### Class work
 - Reshuffling
    - Person logged in is X (greatest number Thinker)
    - X - 1 goes to team + 4
    - X - 2 goes to team + 5
 - Class Work
    - X pulls and runs Mr. Mykolyk's working solution to [Pig.java](https://github.com/ap251/library/blob/main/31_oink/Pig.java) using terminal code on the white board
    - Look for things that stood out 
    - **QAF Post's**
      - TNPG Umm post about hasAVowel 
      - Recommended we respond to [Jayleen's QAF post](https://piazza.com/class/kue5pmk0w7n70n?cid=226)
    - Visualize commafy solution posted in library yourself on a paper and then paste it into an [online Visualier](https://pythontutor.com/java.html#mode=edit) linked in the homepage

#### General Concerns 
 - *Stack Diagrams*
   - Many people wrote (in their QCC) that they didn't know how to draw Stack diagrams
   - Looked at a Recursive Stack diagram
      - If anyone has one that they are proud of maybe post to QAF
   - Discussed why Scheme/ Dr.Racket asked for memory when doing recursion in Intro
      - Because manages memory differently than Java

#### End of Class
 - Had some options
   - Study
   - Visualize Commafy solution in library repository
   - Trace/understand engToPig method in Pig.java

#### Prepare for relaxation day tomorrow!
 - Study for the test 
   - Some suggestions on what to study [here](https://piazza.com/class/kue5pmk0w7n70n?cid=226)
 - Good Luck!

#### Next LCT:
lkwok20@stuy.edu

