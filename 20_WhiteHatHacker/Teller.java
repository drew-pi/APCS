//TNPG: Vegan Dragons (Courtney, Andrew, Anjini)
//subject all of their BankAccount’s functionality to stress testing. (Write code that will a) primarily, test all of BankAccount, and b) secondarily, try to break BankAccount. Note any and all Q/C/C in block comments of the usual fashion at the top of Teller.java.

public class Teller {
	public static void main (String[] args) {
		BankAccount bob = new BankAccount();
		
		String name = "Bob-Ross";
		bob.setName(name);

		String pwd = "y48q743yweai93pow";
		bob.setPasswd(pwd);

		short goodPin = 5679;
		short badPin = 1;
		bob.setPin(badPin);

		System.out.println(bob.toString());
	}
}
