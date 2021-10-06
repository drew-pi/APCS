/*<Mangos: Andrew Piatetsky, Joseph Othman, Lindsay Phung> <Burnt Peanut>
APCS
HW<12> -- <On Elder Individuality and the Elimination of Radio Fuzz/Learning about Java classes/ Used instance varibales to create a few objects that can greet someone specific.>
<2021>-<10>-<5>
*/


public class BigSib {
	public static void main(String[] args){
		System.out.println("It works");
	}

	String helloMsg;

	public String setHElloMsg(String x) {
		helloMsg = x;
		return helloMsg;
	}

	public String greet(String x) {
		helloMsg = helloMsg + " " + x;
		return helloMsg;
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
