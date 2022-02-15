// TNPG - 16 year streak (Andrew Piatetsky and Ben Belotser)
// APCS pd6
// HW64: Revisitation
// 2022-02-14
// time spent: in class + 30min


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
    
    // fib
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

    // bunny ears 2
    public int bunnyEars2(int bunnies) {
      int sum;
      if (bunnies == 0) {
        return 0;
      }
      if (bunnies % 2 == 0) {
        sum = 3 + bunnyEars2(bunnies-1);
      }
      else {
        sum = 2 + bunnyEars2(bunnies-1);
      }
      return sum;
    }

    // sum of triangle blocks
    public int triangle(int rows) {
      if (rows == 0) {
        return 0;
      }
      else {
        int total = rows + triangle(rows-1);
        return total;
      }
    }


}