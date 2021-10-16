/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 18 -- CPA-One/using UML Diagrams of classes to write classes/ We used our UML diagram to write class BankAccount 
2021-10-16
*/

public class BankAccount {

	static String FullName;
	String Password;
	int PIN;
	int AccountNumber;
	double Balance;

	public void BankAccount() {
		AccountNumber = 123456789;
	}

	public void BankAccount(String name, String pwd, int pin, double initAmount) {
		FullName = name;
		Password = pwd;
		PIN = pin;
		Balance = initAmount;
	}

	public void print(){
		System.out.println(FullName);
		//System.out.println(Password);
		//System.out.println(PIN);
		//System.out.println(AccountNumber);
		//System.out.println(Balance);
	}

	public static void main (String[] args) {
		System.out.println("It works!!");
		print();

	}
}