public class Methods {

	//Exercise 2
	public static boolean isDivisible (int n,int m) {
		if ((n % m) == 0) {
			System.out.println("It is true");
			return true;
			
		} else {
			System.out.println("It is false");
			return false;
		}
	}

	//Exercise 3
	public static boolean isTriangle (int a,int b,int c) {
		if ((a + b) <= c) {
			System.out.println("It is false");
			return false;
		} else if ((b + c) <= a) {
			System.out.println("It is false");
			return false;
		} else if ((c + a) <= b) {
			System.out.println("It is false");
			return false;
		} else {
			System.out.println("It is true");
			return true;
		}
	}

	//Exercise 8
	public static int ack (int m,int n) {
		if (m == 0) {
			return (n+1);
		} else if ((m > 0) && (n > 0)) {
				int recurse = ack(m,n-1);
				int result = ack(m-1,recurse);
				return result;
			} else {
				int recurse = ack(m-1,1);
				return recurse;
			}
	}





	public static void main(String[] args) {
		boolean q,w,e;
		q = isDivisible(10,5);
		w = isDivisible(9,5);
		e = isDivisible(20,2);
		System.out.print(q);
		System.out.print(w);
		System.out.println(e);

		boolean z,x,c,v;
		z = isTriangle(1,2,3);
		x = isTriangle(3,4,5);
		c = isTriangle(4,6,10);
		v = isTriangle(6,8,10);
		System.out.print(z);
		System.out.print(x);
		System.out.print(c);
		System.out.println(v);


		int a;
		a = ack(3,3);
		System.out.println(a);
	}
}