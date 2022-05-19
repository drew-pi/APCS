import java.util.ListIterator;
import java.util.NoSuchElementException;

/*
Team PinkLemonade:  Jacob Ng, Andrew Piatetsky, Emily Ortiz
APCS pd6
HW103: Erica's Friends, Hugo, and The One in the Middle
2022-05-18
*/

/*
DISCO
Found error in my program. In current main method, should return 2, but instead returns zero. Always have to be more elements in little values I think. 
Have to do more testing tomorrow, but definitly found error


QCC
what is the point in finding median, don't we usually want minimum and maximums only?

*/

public class RunMed {

    // instance variables
    ALHeapMax _littleVals;
    ALHeapMin _bigVals, _heap;


    // constructor
    public RunMed() {
        _littleVals = new ALHeapMax();
        _bigVals = new ALHeapMin();

        _heap = new ALHeapMin();
    }

    public int getMedian() {
        if (_littleVals.isEmpty() && _bigVals.isEmpty()) throw new NoSuchElementException();

        if (_littleVals.size() > _bigVals.size()) {
            return _littleVals.peekMax();
        }
        else if (_littleVals.size() > _bigVals.size()) {
            return _bigVals.peekMin();
        }
        else {
            return (_bigVals.peekMin() + _littleVals.peekMax()) / 2;
        }
    }


    public void add(Integer newVal) {
        // add to main heap to keep track
        _heap.add(newVal);

        // if both heaps are empty
        if (_littleVals.isEmpty() && _bigVals.isEmpty()) {
            _littleVals.add(newVal);
            return;
        }

        System.out.println("new val: " + newVal);


        if (newVal > _littleVals.peekMax()) {
            // if big vals is more than 1 bigger than little vals
            if ( ( _bigVals.size() - _littleVals.size()) > 1 ) {

                // if newVal is smaller than root of big vals
                if (newVal < _bigVals.peekMin()) {
                    System.out.println("1");
                    _littleVals.add(newVal);
                    return;
                }
                // if newVal is larger or equal to the root of big vals
                else {
                    System.out.println("2");
                    _littleVals.add(_bigVals.removeMin());
                    _bigVals.add(newVal);
                    return;
                }
            }
            /** if statement for if little val's size is more than 1 bigger than big vals: ( (_littleVals.size() - _bigVals.size() ) > 1 ) */
            // if little val's size is more than 1 bigger than big vals or is equal
            else  {
                System.out.println("3");
                _bigVals.add(newVal);
                return;
            }
        }
        else {


            if ( (_littleVals.size() - _bigVals.size() ) > 1 ) {
                System.out.println("4");
                _bigVals.add(_littleVals.removeMax());
                _littleVals.add(newVal);
                return;
            }
            // if big vals is more than 1 bigger than little vals
            else { 
                System.out.println("5");
                _littleVals.add(newVal);
            }
        }



    }// end add




    public static void main(String[] args) {
        
        RunMed rm = new RunMed();

        for (int i = 0; i < 3; i++) {
            rm.add(i);
        }  

        System.out.println("normal heap: " + rm._heap);
        System.out.println("little vals: " + rm._littleVals);
        System.out.println("bigger vals: " + rm._bigVals);


        System.out.println(rm.getMedian());

    }



    
}
