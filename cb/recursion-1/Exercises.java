public class Exercises {


    // factorial
    public int factorial(int n) {
  
        if ((n == 1) || (n == 0)) {
            return 1;
        }
        else {
            int sum = n * factorial(n-1);
            return sum;
        }
    }

    // bunny ears
    public int bunnyEars(int bunnies) {
   
        if (bunnies == 0) {
            return 0;
        }
        else {
            int sum = bunnyEars(bunnies-1) + 2;
            return sum;
        }        
    }       
 public int fibonacci(int n) {
  
  if (n == 0) {
    return 0;
  }
  if (n == 1) {
    return 1;
  }
  else {
    int sum = fibonacci(n-2)+fibonacci(n-1);
    return sum;
  }
}


}