public class Stack { // that is implementation of stack with Array

    private final int[] array; //arrays as storage for stack elements
    private int sizeOfStack = 0;//size of stack state. initially 0


    public Stack(int size) {  // public constructor what create Stack object and create initial state for it.
        array = new int[size];
    }

    public boolean isEmpty() {
        return sizeOfStack == 0;
    }// return value of stackSize field

    public void push(int value) {// method push - insert action. Add value to the top of the stack
        if (isStackWillOverflow()) { // I verify is tack already full and next element will overflow stack
            throw new IllegalStateException("overflow");// creating common exception for illegal state, with message "overflow" and throw it. That will stop method execution
        }

        increaseStackSize(); // increase stack size variable
        addValueToArray(value); // add value to correct place in array

    }

    private boolean isStackWillOverflow() {
        return sizeOfStack + 1 > array.length;
    }

    private void increaseStackSize() {
        sizeOfStack++;// after success adding value to the stack, I increase stack size counter
    }

    private void addValueToArray(int value) {
        array[getCurrentArrayIndexOfTopElement()] = value; // value added to correct place in array. Choose correct array index by stack size
    }

    private int getCurrentArrayIndexOfTopElement() { // calculate correct index of array for last element regarding of size of stack
        return sizeOfStack - 1;
    }

    public int pop() { // pop value from stack - get and delete value. remove top element from stack and return it value
        if (isEmpty()) { // we can't get any value from empty stack
            throw new IllegalStateException("underflow"); // creating common exception for illegal state, with message "underflow" and throw it. That will stop method execution
        }

        int value = getLastElement(); // get top value of stack = last existing value in array
        decreaseStackSize(); // after getting element, I'm remove element from the stack by decrease stack size counter
        return value; // return value
    }

    private void decreaseStackSize() { // after removing element from stack need to decrease stack size counter
        sizeOfStack--;
    }

    private int getLastElement() { //resolving stack top element
        return array[getCurrentArrayIndexOfTopElement()];
    }

    public int size() {
        return sizeOfStack;
    }// return true if stackSize is 0

    @Override
    public String toString() {// Here I return string presentation of stack, what could be printed
        String display = "";  // init display variable, what will be returned by method
        //reversal cycle
        int currentArrayIndexOfTopElement = getCurrentArrayIndexOfTopElement();
        for (int indexOfArray = currentArrayIndexOfTopElement; //start iterate from top element
             indexOfArray >= 0; // iterate while index is in array boundaries
             indexOfArray--) // decrease array index with each iteration
        {
            if (indexOfArray == currentArrayIndexOfTopElement) { // if first element, then add ":" to begining of the string. but we need at least 1 value to get here
                display = display + ": ";
            }
            display = display + array[indexOfArray]; //adding value to string
            if (indexOfArray > 0) { // add "->" while we are not on last element
                display = display + " -> ";
            }
        }

        return "Stack size is " + sizeOfStack + display; // final string Stack size info and stack state
    }

}
