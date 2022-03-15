public class LList implements List {

    // instance variables
    private LLNode _head;
    private int _size;


    // default constructor - initializes head to null and size to 0
    public LList( ) {
        _head = null;
        _size = 0;
    }

    // //overloaded constructor - initializes head to argument - doesn't work because then size is messed up (would work if only adding one node)
    // public LList ( LLNode node ) {
    //     this();
    //     _head = node;
    //     _size = 1;
    // }



    //add node to list, containing input String as its data
    // Best case - O(1), worst case - O(n)
    public boolean add( String x ) {
        LLNode newNode = new LLNode(x);
        LLNode temp = _head;

        _size +=1;

        if (_head == null) {
            _head = newNode;
            return true;
        }

        while (temp.getNext()!= null) {
            temp = temp.getNext();
        }

        temp.setNext(newNode);

        return true;
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
        return _head.toString();
    }



    public static void main(String[] args) {
        LList l = new LList();

        System.out.println(l);

        l.add("horse");
        l.add("cat");

        System.out.println(l);

        l.add("moose");
        l.add("cow");
        l.add("ppl");

        System.out.println(l);
        System.out.println(l.size());

        System.out.println(l.get(4));

        System.out.println(l);

        l.set(4, "goat");

        System.out.println(l);

        System.out.println(l.size());

    }
}