/*<Mangos: Andrew Piatetsky, Joseph Othman, Lindsay Phung> <Burnt Peanut>
APCS
HW<12> -- <On Elder Individuality and the Elimination of Radio Fuzz/Learning about Java classes/.>
<2021>-<10>-<5>
*/

public class Greet {
	public static void main(String[] args){
		BigSib joe = new BigSib();
		joe.setHElloMsg("Word up");

		String joeGreeting = joe.greet("freshman");
		System.out.println(joeGreeting);


		BigSib bob = new BigSib();
		bob.setHElloMsg("Salutations");

		String bobGreeting = bob.greet("Dr. Spaceman");
		System.out.println(bobGreeting);


		BigSib ava = new BigSib();
		ava.setHElloMsg("Hey ya");

		String avaGreeting = ava.greet("Kong Fooey");
		System.out.println(avaGreeting);


		BigSib lea = new BigSib();
		lea.setHElloMsg("sup");

		String leaGreeting = lea.greet("mom");
		System.out.println(leaGreeting);




	}
}

/* 
Discoveries:
You don't have to use main method, in all classes. Also you can variable initialized outside methods
and to use them you just have to remove the static specifier from the method. Going one step at a time is
actually very useful.


Questions: Why is it called instance variable
*/

//Emails - mkamela20,//xlin30

