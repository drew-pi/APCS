/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 19 -- Mo Money Mo Problems ...MORE AWESOME/Revising and augmenting class BankAccount/ Added new features to BankAccount such as testing to see if a PIN is valid. 
2021-10-18
*/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
    if (((newPin - 1000) >= 0) & ((newPin - 1000) < 9000)) {
      pin = newPin;
    } else {
      System.out.println("Not a 4 digit number, setting PIN to 9999");
      pin = 9999;
    }
    return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    int check = newAcctNum - 100000000; 
    if (((check) >= 0) & ((check) < 900000000)) {
      acctNum = newAcctNum;
    } else {
      System.out.println("Not a nine digit number, setting Account Number to 999999999");
      acctNum = 999999999;
    }
    return oldAcctNum;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public boolean withdraw( double withdrawAmount ) {
    if (withdrawAmount > balance) {
      System.out.println("Not enough money in the account");
      return false;
    } else if (withdrawAmount < 0) {
      System.out.println("Cannot withdraw a negative amount");
      return false;
    } else {
      balance = balance - withdrawAmount;
      return true;
    }
  }

  public boolean authenticate( int inptAcctNum, String pwd ) {
    if ((inptAcctNum == acctNum) & (pwd == passwd)) {
      return true;
    } else {
      return false;
    }
  }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args ) {
    // INSERT YOUR METHOD CALLS FOR TESTING HERE
    BankAccount ba = new BankAccount();

    //testing setting pin and account num with different values
    int goodnum = 100000000;//123456789;
    int bignum = 1234567891;
    int small = 1234;
    ba.setAcctNum(goodnum);
    short goodnum2 = 1000;
    short bignum2 = 12345;
    short smallnum2 = 123;
    ba.setPin(smallnum2);

    //testing withdraw
    ba.setBalance(1000);
    double gooddraw = 1000;
    double baddraw = -1;
    ba.withdraw(gooddraw);

    //testing authenticate
    ba.setPasswd("bugs4");
    ba.setAcctNum(goodnum);
    System.out.println(ba.authenticate(goodnum,"bugs4"));
    System.out.println(ba.authenticate(bignum,"bugs4"));
    System.out.println(ba.authenticate(goodnum,"wrong"));
    System.out.println(ba.authenticate(1930,"wrong"));

    //printing all of the instance variables out after tests
    System.out.println(ba.toString());


  }//end main()

}//end class BankAccount


/*
Discoveries: 
You can use the main method to interact with objects (create/modify). 
Java uses '&' and '|' instead of 'and' and 'or' (I knew this b/c of the summer hw but I completely forgot)


Questions: Is there a built in exponent/power function into java?

Q2:How do you know BEFORE you wrote your own constructor, that Java provides one for you?
We know because it initialized the instance varible message in class BigSib. The primary purpose of a constructor is to initialize instance variables 
so when we created object of class BigSib without writing a constructor and the instance variable was initialized it meant that java did it for us automatically.

Q3:Describe a test to determine whether Java provides a mean of outputting a STRING REPRESENTATION of an OBJECT.?
Java does not provide one because when you try to print (System.out.println) the name of an object is shows some gibberish which I do not understand.
So to print/output all of the properties of an object you have to write your own method for that class, and then use the object of that class to run the method. 
*/

