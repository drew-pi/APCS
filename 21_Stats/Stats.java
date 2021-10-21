/*
Vegan Dragons (Andrew Piatesky, Anjini Katari, Courtney Huang) and Burnt Peanut
APCS
HW 21 -- STAtisTically Speaking.../Writing and testing class/Filled in Stats class methods and then tested it using StatsDriver.java
2021-10-20

Discoveries:
There seems to be no build in way to convert double to int in java (have to write it yourself)
some fractions don't work very well because they become long decimals instead of staying fractions 
b/c of this geoMean with three numbers doesn't really work.

Questions: How can you get proper fractions in java

*/

public class Stats {

  //I used Gabriel Thompson's idea from Piazza
  public static int doubleToInt(double a) {
    int integer = 0;
    for (int i = 0; i <= Math.abs(a); i++){
      if (a >= 0) {
        integer = i;
      } else {
        integer = -i;
      }
    }
    return integer;
  }

  public static int mean(int a, int b) {
    return doubleToInt((a+b)/ 2);
  }

  public static double mean(double a, double b) {
    return doubleToInt((a+b)/ 2.0);
  }

  public static int max(int a, int b) {
    if (a > b) {
      return a;
    } else {
      return b;
    }
  }

  public static double max(double a, double b) {
    if (a > b) {
      return a;
    } else {
      return b;
    }
  }

  public static int geoMean(int a, int b) {
    return doubleToInt(Math.floor(Math.sqrt(a*b)));
  }

  public static double geoMean(double a, double b) {
    return Math.sqrt(a*b);
  }

  public static int max(int a, int b, int c) {
    if ((a > b) && (a > c)) {
      return a;
    }
    else if ((b > a) && (b > c)) {
      return b;
    } 
    else {
      return c;
    }
  }

  public static double max(double a, double b, double c) {
    if ((a > b) && (a > c)) {
      return a;
    }
    else if ((b > a) && (b > c)) {
      return b;
    } 
    else {
      return c;
    }
  }

  public static int geoMean(int a, int b, int c) {
    return doubleToInt(Math.pow(a*b*c,1.0/3.0));
  }

  public static double geoMean(double a, double b, double c) {
    return Math.pow(a*b*c,(1.0/3.0));
  }


  //main method for testing functionality
  public static void main( String[] args ) {

  }

}//end class