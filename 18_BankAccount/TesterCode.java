/*
TNPG: Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 18 -- CPA-One/using UML Diagrams of classes to write classes/ We used our UML diagram to write class BankAccount 
2021-10-16
*/


public class TesterCode {
	public static void main(String[] args) {

		//Josh's account and credentials 
		BankAccount joshAccount = new BankAccount("Josh Davis","password",1234,1000);

		joshAccount.Deposit(1234,4000.50);
		joshAccount.ShowInfo("Josh Davis","password");
		joshAccount.Withdraw(1234,2500.50);
		joshAccount.ShowInfo("Josh Davis","password");

		//Bob's account and credentials
		BankAccount bobAccount = new BankAccount("Bob Dylan","123",5678,20000.75);

		bobAccount.Deposit(5678,99.25);
		bobAccount.ShowInfo("Bob Dylan","123");

	}
}