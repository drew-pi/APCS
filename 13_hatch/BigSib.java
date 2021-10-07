/*<Frogs on Fire (FOF): Andrew Piatetsky, Samantha Hua> <Burnt Peanut>
APCS
HW<13> -- <Where do BigSibs Come From?/Learning about Java classes/
Created our first contructor in class BigSib to have a default message>
<2021>-<10>-<6>
*/


public class BigSib {

	String helloMsg;

	public BigSib() {
		helloMsg = "Word up";
	}

	public void setHElloMsg(String msg) {
		helloMsg = msg;
	}

	public String greet(String name) {
		return helloMsg + " " + name;
	}
}


/* 
Discoveries: You cannot define an instance variable inside a method (even in a constructor method)
Cannot make constructor private. You do not need a main function inside a class when you are 
refrencing it from another file/class.



Questions: What does private and public do? 
Why can't the constructor be private? 
And why can't other methods be private and work the same?
*/

//Emails - mkamela20, xlin30, shua30



