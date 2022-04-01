import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>{


  private ArrayList<PANCAKE> _stack; 
  private int _stackSize;

  public ALStack() {
    _stack = new ArrayList<PANCAKE>();
    _stackSize = 0;
  }


  public boolean isEmpty() {
    if (_stackSize <= 0) {
      return true;
    }
    return false;
  }


  public PANCAKE peekTop() {
    if (isEmpty()) return null;

    return _stack.get(_stackSize-1);
  }


  public PANCAKE pop() {

    if (isEmpty()) return null;
    _stackSize -= 1;

    return _stack.remove(_stackSize);
  }


  public void push(PANCAKE x) {
    _stack.add(x);
    _stackSize += 1;
  }
}