/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW49 - Be More Rational/Getting more comfortable with classes/created a class that can express rational numbers through the use of instance variables.
2021-12-2
time spent: 25min

DISCOVERIES:
A rational number is actually a number that can be expressed by a ratio
this() has to go in the first line of a overloaded constructor, never encountered that before

QUESTION:

*/

public class Rational implements Comparable{

    // INSTANCE VARIABLES
    private int numerator, denominator;

    public Rational() {
      numerator = 0;
      denominator = 1;
    }

    public Rational(int p, int q) {
      this();
      if (q != 0) {
        numerator = p;
        denominator = q;
      }
      else {
        System.out.println("denominator cannot be 0");
      }
      // automatically reduces when initialized
      this.reduce();
    }

    public String toString() {
      return numerator + "/" + denominator;
    }

    public double floatValue() {
      return (double)numerator / denominator;
    }

    public void multiply(Rational r) {
        this.numerator *= r.numerator;
        this.denominator *= r.denominator;
    }

    public void divide(Rational r) {
      if (r.numerator != 0) {
        this.numerator *= r.denominator;
        this.denominator *= r.numerator;
      } else {
        System.out.println("Cannot divide by 0");
      }
    }

    public void add(Rational r) {
      this.numerator = (this.numerator * r.denominator) + (r.numerator * this.denominator);
      this.denominator *= r.denominator;
    }

    public void subtract(Rational r) {
      this.numerator = (this.numerator * r.denominator) - (r.numerator * this.denominator);
      this.denominator *= r.denominator;
    }

    public int gcd() {
      int a = this.numerator;
      int b = this.denominator;

       while (a != b) {
        if (a > b) {
          a -= b;
        } else {
          b -= a;
        }
      }
      return a;
    }

    public void reduce() {
      if (numerator != 0) {
        int factor = this.gcd();
        this.numerator /= factor;
        this.denominator /= factor;
      }
    }

    // Convenient method
    public int compareToRat(Rational r) {

      r.reduce();
      this.reduce();

      if ((this.numerator == r.numerator) && (this.denominator == r.denominator)) {
        return 0;
      } else if (this.floatValue() > r.floatValue()) {
        return 1;
      } else {
        return -1;
      }
    }

    // Comparable interface requirements
    public int compareTo(Object r) {

      if (r instanceof Rational) {
        Rational a = (Rational) r;
        return this.compareToRat(a);
      }
      else {
        System.out.println("Not a rational object");
        return 202;
      }
    }

    public static void main(String[] args) {

    }
  }