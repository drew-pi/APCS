// JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
// APCS pd6
// HW75: Nodal Recall
// 2022-03-013
// time spent:  30mins

/*
Q
Why does pass by reference not happen when I set a new instance of Node to an already existing node. Is it something to do with the fact
that each node is defined by the pervious one?

What uses are there for linked lists? I can't really think of any because to get to the last element it seems like such a hassle.

C/C



*/
/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode {

    // instance variables:
    private String _value;
    private LLNode _next;
    
    // overloaded constructor - no more nodes attached
    public LLNode ( String val ) {
        _value = val;
        _next = null;
    }

    // overloaded constructor - node connects to another node
    public LLNode( String val, LLNode next ) {
        this(val);
        _next = next;
    }



    // ACCESSORS

    // returns the value stored inside the node
    public String getCargo() {
        return _value;
    }

    // returns the next node
    public LLNode getNext() {
        return _next;
    }


    // MUTATORS

    // sets cargo to the specified value
    public String setCargo ( String newVal ) {
        String oldVal = _value;
        _value = newVal;
        return oldVal;
    }

    // sets next node to specified value
    public LLNode setNext (LLNode next) {
        LLNode oldVal = _next;
        _next = next;
        return oldVal;
    }


    // overrides toString method
    public String toString() {
        String str = _value + " --> " + _next;
        return str;
    }


    public static void main(String[] args) {
        
        LLNode first = new LLNode("cat");

        first.setNext(new LLNode("dog"));

        first.getNext().setNext(new LLNode("cow"));

        System.out.println(first);


        // when you do this (using first itself as the next node) it basically shortens the linked list each time
        // while (first != null) {
        //     System.out.println(first);
        //     System.out.println(first.getCargo());
        //     first = first.getNext();
        // }



        // better way is to use new variable that is not attached to the starting node
        LLNode next = first;


        while (next != null) {
            System.out.println(next.getCargo());
            next = next.getNext();
        }
    }










}