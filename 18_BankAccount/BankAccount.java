/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 18 -- CPA-One/using UML Diagrams of classes to write classes/ We used our UML diagram to write class BankAccount 
2021-10-16
*/



public class BankAccount {
	
	private String FullName;
	private String Password;
	private int PIN;
	private int AccountNumber;
	private double Balance;
	
	//Overloaded constructor, no default one because need to make account by default.
	public BankAccount(String name, String pwd, int pin, double initAmount) {
		FullName = name;
		Password = pwd;
		PIN = pin;
		Balance = initAmount;
		AccountNumber = 123456789;
	}

	public void ShowInfo(String name, String pwd) {
		System.out.println("FullName: " + FullName);
		System.out.println("Password: " + Password);
		System.out.println("PIN: " + PIN);
		System.out.println("Acc number: " + AccountNumber);
		System.out.println("Balance: " + Balance);
	}

	public double Deposit(int pin, double amount){
		Balance += amount;
		return Balance;
	}

	public double Withdraw(int pin, double amount){
		Balance -= amount;
		return Balance;
	}
	
	public static void main (String[] args) {
		System.out.println("It works!!");		
	}
}


/*
Discoveries: If you want to use a class from another file and create objects of class then all methods must be 
public. Also there is no way to use instance variables in the main method (even when using other methods as
a buffer) except when those instance variables are static (which means they can no longer be attributes of
an object)

Questions: How come instance variables can be private but methods cannot be (at least when you want it to 
interact with another [java] file)?
Is there any way to create an account number randomly but to make sure that none repeat (in java)?

Q2:How do you know BEFORE you wrote your own constructor, that Java provides one for you?
We know because it initialized the instance varible message. The primary purpose of a constructor is to initialize instance variables 
so when we ran a class without writing a constructor and the instance variable was initialized it meant that java did it for us automatically.

Q3:Describe a test to determine whether Java provides a mean of outputting a STRING REPRESENTATION of an OBJECT.?
We can print out the object name so in this case we could 'System.out.println(objectName)' and if it prints out all of the instance variables
then Java does provide a means of outputting a string representation of an object. Otherwise it does not provide one.


*/