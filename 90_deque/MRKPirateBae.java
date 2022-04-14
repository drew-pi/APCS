/*
JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
APCS pd6
HW90: Deque the Halls
2022-04-13
time spent:  20min
QCC:
What are Queue's and Deque's used for, stacks are used to control the flow of operations in programming languages for example,
what are Queue's useful for?

What other methods are we missing?
  - like remove or descendingIterator?



DISCO: Using a linked list was so easy. Just use already built in functionality. And I know how LinkedLists work so I know the run
time for everything and understand how everything works.

When we first started using LinkedLists I didn't realize what they could be useful for, but now I sort of understand. Can use them to
create other data types and not actually store information important to use (like an list of needed information like passwords or words)
    - like the conventional list I mean
*/

public class MRKPirateBae {

    public static void main(String[] args) {

        LLDeque<String> deck = new LLDeque<String>();


        deck.enqueueEnd("cow");
        deck.enqueueEnd("horse");
        deck.enqueueEnd("goat");
        deck.enqueueEnd("string");

        System.out.println(deck);
        System.out.println("contains cow " + deck.contains("cow"));
        System.out.println("contains goose " + deck.contains("goose"));
        System.out.println("contains goat " + deck.contains("goat"));

        deck.enqueueFront("sea horse");
        deck.enqueueFront("butterfly");

        System.out.println(deck);

        System.out.println(deck.peekFront() + " " + deck.dequeueFront());
        System.out.println(deck.peekFront() + " " + deck.dequeueFront());

        System.out.println(deck);


        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());
        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());
        System.out.println(deck.peekEnd() + " " + deck.dequeueEnd());

        System.out.println(deck); 
    }
}