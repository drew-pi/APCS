/*
Spicy Mangoes (Andrew Piatesky, May Qiu, Faiyaz Rafee) and Burnt Peanut
APCS
HW 23 -- What Does Equality Look Like?/Writing and testing class/Filled in coin class methods and then tested it using Driver.java
2021-10-24

Discoveries:
An input for a method can be an object of a specific class

Questions: How do you get random number generator in Java
*/

public class Coin {

  //attributes aka instance vars
  double value; //monetary value
  String name; //the name of the coin
  String upFace; //Shows if its heads or tails right now
  int flipCtr; //show how many times flipped
  int headsCtr; //how many times landed heads up
  int tailsCtr;// how many times landed tails up
  double bias; //likelihood landing heads up or tails (1.0 meaning always head)
  



  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
  flipCtr = 0;
  headsCtr = 0;
  tailsCtr = 0;
  upFace = "heads";
  bias = 0.5; 
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond: name set to input (unless invalid then set to penny), upFace set to "heads", bias to 0.5 and everyting else to 0
  ***/
  public Coin( String s ) {
  // if ((name == "penny") || (name == "nickel") || (name == "dime") || (name == "quarter") || (name == "half dollar") || (name == "dollar")) {
  name = s;
  // } else {
  //   System.out.println("Invalid coin name, setting coin name to penny");
  //   name = "penny";
  // }
  // upFace = "heads";
  flipCtr = 0;
  headsCtr = 0;
  tailsCtr = 0;
  upFace = "heads";
  bias = 0.5; 
  }


  /***
      Coin(String,String) --
      precond: coin name input is one of:
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond: name set to input s(unless invalid then set to penny), upFace set to input nowFace, bias to 0.5 and everyting else to 0
  ***/
  public Coin( String s, String nowFace ) {
  // if ((name == "penny") || (name == "nickel") || (name == "dime") || (name == "quarter") || (name == "half dollar") || (name == "dollar")) {
  name = s;
  // } else {
  //   System.out.println("Invalid coin name, setting coin name to penny");
  //   name = "penny";
  // }
  upFace = nowFace;
  flipCtr = 0;
  headsCtr = 0;
  tailsCtr = 0;
  bias = 0.5; 
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
    if (name == "penny") {
      value = 0.01;
    } else if (name == "nickel") {
      value = 0.05;
    } else if (name == "dime") {
      value = 0.10; 
    } else if (name == "quarter") {
      value = 0.25;
    } else if (name == "half dollar") {
      value = .50;
    } else if (name == "dollar") {
      value = 1;
    } else {
      value = 0;
      System.out.println("Invalid coin selection");
    }
    return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
    if ((s == "heads") || (s == "tails")) {
      upFace = s ; 
    } else {
      System.out.println("Invalid value for current side face up, must be heads or tails only");
    }

    if ((0.0 <= d) && (d <= 1.0)) {
      bias = d;
    } else {
      System.out.println("Invalid value for bias, must be between 0.0 and 1.0");
    }

    value = 0;
    name = null;
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0;

  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    if (bias == 0.0) {
      upFace = "tails";
    } else if (bias == 1.0) {
      upFace = "heads";
    } else if ((0.0 <= bias) && (bias <= 1.0)) {
      //code here
    } else {
      System.out.println("invalid bias");
      upFace = "invalid bias";
    }

    if (upFace == "tails") {
      tailsCtr += 1;
    } else if (upFace == "heads") {
      headsCtr += 1;
    }
    flipCtr += 1;
    return upFace;

  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    if (other.upFace != null) {
      if (upFace == other.upFace) {
        return true;
      } else {
        return false;
      }
    } else {
      System.out.println("Other coin is invalid");
      return false;
    }
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    String str;
    str = name + "--" + upFace;
    // str = "\n=====================";
    // str = str + "\nname: " + name;
    // str = str + "\ncurrent face: " + upFace;
    // str = str + "\nvalue: " + value;
    // str = str + "\nflipCtr: " + flipCtr;
    // str = str + "\nbias: " + bias;
    // str = str + "\n=====================";
    return str;
  }


}//end class