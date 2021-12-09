/*
TNPG: Pseb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW45 - Array of Titanium/Doing more with Arrays/using interfaces to create a wrapper class for arrays so that we can get more functionality like in python
2021-12-8
time spent: 1h30min

DISCOVERIES:
There is no easy way to extend an array, you have to create a new one and then fill it up
Anyone can make any wrapper class with whatever extra functionality
Interfaces are like blueprints and they throw errors when the class implementing the interface doesn't have some specified functions


QUESTION:
How do you get the nice formatting for methods in a class i.e 'superArray[1] = something' like in python instead of 'set(1,something)''
What is the point of an interface, it just throws a bunch of errors. Why don't you create a bunch of classes and inherit thier methods?
How can you interact with  attributes in interfaces
*/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray implements ListInt {

	// ATTRIBUTES
	private int[] _data;
	private int _size;

	// Default constructor
	public SuperArray() {
		_data = new int[10];
	}

	// toString method override
	public String toString() {
		String s = "[";
		for (int i = 0; i < _size; i++) {
			if (i == _size-1) {
				s += _data[i];
			} else {
				s += _data[i] + ",";
			}
		}
		s += "]";
		return s;
	}

	// HELPER METHODS

	// returns true if index is out of range of meaningful values
	private boolean outOfRange(int index) {
		return (index >= _size);
	}

	// HELPER METHOD - returns true if there is at least one extra space in data array
  	private boolean isOneSpace() {
    	return (_size + 1 < _data.length);
  	}

	// fill an empty Array with values from _data
  	private void fill(int[] emptyArr) {
    	if (emptyArr.length >= _data.length) {
      		for (int i = 0; i < _size; i++) {
        		emptyArr[i] = _data[i];
      		}
    	}
  	}

	// sets value at index of _data to newVal and returns old value at index
  	private int set( int index, int newVal ) {
    	int oldVal = _data[index];
    	_data[index] = newVal;
    	return oldVal;
  	}

	// Doubles the length of data
  	private void expand() {
  		int[] tempArr = new int[_data.length*2];
    	this.fill(tempArr);
    	_data = tempArr;
  	}



	// METHODS NECESSATED BY ListInt interface

  	// adds newVal to the end of _data and increases size by 1
	public void add(int newVal) {
		if (!isOneSpace()) {
      		this.expand();
    	}
    	this.set(_size,newVal);
    	_size += 1;
	}

	// inserts newVal at index and pushes everything back one
	// 		- returns true if index is in the range of our meaningful values, while false if it is not
	//		- ex: _data = [1,2,3,0,0,0,0,0,0,0,], _size = 3, input index = 7:
	//			not in the range of meaningful values so returns false (all index's which would result in negative are >= 3)
	public boolean insert(int index, int newVal) {
		if (outOfRange(index)) {
			return false;
		}

		if (!isOneSpace()) {
			this.expand();
		}

		int oldVal;
		for (int i = _size; i >= index + 1; i--) {
			oldVal = _data[i-1];
			_data[i] = oldVal;
		}

		_data[index] = newVal;
		_size += 1;
		return true;
		}

	// removes value at index and aligns everything back to left justified
	// 		- returns true if index is in the range of our meaningful values, while false if it is not
	//		- ex: _data = [1,2,3,0,0,0,0,0,0,0,], _size = 3, input index = 7:
	//			not in the range of meaningful values so returns false (all index's which would result in negative are >= 3)
	public boolean remove(int index) {
		if (outOfRange(index)) {
			return false;
		}

		int oldVal;
		for (int i = index+1; i < _size; i++) {
			oldVal = _data[i];
			_data[i-1] = oldVal;
		}

		_size -= 1;
		return true;
	}

	public int size() {
		return _size;
	}


	// EXTRA METHOD - replaces a value at index (if that index is in meaningful range)
	public boolean replace(int index, int newVal) {
		if (outOfRange(index)) {
			return false;
		}

		set(index,newVal);
		return true;
	}

	
	// main method for testing
	public static void main(String[] args) {
		ListInt ra = new SuperArray();

		System.out.print(ra);
		System.out.println(ra.size());

		for (int i = 1; i < 11; i++) {
			ra.add(i);
		}

		System.out.println();

		System.out.print(ra);
		System.out.println(ra.size());

		System.out.println();

		System.out.println(ra.insert(5,676));
		System.out.println(ra.insert(12,100));
		System.out.println(ra.insert(1,100111));
		System.out.println(ra.insert(0,2323323));

		System.out.println();
		System.out.print(ra);
		System.out.println(ra.size());

		System.out.println();

		int indx = 0; //7,14,2,0
		System.out.println(ra.remove(indx));

		System.out.print(ra);
		System.out.println(ra.size());

		System.out.println();

		System.out.println(ra.replace(11,100000));

		System.out.print(ra);
		System.out.println(ra.size());

	}
}