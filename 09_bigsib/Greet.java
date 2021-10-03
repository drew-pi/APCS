/*<Andrew> <Piatetsky>
APCS
HW<09> -- <What are BigSibs Good For/Reviewing/learning Java/In this assignment I had to create two files and have this one (Greet.java) read from another one (BigSib.java) to print a string out.>
<2021>-<10>-<3>
*/

public class Greet {
	public static void main(String[] args){
		BigSib.greet("Flim");
		BigSib.greet("Flam");
		BigSib.greet("Kazaam");
	}
}

/* 
Discoveries:
At first I was confused because I thought I should put them in the same file, but
then I realized that BigSib.greet meant that it was taking/giving information from a
completely different file/class. These two files work only if they are in the same
directory.

Questions: Why doesn't it work when you have the Greet class and BigSib class in the same file?
*/

//Emails - mkamela20
//xlin30

