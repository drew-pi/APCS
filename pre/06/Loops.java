public class Loops {

	//Exercise 3
	public static double power (double x, int n) {
		int i = 1;
		double answer = 1.0d;
		while (i <= n) {
			answer = (answer * x);
			i ++;
		}
		return answer;
	}

	//Exercise 4
	public static double factorial (int x) {
		double answer = 1.0d;
		while (x > 0) {
			answer = (answer * x);
			x --;
		}
		return answer;
	}

	//Exercise 5
	public static double myexp (double x, int n) {
		int i = 1;
		double fact, exponent;
		double answer = 1;
		while (i <= n) {
			fact = factorial(i);
			exponent = power(x,i);
			answer += (exponent/fact);
			i ++;
		}
		return answer;
	}

	public static double mynewexp (double x, int n) {
		int i = 1;
		double prev_num = 1;
		double prev_den = 1;
		double answer = 1;
		while (i <= n) {
			prev_num = (prev_num * x);
			prev_den = (prev_den * i);
			answer += (prev_num/prev_den);
			i ++;			
		}
		return answer;
	}


	public static void check (double x, int n) {
		System.out.print(x + "/" + n + "\t");
		System.out.print(myexp(x,n) + "\t");
		System.out.print(mynewexp(x,n) + "\t");
		System.out.println(Math.exp(x));
	}


	public static void main (String[] args) {
		//System.out.println(power(8.0d,2));
		//System.out.println(factorial(2));

		for (double i = -0.1; i >= -100; i = i * 10) {
			check(i,40);
		}

		System.out.println("\n");

		for (double i = 0.1; i <= 100; i = i * 10) {
			check(i,40);
		}
	}
}