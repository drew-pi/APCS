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
