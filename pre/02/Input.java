public class Input{

	//Exercise 1
	public static void main(String[] args){
		System.out.printf("five over three = %f\n" , 5.0); // When using an int it throws an error, but when using a double/float it works perfectly fine
		System.out.printf("one hundred = %d\n" , 100); // It also throws an error when you use a double with %d, however replacing it with a integer it works fine.
		System.out.printf("%f = %d" , 100 ); //If you put two formatters you have to input 2 numbers as well. 
	}

}


/*When you use printf, the Java compiler does not check your format string. 
See what happens if you try to display a value with type int using \%f. 
And what happens if you display a double using \%d? 
What if you use two format specifiers, but then only provide one value?*/