/*
TNPG that wrote Teller.java: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
TNPG that wrote class BankAccount: Team Sushi (Ruby Friedman, Joseph Othman, Ivina Wang)
APCS
HW 20 -- External Audit/Checking TNPG+1 group using external java file/Tested the code of TNPG+1, it was the same syntax as ours so it was very easy to implement our tests to thier code
2021-10-19

subject all of their BankAccount’s functionality to stress testing. (Write code that will 
a) primarily, test all of BankAccount, and 
b) secondarily, try to break BankAccount. 
Note any and all Q/C/C in block comments of the usual fashion at the top of Teller.java.
*/



/*
Discoveries:
Issue with PIN: when you set PIN to 9999 manually it prints "Hey! 9999 is not a valid 4 digit pin!!!" which means you forgot to use '<='/'>='
- no issue like that with the number 1000

Issue with AcctNum: Same issue as above 999,999,999(obviously without the commas) doesn't work and leads to the statement "Hey! 999999999 is not a valid 9 digit account number!!!" being printed.
- no issue with 100,000,000 (again without the commas)

Issue with Withdraw: Can withdraw negative money which adds that amount of money to your bankaccount (free money glitch)
- missing an if amount less than zero statement

Questions:

What operations are possible from BankAccount’s main() method but not Teller’s:
For our purposes (or at least for this assignment) there does not seem to be any operations that aren't possible here but are possible in the BankAccount main() method.
*/


public class Teller {
	public static void main (String[] args) {
		BankAccount bob = new BankAccount();
		
		String name = "Bob-Ross";
		bob.setName(name);

		String pwd = "y48q743yweai93pow";
		bob.setPasswd(pwd);

		short goodpin = 1000;
		short badpin = 10000;
		bob.setPin(goodpin);

		int goodacc = 999999998;
		int badacc = 999999999+10;
		bob.setAcctNum(goodacc);

		double initmoney = 1000;
		bob.setBalance(initmoney);

		double goodraw = 0;
		double badraw = -1000;
		bob.withdraw(badraw);

		int badauth = 100;
		String badpwd = "googoogoo";
		System.out.print((bob.authenticate(goodacc,pwd))+" "); //Should be true
		System.out.print((bob.authenticate(goodacc,badpwd))+" "); //Should be false
		System.out.print((bob.authenticate(badauth,pwd))+" "); //false
		System.out.println(bob.authenticate(badauth,badpwd)); //false

		System.out.println(bob.toString());
	}
}