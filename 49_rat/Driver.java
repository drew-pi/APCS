public class Driver {
    public static void main(String[] args) {

        // testing out object compareTo method (required by interface Comparable)

        
        Comparable a = new Rational(5,6);
        Comparable b = new Rational(10,12);
        Comparable c = new Rational(1,2);
        Comparable d = new Rational();
        
        Comparable n = new String("Hello World");
        Integer i = 5;


        System.out.println("a.compareTo(b): " + (a.compareTo(b))); // shud be 0
        System.out.println("a.compareTo(c): " + a.compareTo(c)); // shud be 1
        System.out.println("a compared to d:" + a.compareTo(d)); // shud be 1
        System.out.println("c compared to a" + c.compareTo(a)); // shud be -1

        System.out.println("a compared to n (String)" + a.compareTo(n)); // shud be 0
        System.out.println("a compared to i (Integer)" + a.compareTo(i)); // shud be 0

    }
}