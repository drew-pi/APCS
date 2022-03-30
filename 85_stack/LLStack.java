import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>{
    
    private LinkedList<PANCAKE> _stack;
    private int _stackSize;

    public LLStack() {
        _stack = new LinkedList<PANCAKE>();
        _stackSize = 0;
    }

    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty() {
        return _stackSize <= 0;
    }

    //Return top element of stack without popping it.
    public PANCAKE peekTop() {
        if (isEmpty()) return null;

        return _stack.get(_stackSize-1);
    }

    //Pop and return top element of stack.
    public PANCAKE pop() {
        if (isEmpty()) return null;
        
        _stackSize -= 1;
        return _stack.remove(_stackSize);
    }

    //Push an element onto top of this stack.
    public void push( PANCAKE x ) {
        _stack.add(x);
        _stackSize += 1;
    }
}