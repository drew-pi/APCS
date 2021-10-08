/*<Frogs on Fire (FOF): Andrew Piatetsky, Samantha Hua, Perry Huang> <Burnt Peanut>
APCS
HW<14> -- <Customize Your Creation/Learning about Java classes and constructors/
Create two different versions of BigSib and Greet.java so that one has only a default contructor and the other has overloaded contructor>
<2021>-<10>-<7>
*/


public class BigSib {
	//Default constructor Big Sib class

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
Discoveries: Cannot customize message from Greet with default contructor.



Questions: The default constructor has no args, so why is it useful?
*/

//Emails - mkamela20, xlin30, shua30



