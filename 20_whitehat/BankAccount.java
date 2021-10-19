/*
Team Sushi- Ruby Friedman, Joseph Othman, Ivina Wang
APCS 10-18-21
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
		if ((newPin > 9998) || (newPin < 1000)) {
			System.out.print("Hey! ");
			System.out.print(newPin);
			System.out.println(" is not a valid 4 digit pin!!!");
			pin = 9999;
			return pin;
		}
		else {
			pin = newPin;
			return pin;
		}
	}

	public int setAcctNum( int newAcctNum ) {
		if ((newAcctNum > 999999998) || (newAcctNum < 100000000)) {
        		System.out.print("Hey! ");
			System.out.print(newAcctNum);
 			System.out.println(" is not a valid 9 digit account number!!!");
			acctNum = 999999999;
			return acctNum;
		}
		else {
			acctNum = newAcctNum;
			return acctNum;
		}
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
		if (balance < withdrawAmount) {
			System.out.println("Hey! You don't have enough money in your bank account to withdraw that amount of money!!!");
			return false;
		}
		else {
			balance = balance - withdrawAmount;
			return true;
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

	//authenticate method
	public boolean authenticate(int num, String pass) {
		if ((num == acctNum) && (pass == passwd)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		BankAccount Jared = new BankAccount();
		Jared.setName("Jared Mykolyk");
		Jared.setPasswd("password");
		short hello = 1234;
		Jared.setPin(hello);
		Jared.setAcctNum(987654321);
		Jared.setBalance(126.54);
		System.out.println(Jared.toString());
		System.out.print("New Account Balance: ");
		Jared.deposit(126.53);
		System.out.println(Jared.balance);
		System.out.print("New Account Balance: ");
		Jared.withdraw(62.26);
		System.out.println(Jared.balance);
		Jared.setAcctNum(2026474989);
		short hey = 30000;
		Jared.setPin(hey);
		Jared.withdraw(100000);
		Jared.setAcctNum(987654321);
		System.out.println(Jared.authenticate(987654321, "password"));
		System.out.println(Jared.authenticate(123456789, "uh oh"));
	}
}
