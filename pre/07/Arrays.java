public class Arrays {


	//To be able to read arrays
	public static void printArray(double[] a) {
		System.out.print("(" + a[0]);
		for (int i = 1; i < a.length; i ++) {
			System.out.print("," + a[i]);
		}
		System.out.println(")");
	}

	public static void printArrayInt(int[] a) {
		System.out.print("(" + a[0]);
		for (int i = 1; i < a.length; i ++) {
			System.out.print("," + a[i]);
		}
		System.out.println(")");
	}

	public static void printArrayBool(boolean[] a) {
		System.out.print("(" + a[0]);
		for (int i = 1; i < a.length; i ++) {
			System.out.print("," + a[i]);
		}
		System.out.println(")");
	}


	//Exercise 1
	public static double[] powArray (double[] a) {
		double[] squares;
		squares = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			squares[i] = Math.pow(a[i],2);
		}
		return squares;
	}


	//Exercise 4
	public static int indexOfMax (int[] a) {
		return (a.length-1);
	}


	//Exercise 5
	public static boolean[] sieve (int n) {
		boolean[] sieve_bool_array;
		sieve_bool_array = new boolean[n];
		int[] sieve_int_array;
		sieve_int_array = new int[n];
		for (int i = 0; i < sieve_int_array.length; i++) {
			sieve_int_array[i] = i;
		}
		//printArrayInt(sieve_int_array);
		for (int num : sieve_int_array) {
			for (int i = 2; ((i * num) <= sieve_int_array[(sieve_int_array.length)-1]); i++) {
				if ((num == 0) || (num == 1)) {
					sieve_bool_array[num] = true;
					break;
				} else if (sieve_bool_array[num] == true) { //first run through true means that its not a prime number and prime numbers are false
					sieve_bool_array[num] = true;
				} else {
					sieve_bool_array[num*i] = true;
				}
				
			}
		} 
		for (int i = 0; i < sieve_bool_array.length; i++) {
			if (sieve_bool_array[i] == true) {
				sieve_bool_array[i] = false;
			} else {
				sieve_bool_array[i]= true;			
			}
		} 
		return sieve_bool_array;
	}


	// //Exercise 8
	// public static void arraySplit (int[] a) {
	// 	int len = a.length;

	// 	int[] b = new int[(len+1)/2];
	// 	int[] c = new int[len - b.length];
		
	// 	for (int i = 0; i < len; i++) {
	// 		if (i < b.length) {
	// 			b[i] = a[i];
	// 		} else {
	// 			c[i-b.length] = a[i];
	// 		}
	// 	}
	// }


	// public static int[] getSpecificArray(int [] a, int lowIndex, int highIndex) {
	// 	int[] new_array = new int[(highIndex-lowIndex)+1];

	// 	for (int i = lowIndex; i <= highIndex; i++) {
	// 		new_array[i-lowIndex] = a[i-1];
	// 	}
	// 	printArrayInt(new_array);
	// 	return new_array;
	// }



	// public static int maxInRange (int[] a, int lowIndex, int highIndex) {
	// 	int[] index_array = getSpecificArray(a,lowIndex,highIndex);
	// 	int len = index_array.length;

	// 	if (lowIndex == highIndex) {
	// 		return a[lowIndex];
	// 	} else {
	// 		int recurse;
	// 		recurse = maxInRange(index_array,0,len-1);
	// 		return recurse;   
	// 	}

	// }




	public static void main(String[] args) {

		double[] double_array;
		double_array = new double[10];
		for (int i = 0; i < double_array.length; i+=1.0) {
			double_array[i] = i+1;
		}
		printArray(double_array);
		printArray(powArray(double_array));


		int[] int_array;
		int_array = new int[10];
		for (int i = 0; i < int_array.length; i++) {
			int_array[i] = i;
		}
		printArrayInt(int_array);
		System.out.println(indexOfMax(int_array));

		printArrayBool(sieve(5));

		System.out.println(maxInRange(int_array,3,5));

		//printArrayInt(getSpecificArray(int_array,3,7));

	}
}