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


		BigSib bob = new BigSib("Salutations");
		//bob.setHElloMsg("Salutations");

		greeting = bob.greet("Dr. Spaceman");
		System.out.println(greeting);


		BigSib ava = new BigSib("Hey ya", "Kong Fooey");
		//ava.setHElloMsg("Hey ya");

		//greeting = ava.greet("Kong Fooey");
		System.out.println(ava.helloMsg);


		BigSib lea = new BigSib("sup");
		//lea.setHElloMsg("helloo");

		greeting = lea.greet("mom");
		System.out.println(greeting);
	}
}

