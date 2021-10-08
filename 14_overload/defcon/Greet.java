/*<Frogs on Fire (FOF): Andrew Piatetsky, Samantha Hua, Perry Huang> <Burnt Peanut>
APCS
HW<14> -- <Customize Your Creation/Learning about Java classes and constructors/
Create two different versions of BigSib and Greet.java so that one has only a default contructor and the other has overloaded contructor>
<2021>-<10>-<7>
*/


public class Greet {
	public static void main(String[] args){

		String greeting;

		BigSib joe = new BigSib();

		greeting = joe.greet("freshman");
		System.out.println(greeting);


		BigSib bob = new BigSib();
		bob.setHElloMsg("Salutations");

		greeting = bob.greet("Dr. Spaceman");
		System.out.println(greeting);


		BigSib ava = new BigSib();
		ava.setHElloMsg("Hey ya");

		greeting = ava.greet("Kong Fooey");
		System.out.println(greeting);


		BigSib lea = new BigSib();
		lea.setHElloMsg("sup");

		greeting = lea.greet("mom");
		System.out.println(greeting);
	}
}