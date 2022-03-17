// JAB (Jeffery Tang, Andrew Piatetsky, Brian Kang)
// APCS pd6
// HW75: Nodal Recall
// 2022-03-013
// time spent:  30mins

/*
DISCO:
Its fun adding stuff and removing it because the pointers can be so easily manipulated

QCC:

did not change anything, just added an extra line to add a pointer to the previous index


ALGO INSERT: 
create new arbitrary node, traverse the list to the node at desired index-1
new node and node at index-1 point to the same thing (node at specified index)
then the node at index-1 changes its pointer to the new node. Therefore adding a new element in the desired position

ALGO REMOVE:
traverse list to the node at index-1
store the value of node at index to return later
node at index-1 changes its pointer the the node at index+1, erasing all reference to node at index allowing java to remove it from storage

*/




public class LList implements List {

    // instance variables
    private LLNode _head;
    private int _size;


    // default constructor - initializes head to null and size to 0
    public LList( ) {
        _head = null;
        _size = 0;
    }


    //add node to beginning of list, containing input String as its data
    // Best case - O(1), worst case - O(n)
    public boolean add( String x ) {
        LLNode tmp = new LLNode(x, _head, null);

        // adds the element and then sets the new node as the previous of the node at index 1
        if (_head != null) { _head.setPrevious(tmp); }

        _head = tmp;

        _size +=1;
        
        return true;
    }

    //remove node from list, return its data
    public String remove( int index ) {
        if ( index < 0 || index >= size() ) { throw new IndexOutOfBoundsException(); }

        String oldVal;

        _size -=1;


        // if remove is activated for first value in a list
        if (index == 0) {
            oldVal = _head.getCargo();
            _head = _head.getNext();
            if (_head != null) { _head.setPrevious(null); }
            return oldVal;
        }
        
        // traverses the item of index-1 of the item that will be removed
        LLNode tmp = _head;
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.getNext();
        }

        // save oldValues
        oldVal = tmp.getNext().getCargo();
        // remove all reference to the node that we want to delete and set the pointer of the node at index-1 to the node at index+1
        tmp.setNext(tmp.getNext().getNext());
        // after removal of reference, set previous reference to 
        if (tmp.getNext() != null) { tmp.getNext().setPrevious(tmp); }

        return oldVal;

    }

    // inserts the specified value at the specified index
    public void add( int index, String value) {
        if ( index < 0 || index >= size() ) { throw new IndexOutOfBoundsException(); }
        
        // if want to insert at the beginning just need to add it to the beginning
        if (index == 0) {
            add(value);
            return;
        }

        _size += 1;

        LLNode newNode = new LLNode(value);
        LLNode tmp = _head;
        // traverse to node at index-1
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.getNext();
        }

        // newNode and node at index-1 point to the same thing
        newNode.setNext(tmp.getNext());
        // new node is now connected to index+1 and index-1
        newNode.setPrevious(tmp);
        // tmp points at newNode
        tmp.setNext(newNode);

        newNode.getNext().setPrevious(newNode);


    }

    //return data in element at position i
    // Best case - O(1), worst case - O(n)
    public String get( int i ) {
        if ( i < 0 || i >= size() ) { throw new IndexOutOfBoundsException(); }

        LLNode temp = _head;
        for (int j = 0; j < i; j++) {
            temp = temp.getNext();
        }
        return temp.getCargo();
    }

    //overwrite data in element at position i
    // Best case - O(1), worst case - O(n)
    public String set( int i, String x ) {
        if ( i < 0 || i >= size() ) { throw new IndexOutOfBoundsException(); }
        LLNode temp = _head;
        for (int j = 0; j < i; j++) {
            temp = temp.getNext();
        }
        return temp.setCargo(x);
    }

    //return length of list
    // O(1)
    public int size() {
        return _size;
    }

    

    // overideing inherited toString 
    public String toString() {
        if (_head == null) {
            return null;
        }

        String str = "";

        LLNode tmp = _head;
        while (tmp != null) {
            str += tmp.getPrevious() + " < -- " + tmp.toString() + " -- > " + tmp.getNext() + "\n";
            tmp = tmp.getNext();
        }

        return str;
        // return _head.toString();
    }



    public static void main(String[] args) {
        LList l = new LList();

        l.add("horse");
        l.add("cat");

        l.add("moose");
        l.add("monke");
        l.add("alligator");


        System.out.println(l);
        System.out.println(l.size());

        l.set(2, "goat");

        System.out.println(l);

        // System.out.println(l);

        l.add(4, "boo");

        System.out.println(l);
        System.out.println(l.size());

        l.remove(5);

        System.out.println(l);
        System.out.println(l.size());


    }
}