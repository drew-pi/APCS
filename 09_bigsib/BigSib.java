/*<Andrew> <Piatetsky>
APCS
HW<09> -- <What are BigSibs Good For/Reviewing/learning Java/In this assignment I had to create two files and have this one (BigSib.java) be read from another one (Greet.java) to print a string out.>
<2021>-<10>-<3>
*/

public class BigSib {
	public static void main(String[] args){
		greet("Flim");
		greet("Flam");
		greet("Kazaam");
	}

	public static void greet(String x) {
		System.out.println("Why, hello there " + x + ". How do you do?");
	}
}