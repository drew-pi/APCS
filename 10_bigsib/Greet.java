/*<Mangos> <Burnt Peanut>
APCS
HW<10> -- <Refactor Big Sib one/Reviewing Java/In this assignment I had to edit the files from my previous assignment so that Greet.java can print out the result of BigSib.java instead of BigSib.java printing out the result of itself .>
<2021>-<10>-<4>
*/

public class Greet {
	public static void main(String[] args){
		System.out.println( BigSib.greet("Flim") );
		System.out.println( BigSib.greet("Flam") );
		System.out.println( BigSib.greet("Kazaam"));
	}
}

/* 
Discoveries:
You can return from another file and then use that return value to print to console from another connected file.
Also when you run another file indirectly it also creates a class file for it, so all the errors for both come from the same file.

Questions: Why would you want to do this?
*/

//Emails - mkamela20,//xlin30

