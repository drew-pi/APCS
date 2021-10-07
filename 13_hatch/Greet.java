/*<Frogs on Fire (FOF): Andrew Piatetsky, Samantha Hua> <Burnt Peanut>
APCS
HW<13> -- <Where do BigSibs Come From?/Learning about Java classes/Created our first contructor in class BigSib to have a default message>
<2021>-<10>-<6>
*/

public class Greet {
	public static void main(String[] args){
		BigSib joe = new BigSib();
		joe.setHElloMsg("What's up");

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

		BigSib leroy = new BigSib();
		String leroyGreeting = leroy.greet("Destiny");
		System.out.println(leroyGreeting);




	}
}

/* 
Discoveries: You cannot define an instance variable inside a method (even in a constructor method)
Cannot make constructor private. You do not need a main function inside a class when you are 
refrencing it from another file/class.



Questions: What does private and public do? Why can't the constructor be private? And why can't other methods be private and work the same?
*/

//Emails - mkamela20, xlin30, shua30
