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
        LLNode tmp = new LLNode(x, _head);
        _head = tmp;
        _size +=1;
        
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

        l.add("horse");
        l.add("cat");

        l.add("moose");
        l.add("cow");
        l.add("ppl");

        System.out.println(l);

        System.out.println(l.get(4));

        l.set(4, "goat");

        System.out.println(l);

    }
}